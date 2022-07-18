import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Question11650 {

	public static String time(String input) {
		DecimalFormat df = new DecimalFormat("00");
		StringTokenizer st = new StringTokenizer(input,":");
		int hour = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(st.nextToken());
		if(hour==11 && min==0)
			hour=1;
		else if(hour==11 && min!=0)
			hour=12;
		else if(hour==12 && min!=0)
			hour=11;
		else if(min==0)
			hour=12-hour;
		else
			hour=11-hour;
		if(min!=0)
			min = 60-min;
		return df.format(hour)+":"+df.format(min);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(bf.readLine());
		for(int i=0;i<cases;i++) {
			String input = bf.readLine();
			if(input.equals("12:00") || input.equals("06:00"))
				System.out.println(input);
			else 
				System.out.println(time(input));
		}
	}
}
