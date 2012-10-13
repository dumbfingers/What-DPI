What DPI
=======
## What is "What DPI"?
What DPI is a simple tool for Android Developers/Designers to quickly find out the screen parameters.

## What "What DPI" will tell me?
Basically this app will show you:

Density

Screen Resolution in pixels

Density Factor

Resolution in dp (Density Independent Pixels)

xdpi (Screen's x dots per inch)

ydpi (Screen's y dots per inch)

## What are those stuff means?
1. Density:
Android is using `ldpi` `mdpi` `hdpi` `xhdpi` `xxhdpi` and `tvdpi` to represent the screen densities.
2. Screen Resolution in pixels: yeah, that's your device's resolution in pixels.
3. Density Factor: To do a conversion from pixel to dp, Android using the density factors, which differs from the screen density. `mdpi` is baseline screen density, so it has density factor 1.0, then `hdpi` is 1.5, then `xhdpi` is 2.0. So 1 pixel on `xhdpi` equals 1 * factor = 1 * 2 = 2 dp. So as 1.5 dp on `hdpi` and 1 dp on `mdpi`. 
4. Resolution in dp: Just showing your current screen's resolution in dp.
5. xdpi and ydpi: Shows you the Dots Per Inch in x axis and y axis of your screen.