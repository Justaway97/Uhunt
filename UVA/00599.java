import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Question599 {
	public static void dfs(String p,HashMap<String,String>map,ArrayList<String> point){
		String s = map.get(p);
		if(s==null)
			return;
		point.remove(p);
		StringTokenizer st = new StringTokenizer(s,",");
		LinkedList<String> delete = new LinkedList<String>();
		while(st.hasMoreTokens()) {
			String input = st.nextToken();
			if(point.contains(input)) {
				delete.addLast(input);
				dfs(input,map,point);
			}
		}
		while(!delete.isEmpty())
			point.remove(delete.poll());
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			HashMap<String,String> map = new HashMap<String,String>();
			while(true) {
				String input = bf.readLine();
				if(input.charAt(0)=='*')
					break;
				StringBuilder sb1 = new StringBuilder();
				if(input.substring(1, 2).equals(input.substring(3, 4)))
					continue;
				sb1.append(map.getOrDefault(input.substring(1, 2), "")).append(",").append(input.substring(3, 4));
				map.put(input.substring(1, 2), sb1.toString());
				sb1 = new StringBuilder();
				sb1.append(map.getOrDefault(input.substring(3, 4), "")).append(",").append(input.substring(1, 2));
				map.put(input.substring(3, 4), sb1.toString());
			}
			String input = bf.readLine();
			ArrayList<String> point = new ArrayList<String>();
			for(String j:input.split(","))
				point.add(j);
			int tree=0,acorn=0;
			while(point.size()>0) {
				int size = point.size();
				dfs(point.get(0),map,point);
				if(size==point.size()) {
					acorn++;
					point.remove(0);
				}else
					tree++;
			}
			sb.append("There are ").append(tree).append(" tree(s) and ").append(acorn).append(" acorn(s).\n");
		}
		System.out.print(sb);
	}
}