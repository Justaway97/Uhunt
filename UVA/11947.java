import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Question11947 {
	static String[] zodiac = {"capricorn","aquarius","pisces","aries","taurus","gemini","cancer","leo","virgo","libra","scorpio","sagittarius","capricorn"};
	public static int[] check (int year) {
		int[] check = {0,31,28,31,30,31,30,31,31,30,31,30,31};
			if(year%400==0 ^ (year%4==0 && year%100!=0))
				check[2]=29;
			return check;
		}
	public static String check (int range,int year){
		int check[] = {20,50,79,110,141,172,203,233,266,296,326,356,365};
		if(year%400==0 ^ (year%4==0 && year%100!=0)) 
			for(int i=2;i<check.length;i++)
				check[i]++;
		for(int i=0;i<check.length;i++) 
			if(range<=check[i])
				return zodiac[i];
		return null;
	}
	public static int year(int range,int year) {
		if(year%400==0 ^ (year%4==0 && year%100!=0))
			return range-366;
		return range-365;
	}
	public static String date(int range,int year) {
		DecimalFormat df = new DecimalFormat("00");
		int[] check = check(year);
		for(int j=1;j<=12;j++) {
			if(range==0)
				return "01/"+(j-1)+"/"+year;
			if(range-check[j]>0)
				range-=check[j];
			else
				return df.format(j)+"/"+df.format(range)+"/"+year;
		}
		return null;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(bf.readLine());
		for(int i=1;i<=cases;i++) {
			String input = bf.readLine();
			int range = Integer.parseInt(input.substring(2,4));
			range+=280;
			int year = Integer.parseInt(input.substring(4,8));
			int[] checkday = check(year);
			for(int j=1;j<Integer.parseInt(input.substring(0,2));j++)
				range+=checkday[j];
			if(range>365) {
				range=year(range,year);
				year++;
			}
			if(range==0)
				System.out.println(i+" 12/31/"+(year-1)+" capricorn");
			else
				System.out.println(i+" "+date(range,year)+" "+check(range,year));
			}
		}
	}
