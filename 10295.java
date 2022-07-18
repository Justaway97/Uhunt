import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Question10295 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine()," ");
			map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
		}
		for(int i=0;i<m;i++) {
			int sum = 0;
			while(true) {
				String description = bf.readLine();
				if(description.endsWith("."))
					break;
				st = new StringTokenizer(description," ");
				while(st.hasMoreTokens()) 
					sum += map.getOrDefault(st.nextToken(),0);
			}
			sb.append(sum);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
