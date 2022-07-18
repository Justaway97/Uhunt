import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question539 {
	public static int result(int start,int[][] matrix,boolean[][] visited) {
		int max=0;
		for(int i=0;i<matrix.length-1;i++) {
			if(matrix[start][i]>0 && !visited[start][i]) {
				visited[start][i] = visited[i][start] = true;
				max = Math.max(max, result(i,matrix,visited)+1);
				visited[start][i] = visited[i][start] = false;
			}
		}
		return max;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = bf.readLine();
			if(input.equals("0 0"))
				break;
			StringTokenizer st = new StringTokenizer(input);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] matrix = new int[n+1][n+1];
			boolean[][] visit = new boolean[n+1][n+1];
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				matrix[x][y]=matrix[y][x]=1;
			}
			int max=0;
			for(int i=0;i<n;i++) 
				max = Math.max(max, result(i,matrix,visit));
			sb.append(max).append("\n");
		}
		System.out.print(sb);
	}
}
