import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question703 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n=0;
			try {
				n = Integer.parseInt(bf.readLine().trim());
			}catch(Exception e) {}
			if(n==0)
				break;
			boolean[][] tie = new boolean[n][n];
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for(int j=0;j<n;j++)
					if(Integer.parseInt(st.nextToken())==1)
						tie[i][j]=true;
			}
			String[] build = new String[100001];
			int count=0;
			for(int i=0;i<n;i++) 
				for(int j=0;j<n;j++) 
					for(int k=0;k<n;k++) 
						if((tie[i][j] && tie[j][k] && tie[k][i] && ((i>j && j>k)||(k>j && j>i)) || (!tie[i][j] && !tie[j][k] && !tie[k][i] && !tie[j][i] && !tie[k][j] && !tie[i][k]) && (i<j && j<k))) {
							build[count] = new StringBuilder().append(i+1).append(" ").append(j+1).append(" ").append(k+1).toString();
							count++;
						}	
			sb.append(count).append("\n");
			for(int i=0;i<count;i++)
				sb.append(build[i]).append("\n");
		}		
		System.out.print(sb);
	}
}
