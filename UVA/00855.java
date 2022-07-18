import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Question855 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			st.nextToken();st.nextToken();
			int friend = Integer.parseInt(st.nextToken());
			ArrayList<Integer> x = new ArrayList<Integer>();
			ArrayList<Integer> y = new ArrayList<Integer>();
			for(int j=0;j<friend;j++) {
				st = new StringTokenizer(bf.readLine()," ");
				x.add(Integer.parseInt(st.nextToken()));
				y.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(x);
			Collections.sort(y);
			sb.append("(Street: "+x.get(((friend+1)/2)-1)+", Avenue: "+y.get(((friend+1)/2)-1)+")\n");
		}
		System.out.print(sb);
	}
}
