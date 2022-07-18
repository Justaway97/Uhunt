import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Question860 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
		DecimalFormat df = new DecimalFormat("#.#");
		DecimalFormat df1 = new DecimalFormat("0.0");
		StringBuilder sb = new StringBuilder();
		String s = "";
		while(!s.equals("****END_OF_INPUT****")) {
			int count = 0;
			TreeMap<String,Integer> map = new TreeMap<String,Integer>();
			LinkedList<String> letter = new LinkedList<String>();
			while(true) {
				s = bf.readLine();
				if(s.equals("****END_OF_TEXT****") || s.equals("****END_OF_INPUT****"))
					break;
				StringTokenizer st = new StringTokenizer(s," ,.:;!?\"()\t\n");
				count+=st.countTokens();
				while(st.hasMoreTokens())
					letter.add(st.nextToken().toLowerCase());
			}
			for(int i=0;i<letter.size();i++) 
				map.put(String.valueOf(letter.get(i)), map.getOrDefault(String.valueOf(letter.get(i)),0)+1);
			double Et = 0,Emax = Math.log(count)/Math.log(10);
			for(Entry<String,Integer> e:map.entrySet()) {
				int pi = e.getValue();
				Et += (double)pi*(Emax-Math.log(pi)/Math.log(10));
			}
			Et/=count;
			int Erel = (int) Math.round(Et/Emax*100);
			if(count!=0) {
				sb.append(count);sb.append(" ");sb.append(df1.format(Double.parseDouble(df.format(Et))));
				sb.append(" ");sb.append(Erel);sb.append("\n");
			}else if(count==0 && s.equals("****END_OF_TEXT****"))
				sb.append("0 0.0 0\n");
		}
		System.out.print(sb);
	}
}
