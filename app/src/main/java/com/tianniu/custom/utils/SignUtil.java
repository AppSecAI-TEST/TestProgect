package com.tianniu.custom.utils;


import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Title: SignUtil.java
 * @Description:
 * 
 *               加/解签名工具类
 */
public class SignUtil {

	private static String TAG = "SignUtil";

	// private static final Logger logger =
	// LoggerFactory.getLogger(SignUtil.class);

	/**
	 * check verify
	 * 
	 * @param params
	 *            要验证的参数map
	 * @param sign
	 *            签名字符串
	 * @param secret
	 *            秘钥
	 * @return 验证通过返回真，失败返回false
	 */
	public static boolean verifySignature(TreeMap<String, String> params, String sign, String secret) {
		String strSign = sign(params, secret);
		if (sign.equals(strSign)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param params
	 *            签名的参数
	 * @param secret
	 *            秘钥
	 * @return 签名后的字符串
	 */
	public static String sign(TreeMap<String, String> params, String secret) {
		// Map<String, String> sortedParams = new TreeMap<String, String>();
		// sortedParams.putAll(params);
		
		

		long tempStmp= System.currentTimeMillis();

		params.put("ttkn", DateUtils.updateDate(tempStmp));//添加一个时间戳用来区分程序的访问时间
		
		if (null != params && params.size() > 0) {
			TreeMap<String, String> tree = new TreeMap<String, String>();
			
			
			
			Iterator<String> iterator1 = params.keySet().iterator();
			
			while (iterator1.hasNext()) {
				String name = (String) iterator1.next();
				if (params.get(name) != null && !params.get(name).isEmpty()) {
					String key=name+"="+params.get(name);
					tree.put(key, "test");//这里test只是用来判断不为空而设置的,没有具体的意义，不会向服务器传
				}
				
			}
			
			
			Iterator<String> iterator = tree.keySet().iterator();
			StringBuffer orgin = new StringBuffer();
			while (iterator.hasNext()) {
				String name = (String) iterator.next();
				if (tree.get(name) != null && !tree.get(name).isEmpty()) {
					orgin.append(name).append("&");
				}
			}
			
			orgin.deleteCharAt(orgin.length() - 1);
			orgin.append(secret);
			// String sign=Encoder.md5(orgin.toString());
			String md5 = CommonUtil.MD5(orgin.toString());
			LLog.i(TAG, "签名前字符串：【" + orgin.toString() + "】签名后字符串：【" + md5 + "】");
			return md5;
		}
		return null;
	}

	/**
	 * 二进制转字符串
	 * 
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toUpperCase();
	}

	/**
	 * 使用指定的字符集编码请求参数值。
	 * 
	 * @param value
	 *            参数值
	 * @param charset
	 *            字符集
	 * @return 编码后的参数值
	 */
	public static String encode(String value, String charset) {
		String result = null;
		if (null != value && !"".equals(value)) {
			try {
				result = URLEncoder.encode(value, charset);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return result;
	}

	public static Map<String, String> getParamsFromUrl(String url) {
		Map<String, String> map = null;
		if (url != null && url.indexOf('?') != -1) {
			map = splitUrlQuery(url.substring(url.indexOf('?') + 1));
		}
		if (map == null) {
			map = new HashMap<String, String>();
		}
		return map;
	}

	/**
	 * 从URL中提取所有的参数。
	 * 
	 * @param query
	 *            URL地址
	 * @return 参数映射
	 */
	public static Map<String, String> splitUrlQuery(String query) {
		Map<String, String> result = new HashMap<String, String>();

		String[] pairs = query.split("&");
		if (pairs != null && pairs.length > 0) {
			for (String pair : pairs) {
				String[] param = pair.split("=", 2);
				if (param != null && param.length == 2) {
					result.put(param[0], param[1]);
				}
			}
		}

		return result;
	}

	public static String getHmsTime() {
		long currentTimeMillis = System.currentTimeMillis();
		Date data = new Date();
		SimpleDateFormat simpleFormatter = new SimpleDateFormat("HH:mm:ss");
		return simpleFormatter.format(data);

	}

	public static String getDetaillTime() {
		long currentTimeMillis = System.currentTimeMillis();
		Date data = new Date();
		
		SimpleDateFormat simpleFormatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		
		return simpleFormatter.format(data);
	}

	/*
	 * public static void main(String[] args) { String se="1345~opo-4%";
	 * TreeMap<String,String> tree=new TreeMap<String,String>();
	 * 
	 * //token=f5c034fcd7459ab9ee143de2ed7fb2f1&a1=v1&a2=v2&ka=t3&a3=jk&sign=34e3
	 * c66dc4e77fc36fc3f5a2a9cc048c
	 * 
	 * // tree.put("token", "f5c034fcd7459ab9ee143de2ed7fb2f1"); //
	 * tree.put("a1", "v1"); // tree.put("a2", "v2"); // tree.put("ka", "t3");
	 * //tree.put("a9", ""); tree.put("ay", "中国"); tree.put("cellPhone",
	 * "15201118690"); tree.put("password", "0f1b4f707949803b9a5d596272f54547");
	 * tree.put("clientSign", "1"); tree.put("osVersion", "ios");
	 * tree.put("clientVersion", "2015"); tree.put("clientId", "1234567890");
	 * 
	 * tree.put("userId", "4645"); tree.put("ticket",
	 * "aebd000c50a86f6e2367db8bef106dd1");
	 * 
	 * //client_sign=1&os_version=ios&client_version=2202&client_id=1234567890
	 * //51599bcd2328de5ba818329ad07e0f2b 1094e1b6d5473a6552941334fd41f81a
	 * String aa=SignUtil.sign(tree, se); System.out.println(aa); }
	 */

}
