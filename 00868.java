import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question868 {
	private static boolean[][] pass;
	private static int[][] maze;
	private static int[] dx = new int[]{-1,0,1,0};
	private static int[] dy = new int[]{0,1,0,-1};
	private static boolean[] found;
	private static boolean stop;
	private static boolean valid(int i,int j) {
		return i!=-1 && j!=-1 && i<maze.length && j<maze[0].length;
	}
	private static void solved(int x,int y,int curr,int dest) {
		if(x==maze.length-1) {
			found[y]=true;
			stop = true;
			return;
		}
		pass[x][y] = true;
		for(int i=0;i<4;i++) {
			int nextI = x+dx[i],nextJ = y+dy[i];
			if(valid(nextI,nextJ) && !pass[nextI][nextJ] && maze[nextI][nextJ]==curr) {
				boolean flag = false;
				if(curr==dest) {
					curr=0;
					//curr x=3	curr y=10	2	10
					dest++;
					flag = true;
				}
				
				solved(nextI,nextJ,curr+1,dest);
				if(flag) {
					curr=dest-1;
					dest--;
				}
				pass[nextI][nextJ] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			bf.readLine();
			if(i>0 && i<n)
				sb.append("\n");
			StringTokenizer st = new StringTokenizer(bf.readLine());
			maze = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
			pass = new boolean[maze.length][maze[0].length];
			ArrayList<Integer> start = new ArrayList<Integer>();
			for(int j=0;j<maze.length;j++) {
				st = new StringTokenizer(bf.readLine());
				for(int k=0;k<maze[0].length;k++) {
					maze[j][k] = Integer.parseInt(st.nextToken());
					if(j==0 && maze[j][k]==1)
						start.add(k);
				}
			}
			stop = false;
			for(int j=0;j<start.size() && !stop;j++) {
				found = new boolean[maze[0].length];
				pass[0][start.get(j)] = true;
				solved(0,start.get(j),1,2);
				pass[0][start.get(j)] = false;
				if(stop) {
					sb.append("1 ").append(start.get(j)+1).append("\n").append(maze.length).append(" ");
					for(int k=0;k<found.length;k++)
						if(found[k]) {
							sb.append(k+1).append("\n");
							break;
						}
				}
			}
		}
		System.out.print(sb);
	}
}
