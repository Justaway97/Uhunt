import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Question394 {
	public static int sum(int[] Index,StringTokenizer st,arr calculation) {
		int x=0,sum=0;
		while(st.countTokens()>1) {
			int index = Integer.parseInt(st.nextToken());
			Index[x] = index;
			if(calculation.dimension[x][0]<index);
				index -= calculation.dimension[x][0];
			for(int j=x+1;j<calculation.dimension.length;j++) 
				index*=(calculation.dimension[j][1]-calculation.dimension[j][0]+1);
			sum+=index;
			x++;
		}
		Index[x] = Integer.parseInt(st.nextToken());
		return sum+Index[x]-calculation.dimension[calculation.dimension.length-1][0];
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String,arr> map = new HashMap<String,arr>();
		for(int i=0;i<n;i++) {
			String input = bf.readLine();
			st = new StringTokenizer(input);
			map.put(st.nextToken(), new arr(st));
		}
		for(int i=0;i<m;i++) {
			String input = bf.readLine();
			st = new StringTokenizer(input);
			String arrayName = st.nextToken();
			arr calculation = map.get(arrayName);
			int[] Index = new int[st.countTokens()];
			int sum = sum(Index,st,calculation);
			sb.append(arrayName);
			sb.append("[");
			for(int j=0;j<Index.length-1;j++) {
				sb.append(Index[j]);
				sb.append(", ");
			}
			sb.append(Index[Index.length-1]);
			sb.append("]");
			sb.append(" = ");
			sb.append(sum*calculation.range+calculation.start);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
class arr{
	int start;
	int range;
	int[][] dimension;
	public arr(StringTokenizer st) {
		start = Integer.parseInt(st.nextToken());
		range = Integer.parseInt(st.nextToken());
		dimension = new int[Integer.parseInt(st.nextToken())][2];
		for(int i=0;i<dimension.length;i++) {
			dimension[i][0] = Integer.parseInt(st.nextToken());
			dimension[i][1] = Integer.parseInt(st.nextToken());
		}
	}
}