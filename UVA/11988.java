import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Question11988 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = bf.readLine();
			if(input==null)
				break;
			LinkedList<String> word = new LinkedList<String>();
			char[] s = input.toCharArray();
			int j=0;
			for(char x:s) {
				if(x=='[') j=0;
				else if(x==']') j=word.size();
				else word.add(j++,String.valueOf(x));
			}
			for(String x:word)
				sb.append(x);
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
