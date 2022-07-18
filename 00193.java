import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Question193 {
	private static boolean[][] map;
	private static int min;
	private static int[] selected;
	private static void solved(int index,int curr,int[] node) {
		if(index==map.length) {
			if(curr<min) {
				min = curr;
				selected = node.clone();
			}
			return;
		}
		boolean flag = true;
		for(int i=0;i<map[index].length;i++) 
			if(map[index][i])
				flag = flag && node[i]!=2;
		if(flag) {
			node[index] = 2;
			solved(index+1,curr,node);
			node[index] = 0;
		}
		node[index] = 1;
		solved(index+1,curr+1,node);
		node[index] = 0;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(bf.readLine().trim());
		for(int i=0;i<n;i++) {
			String input = bf.readLine();
			while(input.isEmpty())
				input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input);
			min = Integer.MAX_VALUE;
			int size = Integer.parseInt(st.nextToken());
			map = new boolean[size+1][size+1];
			int m = Integer.parseInt(st.nextToken());
			for(int j=0;j<m;j++) {
				st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken()),y=Integer.parseInt(st.nextToken());
				map[x][y] = map[y][x] = true;
			}
			solved(1,0,new int[size+1]);
			sb.append(map.length-1-min).append("\n");
			int counter = map.length-1-min;
			for(int j=1;j<selected.length;j++) {
				if(selected[j]==2) {
					if(counter-->1)
						sb.append(j).append(" ");
					else
						sb.append(j).append("\n");
				}
			}
		}
		System.out.print(sb);
	}
}
