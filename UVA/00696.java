package GameChess;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question696 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = bf.readLine();
			if(input.equals("0 0"))
				break;
			StringTokenizer st = new StringTokenizer(input);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==0 || m==0)
				sb.append(0);
			else if(n==1 || m==1)
				sb.append(Math.max(n, m));
			else if((n==2 || m==2 )&& (n%4!=0 || m%4!=0)) {
				int count = Math.max(n, m);
				if(count%4==1) {
					sb.append(count+1);
				}else if(count%4!=0)
					sb.append(count+4-count%4);
				else
					sb.append(count);
			}else
				sb.append((int)Math.round((double)n*m/2));
			sb.append(" knights may be placed on a "+n+" row "+m+" column board.\n");
		}
		System.out.print(sb);
	}
}
