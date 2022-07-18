import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Question301 {
	static int[][] station;
	static int money,curr;
	static boolean valid(int[] fill,int[] value) {
		for(int j=value[0];j<value[1];j++) 
			if(fill[j]-value[2]<0)
				return false;
		return true;
	}
	static void backtrack(int start,int[] fill) {
		if(start==station.length) {
			if(curr>money)
				money=curr;
			return;
		}
		for(int i=start;i<station.length;i++) {
			boolean flag = false;
			if(valid(fill,station[i]))
				flag=true;
			for(int j=station[i][0];j<station[i][1] && flag;j++) {
				fill[j]-=station[i][2];
				curr+=station[i][2];
			}
			backtrack(i+1,fill);
			for(int j=station[i][0];j<station[i][1] && flag;j++) {
				fill[j]+=station[i][2];
				curr-=station[i][2];
			}
			flag=false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = bf.readLine();
			if(input.trim().equals("0 0 0"))
				break;
			StringTokenizer st = new StringTokenizer(input);
			curr=money=0;
			int max = Integer.parseInt(st.nextToken());
			int[] fill = new int[Integer.parseInt(st.nextToken())+1];
			Arrays.fill(fill, max);
			int n = Integer.parseInt(st.nextToken());
			station = new int[n][3];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(bf.readLine());
				station[i][0] = Integer.parseInt(st.nextToken());
				station[i][1] = Integer.parseInt(st.nextToken());
				station[i][2] = Integer.parseInt(st.nextToken());
			}
			backtrack(0,fill);
			sb.append(money).append("\n");
		}
		System.out.print(sb);
	}
}
