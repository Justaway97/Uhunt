package Travelling_Salesman_Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Question216 {
	private static double min = 0;
	private static int[] path;
	private static void backtrack(double[][] dp, int length, double curr, int[] temp,int position, boolean[] pass) {
		for(int i=0;i<dp.length;i++) 
			if(i!=position && !pass[i]) {
			pass[i] = true;
			temp[length] = i;
			curr += dp[position][i];
			backtrack(dp,length+1,curr,temp,i,pass);
			curr -= dp[position][i];
			pass[i] = false;
				temp[length] = -1;
			}
		if(length==dp.length) 
			if(min>Math.round(curr*100.0)/100.0) {
				for(int i=0;i<path.length;i++)
					path[i] = temp[i];
				min = Math.round(curr*100.0)/100.0;
			}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		DecimalFormat df = new DecimalFormat("0.00");
		int x = 1;
		while(true) {
			int n = Integer.parseInt(bf.readLine().trim());
			if(n==0)
				break;
			int[][] key = new int[n][2];
			double[][] dp = new double[n][n];
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine().trim());
				for(int j=0;j<2;j++)
					key[i][j] = Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<n;i++) 
				for(int j=i+1;j<n;j++) 
					dp[i][j] = dp[j][i] = Math.sqrt(Math.pow(Math.abs(key[j][0]-key[i][0]),2)+Math.pow(Math.abs(key[j][1]-key[i][1]),2));
			min = Double.MAX_VALUE;
			path = new int[n];
			for(int i=0;i<n;i++) {
				boolean[] pass = new boolean[n];
				pass[i] = true;
				int[] temp = new int[n];
				temp[0] = i;
				backtrack(dp,1,0,temp,i,pass);
			}
			sb.append("**********************************************************\nNetwork #").append(x++).append("\n");
			for(int i=0;i<n-1;i++) 
				sb.append("Cable requirement to connect (").append(key[path[i]][0]).append(",").append(key[path[i]][1]).append(") to (").append(key[path[i+1]][0]).append(",").append(key[path[i+1]][1]).append(") is ").append(df.format((Math.round(dp[path[i]][path[i+1]]*100.0)/100.0)+16)).append(" feet.\n");
			sb.append("Number of feet of cable required is ").append(df.format(min+16.0*(n-1))).append(".\n");
		}
		System.out.print(sb);
	}
}
