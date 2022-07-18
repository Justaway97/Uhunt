import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question626 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = bf.readLine();
			if(input==null || input.isEmpty())
				break;
			int n = Integer.parseInt(input.trim());
			boolean[][] build = new boolean[n][n];
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for(int j=0;j<n;j++) 
					if(st.nextToken().equals("1"))
						build[i][j]=true;
			}
			int count=0;
			for(int i=0;i<n;i++) 
				for(int j=0;j<n;j++) 
					for(int k=0;k<n;k++) 
						if(build[i][j] && build[j][k] && build[k][i] && (k>j && j>i || i>j && j>k)) {
							count++;
							sb.append((i+1)).append(" ").append((j+1)).append(" ").append(k+1).append("\n");
						}
			sb.append("total:").append(count).append("\n").append("\n");
		}
		System.out.print(sb);
	}
}
