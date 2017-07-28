package crawling_test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLCleaner {

	/**
	 * @author Shrek
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HTMLCleaner cleaner = new HTMLCleaner();

		 System.out.println(cleaner.clean("<html>"
		 		+ "<head>"
		 		+ "<script>aaaa</script>"
		 		+ "</head>"
		 		+ "<body>"
		 		+ "<div>aaa</div>"
		 		+ "<div>"
		 		+ "<script></script>"
		 		+ "</div>"
		 		+ "<img src=\"http://tong.nate.com\"values=\">\"> 이건 어떻게 될까요 <!-- zmzm -->"
		 		+ "</body>"
		 		+ "</html>"));

	}

	private static interface Patterns {
		// javascript tags and everything in between
		public static final Pattern SCRIPTS = Pattern.compile("<(no)?script[^>]*>.*?</(no)?script>", Pattern.DOTALL);

		public static final Pattern STYLE = Pattern.compile("<style[^>]*>.*</style>", Pattern.DOTALL);
		// HTML/XML tags

		public static final Pattern TAGS = Pattern.compile("<(\"[^\"]*\"|\'[^\']*\'|[^\'\">])*>");

		public static final Pattern nTAGS = Pattern.compile("<\\w+\\s+[^<]*\\s*>");
		// entity references
		public static final Pattern ENTITY_REFS = Pattern.compile("&[^;]+;");
		// repeated whitespace
		public static final Pattern WHITESPACE = Pattern.compile("\\s\\s+");
	}

	/**
	 * Clean the HTML input.
	 */
	public String clean(String s) {
		if (s == null) {
			return null;
		}

		Matcher m;

		System.out.println(s);
		m = Patterns.SCRIPTS.matcher(s);
		s = m.replaceAll("");
		System.out.println(s);
		m = Patterns.STYLE.matcher(s);
		s = m.replaceAll("");
		System.out.println(s);
		m = Patterns.TAGS.matcher(s);
		s = m.replaceAll("");
		System.out.println(s);
		m = Patterns.ENTITY_REFS.matcher(s);
		s = m.replaceAll("");
		System.out.println(s);
		m = Patterns.WHITESPACE.matcher(s);
		s = m.replaceAll(" ");

		return s;
	}

}