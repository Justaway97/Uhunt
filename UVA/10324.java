import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question10324 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i=1;;i++) {
			String input = bf.readLine();
			if(input==null || input.isEmpty()) 
				break;
			int cases = Integer.parseInt(bf.readLine());
			if(cases==0)
				break;
			int[] dp = new int[input.length()];
			sb.append("Case ").append(i).append(":\n");
			dp[0] = 1;
			for(int j=1;j<dp.length;j++) {
				if(input.charAt(j)==input.charAt(j-1))
					dp[j] = dp[j-1];
				else
					dp[j] = dp[j-1]+1;
			}
			for(int j=0;j<cases;j++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				if(dp[Integer.parseInt(st.nextToken())]!=dp[Integer.parseInt(st.nextToken())])
					sb.append("No\n");
				else
					sb.append("Yes\n");
			}
		}
		System.out.print(sb);
	}
}