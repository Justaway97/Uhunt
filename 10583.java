import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Question10583 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x=1;
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if(m==0 && n==0)
				break;
			Religion r = new Religion(m+1);
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(bf.readLine());
				r.union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			TreeSet<Integer> s = new TreeSet<Integer>();
			for(int i=0;i<r.pick.length;i++) 
				s.add(r.find(r.pick[i]));
			sb.append("Case ").append(x).append(": ").append(s.size()-1).append("\n");
			x++;
		}
		System.out.print(sb);
	}
}
class Religion{
	int[] pick,rank;
	public Religion(int n) {
		pick = new int[n];
		rank = new int[n];
		for(int i=0;i<n;i++)
			pick[i]=i;
	}
	void union(int x,int y) {
		x = find(x);
		y = find(y);
		if(x==y)
			return;
		if(rank[x]>rank[y])
			pick[y]=x;
		else {
			pick[x]=y;
			if(rank[x]==rank[y])
				rank[y]++;
		}
	}
	int find(int x) {
		if(x==pick[x])
			return x;
		return find(pick[x]);
	}
}