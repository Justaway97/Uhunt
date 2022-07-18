import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question12136 {

	public static boolean check(String input,String input1) {
		StringTokenizer st = new StringTokenizer(input," ");
		StringTokenizer st1 = new StringTokenizer(st.nextToken(),":");
		int wife = Integer.parseInt(st1.nextToken())*60;
		wife += Integer.parseInt(st1.nextToken());
		st1 = new StringTokenizer(st.nextToken(),":");
		int wife1 = Integer.parseInt(st1.nextToken())*60;
		wife1 +=Integer.parseInt(st1.nextToken());
		st = new StringTokenizer(input1," ");
		st1 = new StringTokenizer(st.nextToken(),":");
		int meeting = Integer.parseInt(st1.nextToken())*60;
		meeting += Integer.parseInt(st1.nextToken());
		st1 = new StringTokenizer(st.nextToken(),":");
		int meeting1 = Integer.parseInt(st1.nextToken())*60;
		meeting1 +=Integer.parseInt(st1.nextToken());
		if(meeting1<meeting)
			meeting1+=24*60;
		if(wife1<wife)
			wife1+=24*60;
		if((meeting>=wife && meeting<=wife1)||(meeting<=wife && meeting1>=wife)||(meeting>=wife && meeting<=wife1)|| meeting1==wife || wife1==meeting)
			return false;
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(bf.readLine());
		for(int i=1;i<=cases;i++) {
			if(check(bf.readLine(),bf.readLine()))
				System.out.println("Case "+i+": Hits Meeting");
			else
				System.out.println("Case "+i+": Mrs Meeting");
		}
	}
}
