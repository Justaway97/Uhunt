import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question1197 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==0 && m==0)
				break;
			DisjointSet ds = new DisjointSet(n+1);
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(bf.readLine());
				st.nextToken();
				int first = Integer.parseInt(st.nextToken());
				while(st.hasMoreTokens()) 
					ds.union(first, Integer.parseInt(st.nextToken()));
			}
			for(int i=0;i<ds.pick.length;i++)
				System.out.println(i+"="+ds.pick[i]);
			sb.append(ds.suspects()).append("\n");			
		}
		System.out.print(sb);
	}
}
class DisjointSet{
	int[] pick,rank,size;
	DisjointSet(int n){
		pick = new int[n];
		rank = new int[n];
		size = new int[n];
		for(int i=0;i<n;i++) {
			pick[i]=i;
			size[i]=1;
		}
	}
	int find(int x) {
		if(x==pick[x])
			return x;
		return find(pick[x]);
	}
	void union(int x,int y) {
		x = find(x);
		y = find(y);
		if(x==y)
			return;
		if(rank[x]>rank[y]) {
			pick[y]=x;
			size[x]+=size[y];
		}else {
			pick[x]=y;
			size[y]+=size[x];
			if(rank[x]==rank[y])
				rank[y]++;
		}
	}
	int suspects() {
		return size[find(0)];
	}
}