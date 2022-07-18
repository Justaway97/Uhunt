import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Question624 {
	public static int target;
	public static int currMax;
	public static int[] ans;
	public static int anslevel;
	public static void find(int[] track,int value,int[] store,int storelevel,int index) {
		if(value>target)
			return;
		if(value>currMax) {
			ans = Arrays.copyOf(store, storelevel);
			anslevel = storelevel;
			currMax=value;
		}
		for(int i=index;i<track.length;i++) {
			store[storelevel]=track[i];
			find(track,value+track[i],store,storelevel+1,i+1);
			store[storelevel]=0;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = bf.readLine();
			if(input==null || input.isEmpty())
				break;
			currMax = 0;anslevel=0;
			StringTokenizer st = new StringTokenizer(input);
			target = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int[] track = new int[n];
			for(int i=0;i<n;i++) 
				track[i] = Integer.parseInt(st.nextToken());
			find(track,0,new int[n],0,0);
			for(int i=0;i<ans.length;i++)
				sb.append(ans[i]).append(" ");
			sb.append("sum:").append(currMax).append("\n");
		}
		System.out.print(sb);
	}
}
