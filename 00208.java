import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Question208 {

	private static ArrayList<Integer>[] adjList;
	private static int n,routes;
	private static int[] trial = new int[21];
	private static boolean[] pass = new boolean[21];
	private static boolean[] canVisit;
	private static StringBuilder sb = new StringBuilder();
	private static void valid(int u){
		canVisit[u] = true;
		for(int i = 0, size = adjList[u].size(); i < size; i++){
			int v = adjList[u].get(i);
			if(!canVisit[v])
				valid(v);
		}
	}
	private static void dfs(int u, int corners){
		trial[corners-1] = u;
		if(u==n){
			routes++;
			for(int i = 0; i < corners - 1; i++)
				sb.append(trial[i]).append(" ");
			sb.append(trial[corners-1]).append("\n");
			return;
		}
		pass[u] = true;
		for(int i = 0, size = adjList[u].size(); i < size; i++){
			int v = adjList[u].get(i);
			if(!pass[v] && canVisit[v])
				dfs(v,corners+1);
		}
		pass[u] = false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int x = 1;
		while(true){
			adjList = new ArrayList[21];
			for(int i = 1; i < 21; i++)
				adjList[i] = new ArrayList<Integer>(20);
			String input = bf.readLine();
			if(input==null || input.isEmpty())
				break;
			sb.append("CASE "+x+++":\n");
			n = Integer.parseInt(input.trim());
			while(true){
				StringTokenizer st = new StringTokenizer(bf.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				if(u==0 && v ==0)
					break;
				adjList[u].add(v);
				adjList[v].add(u);
			}
			for(int i = 1; i < 21; i++)
				Collections.sort(adjList[i]);
			routes  = 0;
			canVisit = new boolean[21];
			valid(n);
			dfs(1,1);
			sb.append("There are ").append(routes).append(" routes from the firestation to streetcorner ").append(n).append(".\n");
		}
		System.out.print(sb);
	}
}