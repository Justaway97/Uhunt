import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;

public class Question10815 {
	public static ArrayList<String> GetWord(String s){
		ArrayList<String> al = new ArrayList<String>();
		char[] c = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<c.length;i++) {
			if(Character.isAlphabetic(c[i]))
				sb.append(c[i]);
			else if(sb.length()>0){
				al.add(sb.toString());
				sb = new StringBuilder();
			}
		}
		if(sb.length()>0)
			al.add(sb.toString());
		return al;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		TreeSet<String> set = new TreeSet<String>();
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = bf.readLine();
			if(s==null)
				break;
			ArrayList<String> word = GetWord(s);
			while(!word.isEmpty())
				set.add(word.remove(0).toLowerCase());
		}
		while(!set.isEmpty()) {
			sb.append(set.pollFirst());
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
