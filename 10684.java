package Max_1D_Range_Sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question10684 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = bf.readLine();
			while(s.isEmpty())
				s = bf.readLine();
			int n = Integer.parseInt(s.trim());
			if(n==0)
				break;
			int currMax=0,max=-1;
			while(n!=0) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				n-=st.countTokens();
				while(st.hasMoreTokens()) {
					currMax+=Integer.parseInt(st.nextToken());
					if(currMax<0)
						currMax=0;
					if(currMax>max)
						max=currMax;
				}
			}
			if(max>0)
				sb.append("The maximum winning streak is ").append(max).append(".\n");
			else
				sb.append("Losing streak.\n");
		}
		System.out.print(sb);
	}
}