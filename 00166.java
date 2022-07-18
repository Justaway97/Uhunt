import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question166 {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[] value = {1,2,4,10,20,40};
		int[] base = new int[41];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<5;i++) 
			for(int k=value[i];k<value[i+1];k++)
				if(k%value[i]==0)
					base[k] = k/value[i];
				else
					base[k] = 1+base[k-value[i]];
		base[40]=1;
		while(true) {
			String s = bf.readLine();
			if(s.trim().equals("0 0 0 0 0 0"))
				break;
			int[] coin = new int[6];
			StringTokenizer st = new StringTokenizer(s);
			int n=0;
			int[] length = new int[6];
			for(int i=0;i<6;i++) {
				coin[i] = Integer.parseInt(st.nextToken());
				n+=coin[i]*value[i];
				if(i>0)
					length[i] = value[i]*coin[i] + length[i-1];
				else
					length[i] = value[i]*coin[i];
			}
			int price = (int)(Math.ceil(Double.parseDouble(st.nextToken())*100))/5;
			int[] dp = new int[n+1];
			for(int i=1;i<dp.length;i++)
				dp[i] = 999;
			for(int i=0;i<6;i++) 
				if(coin[i]!=0) 
					for(int j=value[i];j<=length[i] && j<=price+40;j++) { 
						if(j<=coin[i]*value[i] && j%value[i]==0) 
							dp[j] = j/value[i];
						dp[j] = Math.min(1 + dp[j-value[i]],dp[j]);
					}
			int min = dp[price];
			for(int i=price+1;i<=price+40 && i<dp.length;i++) {
				dp[i] += base[i-price];
				if(min>dp[i])
					min = dp[i];
			}
			sb.append(String.format("%3d",min)).append("\n");
		}
		System.out.print(sb);
	}

}
