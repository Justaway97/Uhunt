package CoinChange;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question357 {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] coin = {1,5,10,25,50};
		long[] dp = new long[30001];
		dp[0]=1;
		for(int i=0;i<coin.length;i++)
			for(int j=coin[i];j<dp.length;j++)
				dp[j] += dp[j-coin[i]];
		while(true) {
			String s = bf.readLine();
			if(s==null)
				break;
			int n = Integer.parseInt(s.trim());
			long way = dp[n];
			if(way==1)
				sb.append("There is only 1 way to produce ").append(n).append(" cents change.\n");
			else
				sb.append("There are ").append(way).append(" ways to produce ").append(n).append(" cents change.\n");
		}
		System.out.print(sb);
	}
}
