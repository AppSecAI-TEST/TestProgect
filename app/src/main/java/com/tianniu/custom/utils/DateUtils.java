package com.tianniu.custom.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	private static long todayStart=0;
	private static long todayEnd=0;

	/**
	 * 这句话写在某一个onResume里方便重置
	 */
	public static void resetTodayTime(){
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		today.set(Calendar.MILLISECOND, 0);
		todayStart= today.getTime().getTime();

	//	String ddddd=DateUtils.getdfyyyyMdHH(todayStart);
		today.set(Calendar.HOUR_OF_DAY, 23);
		today.set(Calendar.MINUTE, 59);
		today.set(Calendar.SECOND, 59);
		today.set(Calendar.MILLISECOND, 999);
		todayEnd= today.getTime().getTime();
	//	String sss=DateUtils.getdfyyyyMdHH(todayEnd);
	//	String uu=sss;
	}

	public static boolean isToday(long time){
		resetTodayTime();

//		String s1=getdfyyyyMdHH(todayStart);
//		String s2=getdfyyyyMdHH(todayEnd);
//		String s3=getdfyyyyMdHH(time);
		if(todayStart<=time&&time<=todayEnd){
			return true;
		}
		return false;
	}

	public static String cargoListItemTimeConvert(long time){
		if(isToday(time)){
			return getHHmm(time);
		}else{
			return getMMddHHmm(time);
		}
	}

	private static SimpleDateFormat updateDate = new SimpleDateFormat("yyyyMMdHHmmss");
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat dfyyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat dfyyyyMMddHHmm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private static SimpleDateFormat dfMMddHHmm = new SimpleDateFormat("MM-dd HH:mm");
	private static SimpleDateFormat dfyyyyMdHH = new SimpleDateFormat("yyyy.M.d  HH:mm");
	private static SimpleDateFormat dfMMddm = new SimpleDateFormat("MM-dd");
	private static SimpleDateFormat HHmm = new SimpleDateFormat("HH:mm");
	public static String getYMDFromLong(long time) {

		Date date = new Date(time);

		return df.format(date);
	}
	public static String updateDate(long time){
		Date date = new Date(time);
		return dfyyyyMdHH.format(date);
	}
	public static String getdfyyyyMdHH(long time){
		Date date = new Date(time);
		return dfyyyyMdHH.format(date);
	}
	private static SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");

	public static String getMDFromLong(long time) {

		Date date = new Date(time);

		return dfMMddm.format(date);
	}
	public static String getYMDFromLong2(long time) {

		Date date = new Date(time);

		return df2.format(date);
	}
	public static String getHHmm(long time) {

		Date date = new Date(time);

		return HHmm.format(date);
	}

	public static String getMMddHHmm(long time) {

		Date date = new Date(time);

		return dfMMddHHmm.format(date);
	}
	public static String getYMDFromLong(Date date) {

		return df.format(date);
	}


	public static String getyyyyMMdd(long time){
		String result="";
	
		try{
		Date date = new Date(time);
		result= df.format(date);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	public static String getyyyyMMddHHmmss(long time){
		Date date = new Date(time);
		return dfyyyyMMddHHmmss.format(date);
	}
	
	public static String getyyyyMMddHHmmss(Date date){
		return dfyyyyMMddHHmmss.format(date);
	}
	
	public static String getyyyyMMddHHmm(Date date){
		return dfyyyyMMddHHmm.format(date);
	}
	public static String getyyyyMMddHHmm(long time){
		Date date = new Date(time);
		return dfyyyyMMddHHmm.format(date);
	}
	public static int getDay(long time) {
		Date d = new Date(time);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		int date = c.get(Calendar.DATE);
		int dad = d.getDate();
		int test = dad;
		return date;
	}

	public static int isYeaterday(Date oldTime, Date newTime)
			throws ParseException {
		if (newTime == null) {
			newTime = new Date();
		}
		// 将下面的 理解成 yyyy-MM-dd 00：00：00 更好理解点

		String todayStr = df.format(newTime);
		Date today = df.parse(todayStr);
		// 昨天 86400000=24*60*60*1000 一天
		if ((today.getTime() - oldTime.getTime()) > 0
				&& (today.getTime() - oldTime.getTime()) <= 86400000) {
			return 0;
		} else if ((today.getTime() - oldTime.getTime()) <= 0) { // 至少是今天
			return -1;
		} else { // 至少是前天
			return 1;
		}

	}
	
	/**
	 * 格式化时间
	 * @param time
	 * @return
	 */
	public static String formatDateTime(long time) {
	
	
		Date date = null;
		
			date =new Date(time);
		
		
		Calendar current = Calendar.getInstance();
		
		Calendar today = Calendar.getInstance();	//今天
		
		today.set(Calendar.YEAR, current.get(Calendar.YEAR));
		today.set(Calendar.MONTH, current.get(Calendar.MONTH));
		today.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH));
		//  Calendar.HOUR——12小时制的小时数 Calendar.HOUR_OF_DAY——24小时制的小时数
		today.set( Calendar.HOUR_OF_DAY, 0);
		today.set( Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		
		Calendar yesterday = Calendar.getInstance();	//昨天
		
		yesterday.set(Calendar.YEAR, current.get(Calendar.YEAR));
		yesterday.set(Calendar.MONTH, current.get(Calendar.MONTH));
		yesterday.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH)-1);
		yesterday.set( Calendar.HOUR_OF_DAY, 0);
		yesterday.set( Calendar.MINUTE, 0);
		yesterday.set(Calendar.SECOND, 0);
		current.setTime(date);
		
		if(current.after(today)){
			return ""+HHmm.format(time);
		}else if(current.before(today) && current.after(yesterday)){
			
			return "昨天 "+HHmm.format(time);
		}else{
		
			return df2.format(time);
		}
	}

}
