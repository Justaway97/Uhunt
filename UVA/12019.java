import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Question12019 {
	static int[] checkmonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	static String[] checkday = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(bf.readLine());
		for(int i=0;i<cases;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			int month = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			for(int j=0;j<month;j++) 
				day+=checkmonth[j];
			day+=5;
			System.out.println(checkday[day%7]);
		}
	}
}
