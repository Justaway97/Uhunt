import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Question10138 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat("00");
		int n = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		bf.readLine();
		for(int i=0;i<n;i++) {
			int[] cent = new int[24];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<cent.length;j++)
				cent[j] = Integer.parseInt(st.nextToken());
			TreeMap<String,LinkedList<car>> map = new TreeMap<String,LinkedList<car>>();
			while(true) {
				String s = bf.readLine();
				if(s==null || s.isEmpty())
					break;
				st = new StringTokenizer(s);
				String carName = st.nextToken();
				LinkedList<car> c = map.getOrDefault(carName, new LinkedList<car>());
				c.add(new car(st.nextToken(),st.nextToken(),st.nextToken()));
				map.put(carName, map.getOrDefault(carName, c));
			}
			for(Entry<String,LinkedList<car>> e:map.entrySet()) {
				LinkedList<car> c = e.getValue();
				if(c.size()==1)
					continue;
				int pay = 200;
				Collections.sort(c);
				for(int j=0;j<c.size()-1;++j) 
					if(c.get(j).InOut.equals("enter") && c.get(j+1).InOut.equals("exit"))
						pay += 100 + cent[c.get(j).hour]*(Math.abs(c.get(j+1).pass-c.get(j).pass));
				if(pay>200) {
					sb.append(e.getKey());
					sb.append(" $");
					sb.append(pay/100);
					sb.append(".");
					sb.append(df.format(pay%100));
					sb.append("\n");
				}
			}
			if(i!=n-1)
				sb.append("\n");
		}
		System.out.print(sb);
	}
}
class car implements Comparable<car>{
	private String time;
	String InOut;
	int pass;
	int hour;
	public car(String x,String y,String z) {
		time = x;
		hour = Integer.parseInt(x.substring(6, 8));
		InOut = y;
		pass = Integer.parseInt(z);
	}
	@Override
	public int compareTo(car c) {
		return this.time.compareTo(c.time);
	}
}
