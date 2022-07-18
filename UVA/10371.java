import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Question10371 {
	public static String[][] zone = {{"UTC","0"},{"GMT","0"},{"BST","1"},{"IST","1"},{"WET","0"},{"WEST","1"},{"CET","1"}
									,{"CEST","2"},{"EET","2"},{"EEST","3"},{"MSK","3"},{"MSD","4"},{"AST","-4"},{"ADT","-3"}
									,{"NST","-3.5"},{"NDT","-2.5"},{"EST","-5"},{"EDT","-4"},{"CST","-6"},{"CDT","-5"}
									,{"MST","-7"},{"MDT","-6"},{"PST","-8"},{"PDT","-7"},{"HST","-10"},{"AKST","-9"}
									,{"AKDT","-8"},{"AEST","10"},{"AEDT","11"},{"ACST","9.5"},{"ACDT","10.5"},{"AWST","8"}};
	public static String checkzone(String input) {
		for(int i=0;i<zone.length;i++) 
			if(zone[i][0].equals(input))
				return zone[i][1];
		return null;
	}
	public static void main(String[] args) throws Exception {	
		DecimalFormat df = new DecimalFormat("00");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(bf.readLine());
		for(int i=0;i<cases;i++) {
			int hour=0,min=0;
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			String time = st.nextToken();
			if(time.equals("noon"))
				hour=12;
			else if(time.equals("midnight"))
				hour=24;
			else {
				StringTokenizer st1 = new StringTokenizer(time,":");
				hour = Integer.parseInt(st1.nextToken());
				min = Integer.parseInt(st1.nextToken());
				if(hour==12)
					hour=0;
			}
			if(st.countTokens()==3 && st.nextToken().equals("p.m.")) 
				hour+=12;
			String zone = checkzone(st.nextToken());
			double timechange = Double.parseDouble(checkzone(st.nextToken()))-Double.parseDouble(zone);
			if(timechange%1!=0) {
				if(timechange>0)
					min+=30;
				else
					min-=30;
			}
			hour+=(int) timechange;
			if(min>=60) {
				min-=60;
				hour++;
			}
			while(hour>24)
				hour-=24;
			if(min<0) {
				min+=60;
				hour--;
			}
			if(hour<0) 
				hour+=24;
			if((hour==24 || hour==0) && min==0)
				System.out.println("midnight");
			else if(hour==12 && min==0)
				System.out.println("noon");
			else if(hour>12 && hour!=24)
				System.out.println(hour-12+":"+df.format(min)+" p.m.");
			else if(hour==12)
				System.out.println(hour+":"+df.format(min)+" p.m.");
			else if(hour==24 || hour==0)
				System.out.println("12:"+df.format(min)+" a.m.");
			else if(hour<12)
				System.out.println(hour+":"+df.format(min)+" a.m.");
		}
	}
}