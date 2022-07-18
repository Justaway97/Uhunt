import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Question10125 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = Integer.parseInt(bf.readLine().trim());
			if(n==0)
				break;
			int[] tree = new int[n];
			for(int i=0;i<n;i++) 
				tree[i] = Integer.parseInt(bf.readLine().trim());
			Arrays.sort(tree);
			HashMap<Integer,int[]> pair = new HashMap<Integer,int[]>();
			for(int i=0;i<tree.length;i++) 
				for(int j=i+1;j<tree.length;j++) {
					int[] temp = new int[2];
					temp[0]=tree[i];
					temp[1]=tree[j];
					pair.put(temp[0]+temp[1], temp);
				}
			boolean flag=false;
			for(int i=tree.length-1;i>=0 && !flag;i--) 
				for(int j=i-1;j>=0;j--) {
					int d = tree[i]-tree[j];
					if(pair.get(d)!=null && !(tree[i]==pair.get(d)[0] || tree[i]==pair.get(d)[1] || tree[j]==pair.get(d)[0] || tree[j]==pair.get(d)[1])) {
						sb.append(tree[i]).append("\n");
						flag=true;
						break;
					}
				}
			if(!flag)
				sb.append("no solution\n");
		}
		System.out.print(sb);
	}
}
