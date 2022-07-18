import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question594 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = bf.readLine();
			if(s==null || s.equals(""))
				break;
			sb.append(s+" converts to "+Integer.reverseBytes(Integer.parseInt(s))+"\n");
		}
		System.out.print(sb);
	}
}
