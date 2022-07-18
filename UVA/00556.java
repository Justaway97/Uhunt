import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question556 {

	public static int[][] facedown(int[][] maze,int currenti,int currentj){
		for(int i=currenti;;i++) {
			if(maze[maze.length-2][1]==2)
				return maze;
			if(maze[i][currentj]==-1) 
				return faceright(maze,i-1,currentj+1);
			else if(maze[i][currentj-1]!=-1) {
				maze[i][currentj]++;
				return faceleft(maze,i,currentj-1);
			}else 
				maze[i][currentj]++;
		}
	}
	public static int[][] faceleft(int[][] maze,int currenti,int currentj){
		for(int j=currentj;;j--) {
			if(maze[maze.length-2][1]==2)
				return maze;
			if(maze[currenti][j]==-1) 
				return facedown(maze,currenti+1,j+1);
			else if(maze[currenti-1][j]!=-1) {
				maze[currenti][j]++;
				return faceup(maze,currenti-1,j);
			}else
				maze[currenti][j]++;
		}
	}
	public static int[][] faceup(int[][] maze,int currenti, int currentj){
		for(int i=currenti;;i--) {
			if(maze[maze.length-2][1]==2)
				return maze;
			if(maze[i][currentj]==-1) 
				return faceleft(maze,i+1,currentj-1);
			else if(maze[i][currentj+1]!=-1) {
				maze[i][currentj]++;
				return faceright(maze,i,currentj+1);
			}else
				maze[i][currentj]++;
		}
	}
	public static int[][] faceright(int[][] maze,int currenti,int currentj){
		for(int j=currentj;;j++) {
			if(maze[maze.length-2][1]==2)
				return maze;
			else if(maze[currenti][j]==-1) 
				return faceup(maze,currenti-1,j-1);
			if(maze[currenti+1][j]!=-1) {
				maze[currenti][j]++;
				return facedown(maze,currenti+1,j);
			}else
				maze[currenti][j]++;
		}
	}
	public static int[][] maze(int[][] maze) {
		for(int i=0;i<maze.length;i++) 
			for(int j=0;j<maze[i].length;j++) 
				if(i==0 || j==0 || i==maze.length-1 || j==maze[i].length-1)
					maze[i][j]=-1;
		return maze;
	}
	public static int[] result(int[][] maze) {
		int[] result = new int[5];
		maze[maze.length-2][1]--;
		for(int i=1;i<maze.length;i++) {
			for(int j=1;j<maze[i].length;j++) {
				try {
					result[maze[i][j]]++;
				}catch(Exception e) {}
			}
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = bf.readLine();
			if(s.equals("0 0"))
				break;
			StringTokenizer st = new StringTokenizer(s," ");
			int height = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int[][] maze = new int[height+2][width+2];
			int[] result = new int[width];
			maze=maze(maze);
			for(int i=1;i<=height;i++) {
				String input = bf.readLine();
				for(int j=1;j<=width;j++) {
					maze[i][j]=Character.getNumericValue(input.charAt(j-1));
					if(maze[i][j]==1)
						maze[i][j]=-1;
				}
			}
			maze=faceright(maze,height,1);
			result=result(maze);
			for(int i=0;i<5 && i<result.length;i++){
				if(result[i]<10)
					System.out.print(" ");
				if(result[i]<100)
					System.out.print(" ");
				System.out.print(+result[i]);
			}
			System.out.println();
		}
	}
}
