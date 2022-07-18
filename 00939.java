import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Question939 {
	public static int getGenes(String gene) {
		if(gene.equals("dominant"))
			return -1;
		if(gene.equals("non-existent"))
			return 1;
		if(gene.equals("recessive"))
			return 0;
		return 1000;
	}
	public static String gene(int x,int y) {
		if(x==y) {
			if(x==-1)
				return "dominant";
			else if(x==0)
				return "recessive";
			else if(x==1)
				return "non-existent";
		}else {
			if(x+y==1)
				return "non-existent";
			else if(x+y==0)
				return "recessive";
			else if(x+y==-1)
				return "dominant";
		}
		return null;
	}
	public static void dfs(TreeMap<String,String> map,String child,String parent) {
		StringTokenizer st = new StringTokenizer(parent," ");
		if(st.countTokens()==1)
			return;
		String parent1 = st.nextToken();
		dfs(map,parent1,map.get(parent1));
		StringTokenizer st1 = new StringTokenizer(map.get(child)," ");
		map.put(child, map.get(st1.nextToken())+" "+st1.nextToken());
		String parent2 = st.nextToken();
		dfs(map,parent2,map.get(parent2));
		st1 = new StringTokenizer(map.get(child)," ");
		map.put(child, st1.nextToken()+" "+map.get(st1.nextToken()));
		st1 = new StringTokenizer(map.get(child)," ");
		map.put(child, gene(getGenes(st1.nextToken()),getGenes(st1.nextToken())));
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		TreeMap<String,String> map = new TreeMap<String,String>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			String input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			String parent = st.nextToken();
			String child = st.nextToken();
			if(child.equals("dominant") || child.equals("recessive") || child.equals("non-existent")) 
				map.put(parent, child);
			else
				map.put(child, map.getOrDefault(child, "")+" "+parent);
		}
		for(Entry<String,String> e:map.entrySet()) {
			String x = e.getKey();
			if(!e.getValue().equals("dominant") || !e.getValue().equals("recessive") || !e.getValue().equals("non-existent"))
				dfs(map,x,map.get(x));
			sb.append(e.getKey());
			sb.append(" ");
			sb.append(e.getValue());
			sb.append("\n");
		}
		System.out.print(sb);
	}
}