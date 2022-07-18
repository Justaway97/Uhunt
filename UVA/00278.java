package GameChess;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question278 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cases = Integer.parseInt(bf.readLine());
		for(int i=0;i<cases;i++) {
			String input = bf.readLine();
			while(input==null || input.isEmpty())
				input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			st.nextToken();
			if(input.substring(0,1).equals("r") || input.substring(0,1).equals("Q"))
				sb.append(Math.min(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()))).append("\n");
			else if(input.substring(0,1).equals("k"))
				sb.append(((Long.parseLong(st.nextToken())*Long.parseLong(st.nextToken()))+1)/2).append("\n");
			else
				sb.append(((Integer.parseInt(st.nextToken())+1)/2)*((Integer.parseInt(st.nextToken())+1)/2)).append("\n");
		}
		System.out.print(sb);
	}
}
