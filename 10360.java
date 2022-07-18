import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Question10360 {
	public static StringBuilder fill(rat r,int[][] map,String result,int x,int y,int boom,int d) {
		StringTokenizer st = new StringTokenizer(result);
		int indexX = Integer.parseInt(st.nextToken());
		int indexY = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		int kill = max;
		for(int i=x-d;i<=x+d;i++) {
			if(i<0 || i>=map.length) continue;
			for(int j=y-d;j<=y+d;j++) {
				if(j<0 || j>=map.length) continue;
				map[i][j] += boom;
				if(map[i][j]>max) {
					max=map[i][j];
					indexX = i;
					indexY = j;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		if(max>kill)
			sb.append(indexX).append(" ").append(indexY).append(" ").append(max).append("\n");
		return sb;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			String input = bf.readLine();
			while(input==null || input.isEmpty())
				input = bf.readLine();
			int d = Integer.parseInt(input.trim());
			int rat = Integer.parseInt(bf.readLine().trim());
			int[][] map = new int[1025][1025];
			rat[] r = new rat[rat];
			for(int j=0;j<rat;j++) 
				r[j] = new rat(bf.readLine());
			Arrays.sort(r);
			String s="0 0 0";
			for(int j=0;j<rat;j++) {
				StringBuilder build = fill(r[j],map,s,r[j].x,r[j].y,r[j].population,d);
				if(build.toString().length()!=0) 
					s = build.toString();
			}
			sb.append(s);
		}
		System.out.print(sb);
	}
}
class rat implements Comparable<rat>{
	int x;
	int y;
	int population;
	String s;
	public rat(String s) {
		this.s=s;
		StringTokenizer st = new StringTokenizer(s);
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		population = Integer.parseInt(st.nextToken());
	}
	@Override
	public int compareTo(rat r) {
		int compare = this.x-r.x;
		if(compare==0)
			compare = this.y-r.y;
		if(compare==0)
			compare = this.population-r.population;
		return compare;
	}
}