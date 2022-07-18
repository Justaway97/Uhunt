package Subset_Sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question990 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x=0;
		while(true) {
			String s = bf.readLine();
			if(s==null || s.isEmpty())
				break;
			if(x>0) sb.append("\n");
			StringTokenizer st = new StringTokenizer(s);
			int time = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(bf.readLine().trim());
			int[] list = new int[n],value = new int[n];
			int d=0;
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(bf.readLine());
				d = Integer.parseInt(st.nextToken());
				list[i] = 3*w*d;
				value[i] = Integer.parseInt(st.nextToken());
			}
			int[][] dp = new int[n+1][time+1];
			for(int i=list[0];i<dp[0].length;i++) 
				dp[1][i]=value[0];
			for(int i=2;i<n+1;i++) 
				for(int j=1;j<dp[i].length;j++) 
					if(j>=list[i-1]) 
						dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-list[i-1]]+value[i-1]);
					else 
						dp[i][j] = dp[i-1][j];
			ArrayList<int[]> backTrack = new ArrayList<int[]>();
			for(int i=dp.length-1,j=dp[0].length-1;i>=1 && j>=1;)
				if(dp[i][j]>dp[i-1][j]) {
					int[] temp = new int[2];
					temp[0] = list[i-1]/3/w;
					temp[1] = value[i-1];
					j-=list[i-1];
					i--;
					backTrack.add(temp);
				}else if(dp[i][j]==dp[i-1][j])
					i--;
			sb.append(dp[dp.length-1][dp[0].length-1]).append("\n").append(backTrack.size()).append("\n");
			for(int i=backTrack.size()-1;i>=0;i--)
				sb.append(backTrack.get(i)[0]).append(" ").append(backTrack.get(i)[1]).append("\n");
			bf.readLine();
			x++;
		}
		System.out.print(sb);
	}
}
//974 4
//17
//16 27
//20 30
//19 44
//10 46
//12 30
//13 45
//17 40
//12 13
//5 12
//19 45
//12 11
//17 8
//5 40
//4 8
//17 26
//8 22
//3 36

