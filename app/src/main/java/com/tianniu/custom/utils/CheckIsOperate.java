package com.tianniu.custom.utils;

import android.app.Activity;
import android.view.View;

/**
 * 按钮控制工具
 * @author long
 *
 */
public class CheckIsOperate {
	private static int OnDownRefreshTime = 10000;
	private static int OnUpRefreshTime = 10000;

	private static long lastOnDownRefreshTime;
	private static long lastOnUpRefreshTime;
	
	/**
	 * 
	 * @param currentState 刷新状态
	 * @param refreshIntervalTime  刷新间隔时间
	 * @return
	 */
	public static boolean checkPullRefreshTime(int currentState, int refreshIntervalTime) {
		OnDownRefreshTime = refreshIntervalTime;
		OnUpRefreshTime = refreshIntervalTime;
		if (currentState == 0) {
			return checkDownTime();
		} else {
			return checkUptime();
		}
	}

	private static boolean checkDownTime() {
		if ((System.currentTimeMillis() - lastOnDownRefreshTime) > (OnDownRefreshTime*1000)) {
			lastOnDownRefreshTime = System.currentTimeMillis();
			return true;
		} else {
			return false;
		}
	}

	private static boolean checkUptime() {
		if ((System.currentTimeMillis() - lastOnUpRefreshTime) > (OnUpRefreshTime*1000)) {
			lastOnUpRefreshTime = System.currentTimeMillis();
			return true;
		} else {
			return false;
		}
	}

	// 按钮部分
	private static long lastOnClickTime = 0;
	private static long onClickTimeInterval = 1000;

	/**
	 *
	 * @param postionView
	 * @param act
     * @return true 可以操作，false 点击过快
     */
	public static boolean checkViewIsClick(View postionView, Activity act) {
		return checkTime(postionView, act);
	}

	private static boolean checkTime(View postionView, Activity act) {
		if ((System.currentTimeMillis() - lastOnClickTime) > onClickTimeInterval) {
			lastOnClickTime = System.currentTimeMillis();
			return true;
		} else {
		//	ToastUtil.showShortToast(act, "点的太快了~");
			return false;
		}
	}

	private static int timeLimit = 3000;
	private static long timeCount = 0;

	/**
	 * 返回true表示超出了限制时间，可以进行其他操作了
	 * 
	 * @return
	 */
	public static boolean isTimeOut() {
		long time = System.currentTimeMillis();
		if (time - timeCount > timeLimit) {
			timeCount = time;
			return true;
		}

		return false;
	}
	
	/**
	 * 返回true表示超出了限制时间，可以进行其他操作了
	 * 
	 * @return
	 */
	public static boolean isTimeOut(int timeLimit) {
		long time = System.currentTimeMillis();
		if (time - timeCount > timeLimit) {
			timeCount = time;
			return true;
		}

		return false;
	}
   public static class CheckIsTimeOut {
		private  int OnDownRefreshTime = 10000;
		private  int OnUpRefreshTime = 10000;

		private  long lastOnDownRefreshTime;
		private  long lastOnUpRefreshTime;
		
		/**
		 * 
		 * @param currentState 刷新状态
		 * @param refreshIntervalTime  刷新间隔时间
		 * @return
		 */
		public  boolean checkPullRefreshTime(int currentState, int refreshIntervalTime) {
			OnDownRefreshTime = refreshIntervalTime;
			OnUpRefreshTime = refreshIntervalTime;
			if (currentState == 0) {
				return checkDownTime();
			} else {
				return checkUptime();
			}
		}

		private  boolean checkDownTime() {
			if ((System.currentTimeMillis() - lastOnDownRefreshTime) > (OnDownRefreshTime*1000)) {
				lastOnDownRefreshTime = System.currentTimeMillis();
				return true;
			} else {
				return false;
			}
		}

		private  boolean checkUptime() {
			if ((System.currentTimeMillis() - lastOnUpRefreshTime) > (OnUpRefreshTime*1000)) {
				lastOnUpRefreshTime = System.currentTimeMillis();
				return true;
			} else {
				return false;
			}
		}

		// 按钮部分
		private  long lastOnClickTime = 0;
		private  long onClickTimeInterval = 2000;

		public  boolean checkViewIsClick(View postionView, Activity act) {
			return checkTime(postionView, act);
		}

		private  boolean checkTime(View postionView, Activity act) {
			if ((System.currentTimeMillis() - lastOnClickTime) > onClickTimeInterval) {
				lastOnClickTime = System.currentTimeMillis();
				return true;
			} else {
				ToastUtil.showShortToast(act, "点的太快了~");
				return false;
			}
		}

		private  int timeLimit = 3000;
		private  long timeCount = 0;

		/**
		 * 返回true表示超出了限制时间，可以进行其他操作了
		 * 
		 * @return
		 */
		public  boolean isTimeOut() {
			long time = System.currentTimeMillis();
			if (time - timeCount > timeLimit) {
				timeCount = time;
				return true;
			}

			return false;
		}
		
		/**
		 * 返回true表示超出了限制时间，可以进行其他操作了
		 * 
		 * @return
		 */
		public  boolean isTimeOut(int timeLimit) {
			long time = System.currentTimeMillis();
			if (time - timeCount > timeLimit) {
				timeCount = time;
				return true;
			}
			return false;
		}  
   }
}
