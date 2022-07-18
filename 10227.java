import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Question10227 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(bf.readLine().trim());
		bf.readLine();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			TreeSet<Integer>[] tree = new TreeSet[x];
			for(int j=0;j<tree.length;j++)
				tree[j] = new TreeSet<Integer>();
			while(true) {
				String input = bf.readLine();
				if(input.isEmpty() || input==null)
					break;
				st = new StringTokenizer(input);
				tree[Integer.parseInt(st.nextToken())-1].add(Integer.parseInt(st.nextToken())-1);
			}
			HashSet<String> set = new HashSet<String>();
			for(int j=0;j<tree.length;j++) 
				set.add(tree[j].toString());
			sb.append(set.size()).append("\n");
			if(i!=n-1)
				sb.append("\n");
		}
		System.out.print(sb);
	}
}
