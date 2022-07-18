import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Question1047 {
	public static void fill(ArrayList<Integer> max,int[] pos,int m) {
		for(int j=0;j<pos.length;j++) 
			if(pos[j]!=0) {
				max.add(j);
				max.add(pos[j]);
			}
		max.add(m);
	}
	public static void FindMax(BitSet[] tree,int[] pos,ArrayList<Integer> max,int[] v) {
		int m=0;
		for(int j=0;j<pos.length;j++) 
			m+=pos[j];
		for(int i=0;i<tree.length;i++) {
			boolean flag=false;
			for(int j=0;j<pos.length;j++) 
				if(pos[j]!=0 && tree[i].get(j)) {
					if(flag)
						m-=v[i];
					flag=true;
				}
		}
		if(max.isEmpty()) {
			fill(max,pos,m);
		}else if(m>max.get(max.size()-1)) {
			max.clear();
			fill(max,pos,m);
		}
	}
	public static void findLocation(int start,int build,int[] prev,int n,int[] ori,int end,BitSet[] tree,ArrayList<Integer>max,int[] v) {
		int[] temp = Arrays.copyOf(prev, prev.length);
		temp[start] = ori[start];
		if(build==end) {
			FindMax(tree,temp,max,v);
			return;
		}
		for(int i=start+1;i<prev.length;i++) {
			findLocation(i,build,temp,n,ori,end+1,tree,max,v);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x=1;
		while(true) {
			String input = bf.readLine();
			if(input.equals("0 0"))
				break;
			StringTokenizer st = new StringTokenizer(input);
			int[] tower = new int[Integer.parseInt(st.nextToken())+1];
			int build = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			for(int i=1;i<tower.length;i++) 
				tower[i] = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(bf.readLine());
			BitSet[] tree = new BitSet[n];
			int[] v = new int[n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(bf.readLine());
				int size = Integer.parseInt(st.nextToken());
				tree[i] = new BitSet(tower.length);
				for(int j=0;j<size;j++) 
					tree[i].set(Integer.parseInt(st.nextToken()));
				v[i] = Integer.parseInt(st.nextToken());
			}
			ArrayList<Integer> max = new ArrayList<Integer>();
			int maximum=0;
			for(int i=1;i<=tower.length-build;i++) {
				ArrayList<Integer> m = new ArrayList<Integer>();
				findLocation(i,build,new int[tower.length],n,tower,1,tree,m,v);
				if(!m.isEmpty() && m.get(m.size()-1)>maximum) {
					max = m;
					maximum = m.get(m.size()-1);
				}
				
			}
			sb.append("Case Number  "+x).append("\n").append("Number of Customers: ").append(max.get(max.size()-1)).append("\n").append("Locations recommended:");
			for(int i=0;i<max.size()-1;i+=2)
				sb.append(" ").append(max.get(i));
			sb.append("\n\n");
			x++;
		}
		System.out.print(sb);
	}
}
