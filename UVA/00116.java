package Non_Classical_Easier;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Question116 {
	private static class path implements Comparable<path> {
		public int value;
		public int[] p = new int[101];
		public path(int value, int n,int direction, int[] previous_p) {
			this.value=value;
			for(int i=0;i<n;i++)
				p[i] = previous_p[i];
			p[n] = direction;
		}
		@Override
		public int compareTo(path o) {
			return this.value-o.value;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = bf.readLine();
			if(s==null || s.isEmpty())
				break;
			StringTokenizer st = new StringTokenizer(s);
			int[][] map = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
			for(int i=0;i<map.length;i++) 
				for(int j=map[0].length-1;j>=0;j--) {
					if(!st.hasMoreTokens())
						st = new StringTokenizer(bf.readLine());
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			path[][] dp = new path[map.length][map[0].length];
			for(int i=0;i<dp.length;i++)
				dp[i][0] = new path(map[i][0],0,i,new int[101]);
			for(int j=1;j<map[0].length;j++) {
				for(int i=0;i<map.length;i++) {
					int a = i-1;
					if(a<0)
						a = map.length-1;
					int b = i+1;
					if(b>map.length-1)
						b = 0;
					int[] direction = {a,i,b};
					Arrays.sort(direction);
					path[] temp = {new path(dp[direction[0]][j-1].value+map[i][j],j,i,dp[direction[0]][j-1].p),new path(dp[direction[1]][j-1].value+map[i][j],j,i,dp[direction[1]][j-1].p),new path(dp[direction[2]][j-1].value+map[i][j],j,i,dp[direction[2]][j-1].p)};
					Arrays.sort(temp);
					dp[i][j] = temp[0];
				}
			}
			int index = -1, min=Integer.MAX_VALUE;
			for(int i=0;i<dp.length;i++)
				if(min>dp[i][map[0].length-1].value) {
					min = dp[i][map[0].length-1].value;
					index = i;
				}
			sb.append(dp[index][map[0].length-1].p[map[0].length-1]+1);
			for(int i=map[0].length-2;i>=0;i--)
				sb.append(" ").append(dp[index][map[0].length-1].p[i]+1);
			sb.append("\n");
			sb.append(min).append("\n");
		}
		System.out.print(sb);
	}
}

