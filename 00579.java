import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Question579 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader (new InputStreamReader (System.in));
		DecimalFormat df = new DecimalFormat("0.000");
		String input="";
		while(true) {
			input = bf.readLine();
			if(input.equals("0:00"))
				break;
			StringTokenizer st = new StringTokenizer(input,":");
			double hour = Integer.parseInt(st.nextToken());
			double minute = Integer.parseInt(st.nextToken());
			double degreehour = hour*360/12 + minute/2;
			double degreeminute = minute*360/60;
			double result=Math.max(degreehour,degreeminute)-Math.min(degreeminute,degreehour);
			if(result>180) {
				result=360-result;
			}
			System.out.println(df.format(result));
		}
	}
}
