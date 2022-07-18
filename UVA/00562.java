
package Subset_Sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question562 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine().trim());
			int sum=0;
			int[] num;
			if(st.countTokens()==1) {
				num = new int[Integer.parseInt(st.nextToken())];
				st = new StringTokenizer(bf.readLine());
				int x=0;
				while(st.hasMoreTokens()) { 
					num[x++] = Integer.parseInt(st.nextToken());
					sum+=num[x-1];
				}
			}else {
				num = new int[Integer.parseInt(st.nextToken())];
				for(int j=0;j<num.length;j++) {
					num[j] = Integer.parseInt(st.nextToken());
					sum+=num[j];
				}
			}
			boolean[] check = new boolean[(sum+1)/2+1];
			check[0] = true;
			for(int j=0;j<num.length;j++) {
				boolean[] curr = new boolean[check.length];
				for(int k=0;k<check.length;k++) {
					if(check[k]) {
						curr[k] = check[k];
						if(num[j]+k<check.length)
							curr[num[j]+k]=true;
					}
				}
				check = curr;
			}
			
			int max=0;
			for(int j=check.length-1;j>=0;j--)
				if(check[j]) {
					max = j;
					break;
				}
			if(sum>=max*2)
				sb.append(sum-max-max).append("\n");
			else
				sb.append(sum-max-max+2).append("\n");
		}
		System.out.print(sb);
	}
}
