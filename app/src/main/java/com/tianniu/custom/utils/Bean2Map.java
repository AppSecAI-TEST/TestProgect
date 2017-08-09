package com.tianniu.custom.utils;

import android.text.TextUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Bean2Map<K, V> {

	private static Bean2Map<String, String> mBean2Map;

	public synchronized static Bean2Map<String, String> getInstance() {
		if (mBean2Map == null) {
			mBean2Map = new Bean2Map<String, String>();
		}
		return mBean2Map;
	}

	private Bean2Map() {

	}

	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, V> bean2Map(Object javaBean) {
		Map<K, V> ret = new HashMap<K, V>();
		try {

			Method[] methods = javaBean.getClass().getDeclaredMethods();

			for (Method method : methods) {
				if (method.getName().startsWith("get")) {
					String field = method.getName();

					field = field.substring(field.indexOf("get") + 3);

					field = field.toLowerCase().charAt(0) + field.substring(1);

					Object value = method.invoke(javaBean, (Object[]) null);

					if(value instanceof String){
						String s= String.valueOf(value);
						if(!TextUtils.isEmpty(s)){
						ret.put((K) field, (V) (null == value ? "" : value));
						}
					}
			
					
				}
			}

		} catch (Exception e) {
		}
		return ret;
	}

	public TreeMap<String, String> bean2Map(Object info, TreeMap<String, String> loginParams) {

		try {

			Method[] methods = info.getClass().getDeclaredMethods();

			for (Method method : methods) {
				
				if (method.getName().startsWith("get")) {
					String field = method.getName();

					field = field.substring(field.indexOf("get") + 3);

					field = field.toLowerCase().charAt(0) + field.substring(1);

					Object value = method.invoke(info, (Object[]) null);
					if (null != value) {
						loginParams.put((String) field, value.toString());
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginParams;
	}


	
	
//	public TreeMap<String, String> Bean2Map(Object info, TreeMap<String, String> loginParams) {
//
//		try {
//
//			Method[] methods = info.getClass().getDeclaredMethods();
//
//			for (Method method : methods) {
//				if (method.getName().startsWith("get")) {
//					String field = method.getName();
//
//					field = field.substring(field.indexOf("get") + 3);
//
//					field = field.toLowerCase().charAt(0) + field.substring(1);
//
//					Object value = method.invoke(info, (Object[]) null);
//					if (null != value) {
//						loginParams.put((String) field, (String) (null == value ? "" : value));
//					}
//
//				}
//			}
//
//		} catch (Exception e) {
//		}
//		return loginParams;
//	}

}
