import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Question10282 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,String> map = new HashMap<String,String>();
		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = bf.readLine();
			if(input.isEmpty() || input==null)
				break;
			StringTokenizer st = new StringTokenizer(input," ");
			String value = st.nextToken();
			String key = st.nextToken();
			map.put(key,value);
		}
		while(true) {
			String key = bf.readLine();
			if(key==null)
				break;
			sb.append(map.getOrDefault(key, "eh"));
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
