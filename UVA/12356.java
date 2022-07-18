import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question12356 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			int S = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if(S==0 && B==0)
				break;
			int[] left = new int[S+2];
			int[] right = new int[S+2];
			for(int i=1;i<left.length;i++) {
				left[i] = i-1;
				right[i] = i+1;
			}
			for(int i=0;i<B;i++) {
				st = new StringTokenizer(bf.readLine()," ");
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());
				if(left[L]==0 || left[R]<1)
					sb.append("* ");
				else
					sb.append(String.valueOf(left[L])+" ");
				if(right[R]>S || right[R]>S)
					sb.append("*\n");
				else
					sb.append(String.valueOf(right[R])+"\n");
				left[right[R]] = left[L];
				right[left[L]] = right[R];
			}
			sb.append("-\n");
		}
		System.out.print(sb);
	}
}