import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question10608 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Friend f = new Friend(a+1);
			for(int j=0;j<b;j++) {
				st = new StringTokenizer(bf.readLine());
				f.union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			int[] max = new int[a+1];
			int MAX = 0;
			for(int j=1;j<max.length;j++) {
				max[f.find(f.pick[j])]++;
				if(max[f.find(f.pick[j])]>MAX)
					MAX = max[f.find(f.pick[j])];
			}
			sb.append(MAX).append("\n");
		}
		System.out.print(sb);
	}
}
class Friend{
	int[] pick,rank;
	public Friend(int a) {
		pick = new int[a];
		rank = new int[a];
		for(int i=0;i<a;i++) 
			pick[i]=i;
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
		if(rank[x]>rank[y])
			pick[y]=x;
		else {
			pick[x]=y;
			if(rank[x]==rank[y])
				rank[y]++;
		}
	}
}