package com.yeyaxi.whatdpi;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.widget.TextView;
/**
 * What DPI is a simple tool for developers/designers to quickly find out the screen parameters.
 * @author Yaxi Ye
 *
 */
public class MainActivity extends Activity {

	TextView dpiText;
	TextView resolutionText;
	TextView factorText;
	TextView dpText;
	TextView xdpiText;
	TextView ydpiText;
	TextView deviceText;

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
//		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
