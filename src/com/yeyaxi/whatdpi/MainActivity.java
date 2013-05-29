package com.yeyaxi.whatdpi;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.ShareActionProvider;
/**
 * What DPI is a simple tool for developers/designers to quickly find out the screen parameters.
 * @author Yaxi Ye
 * @since 13/Oct/2012
 * @version 1.2
 */
public class MainActivity extends SherlockActivity {

	TextView dpiText;
	TextView resolutionText;
	TextView factorText;
	TextView dpText;
	TextView xdpiText;
	TextView ydpiText;
	TextView deviceText;
    private  ShareActionProvider actionProvider;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dpiText = (TextView)findViewById(R.id.dpiText);
		resolutionText = (TextView)findViewById(R.id.resolutionText);
		factorText = (TextView)findViewById(R.id.factorText);
		dpText = (TextView)findViewById(R.id.dpText);
		xdpiText = (TextView)findViewById(R.id.xdpiText);
		ydpiText = (TextView)findViewById(R.id.ydpiText);
		deviceText = (TextView)findViewById(R.id.deviceText);
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onResume() {
		super.onResume();
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);    	

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
			
			switch(metrics.densityDpi) {
			
			default: 
				dpiText.setText("mdpi");
				break;
				
			case (DisplayMetrics.DENSITY_LOW):
				dpiText.setText("ldpi");
			break;
			
			case (DisplayMetrics.DENSITY_MEDIUM):
				dpiText.setText("mdpi");
			break;
			
			case (DisplayMetrics.DENSITY_HIGH):
				dpiText.setText("hdpi");
			break;
			
			case (DisplayMetrics.DENSITY_XHIGH):
				dpiText.setText("xhdpi");
			break;
			
			case (DisplayMetrics.DENSITY_TV):
				dpiText.setText("tvdpi");
			break;
			
			case (DisplayMetrics.DENSITY_XXHIGH):
				dpiText.setText("xxhdpi");
			break;
			
			}
		} else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD){
			
			switch(metrics.densityDpi) {
			default: 
				dpiText.setText("mdpi");
				break;
			case (DisplayMetrics.DENSITY_LOW):
				dpiText.setText("ldpi");
			break;
			case (DisplayMetrics.DENSITY_MEDIUM):
				dpiText.setText("mdpi");
			break;
			case (DisplayMetrics.DENSITY_HIGH):
				dpiText.setText("hdpi");
			break;
			case (DisplayMetrics.DENSITY_XHIGH):
				dpiText.setText("xhdpi");
			break;
			case (DisplayMetrics.DENSITY_TV):
				dpiText.setText("tvdpi");
			break;
			}
		} else {
			switch(metrics.densityDpi) {
			default: 
				dpiText.setText("mdpi");
				break;
			case (DisplayMetrics.DENSITY_LOW):
				dpiText.setText("ldpi");
			break;
			case (DisplayMetrics.DENSITY_MEDIUM):
				dpiText.setText("mdpi");
			break;
			case (DisplayMetrics.DENSITY_HIGH):
				dpiText.setText("hdpi");
			break;
			}
		}
		
		String res = metrics.widthPixels + "px x " + metrics.heightPixels + "px";
		resolutionText.setText(res);
		
		String factor = Float.toString(metrics.density) + " times of baseline";
		factorText.setText(factor);
		
		int widthDP = (int)(metrics.widthPixels / metrics.density);
		int heightDP = (int)(metrics.heightPixels / metrics.density);
		
		String dp = Integer.toString(widthDP) + "dp x " + Integer.toString(heightDP) + "dp";
		dpText.setText(dp);
		
		xdpiText.setText(Float.toString(metrics.xdpi));
		ydpiText.setText(Float.toString(metrics.ydpi));
		
		deviceText.setText("Your Device:" +
                android.os.Build.MANUFACTURER + " " +
                android.os.Build.MODEL +
				"\nCode name: " + android.os.Build.PRODUCT);

	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu
        getSupportMenuInflater().inflate(R.menu.activity_main, menu);

        // Set menu items
        MenuItem actionItem = menu.findItem(R.id.menu_share_provider);
        actionProvider = (ShareActionProvider) actionItem.getActionProvider();
        actionProvider.setShareHistoryFileName(ShareActionProvider.DEFAULT_SHARE_HISTORY_FILE_NAME);
        actionProvider.setShareIntent(createDefaultShareIntent());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_share_provider:
//                actionProvider.setShareIntent(getShareIntent());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private Intent createDefaultShareIntent() {

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
//        shareIntent.putExtra(Intent.EXTRA_TITLE, "Device Screen Parameters");
//        String stringToShare = (buildTextContent().equals(null)) ? "Initializing" : buildTextContent();
        shareIntent.putExtra(Intent.EXTRA_TEXT, buildTextContent());
//        shareIntent.putExtra(Intent.EXTRA_TEXT, stringToShare);


        return shareIntent;
    }

//    private Intent getShareIntent() {
//        Intent shareIntent = new Intent();
//        shareIntent.setAction(Intent.ACTION_SEND);
//        shareIntent.setType("text/plain");
//        shareIntent.putExtra(Intent.EXTRA_TITLE, "Device Screen Parameters");
//        shareIntent.putExtra(Intent.EXTRA_TEXT, buildTextContent());
//
//        return shareIntent;
//    }
    /**
     * Build the Text for sharing
     * @return the text describes the screen parameters
     */
    private String buildTextContent() {

        return new String("Device Name: " + deviceText.getText() + "\n" +
                            "Screen Density: " + dpiText.getText() + "\n" +
                            "Screen Density Factor: " + factorText.getText() + "\n" +
                            "Screen Resolution(px): " + resolutionText.getText() + "\n" +
                            "Screen Resolution(dp): " + dpText.getText() + "\n" +
                            "Screen DPI: " + xdpiText.getText() + " x " + ydpiText.getText());
    }
}
