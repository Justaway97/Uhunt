import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question300 {

	public static String[] list = {"pop","no","zip","zotz","tzec","xul","yoxkin","mol","chen","yax","zac","ceh","mac","kankin","muan","pax","koyab","cumhu"};
	public static String[] LIST = {"ahau","imix","ik","akbal","kan","chicchan","cimi","manik","lamat","muluk","ok","chuen","eb","ben","ix","mem","cib","caban","eznab","canac"}; 
	public static int checkPeriod(String input) {
		for(int i=0;i<list.length;i++) 
			if(input.equals(list[i]))
				return i;
		return 18;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(bf.readLine()," ");
		int cases = Integer.parseInt(st1.nextToken());
		for(int i=0;i<cases;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			String input=st.nextToken();
			int day=1;
			day += Integer.parseInt(input.substring(0,input.length()-1));
			day += checkPeriod(st.nextToken())*20;
			day += Integer.parseInt(st.nextToken())*365;
			int finalyear = day/260;
			int remainder = day-finalyear*260;
			int finalday = remainder%13;
			if(day%260==0)
				finalyear--;
			if(finalday==0)
				finalday=13;
			if(i==0)
				System.out.println(cases);
			System.out.println(finalday+" "+LIST[remainder%20]+" "+finalyear);
		}
	}
}
