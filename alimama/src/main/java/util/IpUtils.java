package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpGet;

import weiboread.HttpTest;

public class IpUtils {
	
	
	/*
	 * 随机生成国内IP地址
	 */
	public static String getRandomIp() {

		// ip范围
		int[][] range = { { 607649792, 608174079 },// 36.56.0.0-36.63.255.255
				{ 1038614528, 1039007743 },// 61.232.0.0-61.237.255.255
				{ 1783627776, 1784676351 },// 106.80.0.0-106.95.255.255
				{ 2035023872, 2035154943 },// 121.76.0.0-121.77.255.255
				{ 2078801920, 2079064063 },// 123.232.0.0-123.235.255.255
				{ -1950089216, -1948778497 },// 139.196.0.0-139.215.255.255
				{ -1425539072, -1425014785 },// 171.8.0.0-171.15.255.255
				{ -1236271104, -1235419137 },// 182.80.0.0-182.92.255.255
				{ -770113536, -768606209 },// 210.25.0.0-210.47.255.255
				{ -569376768, -564133889 }, // 222.16.0.0-222.95.255.255
		};

		Random rdint = new Random();
		int index = rdint.nextInt(10);
		String ip = num2ip(range[index][0] + new Random().nextInt(range[index][1] - range[index][0]));
		return ip;
	}

	/*
	 * 将十进制转换成ip地址
	 */
	public static String num2ip(int ip) {
		int[] b = new int[4];
		String x = "";

		b[0] = (int) ((ip >> 24) & 0xff);
		b[1] = (int) ((ip >> 16) & 0xff);
		b[2] = (int) ((ip >> 8) & 0xff);
		b[3] = (int) (ip & 0xff);
		x = Integer.toString(b[0]) + "." + Integer.toString(b[1]) + "." + Integer.toString(b[2]) + "." + Integer.toString(b[3]);

		return x;
	}
	
	/**
	 * <br>
	 * * 批量代理IP有效检测<br>
	 * *<br>
	 * * @param IP<br>
	 * * @param post<br>
	 */
	public static void createIPAddress(String ip, int port) {
		URL url = null;
		try {
			url = new URL("http://www.baidu.com");
		} catch (MalformedURLException e) {
			System.out.println("url invalidate");
		}
		InetSocketAddress addr = null;
		addr = new InetSocketAddress(ip, port);
		Proxy proxy = new Proxy(Proxy.Type.HTTP, addr); // http proxy
		InputStream in = null;
		try {
			URLConnection conn = url.openConnection(proxy);
			conn.setConnectTimeout(1000);
			in = conn.getInputStream();
		} catch (Exception e) {
			System.out.println("ip " + ip + " is not aviable");// 异常IP
		}
		String s = convertStreamToString(in);
		System.out.println(s);
		// System.out.println(s);
		if (s.indexOf("baidu") > 0) {// 有效IP
			System.out.println(ip + ":" + port + " is ok");
		}
	}
	
public  static List<HttpHost> getips(String url) {
		
		System.out.println("ip url =="+url);

		try {
			List<HttpHost> hosts = new ArrayList<HttpHost>();
			String str = getIpStr(url);
			
			if(StringUtils.isBlank(str)){
				System.out.println("获取ip是空>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			}

			//System.out.println("get ipstr :" + str);

			String[] strs = str.replaceAll("\\t", "").replace("    ", "").replace("<br>", "").split("\r\n");
			for (String ipstr : strs) {
				String[] ip = ipstr.split(":");
				HttpHost e = new HttpHost(ip[0], Integer.parseInt(ip[1]));
				hosts.add(e);
			}
			return hosts;
		} catch (Exception e) {
			System.out.println("获取ip有问题>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			e.printStackTrace();
		}
		return null;
	}

public static String getIpStr(String url) {
	String urlStr = new HttpTest().getContentByUrl(null, new HttpGet(url));
	return urlStr;
}

	public static String convertStreamToString(InputStream is) {
		if (is == null)
			return "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "/n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();

	}

}
