package crawling_test;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test_crawling_daum {
	public static void main(String[] args) {
		
		Document doc = null;
		try {
			doc = Jsoup.connect("http://movie.daum.net/boxoffice/yearly?year=2017").get();
		} catch (IOException e1) {
			System.out.println("사이트 읽는 도중 에러!!");
		}

		// div#mArticle/ul/li[1]/div[1]/span/img // image
		// image
//		Elements img = doc.select("div#mArticle > ul > li > div.info_movie > span > img");
		 
		// title
		Elements titles = doc.select("div#mArticle > ul > li > div.wrap_movie > div.info_tit > a");

		// daum_info_link

		// System.out.println(image.get(0));
//		System.out.println(img.attr("src"));
//		System.out.println(img);
//		System.out.println(titles.text());
		for (Element e : titles) {
			System.out.println(e.attr("href").replace("/moviedb/main?movieId=", ""));
		}
	}
}
