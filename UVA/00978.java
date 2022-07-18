import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Question978 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int field = Integer.parseInt(st.nextToken());
			PriorityQueue<Integer> green = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> blue = new PriorityQueue<>(Collections.reverseOrder());
			int soldierG = Integer.parseInt(st.nextToken());
			int soldierB = Integer.parseInt(st.nextToken());
			for(int j=0;j<soldierG;j++)
				green.add(Integer.parseInt(bf.readLine()));
			for(int j=0;j<soldierB;j++)
				blue.add(Integer.parseInt(bf.readLine()));
			while(blue.size()!=0 && green.size()!=0) {
				LinkedList<Integer> greenleft = new LinkedList<Integer>();
				LinkedList<Integer> blueleft = new LinkedList<Integer>();
				int size = Math.min(green.size(), blue.size());
				for(int j=0;j<Math.min(field, size);j++) {
					int g = green.poll();
					int b = blue.poll();
					if(g>b)
						greenleft.add(g-b);
					else if(g<b)
						blueleft.add(b-g);
				}
				while(!greenleft.isEmpty())
					green.add(greenleft.poll());
				while(!blueleft.isEmpty())
					blue.add(blueleft.poll());
			}
			if(blue.size()==0 && green.size()==0)
				sb.append("green and blue died\n");
			else if(blue.size()==0) {
				sb.append("green wins\n");
				while(!green.isEmpty()) {
					sb.append(green.poll());
					sb.append("\n");
				}
			}else if(green.size()==0) {
				sb.append("blue wins\n");
				while(!blue.isEmpty()) {
					sb.append(blue.poll());
					sb.append("\n");
				}
			}
			if(i!=n-1)
				sb.append("\n");
		}
		System.out.print(sb);
	}
}
