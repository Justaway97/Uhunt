import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
	
public class Question957 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = bf.readLine();
			if(s==null || s.isEmpty())
				break;
			int length = Integer.parseInt(s.trim());
			int[] year = new int[Integer.parseInt(bf.readLine().trim())];
			for(int i=0;i<year.length;i++)
				year[i] = Integer.parseInt(bf.readLine().trim());
			int max = 0,maxStart=0,maxEnd=0;
			for(int i=0;i<year.length;i++) {
				int curr = 0;
				for(int j=i;j<year.length && year[j]<year[i]+length;j++) 
					if(++curr>max) {
						max = curr;
						maxStart = year[i];
						maxEnd = year[j];
					}
			}
			sb.append(max).append(" ").append(maxStart).append(" ").append(maxEnd).append("\n");
			bf.readLine();
		}
		System.out.print(sb);
	}
}
