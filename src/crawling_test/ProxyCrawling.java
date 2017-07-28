package crawling_test;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.commons.codec.binary.Base64;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ProxyCrawling {

    public static void main(String[] args) throws Exception{

//        String strKeyword    = URLEncoder.encode("신발", "UTF-8");
//        String strUrl            = "http://search.naver.com/search.naver?where=nexearch&sm=osd&ie=UTF-8&query="+strKeyword;
//        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 10));
//        URL url = new URL(strUrl);
//        HttpURLConnection uc = (HttpURLConnection)url.openConnection(proxy);
//        uc.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; InfoPath.2)");
//        uc.setRequestProperty("Accept-Language", "ko-KR");
//        uc.setRequestProperty("Method", "GET");
//        uc.setRequestProperty("Accept", "image/gif, image/xxbitmap, image/jpeg, image/pjpeg,application/xshockwaveflash, application/vnd.msexcel,application/vnd.mspowerpoint, application/msword, */*");
//        uc.setRequestProperty("Accept-Charset","UTF-8");
//        uc.setRequestProperty("Referer","http://www.kr.yahoo.com/");       
//        uc.connect();
//        
//        String line;
//        StringBuffer tmp         = new StringBuffer();
//        BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream(), "EUC-KR"));
//        while ((line = br.readLine()) != null){
//            tmp.append(line);
//        }
//       
//        System.out.println(tmp.toString());
    	

    	// ======================
//		FileWriter f0 = new FileWriter("C:/Users/student/Desktop/output.txt");
//		String newLine = System.getProperty("line.separator");
//		
//    	// if you use https, set it here too
////    	System.setProperty("http.proxyHost", "<proxyip>"); // set proxy server
////    	System.setProperty("http.proxyPort", "<proxyport>"); // set proxy port
//    	System.setProperty("https.proxyHost", "125.209.218.42");
//    	System.setProperty("https.proxyPort","80");
//	 
//    	Document doc = Jsoup.connect("http://entertain.naver.com/comment/list?oid=015&aid=0003796513").get(); // Jsoup now connects via proxy
//
//		Elements titles = doc.select("div.end_ct_area");
////		Elements titles = doc.select("ul.type01 > li");
//		int i = 0;
//		for (Element e : titles) {
//			i++;
//			System.out.println("text: " + e.text());
//			System.out.println("html: " + e.html());
//		    f0.write("text" + i + ": " + e.text() + newLine);
//		    f0.write("html" + i + ": " + e.html() + newLine);
//		}
//		f0.close();

		
		// === OR ===

    	final URL website = new URL("http://entertain.naver.com/comment/list?oid=015&aid=0003796513"); // The website you want to connect

    	// -- Setup connection through proxy
    	Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("125.209.218.42", 80)); // set proxy server and port
    	HttpURLConnection httpUrlConnetion = (HttpURLConnection) website.openConnection(proxy);
    	
    	httpUrlConnetion.connect();

    	// -- Download the website into a buffer
    	BufferedReader br = new BufferedReader(new InputStreamReader(httpUrlConnetion.getInputStream()));
    	StringBuilder buffer = new StringBuilder();
    	String str;

    	while( (str = br.readLine()) != null )
    	{
    	    buffer.append(str);
    	}

    	// -- Parse the buffer with Jsoup
    	Document doc = Jsoup.parse(buffer.toString());
    	
    	// ===========================
    	
    	System.out.println(doc);
    	
    }
}
