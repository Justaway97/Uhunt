package CoinChange;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question147 {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[] cash = {1,2,4,10,20,40,100,200,400,1000,2000};
		long[] change = new long[6001];
		change[0]=1;
		for(int i=0;i<cash.length;i++) 
			for(int j=cash[i];j<change.length;j++) 
				change[j] += change[j-cash[i]];
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = bf.readLine().trim();
			if(s.equals("0.00"))
				break;
			double m = Double.parseDouble(s);
			int money = (int)(Math.ceil(m*100.0));
			money/=5;
			sb.append(String.format("%6.2f%17d", m,change[money])).append("\n");
		}
		System.out.print(sb);
	}
}
