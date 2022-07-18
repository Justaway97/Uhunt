import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Question380 {
	public static void find(HashMap<String,Integer> map,String num,HashMap<String,ArrayList<call>> m,StringBuilder sb,int start) {
		if(map.get(num)!=null) {
			sb.append(9999).append("\n");
			return;
		}
		ArrayList<call> temp = m.getOrDefault(num,new ArrayList<call>());
		for(int i=0;i<temp.size();i++) {
			if(temp.get(i).afkStart<=start) {
				if(temp.get(i).afkEnd>=start) {
					map.put(num, 1);
					find(map,temp.get(i).forward,m,sb,start);
					return;
				}
			}
		}
		sb.append(num).append("\n");
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append("CALL FORWARDING OUTPUT\n");
		for(int i=0;i<n;i++) {
			sb.append("SYSTEM ").append(i+1).append("\n");
			HashMap<String,ArrayList<call>> map = new HashMap<String,ArrayList<call>>();
			while(true) {
				String input = bf.readLine();
				if(input.equals("0000"))
					break;
				StringTokenizer st = new StringTokenizer(input);
				String name = st.nextToken();
				ArrayList<call> q = map.getOrDefault(name, new ArrayList<call>());
				q.add(new call(st));
				map.put(name,q);
			}
			while(true) {
				String input = bf.readLine();
				if(input.equals("9000"))
					break;
				StringTokenizer st = new StringTokenizer(input);
				String start = st.nextToken();
				String f = st.nextToken();
				sb.append("AT ").append(start).append(" CALL TO ").append(f).append(" RINGS ");
				find(new HashMap<String,Integer>(),f,map,sb,Integer.parseInt(start));
			}
		}
		sb.append("END OF OUTPUT\n");
		System.out.print(sb);
	}
}
class call{
	int afkStart,afkEnd;
	String forward;
	public call(StringTokenizer st) {
		afkStart = Integer.parseInt(st.nextToken());
		afkEnd = afkStart + Integer.parseInt(st.nextToken());
		forward = st.nextToken();
	}
}
