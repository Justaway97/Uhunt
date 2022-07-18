import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question105 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int maxIndex=0,minIndex=Integer.MAX_VALUE;
		int[] coordinate = new int[10001];
		while(true) {
			String input = bf.readLine();
			if(input==null)
				break;
			StringTokenizer st = new StringTokenizer(input);
			int start = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			minIndex = Math.min(minIndex,start);
			maxIndex = Math.max(maxIndex, end);
			for(int i=start;i<end;i++) 
				coordinate[i]=Math.max(coordinate[i],value);
		}
		int curr = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=minIndex;i<maxIndex;i++) 
			if(coordinate[i]!=curr) {
				sb.append(i).append(" ").append(coordinate[i]).append(" ");
				curr = coordinate[i];
			}
		sb.append(maxIndex).append(" 0").append("\n");
		System.out.print(sb);
	}
}
