import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question434 {
	public static int findmin(int[] grid,String input,int[] position) {
		StringTokenizer st = new StringTokenizer(input," ");
		int x=0,min = 0;
		while(st.hasMoreTokens()) {
			grid[x] = Integer.parseInt(st.nextToken());
			position[grid[x]]++;
			min += grid[x];
			x++;
		}
		return min;
	}
	public static int maximum(int[] gridmin , int[] gridmax) {
		int max=0;
		for(int i=0;i<gridmin.length;i++) 
			for(int j=0;j<gridmax.length;j++) {
				if(gridmin[i]>=gridmax[j])
					max+=gridmax[j];
				else
					max+=gridmin[i];
			}
		return max;
	}
	public static int diff(int[] positionmin,int[] positionmax) {
		int diff=0;
		for(int i=0;i<positionmax.length;i++) 
			if(positionmax[i]<positionmin[i]) {
				diff += i*(positionmin[i]-positionmax[i]);
			}
		return diff;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			int[] gridX = new int[Integer.parseInt(bf.readLine())];
			int[] gridY = new int[gridX.length];
			int[] positionX = new int[9];
			int[] positionY = new int[9];
			int minX = findmin(gridX,bf.readLine(),positionX);
			int minY = findmin(gridY,bf.readLine(),positionY);
			int min = Math.max(minX,minY),max=0,diff=0;
			if(minX>minY) {
				max = maximum(gridY,gridX);
				diff = diff(positionY,positionX);
			}else {
				max = maximum(gridX,gridY);
				diff = diff(positionX,positionY);
			}
			sb.append("Matty needs at least "+String.valueOf(min+diff)+" blocks, and can add at most "+String.valueOf(max-min-diff)+" extra blocks.\n");
		}
		System.out.print(sb);
	}

}
