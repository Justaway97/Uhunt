import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class Question417 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int count=0;
		StringBuilder sb = new StringBuilder();
		LinkedList<String> letter = new LinkedList<String>();
		while(count<=83681) {
			String s = letter.pollFirst();
			map.put(s, count++);
			if(s==null || s.length()<5) {
				for(char i='a';i<='z';i++) {
					if(s==null)
						letter.addLast(String.valueOf(i));
					else if(s.charAt(s.length()-1)<i) 
						letter.addLast(s+String.valueOf(i));
					else if(s!=null && s.charAt(s.length()-1)<i) {
						i = s.charAt(s.length()-1);
						i--;
					}
				}
			}
		}
		while(true) {
			String s = bf.readLine();
			if(s==null)
				break;
			sb.append(map.getOrDefault(s,0));
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
