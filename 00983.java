import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question983 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x=0;
		String s;
		while((s=bf.readLine())!=null) {
			while(s.isEmpty())
				s = bf.readLine();
			StringTokenizer st = new StringTokenizer(s);
			if(x>0)
				sb.append("\n");
			int n = Integer.parseInt(st.nextToken()),m = Integer.parseInt(st.nextToken()),total=0;
			int[][] matric = new int[n][n];
			int[][] sub = new int[n-m+1][n-m+1];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					matric[i][j] = Integer.parseInt(bf.readLine().trim());
			for(int i=0;i<=n-m;i++) {
				int[] temp = new int[n];
				for(int j=i;j<m+i;j++)
					for(int k=0;k<temp.length;k++)
						temp[k]+=matric[k][j];
				for(int j=0;j<=n-m;j++) {
					for(int k=j;k<m+j;k++)
						sub[j][i]+=temp[k];
					total+=sub[j][i];
				}
			}
			for(int i=0;i<sub.length;i++)
				for(int j=0;j<sub.length;j++)
					sb.append(sub[i][j]).append("\n");
			sb.append(total).append("\n");
			x++;
		}
		System.out.print(sb);
	}
}
