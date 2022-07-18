import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Question167 {
	public static boolean valid(int[][] pos,int i,int start) {
		for(int col=0;col<i;col++) 
			if(pos[col][start]==1)
				return false;
		for(int col=i,j=start;col>=0 && j>=0;col--,j--) 
			if(pos[col][j]==1)
				return false;
		for(int col=i,j=start;col>=0 && j<8;col--,j++) 
			if(pos[col][j]==1)
				return false;
		return true;
	}
	public static void find(int[][]pos,int[][] chess,int i,int start,int count,int max,TreeSet<Integer> tree) {
		if(start>=8)
			return;
		int[][] temp = new int[8][8];
		for(int a=0;a<pos.length;a++) 
			temp[a] = Arrays.copyOf(pos[a],8);
		temp[i][start]=1;
		max+=chess[i][start];
		count++;
		if(count==8) {
			tree.add(max);
			return ;
		}
		i++;
		if(i>=8)
			return;
		for(int b=0;b<temp.length;b++) 
			if(valid(temp,i,b))
				find(temp,chess,i,b,count,max,tree);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(bf.readLine().trim());
		for(int i=0;i<n;i++) {
			int[][] chess = new int[8][8];
			for(int j=0;j<8;j++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for(int k=0;k<8;k++) 
					chess[j][k] = Integer.parseInt(st.nextToken());
			}
			TreeSet<Integer> tree = new TreeSet<Integer>();
			for(int j=0;j<chess.length;j++) {
				int[][] pos = new int[8][8];
				find(pos,chess,0,j,0,0,tree);
			}
			String ans = String.valueOf(tree.pollLast());
			for(int j=0;j<5-ans.length();j++)
				sb.append(" ");
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
