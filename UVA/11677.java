import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question11677 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String input=bf.readLine();
			if(input.equals("0 0 0 0"))
				break;
			StringTokenizer st = new StringTokenizer(input," ");
			int hour = Integer.parseInt(st.nextToken());
			int min = Integer.parseInt(st.nextToken());
			hour = Integer.parseInt(st.nextToken())-hour;
			min = Integer.parseInt(st.nextToken())-min;
			if(min<0) {
				min+=60;
				hour--;
			}
			if(hour<0)
				hour+=24;
			System.out.println(hour*60+min);
		}
	}
}
