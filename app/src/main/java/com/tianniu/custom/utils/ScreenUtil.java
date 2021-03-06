package com.tianniu.custom.utils;


import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * 得到屏幕宽高密度等
 * @author 
 */
public class ScreenUtil {
	
	 private Activity activity;
	 /** 屏幕宽度（像素）*/
	 private int width;
	 /**屏幕高度（像素）*/
	 private int height;
	 /**屏幕密度（0.75 / 1.0 / 1.5）*/
	 private float density;
	 /**屏幕密度DPI（120 / 160 / 240）*/
	 private int densityDpi;
	 
	 public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getDensity() {
		return density;
	}

	public void setDensity(float density) {
		this.density = density;
	}

	public int getDensityDpi() {
		return densityDpi;
	}

	public void setDensityDpi(int densityDpi) {
		this.densityDpi = densityDpi;
	}

	public ScreenUtil(Activity activity){
		 this.activity = activity;
		 ini();
	 }
	 
	 private void ini(){
		 DisplayMetrics metric = new DisplayMetrics();
		 activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
	     width = metric.widthPixels;  
	     height = metric.heightPixels; 
	     density = metric.density;  
	     densityDpi = metric.densityDpi;  
	 }

	 public static int px2dip(Context context,float pxValue){
		 float density = context.getResources().getDisplayMetrics().density;
		 return  (int)(pxValue / density+0.5f);
	 }
	public static int dip2px(Context context,float dipValue){
		float density = context.getResources().getDisplayMetrics().density;
		return (int)(density * dipValue + 0.5f);
	}

	/**
	 * 获取屏幕的宽度
	 *
	 * @param context
	 * @return
	 */
	public static int getScreenWidth(Context context) {
		WindowManager manager = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = manager.getDefaultDisplay();
		return display.getWidth();
	}

}
