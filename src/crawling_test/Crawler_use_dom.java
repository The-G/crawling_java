package crawling_test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Proxy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler_use_dom {
	

	public static void main(String[] args) throws IOException {

		FileWriter f0 = new FileWriter("C:/Users/student/Desktop/output.txt");
		String newLine = System.getProperty("line.separator");
		
		Document doc = Jsoup
//				.connect(
//						"http://entertain.naver.com/read?oid=015&aid=0003796513") // 댓글 안긁어 진다.. 가려놈 naver가..
//				.get();	// 김수현 뉴스 기사 댓글
//				.connect(
//						"https://search.naver.com/search.naver?sm=tab_hty.top&where=news&query=%EA%B9%80%EC%88%98%ED%98%84&oquery=twice&ie=utf8&tqi=TTAiUdpySo8sscqVwmlssssssyC-056733")
//				.get(); // 김수현 뉴스 기사
//				.connect(
//						"http://movie.naver.com/movie/bi/mi/review.nhn?code=135874#")
//				.get(); // 영화 댓글
//				.connect(
//						"http://movie.naver.com/movie/bi/mi/reviewread.nhn?nid=4526239&code=135874&order=#tab")
//				.get(); // 영화 댓글 detail
				.connect(
						"http://movie.daum.net/moviedb/grade?movieId=93697&type=netizen&page=25")
				.get(); // 영화 댓글 detail // daum 영화 평점
		

		// WriteFile(doc.toString());
		
		// print all titles in main page
		Elements titles = doc.select("div.movie_detail");
//		Elements titles = doc.select("ul.type01 > li");
		int i = 0;
		for (Element e : titles) {
			i++;
			System.out.println("text: " + e.text());
			System.out.println("html: " + e.html());
		    f0.write("text" + i + ": " + e.text() + newLine);
		    f0.write("html" + i + ": " + e.html() + newLine);
		}
		f0.close();


		// print all available links on page
		// Elements links = doc.select("a[href]");
		// for (Element l : links) {
		// System.out.println("link: " + l.attr("abs:href"));
		// }
	}
}
