package dataoke;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import jodd.http.Cookie;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import util.CharUtil;
import util.HtmlUnitUtil;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Test {
	
	static Map<String,Cookie[]> map = new HashMap<String, Cookie[]>();
	
	public static void main(String[] args) throws Exception{
		//boolean flag = tuijian("2231931");
		//System.out.println("推广成功》》》》》》》》》》》》》》》》》》》"+flag);
		//execteAll("2255030",new File("G:\\taoke\\第4组.txt"));
		//executeTest();
	  // testck();
		/*File[] files = new File[]{new File("G:\\taoke\\第1组500.txt"),new File("G:\\taoke\\第2组500.txt")
		,new File("G:\\taoke\\第3组500.txt"),new File("G:\\taoke\\第4组.txt")};
		execteAll("2262582",files);*/
		
		//deleteAll("15201733860");
		//login("15201733860", "1qaz2wsx");
		//deleteById("2247791","13040003624");
		//check();
		
		
		//System.out.println(readDetailHttp("2325753", "13411679603"));
		
		//System.out.println(biaoji("2333730", "17189683009"));
		
		//System.out.println(queryPidByName("17189683009", "已破形常准"));
		
		//System.out.println(createPidAll("17189683009"));
		
		//System.out.println(createPid("17189683009"));
		
		System.out.println(zhuan("13411679603", "2337538"));
	}
	
	public static boolean check(){
		try{
			String url = "http://m635674608.iteye.com/blog/2370843";
			 HttpRequest httpRequest = HttpRequest.post(url).timeout(20000);
			 HttpResponse response = httpRequest.send();
			 String rc = response.bodyText();
			 if(rc.contains("dataoke")){
				 System.out.println("验证码通过>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				 return true;
			 }else{
				 System.out.println("验证码不通过>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			 }
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public static void executeTest()throws Exception{
		String pid ="2250281";
		
			//String uname = "15201733860";
			//String pwd = "1qaz2wsx";
		   String uname = "17071610350";
		   String pwd = "1qaz2wsx";
		
			System.out.println("u = "+uname + "p = "+pwd +" 开始登陆");
			
			boolean flag = login(uname,pwd);
			System.out.println("u = "+uname + "登陆>>>>>>>>>>>>>"+flag);
			Thread.sleep(3000);
			if(flag){
				//flag = tuijian(pid,uname);
				flag = tuijianToFile(pid,uname);
				if(flag){
					System.out.println("推广成功》》》》》》》》》》》》》》》》》》》pid="+pid+" uname="+uname);
				}else{
					System.out.println("推广失败》》》》》》》》》》》》》》》》》》pid="+pid+"uname="+uname);
				}
			}
			Thread.sleep(5000);
	}
	
	
	public static void testck()throws Exception{
		//boolean flag = login("15201733860","1qaz2wsx");
		//System.out.println(flag);
		
		 boolean flag = getSlftConent("2217018","15201733860");
		Thread.sleep(1000);
		if(flag){
			System.out.println("商品已存在商品列表..删除商品");
			flag = deleteId("2217018","15201733860");
			if(flag){
				System.out.println("商品删除==="+flag);
			}else{
				System.out.println("商品删除失败结束>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			}
		}else{
			System.out.println("不在推广列表>>>>>>>>>>>>>>>>>>>>>>>>");
		}
		/*Thread.sleep(1000);
		flag = tuijianToFile("2217018","15201733860");
		if(flag){
			System.out.println("推广成功》》》》》》》》》》》》》》》》》》》");
		}else{
			System.out.println("推广失败》》》》》》》》》》》》》》》》》》》");
		}*/
	}
	
	static File fileStoreBase = new File("D:\\dataoke\\ck\\");
	
	/**
	 * 获取判断商品是否在推广商品页面
	 */
	public static boolean getSlftConent(String id,String uname)throws Exception{
		String url ="http://www.dataoke.com/ucenter/favorites_quan.asp";
		HttpRequest httpRequest = HttpRequest.get(url);
		// httpRequest.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		 httpRequest.header("Host", "www.dataoke.com");
		 httpRequest.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0");
		 httpRequest.header("Referer", "http://www.dataoke.com/ucenter/favorites_quan.asp");
		 httpRequest.header("Upgrade-Insecure-Requests", "1");
		 httpRequest.header("Connection", "keep-alive");
		 httpRequest.header("X-Requested-With", "XMLHttpRequest");
		 httpRequest.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		 httpRequest.header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		 httpRequest.header("X-Requested-With", "XMLHttpRequest");
		 

			Map<String, String> cookisMap = new HashMap<String, String>();
			String cookisStr = "random=8696; ASPSESSIONIDSQCRRSDT=PMFGMKPANNDIPLFIEAGFOJHD; dtk_web=mgbpf1uvaohssnvee7m02u1lt7; UM_distinctid=15b906fc3d99a-0ca45cd09b0c9d-12616a4a-1fa400-15b906fc3db105; CNZZDATA1257179126=1538129784-1492772062-http%253A%252F%252Fwww.dataoke.com%252F%7C1492777462; userid=537000; user_email=15201733860; user%5Femail=15201733860; upe=537e2926; e88a8013345a8f05461081898691958c=834b4337570611838d9b6989521575fb85ae30b6a%3A4%3A%7Bi%3A0%3Bs%3A6%3A%22537000%22%3Bi%3A1%3Bs%3A11%3A%2215201733860%22%3Bi%3A2%3Bi%3A2592000%3Bi%3A3%3Ba%3A0%3A%7B%7D%7D; ASPSESSIONIDSSBQSTCT=ICEPOLPACLKKGLDMHNNFFFIA; ASPSESSIONIDQSCRRTDS=CACEBLPAJEAMCMJMGPHFAEOB; ASPSESSIONIDSQCTQTCS=HNCMFMPAEKHOCBIEFGDHDDLH; ASPSESSIONIDQQCTRTCS=OMKMBNPAOFLEBJBEGOKDNIIF; ASPSESSIONIDQSBTQSCS=OHDGKNPACFIHDDFNANILEPKF; token=8f5d2c916cf9a2051dea789e96780d5d; ASPSESSIONIDSQBQSSDT=KNFMMBABCBPCEFDLDGGAGLJO; ASPSESSIONIDQSASQTDT=CDAFIBABKOLMLCOGGMEINGBM";
			for(String str:cookisStr.split("\\;")){
				cookisMap.put(str.split("\\=")[0],str.split("\\=")[1]);
			}
			
	          
			 
			 for(Cookie c:getObjToFile(uname)){
					// System.out.println(c.getName()+"===="+c.getValue());
					// buffer.append(c.getName()).append("=").append(c.getValue()).append("; ");
				 cookisMap.put(c.getName(), c.getValue());
				 }
			 
			 StringBuffer buffer = new StringBuffer();
			 
			 for(Entry<String, String> en:cookisMap.entrySet()){
				 buffer.append( en.getKey()).append("=").append(en.getValue()).append("; ");
			 }
			 
			 System.out.println(buffer.toString());
				
			httpRequest.header("Cookie",buffer.toString());	
		 
		 HttpResponse response = httpRequest.send();
		 response = response.charset("gb2312");
		 String rc = response.bodyText();
		 System.out.println(rc);
		 
		 if(rc.contains(id)){
			 return true;
		 }else{
			 return false;
		 }
	}
	
	public static void setCookis(String uname,HttpRequest httpRequest)throws Exception{
		Map<String, String> cookisMap = new HashMap<String, String>();
		String cookisStr = "random=8696; ASPSESSIONIDSQCRRSDT=PMFGMKPANNDIPLFIEAGFOJHD; dtk_web=mgbpf1uvaohssnvee7m02u1lt7; UM_distinctid=15b906fc3d99a-0ca45cd09b0c9d-12616a4a-1fa400-15b906fc3db105; CNZZDATA1257179126=1538129784-1492772062-http%253A%252F%252Fwww.dataoke.com%252F%7C1492777462; userid=537000; user_email=15201733860; user%5Femail=15201733860; upe=537e2926; e88a8013345a8f05461081898691958c=834b4337570611838d9b6989521575fb85ae30b6a%3A4%3A%7Bi%3A0%3Bs%3A6%3A%22537000%22%3Bi%3A1%3Bs%3A11%3A%2215201733860%22%3Bi%3A2%3Bi%3A2592000%3Bi%3A3%3Ba%3A0%3A%7B%7D%7D; ASPSESSIONIDSSBQSTCT=ICEPOLPACLKKGLDMHNNFFFIA; ASPSESSIONIDQSCRRTDS=CACEBLPAJEAMCMJMGPHFAEOB; ASPSESSIONIDSQCTQTCS=HNCMFMPAEKHOCBIEFGDHDDLH; ASPSESSIONIDQQCTRTCS=OMKMBNPAOFLEBJBEGOKDNIIF; ASPSESSIONIDQSBTQSCS=OHDGKNPACFIHDDFNANILEPKF; token=8f5d2c916cf9a2051dea789e96780d5d; ASPSESSIONIDSQBQSSDT=KNFMMBABCBPCEFDLDGGAGLJO; ASPSESSIONIDQSASQTDT=CDAFIBABKOLMLCOGGMEINGBM";
		for (String str : cookisStr.split("\\;")) {
			cookisMap.put(str.split("\\=")[0], str.split("\\=")[1]);
		}

		for (Cookie c : getObjToFile(uname)) {
			// System.out.println(c.getName()+"===="+c.getValue());
			// buffer.append(c.getName()).append("=").append(c.getValue()).append("; ");
			cookisMap.put(c.getName(), c.getValue());
		}

		StringBuffer buffer = new StringBuffer();

		for (Entry<String, String> en : cookisMap.entrySet()) {
			buffer.append(en.getKey()).append("=").append(en.getValue())
					.append("; ");
		}

		// System.out.println(buffer.toString());

		httpRequest.header("Cookie", buffer.toString());
	}
	
	
	public static boolean pidAdd(String uname,String pid,String type) throws Exception {

		//set_wx
       //set_qq
		String url = "http://www.dataoke.com/ucenter/mypid.asp?act="+type+"&id="+pid;
		HttpRequest httpRequest = HttpRequest.get(url);
		httpRequest.header("Host", "www.dataoke.com");
		httpRequest
				.header("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0");
		httpRequest.header("Referer",
				"http://www.dataoke.com/ucenter/mypid.asp");
		httpRequest.header("Upgrade-Insecure-Requests", "1");
		httpRequest.header("Connection", "keep-alive");
		httpRequest.header("X-Requested-With", "XMLHttpRequest");
		httpRequest
				.header("Accept",
						"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		httpRequest.header("Accept-Language",
				"zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		httpRequest.header("X-Requested-With", "XMLHttpRequest");

		setCookis(uname, httpRequest);

		HttpResponse response = httpRequest.send();
		response = response.charset("gb2312");
		String rc = response.bodyText();

		//System.out.println("pidAddwx：" + rc);

		if (rc.contains("欢迎")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String queryPidByName(String uname,String pname) throws Exception {

		String url = "http://www.dataoke.com/ucenter/mypid.asp";
		HttpRequest httpRequest = HttpRequest.get(url);
		httpRequest.header("Host", "www.dataoke.com");
		httpRequest
				.header("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0");
		httpRequest.header("Referer",
				"http://www.dataoke.com/ucenter/mypid.asp");
		httpRequest.header("Upgrade-Insecure-Requests", "1");
		httpRequest.header("Connection", "keep-alive");
		httpRequest.header("X-Requested-With", "XMLHttpRequest");
		httpRequest
				.header("Accept",
						"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		httpRequest.header("Accept-Language",
				"zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		httpRequest.header("X-Requested-With", "XMLHttpRequest");

		setCookis(uname, httpRequest);
		
		HttpResponse response = httpRequest.send();
		response = response.charset("gb2312");
		String rc = response.bodyText();

		//System.out.println("createPid返回结果：" + rc);

		if (rc.contains("PID管理")) {
			Document document = Jsoup.parse(rc);
			Elements elements = document.getElementsByTag("tr");
			for(Element element:elements){
				String html = element.html();
				if(html.contains(pname) && !html.contains("领券优惠")){
					//System.out.println(html);
					//System.out.println("===============================");
					elements = element.getElementsByTag("a");
					for(Element e:elements){
						//System.out.println(e.html());
						String href = e.attr("href");
						if(StringUtils.isNotBlank(href) && href.contains("id=")){
							return href.replace("?act=set_qq&id=", "").replace("?act=set_wx&id=", "");
						}
					}
				}
			}
			
			
			return "";
		} else {
			return "";
		}
	}
	
	public static boolean createPidAll(String uname)throws Exception{
		 String title=createPid(uname);
		 System.out.println("title: "+title);
		 if(StringUtils.isNotBlank(title)){
			 String pid = queryPidByName(uname, title);
			 Thread.sleep(1000);
			 boolean flag = pidAdd(uname, pid, "set_wx");
			 System.out.println("设为微信专用>>>>>>>>>>>>>>>"+flag);
		 }
		 Thread.sleep(1000);
		 title=createPid(uname);
		 System.out.println("title: "+title);
		 if(StringUtils.isNotBlank(title)){
			 String pid = queryPidByName(uname, title);
			 Thread.sleep(1000);
			 boolean flag =  pidAdd(uname, pid, "set_qq");
			 System.out.println("设为Q群专用>>>>>>>>>>>>>>>"+flag);
		 }
		 return true;
	}
	
	public static String createPid(String uname) throws Exception {

		String url = "http://www.dataoke.com/ucenter/mypid.asp?act=add";
		HttpRequest httpRequest = HttpRequest.post(url);
		httpRequest.header("Host", "www.dataoke.com");
		httpRequest
				.header("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0");
		httpRequest.header("Referer",
				"http://www.dataoke.com/ucenter/mypid.asp");
		httpRequest.header("Upgrade-Insecure-Requests", "1");
		httpRequest.header("Connection", "keep-alive");
		httpRequest.header("X-Requested-With", "XMLHttpRequest");
		httpRequest
				.header("Accept",
						"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		httpRequest.header("Accept-Language",
				"zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		//httpRequest.header("X-Requested-With", "XMLHttpRequest");

		setCookis(uname, httpRequest);
		
		String title = CharUtil.drawRandomNum();
		//title = "Æ¬³åÊý·Å¶¼";
		String pid = CharUtil.getRandomPid();
		httpRequest.form("title", title);
		httpRequest.form("tong_pid", pid);
		httpRequest.form("Submit", " ´´ ½¨ ");
		
		httpRequest.charset("gb2312");
		
		System.out.println("title: "+title + " pid : "+pid);

		HttpResponse response = httpRequest.send();
		response = response.charset("gb2312");
		String rc = response.bodyText();

		//System.out.println("createPid返回结果：" + rc);

		if (rc.contains("创建成功")) {
			//String ppid = queryPidByName(uname, title);
			return title;
		} else {
			return "";
		}
	}
	
	public static boolean zhuan(String uname,String ppid)throws Exception {
		try{
			boolean flag = tuijian2to1_1(uname, ppid);
			System.out.println("二转一第一步>>>>>>>>>>>>>>>>>>>>>>>"+flag);
			
			if(!flag){
				return flag;
			}
			
			flag = tuijian2to1_2(uname, ppid);
			System.out.println("二转一第二步>>>>>>>>>>>>>>>>>>>>>>>"+flag);
			
			return flag;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static boolean tuijian2to1_1(String uname,String ppid) throws Exception {

		String url = "http://www.dataoke.com/dtpwd";
		HttpRequest httpRequest = HttpRequest.post(url);
		httpRequest.header("Host", "www.dataoke.com");
		httpRequest
				.header("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0");
		httpRequest.header("Referer",
				"http://www.dataoke.com/item?id="+ppid);
		httpRequest.header("Upgrade-Insecure-Requests", "1");
		httpRequest.header("Connection", "keep-alive");
		httpRequest.header("X-Requested-With", "XMLHttpRequest");
		httpRequest
				.header("Accept",
						"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		httpRequest.header("Accept-Language",
				"zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		//httpRequest.header("X-Requested-With", "XMLHttpRequest");

		setCookis(uname, httpRequest);
		
		httpRequest.form("gid", ppid);
		httpRequest.form("type", 1);
		
		httpRequest.charset("gb2312");
		

		HttpResponse response = httpRequest.send();
		response = response.charset("gb2312");
		String rc = response.bodyText();

		//System.out.println("createPid返回结果：" + rc);

		if (rc.contains(":1")) {
			//String ppid = queryPidByName(uname, title);
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean tuijian2to1_2(String uname,String ppid) throws Exception {

		String url = "http://www.dataoke.com/detailtpl";
		HttpRequest httpRequest = HttpRequest.post(url);
		httpRequest.header("Host", "www.dataoke.com");
		httpRequest
				.header("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0");
		httpRequest.header("Referer",
				"http://www.dataoke.com/item?id="+ppid);
		httpRequest.header("Upgrade-Insecure-Requests", "1");
		httpRequest.header("Connection", "keep-alive");
		httpRequest.header("X-Requested-With", "XMLHttpRequest");
		httpRequest
				.header("Accept",
						"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		httpRequest.header("Accept-Language",
				"zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		//httpRequest.header("X-Requested-With", "XMLHttpRequest");

		setCookis(uname, httpRequest);
		
		httpRequest.form("gid", ppid);
		
		httpRequest.charset("gb2312");

		HttpResponse response = httpRequest.send();
		response = response.charset("gb2312");
		String rc = response.bodyText();

		//System.out.println("createPid返回结果：" + rc);

		if (rc.contains(":1")) {
			//String ppid = queryPidByName(uname, title);
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean biaojiAction(String goodId,String uname)throws Exception{
		
			String url ="http://www.dataoke.com/ucenter/save.asp?act=setup_fav_sendtime&gid="+goodId+"&_="+System.currentTimeMillis();
	HttpRequest httpRequest = HttpRequest.get(url);
	 httpRequest.header("Host", "www.dataoke.com");
	 httpRequest.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0");
	 httpRequest.header("Referer", "http://www.dataoke.com/ucenter/favorites_quan.asp");
	 httpRequest.header("Upgrade-Insecure-Requests", "1");
	 httpRequest.header("Connection", "keep-alive");
	 httpRequest.header("X-Requested-With", "XMLHttpRequest");
	 httpRequest.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
	 httpRequest.header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
	 httpRequest.header("X-Requested-With", "XMLHttpRequest");
	 

		setCookis(uname, httpRequest);
	 
	 HttpResponse response = httpRequest.send();
	 response = response.charset("gb2312");
	 String rc = response.bodyText();
	 
	 System.out.println("标记返回结果："+rc);
	 
	 if(rc.contains("成功")){
		 return true;
	 }else{
		 return false;
	 }
	}
	
	public static boolean biaoji(String id,String uname)throws Exception{
		
		String url ="http://www.dataoke.com/ucenter/favorites_quan.asp";
		HttpRequest httpRequest = HttpRequest.get(url);
		// httpRequest.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		 httpRequest.header("Host", "www.dataoke.com");
		 httpRequest.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0");
		 httpRequest.header("Referer", "http://www.dataoke.com/ucenter/favorites_quan.asp");
		 httpRequest.header("Upgrade-Insecure-Requests", "1");
		 httpRequest.header("Connection", "keep-alive");
		 httpRequest.header("X-Requested-With", "XMLHttpRequest");
		 httpRequest.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		 httpRequest.header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		 httpRequest.header("X-Requested-With", "XMLHttpRequest");
		 
        setCookis(uname, httpRequest);
		 
		 HttpResponse response = httpRequest.send();
		 response = response.charset("gb2312");
		 String rc = response.bodyText();
		 
		 Document document = Jsoup.parse(rc);
		 
		Element elementId = document.getElementById("fav_add_rz_"+id);
		
		//System.out.println(elementId.attr("title"));
		
		elementId = elementId.previousElementSibling();
		String goodsId = elementId.attr("id");
		 System.out.println("id==="+id+" 获取商品id为："+goodsId);
		 if(StringUtils.isNotBlank(goodsId)){
			 goodsId = goodsId.replace("fav_sendtime_", "");
			 Thread.sleep(1000);
			 boolean bflag = biaojiAction(goodsId, uname);
			 System.out.println("商品："+id +" 标记结果："+bflag);
			 return bflag;
		 }
		
		/* Elements elements = document.getElementsByClass("fav_sendtime");
		 if(CollectionUtils.isNotEmpty(elements)){
			 Element element = elements.get(0);
			 String goodsId = element.attr("id");
			 System.out.println("获取商品id为："+goodsId);
			 if(StringUtils.isNotBlank(goodsId)){
				 goodsId = goodsId.replace("fav_sendtime_", "");
				 Thread.sleep(1000);
				 boolean bflag = biaojiAction(goodsId, uname);
				 System.out.println("商品："+id +" 标记结果："+bflag);
				 return bflag;
			 }
		 }*/
		 
		 
		 
			 return false;
	}
	
	
	public static boolean deleteId(String id,String uname)throws Exception{
		String url ="http://www.dataoke.com/ucenter/save.asp?act=setup_fav_sendtime&gid=530456660905&_="+System.currentTimeMillis();
		HttpRequest httpRequest = HttpRequest.get(url);
		 httpRequest.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		 httpRequest.header("Host", "www.dataoke.com");
		 httpRequest.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0");
		 httpRequest.header("Referer", "http://www.dataoke.com/ucenter/favorites_quan.asp");
		 httpRequest.header("Connection", "keep-alive");
		 
		 Cookie[]  cookies = map.get(uname);
		 if(ArrayUtils.isNotEmpty(cookies)){
			 System.out.println("uanem ==="+uname+"  cookis 存在");
			 httpRequest.cookies(cookies);
		 }else{
			 cookies = getObjToFile(uname);
			 httpRequest.cookies(cookies);
		 }
		 
		 HttpResponse response = httpRequest.send().charset("utf-8");
		 String rc = response.bodyText();
		 System.out.println(rc);
		 
		 if(rc.contains("成功")){
			 return true;
		 }
		return false;
	}
	
	
	public static boolean addObjTOfile(Cookie[] obj,String id)throws Exception{
		try{
			File file = new File(fileStoreBase, id);
			if(file.exists()){
				file.delete();
			}
			//序列化对象
	        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
	        out.writeObject(obj);    //写入字面值常量
	        out.close();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
        return true;
      
	}
	
	public static Cookie[] getObjToFile(String id)throws Exception{
		System.out.println("id=="+id+"读取cookid文件");
		File file = new File(fileStoreBase, id);
		if(!file.exists()){
			return null;
		}
		  //反序列化对象
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Cookie[] obj3 = (Cookie[]) in.readObject();    //读取customer对象
        in.close();
        return obj3;
	}
	
	public static void execteDeleteAll(File... files)throws Exception{
		for(File f:files){
			executeDelete( f);
		}
	}
	
	public static void executeDelete(File file)throws Exception{
		List<String> lists=FileUtils.readLines(file);
		for(String s:lists){
			if(StringUtils.isBlank(s)){
				continue;
			}
			count++;
			String uname = s.split("\\----")[0].trim();
			String pwd = s.split("\\----")[1].trim();
			System.out.println("u = "+uname + "p = "+pwd +" 开始登陆  当前已刷>>>>>>>>>>>>>>>"+count +"当前 文件名称："+file.getName());
			
			boolean flag = login(uname,pwd);
			System.out.println("u = "+uname + "登陆>>>>>>>>>>>>>"+flag);
			Thread.sleep(1000);
			if(flag){
				flag = deleteAll(uname);
				//flag = tuijianToFile(pid,uname);
				if(flag){
					System.out.println("删除成功》》》》》》》》》》》》》》》》》》》 uname="+uname);
				}else{
					System.out.println("删除失败》》》》》》》》》》》》》》》》》》uname="+uname);
				}
			}
			Thread.sleep(1000);
		}
	}
	
	public static void execteAll(String[] pid,File... files)throws Exception{
		for(File f:files){
			execute(pid, f);
		}
	}
	
	public static boolean readDetailWebClient(String pid){
		String url = "http://www.dataoke.com/item?id="+pid;
		WebClient webClient = HtmlUnitUtil.create();
		try {
			HtmlPage htmlPage = webClient.getPage(url);
			Thread.sleep(1000);
			 if(htmlPage.asXml().contains("商家合作")){
				 return true;
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 点击商品详情
	 * @param pid
	 * @param uname
	 * @return
	 */
	public static boolean readDetailHttp(String pid,String uname){
		String url = "http://www.dataoke.com/item?id="+pid;
		try{
			 HttpRequest httpRequest = HttpRequest.get(url).timeout(30000);
			 httpRequest.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			 httpRequest.header("Host", "www.dataoke.com");
			 httpRequest.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0");
			 //httpRequest.header("Referer", "http://www.dataoke.com/item?id="+id);
			 //http://www.dataoke.com/search/?keywords=%E5%A4%8F%E5%AD%A3%E5%A5%B3%E5%A3%AB&xuan=keyword_miaoshu
			 httpRequest.header("Referer", "http://www.dataoke.com/top_tui");
			 httpRequest.header("Upgrade-Insecure-Requests", "1");
			 httpRequest.header("Connection", "keep-alive");
			 httpRequest.header("X-Requested-With", "XMLHttpRequest");
			 
			 Cookie[]  cookies = map.get(uname);
			 if(ArrayUtils.isNotEmpty(cookies)){
				 System.out.println("uanem ==="+uname+"  cookis 存在");
				 httpRequest.cookies(cookies);
			 }else{
				 cookies = getObjToFile(uname);
				 httpRequest.cookies(cookies);
			 }
			 HttpResponse response = httpRequest.send();
			 response=  response.charset("utf-8");
			 String rc = response.bodyText();
			// System.out.println(rc);
			 
			 if(rc.contains("商家合作")){
				 return true;
			 }else{
				 System.out.println("商品详情返回："+rc);
			 }
			 
			}catch(Exception e){
				e.printStackTrace();
			}
		   
			 
			return false;
	
	}
	
	public static void readExecute(final String pid,final String uname){
		new Thread(){
			public void run() {
				int cout = new Random().nextInt(5);
				for(int i=0;i<cout;i++){
					try {
						boolean flag = readDetailHttp(pid, uname);
						System.out.println("uname :"+uname + " 刷阅读数结果 ："+flag);
						long time = new Random().nextInt(1000)+1000l;
						Thread.sleep(time);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();
	}
	
	static int count = 0;
	public static void execute(String[] pids,File file)throws Exception{
		//String pid ="2247791";
		//List<String> lists=FileUtils.readLines(new File("G:\\taoke\\第2组500.txt"));
		System.out.println("开始读取文件>>>>>>>>>>"+file.getAbsolutePath());
		List<String> lists=FileUtils.readLines(file);
		for(String s:lists){
			if(StringUtils.isBlank(s)){
				continue;
			}
			count++;
			
			/*if(623>count){
				continue;
			}*/
			
			
			String uname = s.split("\\----")[0].trim();
			String pwd = s.split("\\----")[1].trim();
			System.out.println("u = "+uname + "p = "+pwd +" 开始登陆  当前已刷>>>>>>>>>>>>>>>"+count+" 当前 文件名称："+file.getName());
			
			boolean flag = login(uname,pwd);
			System.out.println("u = "+uname + "登陆>>>>>>>>>>>>>"+flag);
			Thread.sleep(200);
			for(String pid:pids){
				readExecute(pid, uname);
				if(flag){
					//boolean flagt = tuijian(pid,uname);
					//flag = tuijianToFile(pid,uname);
					boolean flagt = zhuan(uname,pid);
					if(flagt){
						System.out.println("推广成功》》》》》》》》》》》》》》》》》》》pid="+pid+" uname="+uname);
						//boolean bflag = biaoji(pid, uname);
						//System.out.println("标记结果》》》》》》》》》"+bflag+"》》》》》》》》pid="+pid+" uname="+uname);
						
					}else{
						System.out.println("推广失败》》》》》》》》》》》》》》》》》》     pid="+pid+"   uname="+uname);
					}
				}
				Thread.sleep(Cmd.getSleepTime());
			}
			
		}
	}
	
	
	public static boolean tuijianToFile(String id,String uname)throws Exception{
		String url ="http://www.dataoke.com/handle_popularize";
		 HttpRequest httpRequest = HttpRequest.post(url);
		 httpRequest.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		 httpRequest.header("Host", "www.dataoke.com");
		 httpRequest.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0");
		 httpRequest.header("Referer", "http://www.dataoke.com/item?id="+id);
		 httpRequest.header("Upgrade-Insecure-Requests", "1");
		 httpRequest.header("Connection", "keep-alive");
		 httpRequest.header("X-Requested-With", "XMLHttpRequest");
		 
		 Cookie[]  cookies = getObjToFile(uname);
		 if(ArrayUtils.isNotEmpty(cookies)){
			 System.out.println("uanem ==="+uname+"  cookis 存在");
			 httpRequest.cookies(cookies);
		 }
		 //act=add_quan&id=2231931
		 httpRequest.form("act", "add_quan");
		 httpRequest.form("id", id);
		 
		 HttpResponse response = httpRequest.send();
		 String rc = response.bodyText();
		 System.out.println("tuijianToFile===="+rc);
		 
		 if(rc.equalsIgnoreCase("ok")){
			 return true;
		 }
		 
		return false;
	}
	
	public static boolean deleteById(String id,String uname)throws Exception{
		String url ="http://www.dataoke.com/ucenter/save.asp?act=del_my_quan&id="+id;
		HttpRequest httpRequest = HttpRequest.get(url);
		 httpRequest.header("Host", "www.dataoke.com");
		 httpRequest.header("Content-Type", "application/x-www-form-urlencoded");
		 httpRequest.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0");
		 httpRequest.header("Referer", "http://www.dataoke.com/ucenter/favorites_quan.asp");
		 httpRequest.header("Connection", "keep-alive");
		 httpRequest.header("X-Requested-With", "XMLHttpRequest");
		 //httpRequest.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		 //httpRequest.header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		// httpRequest.header("Accept-Encoding", "gzip, deflate");
		 
		
			
		 
		Map<String, String> cookisMap = new HashMap<String, String>();
		String cookisStr = "random=8696; ASPSESSIONIDSQCRRSDT=PMFGMKPANNDIPLFIEAGFOJHD; dtk_web=mgbpf1uvaohssnvee7m02u1lt7; UM_distinctid=15b906fc3d99a-0ca45cd09b0c9d-12616a4a-1fa400-15b906fc3db105; CNZZDATA1257179126=1538129784-1492772062-http%253A%252F%252Fwww.dataoke.com%252F%7C1492777462; userid=537000; user_email=15201733860; user%5Femail=15201733860; upe=537e2926; e88a8013345a8f05461081898691958c=834b4337570611838d9b6989521575fb85ae30b6a%3A4%3A%7Bi%3A0%3Bs%3A6%3A%22537000%22%3Bi%3A1%3Bs%3A11%3A%2215201733860%22%3Bi%3A2%3Bi%3A2592000%3Bi%3A3%3Ba%3A0%3A%7B%7D%7D; ASPSESSIONIDSSBQSTCT=ICEPOLPACLKKGLDMHNNFFFIA; ASPSESSIONIDQSCRRTDS=CACEBLPAJEAMCMJMGPHFAEOB; ASPSESSIONIDSQCTQTCS=HNCMFMPAEKHOCBIEFGDHDDLH; ASPSESSIONIDQQCTRTCS=OMKMBNPAOFLEBJBEGOKDNIIF; ASPSESSIONIDQSBTQSCS=OHDGKNPACFIHDDFNANILEPKF; token=8f5d2c916cf9a2051dea789e96780d5d; ASPSESSIONIDSQBQSSDT=KNFMMBABCBPCEFDLDGGAGLJO; ASPSESSIONIDQSASQTDT=CDAFIBABKOLMLCOGGMEINGBM";
		for(String str:cookisStr.split("\\;")){
			cookisMap.put(str.split("\\=")[0],str.split("\\=")[1]);
		}
		
          
		 
		 for(Cookie c:getObjToFile(uname)){
				// System.out.println(c.getName()+"===="+c.getValue());
				// buffer.append(c.getName()).append("=").append(c.getValue()).append("; ");
			 cookisMap.put(c.getName(), c.getValue());
			 }
		 
		 StringBuffer buffer = new StringBuffer();
		 
		 for(Entry<String, String> en:cookisMap.entrySet()){
			 buffer.append( en.getKey()).append("=").append(en.getValue()).append("; ");
		 }
		 
		 System.out.println(buffer.toString());
			
		httpRequest.header("Cookie",buffer.toString());	
			
		//httpRequest.header("Cookie","random=8696; ASPSESSIONIDSQCRRSDT=PMFGMKPANNDIPLFIEAGFOJHD; dtk_web=mgbpf1uvaohssnvee7m02u1lt7; UM_distinctid=15b906fc3d99a-0ca45cd09b0c9d-12616a4a-1fa400-15b906fc3db105; CNZZDATA1257179126=1538129784-1492772062-http%253A%252F%252Fwww.dataoke.com%252F%7C1492777462; userid=537000; user_email=15201733860; user%5Femail=15201733860; upe=537e2926; e88a8013345a8f05461081898691958c=834b4337570611838d9b6989521575fb85ae30b6a%3A4%3A%7Bi%3A0%3Bs%3A6%3A%22537000%22%3Bi%3A1%3Bs%3A11%3A%2215201733860%22%3Bi%3A2%3Bi%3A2592000%3Bi%3A3%3Ba%3A0%3A%7B%7D%7D; ASPSESSIONIDSSBQSTCT=ICEPOLPACLKKGLDMHNNFFFIA; ASPSESSIONIDQSCRRTDS=CACEBLPAJEAMCMJMGPHFAEOB; ASPSESSIONIDSQCTQTCS=HNCMFMPAEKHOCBIEFGDHDDLH; ASPSESSIONIDQQCTRTCS=OMKMBNPAOFLEBJBEGOKDNIIF; ASPSESSIONIDQSBTQSCS=OHDGKNPACFIHDDFNANILEPKF; token=8f5d2c916cf9a2051dea789e96780d5d; ASPSESSIONIDSQBQSSDT=KNFMMBABCBPCEFDLDGGAGLJO; ASPSESSIONIDQSASQTDT=CDAFIBABKOLMLCOGGMEINGBM");
		 
			
			
		 /*Cookie[]  cookies = map.get(uname);
		 if(ArrayUtils.isNotEmpty(cookies)){
			 System.out.println("uanem ==="+uname+"  cookis 存在");
			 httpRequest.cookies(cookies);
		 }else{
			 cookies = getObjToFile(uname);
			 httpRequest.cookies(cookies);
		 }*/
		 
		 
		 HttpResponse response = httpRequest.send();
		 String rc = response.bodyText();
		 System.out.println(rc);
		
		
		//String rc = "";
		 
		 
		 if(rc.equalsIgnoreCase("ok")){
			 System.out.println("id=="+id+" 删除成功>>>>>>>>>>>>>>>");
			 return true;
		 }
		 
		return false;
	}
	
	public static boolean deleteAll(String uname)throws Exception{
		String url ="http://www.dataoke.com/ucenter/all_del_quan.asp?act=del";
		HttpRequest httpRequest = HttpRequest.post(url);
		 httpRequest.header("Host", "www.dataoke.com");
		 httpRequest.header("Content-Type", "application/x-www-form-urlencoded");
		 httpRequest.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0");
		 httpRequest.header("Referer", "http://www.dataoke.com/ucenter/all_del_quan.asp");
		 httpRequest.header("Upgrade-Insecure-Requests", "1");
		 httpRequest.header("Connection", "keep-alive");
		 httpRequest.header("X-Requested-With", "XMLHttpRequest");
		 httpRequest.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		 httpRequest.header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		// httpRequest.header("Accept-Encoding", "gzip, deflate");
		 
		 
		
			Map<String, String> cookisMap = new HashMap<String, String>();
			String cookisStr = "random=8696; ASPSESSIONIDSQCRRSDT=PMFGMKPANNDIPLFIEAGFOJHD; dtk_web=mgbpf1uvaohssnvee7m02u1lt7; UM_distinctid=15b906fc3d99a-0ca45cd09b0c9d-12616a4a-1fa400-15b906fc3db105; CNZZDATA1257179126=1538129784-1492772062-http%253A%252F%252Fwww.dataoke.com%252F%7C1492777462; userid=537000; user_email=15201733860; user%5Femail=15201733860; upe=537e2926; e88a8013345a8f05461081898691958c=834b4337570611838d9b6989521575fb85ae30b6a%3A4%3A%7Bi%3A0%3Bs%3A6%3A%22537000%22%3Bi%3A1%3Bs%3A11%3A%2215201733860%22%3Bi%3A2%3Bi%3A2592000%3Bi%3A3%3Ba%3A0%3A%7B%7D%7D; ASPSESSIONIDSSBQSTCT=ICEPOLPACLKKGLDMHNNFFFIA; ASPSESSIONIDQSCRRTDS=CACEBLPAJEAMCMJMGPHFAEOB; ASPSESSIONIDSQCTQTCS=HNCMFMPAEKHOCBIEFGDHDDLH; ASPSESSIONIDQQCTRTCS=OMKMBNPAOFLEBJBEGOKDNIIF; ASPSESSIONIDQSBTQSCS=OHDGKNPACFIHDDFNANILEPKF; token=8f5d2c916cf9a2051dea789e96780d5d; ASPSESSIONIDSQBQSSDT=KNFMMBABCBPCEFDLDGGAGLJO; ASPSESSIONIDQSASQTDT=CDAFIBABKOLMLCOGGMEINGBM";
			for(String str:cookisStr.split("\\;")){
				cookisMap.put(str.split("\\=")[0],str.split("\\=")[1]);
			}
			
	          
			 
			 for(Cookie c:getObjToFile(uname)){
					// System.out.println(c.getName()+"===="+c.getValue());
					// buffer.append(c.getName()).append("=").append(c.getValue()).append("; ");
				 cookisMap.put(c.getName(), c.getValue());
				 }
			 
			 StringBuffer buffer = new StringBuffer();
			 
			 for(Entry<String, String> en:cookisMap.entrySet()){
				 buffer.append( en.getKey()).append("=").append(en.getValue()).append("; ");
			 }
			 
			 System.out.println(buffer.toString());
				
			httpRequest.header("Cookie",buffer.toString());	
			
			
		 
		/* Cookie[]  cookies = map.get(uname);
		 if(ArrayUtils.isNotEmpty(cookies)){
			 System.out.println("uanem ==="+uname+"  cookis 存在");
			 httpRequest.cookies(cookies);
		 }else{
			 cookies = getObjToFile(uname);
			 httpRequest.cookies(cookies);
		 }*/
		 
		 
		 //act=add_quan&id=2231931
		 httpRequest.form("leibie", "0");
		 httpRequest.form("zh_que_bt", "%C8%B7%C8%CF%C9%BE%B3%FD");
		// httpRequest.form("zh_que_bt", "È·ÈÏÉ¾³ý");
		 
		 
		 HttpResponse response = httpRequest.send();
		 response.charset("gb2312");
		 String rc = response.bodyText();
		 System.out.println(rc);
		 
		 
		 if(rc.contains("删除成功")){
			 System.out.println("id=="+uname+" 删除成功>>>>>>>>>>>>>>>");
			 return true;
		 }
		 
		return false;
	}
	
	public static boolean tuijian(String id,String uname)throws Exception{
		try{
		String url ="http://www.dataoke.com/handle_popularize";
		HttpRequest httpRequest = HttpRequest.post(url).timeout(30000);
		 httpRequest.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		 httpRequest.header("Host", "www.dataoke.com");
		 httpRequest.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0");
		 httpRequest.header("Referer", "http://www.dataoke.com/item?id="+id);
		 httpRequest.header("Upgrade-Insecure-Requests", "1");
		 httpRequest.header("Connection", "keep-alive");
		 httpRequest.header("X-Requested-With", "XMLHttpRequest");
		 
		 Cookie[]  cookies = map.get(uname);
		 if(ArrayUtils.isNotEmpty(cookies)){
			 System.out.println("uanem ==="+uname+"  cookis 存在");
			 httpRequest.cookies(cookies);
		 }else{
			 cookies = getObjToFile(uname);
			 httpRequest.cookies(cookies);
		 }
		 //act=add_quan&id=2231931
		 httpRequest.form("act", "add_quan");
		 httpRequest.form("id", id);
		 
		 HttpResponse response = httpRequest.send();
		 String rc = response.bodyText();
		 System.out.println(rc);
		 
		 if(rc.equalsIgnoreCase("ok")){
			 return true;
		 }
		 
		}catch(Exception e){
			e.printStackTrace();
		}
		 
		return false;
	}
	
	public static boolean login(String uname,String pwd)throws Exception{
		System.out.println("开始查找cookis文件是否存在>>>>>>>>>>>>>>>>>>");
		Cookie[]  cookies = getObjToFile(uname);
		if(ArrayUtils.isNotEmpty(cookies)){
			System.out.println("cookis文件存在>>>>>>>>>>>>>>>>>>返回登录成功");
			return true;
		}
		
		
		System.out.println("用户开始登陆："+uname);
		 String baseURI = "http://www.dataoke.com/loginApi";
		 HttpRequest httpRequest = HttpRequest.post(baseURI).timeout(20000);
		 httpRequest.header("Content-Type", "application/json");
		 httpRequest.header("Host", "www.dataoke.com");
		 httpRequest.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0");
		 httpRequest.header("Referer", "http://www.dataoke.com/login");
		 httpRequest.header("Upgrade-Insecure-Requests", "1");
		 httpRequest.header("Connection", "application/json");
		// httpRequest.header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		// httpRequest.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		 
		 //username=15201733860&password=1qaz2wsx&vc=&ref=
		 //Cookie	random=9069; UM_distinctid=15b809dffcb9-00e25cf7281db-47534130-15f900-15b809dffcc172; CNZZDATA1257179126=2114245438-1492507982-http%253A%252F%252Fwww.dataoke.com%252F%7C1492507982; dtk_web=2prh3gjms7ut0g2r3fnm1oiap2; upe=98bf65d2; ASPSESSIONIDQSBSQSDT=CGNGMEPCJLPEEEMKOKKBJNCC; ASPSESSIONIDSSDTRTCS=HEDHLEPCNOOCHALCBPCKPEFN; token=15e519c05e03cdc8d3fb524de429edfa; ASPSESSIONIDQSBTQSCT=ADIDAGPCLLIMIEMMDGINPMCL; userid=538278; user_email=17097636339; user%5Femail=17097636339; e88a8013345a8f05461081898691958c=c33d184d1d3e5173a78fcd3eb25d0ed092bb3d58a%3A4%3A%7Bi%3A0%3Bs%3A6%3A%22538278%22%3Bi%3A1%3Bs%3A11%3A%2217097636339%22%3Bi%3A2%3Bi%3A2592000%3Bi%3A3%3Ba%3A0%3A%7B%7D%7D
		 
		//httpRequest.header("Cookie", "random=9069; UM_distinctid=15b809dffcb9-00e25cf7281db-47534130-15f900-15b809dffcc172; CNZZDATA1257179126=2114245438-1492507982-http%253A%252F%252Fwww.dataoke.com%252F%7C1492507982; dtk_web=2prh3gjms7ut0g2r3fnm1oiap2; upe=98bf65d2; ASPSESSIONIDQSBSQSDT=CGNGMEPCJLPEEEMKOKKBJNCC; ASPSESSIONIDSSDTRTCS=HEDHLEPCNOOCHALCBPCKPEFN; token=15e519c05e03cdc8d3fb524de429edfa; ASPSESSIONIDQSBTQSCT=ADIDAGPCLLIMIEMMDGINPMCL; userid=538278; user_email=17097636339; user%5Femail=17097636339; e88a8013345a8f05461081898691958c=c33d184d1d3e5173a78fcd3eb25d0ed092bb3d58a%3A4%3A%7Bi%3A0%3Bs%3A6%3A%22538278%22%3Bi%3A1%3Bs%3A11%3A%2217097636339%22%3Bi%3A2%3Bi%3A2592000%3Bi%3A3%3Ba%3A0%3A%7B%7D%7D");
		 
		 
		 httpRequest.header("Cookie", "random=8337; ASPSESSIONIDSQCRRSDT=PMFGMKPANNDIPLFIEAGFOJHD; dtk_web=mgbpf1uvaohssnvee7m02u1lt7; UM_distinctid=15b906fc3d99a-0ca45cd09b0c9d-12616a4a-1fa400-15b906fc3db105; CNZZDATA1257179126=1538129784-1492772062-http%253A%252F%252Fwww.dataoke.com%252F%7C1492773526; userid=537000; user_email=15201733860; user%5Femail=15201733860; upe=537e2926; e88a8013345a8f05461081898691958c=834b4337570611838d9b6989521575fb85ae30b6a%3A4%3A%7Bi%3A0%3Bs%3A6%3A%22537000%22%3Bi%3A1%3Bs%3A11%3A%2215201733860%22%3Bi%3A2%3Bi%3A2592000%3Bi%3A3%3Ba%3A0%3A%7B%7D%7D; ASPSESSIONIDSSBQSTCT=ICEPOLPACLKKGLDMHNNFFFIA; ASPSESSIONIDQSCRRTDS=CACEBLPAJEAMCMJMGPHFAEOB; ASPSESSIONIDSQCTQTCS=HNCMFMPAEKHOCBIEFGDHDDLH; token=41d5a8a7ada70ee5b3840f0b84ef60d1; ASPSESSIONIDQQCTRTCS=OMKMBNPAOFLEBJBEGOKDNIIF");
		 
		 httpRequest.form("username", uname);
		 httpRequest.form("password", pwd);
		 httpRequest.form("vc", "");
		 httpRequest.form("ref", "");
		 
		 HttpResponse response = httpRequest.send();
		 String rc = response.bodyText();
		 System.out.println(rc);
		 
		 
		  cookies = response.cookies();
		 
		 for(Cookie c:cookies){
			// System.out.println(c.getName()+"===="+c.getValue());
		 }
		 
		// System.out.println("================================="+httpRequest.header("Cookie"));
		 
		 
		 //System.out.println("response.headers()");
		
		// System.out.println(response.headers());
		 
		 
		 if(rc.contains("1")){
			 map.put(uname, cookies);
			 addObjTOfile(cookies, uname);
			 return true;
		 }
		 
		 return false;
		 
		
	}

}
