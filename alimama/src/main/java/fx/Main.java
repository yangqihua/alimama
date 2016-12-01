package fx;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpGet;

public class Main {
	
	String fileName = "c:\\rrz"+DateFormatUtils.format(new Date(), "yyyyMMdd");
	
	IPDao ipDao = new IPDao(new File(fileName));
	
	
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			System.out.println(new Main().getRandomAurl());
		}
	}
	
	public void execute(String ip,int prot,String url){
		try{
			HttpHost host = new HttpHost(ip, prot);;
			HttpTest http = new HttpTest();
			http.aurl = url;
			http.host = host;
			http.execute();
			System.out.println("execute ok>>>>>>>>>>>>>>>>>>>>>>");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void executeAll()throws Exception{
		HttpHost httpHost = getIp();
		System.out.println("httpHost :"+httpHost);
		boolean flag = checkIp(httpHost.getHostName(), httpHost.getPort());
		System.out.println("checkIp : "+flag);
		if(flag){
			String url = getRandomAurl();
			System.out.println("aurl : " +url);
			execute(httpHost.getHostName(), httpHost.getPort(), url);
			System.out.println("execute end >>>>>>>>>>>>>>>>>>>>>>>>");
			destroy(httpHost.getHostName());
			System.out.println("destroy end >>>>>>>>>>>>>>>>>>>>>>>>");
		}
		
	}
	
	
	public HttpHost getIp(){
		
		return null;
	}
	
	public boolean checkIp(String ip,int prot){
	    boolean flag = ipDao.containsKey(ip);
	    if(!flag){
	    	//checkIp
	    	HttpGet httpReq = new HttpGet(
					"http://haitmall.com/login.php");
			HttpTest http = new HttpTest();
			HttpHost host = new HttpHost(ip, prot);;
			String s = http.getContentByUrl(host, httpReq);
			if(StringUtils.isNotBlank(s)){
				return true;
			}
	    }
		return false;
	}
	
	public void destroy(String ip){
		ipDao.addIp(ip);
	}
	
	
	public static List<String> aurls = new ArrayList<String>();
	
	static
	{
		String aurl = PropertiesUtil.getProperty("aurl");
		System.out.println("aurl>>>>>>>>>>>>>>> "+aurl);
		for(String url:aurl.split(",")){
			aurls.add(url);
		}
		
	}
	
	public String getRandomAurl(){
		return aurls.get(new Random().nextInt(aurls.size()));
	}

}
