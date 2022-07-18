import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Question11340 {

	public static void main(String[] args) throws Exception {
		DecimalFormat df = new DecimalFormat("00");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++) {
			int N = Integer.parseInt(bf.readLine());
			HashMap<String,Integer> map = new HashMap<String,Integer>();
			for(int j=0;j<N;j++) {
				String input = bf.readLine();
				StringTokenizer st = new StringTokenizer(input," ");
				map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
			}
			int sum = 0;
			int word = Integer.parseInt(bf.readLine());
			for(int j=0;j<word;j++) {
				String input = bf.readLine();
				for(int k=0;k<input.length();k++)
					if(map.containsKey(Character.toString(input.charAt(k))))
						sum += map.get(Character.toString(input.charAt(k)));
			}
			System.out.println((sum/100)+"."+df.format(sum%100)+"$");
		}
	}
}
