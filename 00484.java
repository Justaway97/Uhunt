import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Question484 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		LinkedList<Integer> l = new LinkedList<Integer>();
		while(true) {
			String s = bf.readLine();
			if(s==null)
				break;
			StringTokenizer st = new StringTokenizer(s," ");
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				map.put(num, map.getOrDefault(num, 0)+1);
				if(!l.contains(num))
					l.addLast(num);
			}
		}
		for(int i=0;i<l.size();i++) {
			sb.append(String.valueOf(l.get(i))+" "+String.valueOf(map.get(l.get(i))));
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
