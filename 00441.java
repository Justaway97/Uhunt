import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question441 {
	public static void buildtree(int[] num,int[] data,int start,int stop,StringBuilder sb) {
		if(stop==6) {
			for(int i=0;i<5;i++)
				sb.append(data[i]).append(" ");
			sb.append(data[5]).append("\n");
			return;
		}
		for(int i=start;num.length-i>=6-stop;i++) {
			data[stop] = num[i];
			buildtree(num,data,(i+1),(stop+1),sb);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x=0;
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n==0)
				break;
			if(x>0)
				sb.append("\n");
			int[] num = new int[n];
			for(int i=0;i<n;i++)
				num[i] = Integer.parseInt(st.nextToken());
			buildtree(num,new int[num.length],0,0,sb);
			x++;
		}
		System.out.print(sb);
	}
}
