import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question11192 {
	public static void main(String[]args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String input = bf.readLine();
			if(input.equals("0"))
				break;
			StringTokenizer st = new StringTokenizer(input," ");
			int n = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder();
			input = input.substring(2, input.length());
			int group = input.length()/n;
			for(int i=0;i<input.length();i+=group) {
				for(int j=i+group-1;j>=i;j--) {
					try {
						sb.append(input.charAt(j));
					}catch(Exception e) {}
				}
			}
			System.out.println(sb);
		}
	}
}
