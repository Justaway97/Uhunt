import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question679 {
	private static int max;
	private static int ball(int node,int ball) {
		int left = node*2,right = left+1;
		while(left<max && right<max) {
			if(ball%2==0)
				return ball(right,ball/2);
			else
				return ball(left,ball/2+1);
		}
		return node;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(bf.readLine().trim());
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int d = Integer.parseInt(st.nextToken());
			int I = Integer.parseInt(st.nextToken());
			max = (int)Math.pow(2, d);
			sb.append(ball(1,I)).append("\n");
		}
		System.out.print(sb);
	}
}
