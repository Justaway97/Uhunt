import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Question10226 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat("0.0000");
		int n = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		bf.readLine();
		for(int i=0;i<n;i++) {
			TreeMap<String,Double> map = new TreeMap<String,Double>();
			int count=0;
			while(true) {
				String tree = bf.readLine();
				if(tree==null || tree.isEmpty())
					break;
				map.put(tree, map.getOrDefault(tree, 0.0)+1.0);
				count++;
			}
			for(Entry<String, Double> e:map.entrySet()) {
				sb.append(e.getKey());
				sb.append(" ");
				sb.append(df.format(e.getValue()/count*100));
				sb.append("\n");
			}
			if(i!=n-1)
				sb.append("\n");
		}
		System.out.print(sb);
	}
}
