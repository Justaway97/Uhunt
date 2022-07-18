import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Question540 {
	
	public static void main(String[]args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x=1;
		while(true) {
			int n = Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			sb.append("Scenario #"+String.valueOf(x)+"\n");
			TreeMap<String,Integer> original = new TreeMap<String,Integer>();
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine()," ");
				st.nextToken();
				while(st.hasMoreTokens()) 
					original.put(st.nextToken(), i);
			}
			LinkedList<LinkedList<String>> queue = new LinkedList<LinkedList<String>>();
			LinkedList<String>[] q = new LinkedList[n];
			for(int i=0;i<q.length;i++)
				q[i] = new LinkedList<String>();
			boolean[] flag = new boolean[n]; 
			while(true) {
				StringTokenizer st = new StringTokenizer(bf.readLine()," ");
				String command = st.nextToken();
				if(command.equals("ENQUEUE")) {
					String num = st.nextToken();
					int index = original.get(num);
					q[index].addLast(num);
					if(!flag[index]) {
						queue.addLast(q[index]);
						flag[index]=true;
					}
				}else if(command.equals("DEQUEUE")) {
					LinkedList<String> remove = queue.peekFirst();
					if(remove.size()==1) {
						flag[original.get(remove.getFirst())]=false;
						queue.removeFirst();
					}
					sb.append(remove.removeFirst());
					sb.append("\n");
				}else if(command.equals("STOP"))
					break;
			}
			sb.append("\n");
			x++;
		}
		System.out.print(sb);
	}
}