import java.util.HashSet;
import java.util.Set;


public class FileFixit {

	public static void main(String[] args) {
		//String[] existingPaths = new String[] {"/home"};
		//String[] paths = new String[] {"/home/gcj/finals", "/home/gcj/quals"};
		//String[] existingPaths = new String[] {"/chicken", "/chicken/egg"};
		//String[] paths = new String[] {"/chicken"};
		String[] existingPaths = new String[] {"/a"};
		String[] paths = new String[] {"/a/b", "/a/c", "/b/b"};
		
		Set<String> counter = new HashSet<String>();
		for (String path : paths) {
			String[] split = path.substring(1, path.length()).split("/");
			String tmpPath = "";
			for (String s : split) {
				tmpPath += "/" + s;
				counter.add(tmpPath);
			}
		}
		
		for (String path : existingPaths) {
			String[] split = path.substring(1, path.length()).split("/");
			String tmpPath = "";
			for (String s : split) {
				tmpPath += "/" + s;
				counter.remove(tmpPath);
			}
		}
		
		System.out.println(counter.size());
	}
	
}
