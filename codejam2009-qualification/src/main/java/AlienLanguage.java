
public class AlienLanguage {

	public static void main(String[] args) {
		String[] language = new String[] {"abc", "bca", "dac", "dbc", "cba"};
		String[] patterns = new String[] {"(ab)(bc)(ca)", "abc", "(abc)(abc)(abc)", "(zyx)bc"};
		
		for (String pattern : patterns) {
			pattern = pattern.replaceAll("\\(", "[").replaceAll("\\)", "]");
			int count = 0;
			for (String word : language) {
				if (word.replaceAll(pattern, "").length() == 0) {
					count++;
				}
			}
			System.out.println(count);
		}
	}
	
}
