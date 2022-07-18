import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
public class Question335{
	private static int minValue;
	private static String result;
	private static HashMap<String,Integer> down = new HashMap<String,Integer>();
	private static HashMap<String,ArrayList<destination>> map = new HashMap<String,ArrayList<destination>>();
	private static void findBest(String start) {
		ArrayList<destination> temp = map.getOrDefault(start, new ArrayList<destination>());
		if(start.equals("*"))
			return;
		for(int i=0;i<temp.size();i++)
			if(temp.get(i).value<minValue && down.get(temp.get(i).d)==null) {
				minValue=temp.get(i).value;
				result = temp.get(i).d;
			}
		StringTokenizer st = new StringTokenizer(start,"*");
		StringBuilder sb = new StringBuilder();
		StringTokenizer st1 = new StringTokenizer(st.nextToken(),".");
		st1.nextToken();
		sb.append("*");
		while(st1.hasMoreTokens())
			sb.append(".").append(st1.nextToken());
		findBest(sb.toString());
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(bf.readLine());
		String start = "";
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			if(st.countTokens()==3)
				start = st.nextToken();
			int v = Integer.parseInt(st.nextToken());
			String dest = st.nextToken();
			ArrayList<destination> temp = map.getOrDefault(start, new ArrayList<destination>());
			temp.add(new destination(v,dest));
			map.put(start, temp);
		}
		for(Entry<String,ArrayList<destination>> e:map.entrySet())
			Collections.sort(e.getValue());
		while(true) {
			minValue=Integer.MAX_VALUE;
			result="";
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String command = st.nextToken();
			if(command.equals("X"))
				break;
			String location = st.nextToken();
			if(command.equals("D"))
				down.put(location,1);
			else if(command.equals("U"))
				down.remove(location);
			else {
				findBest(location);
				sb.append(location);
				if(result.isEmpty())
					sb.append(" =>");
				else
					sb.append(" => ");
				sb.append(result).append("\n");
			}
		}
		System.out.print(sb);
	}
}
class destination implements Comparable<destination>{
	int value;
	String d;
	public destination(int v,String dest) {
		this.value = v;
		this.d = dest;
	}
	@Override
	public int compareTo(destination d) {
		return this.value-d.value;
	}
}