import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question11683 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==0 && m==0)
				break;
			st = new StringTokenizer(bf.readLine());
			int[] block = new int[m];
			int max = 0,count = 0;
			for(int i=0;i<m;i++) {
				int fill = Integer.parseInt(st.nextToken());
				if(i>0 && fill>max)
					count+=fill-max;
				max = Math.max(max, fill);
				block[i]=fill;
				if(i>0 && block[i-1]>block[i])
					count+=block[i-1]-block[i];
			}
			count+=n-max;
			sb.append(count).append("\n");
		}
		System.out.print(sb);
	}
}
