import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Question514 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			while(true) {
				LinkedList<Integer> train = new LinkedList<Integer>();
				Stack<Integer> station = new Stack<Integer>();
				for(int i=1;i<=n;i++)
					train.add(i);
				boolean flag=true;
				String input = bf.readLine();
				if(input.equals("0")) 
					break;
				StringTokenizer st = new StringTokenizer(input," ");
				while(st.hasMoreTokens()) {
					int queue = Integer.parseInt(st.nextToken());
					while(train.contains(queue))
						station.push(train.removeFirst());
					if(station.size()>0 && station.peek()==queue)
						station.pop();
					else {
						flag = false;
						break;
					}
				}
				if(flag)
					sb.append("Yes\n");
				else
					sb.append("No\n");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
