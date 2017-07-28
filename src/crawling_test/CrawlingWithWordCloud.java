package crawling_test;

import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingWithWordCloud {

	public static void main(String[] args) throws IOException {
		FileWriter f0 = null;
		FileWriter f1 = null;
		try {
			f0 = new FileWriter("C:/dev/workspace/mini_project/under5.txt");
			f1 = new FileWriter("C:/dev/workspace/mini_project/upper5.txt");
		} catch (IOException e1) {
			// e1.printStackTrace();
			System.out.println("file 만들 때 에러!!");
		}
		String newLine = System.getProperty("line.separator");

		for (int page_num = 1; page_num < 25; page_num++) {

			Document doc = null;
			try {
				doc = Jsoup.connect("http://movie.daum.net/moviedb/grade?movieId=93697&type=netizen&page=" + page_num)
						.get();
			} catch (IOException e1) {
				// e1.printStackTrace();
				System.out.println("사이트 읽는 도중 에러!!");
			}

			// 평점
			Elements scores = doc.select("ul.list_review > li > div.review_info > div.raking_grade > em");
			// 댓글내용
			Elements titles = doc.select("ul.list_review > li > div.review_info > p.desc_review");
			
			
			
			System.out.println(scores.get(0));
			System.out.println(titles.get(0));
			
			try {
				for (int j = 0; j < 10; j++) {
					if (Integer.parseInt(scores.get(j).text()) < 5) {
						f0.write("page_num:" + page_num + " / score" + j + ": " + scores.get(j).text() + newLine);					
						f0.write("page_num:" + page_num + " / text" + j + ": " + titles.get(j).text() + newLine);											
					} else {
						f1.write("page_num:" + page_num + " / score" + j + ": " + scores.get(j).text() + newLine);					
						f1.write("page_num:" + page_num + " / text" + j + ": " + titles.get(j).text() + newLine);												
					}
					System.out.println("page_num : " + page_num + "/" + "list_num: " + j);
				}
//				int i = 0;
//				for (Element e : titles) {
//					i++;
//					f0.write("text" + i + ": " + e.text() + newLine);
//					f0.write("html" + i + ": " + e.html() + newLine);
//				}
			} catch (Exception e) {
				System.out.println("파일 출력 중 에러");
			}
		}
		f0.close();
		f1.close();
	}
}
