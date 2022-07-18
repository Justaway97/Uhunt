import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Question12439 {
	private static long count;
	private static void yearCount(long year1,long year2) {
		if(year1==year2 && leapYear(year1) && leapYear(year2)) {
			count++;
			return;
		}
		if(leapYear(year1))
			count++;
		count+=(year2)/4-(year1)/4;
		count-=(year2)/100-(year1)/100;
		count+=(year2)/400-(year1)/400;
	}
	private static boolean leapYear(long year) {
		if(year%400==0 || (year%4==0 && year%100!=0))
			return true;
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("January", 1);
		map.put("February", 2);
		map.put("March", 3);
		map.put("April", 4);
		map.put("May", 5);
		map.put("June", 6);
		map.put("July", 7);
		map.put("August", 8);
		map.put("September", 9);
		map.put("October", 10);
		map.put("November", 11);
		map.put("December", 12);
		int cases = Integer.parseInt(bf.readLine());
		for(int i=1;i<=cases;i++) {
			count=0;
			String input1 = bf.readLine();
			String input2 = bf.readLine();
			StringTokenizer st = new StringTokenizer(input1);
			int month1 = map.get(st.nextToken());
			st.nextToken();
			long year1 = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(input2);
			int month2 = map.get(st.nextToken());
			String s = st.nextToken();
			int day2 = Integer.parseInt(s.substring(0,s.length()-1));
			long year2 = Integer.parseInt(st.nextToken());
			yearCount(year1,year2);
			if(year1!=year2) {
				if(leapYear(year1) && month1>2)
					count--;
				if(leapYear(year2) && (month2<=2 && day2<29 || month2<2))
					count--;
			}else {
				if(leapYear(year1) && (month1>2 || month2<2 || month2==2 && day2<29))
					count--;
			}
			sb.append("Case ").append(i).append(": ").append(count).append("\n");
		}
		System.out.print(sb);
	}
}
