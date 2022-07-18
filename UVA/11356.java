import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Question11356 {
	static DecimalFormat df = new DecimalFormat("00");
	static String[] p = {"","January","February","March","April","May","June","July","August","September","October","November","December"};
	public static int[] check (int year) {
	int[] check = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(year%400==0 ^ (year%4==0 && year%100!=0))
			check[2]=29;
		return check;
	}
	public static String result1 (int range,int year) {
		int[] month = check(year);
		for(int i=1;;i++) {
			if(range==0)
				return p[i-1]+"-"+month[i-1];
			if(range-month[i]>=0)
				range-=month[i];
			else
				return p[i]+"-"+df.format(range);
		}
	}
	public static String result (int year,int range) {
		for(int i=year,interval=365;;i++) {
			if(range==1)
				return (i)+"-January-01";
			if(range==0)
				return(i-1)+"-December-31";
			if(i%400==0 ^ (i%4==0 && i%100!=0))
				interval=366;
			else
				interval=365;
			if(range-interval>=0)
				range-=interval;
			else
				return i+"-"+result1(range,i);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(bf.readLine());
		for(int i=1;i<=cases;i++) {
			System.out.print("Case "+i+": ");
			StringTokenizer st = new StringTokenizer(bf.readLine(),"-");
			int year = Integer.parseInt(st.nextToken());
			int range=0;
			String s=st.nextToken();
			int j=0;
			for(j=1;;j++)
				if(s.equals(p[j]))
					break;
			for(int k=1;k<j;k++) 
				range += check(year)[k];
			range+=Integer.parseInt(st.nextToken());
			range += Integer.parseInt(bf.readLine());
			System.out.println(result(year,range));
		}
	}
}
