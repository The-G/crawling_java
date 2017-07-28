package crawling_test;

import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test_crawling_comment {

	public static void main(String[] args) throws IOException {

		String newLine = System.getProperty("line.separator");


			Document doc = null;
			try {
				doc = Jsoup.connect("http://movie.daum.net/moviedb/grade?movieId=93697&type=netizen&page=" + "1")
						.get();
			} catch (IOException e1) {
				// e1.printStackTrace();
				System.out.println("사이트 읽는 도중 에러!!");
			}

//			// 평점
			Elements scores = doc.select("ul.list_review > li > div.review_info > div.raking_grade > em");
//			// 댓글내용
			Elements titles = doc.select("ul.list_review > li > div.review_info > p.desc_review");
			Elements nickname = doc.select("ul.list_review > li > div.review_info > a > em");

			System.out.println(scores);
			System.out.println(titles);
			System.out.println(nickname);
	}
}
