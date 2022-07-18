import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question893 {

	public static int Day(int year) {
		if(checkLeap(year))
			return 366;
		return 365;
	}
	public static String checkYear(int range,int year) {
		int i=year;
		for(i=year;range>364;i++) 
			range-=Day(i);
		if(range==0)
			return 31+" "+12+" "+(i-1);
		return checkMonth(range,i)+" "+i;
	}
	public static boolean checkLeap(int year) {
		if(year%4==0&&(year%100!=0||year%400==0))
			return true;
		return false;
	}
	public static String checkMonth(int range,int year) {
		int[] normal = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(checkLeap(year))
			normal[2]++;
		int i=1;
		for(i=1;range>normal[i];i++) 
			range-=normal[i];
		return range+" "+i;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String input = bf.readLine();
			if(input.equals("0 0 0 0"))
				break;
			StringTokenizer st = new StringTokenizer(input," ");
			int range = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			int[] normal = {0,31,28,31,30,31,30,31,31,30,31,30,31};
			if(checkLeap(year))
				normal[2]++;
			for(int i=1;i<month;i++) 
				range+=normal[i];
			range+=day;
			System.out.println(checkYear(range,year));
		}
	}
}
