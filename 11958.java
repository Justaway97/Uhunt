import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question11958 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(bf.readLine());
		for(int i=1;i<=cases;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			int bus = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(st.nextToken(),":");
			int hour = Integer.parseInt(st.nextToken());
			int min = Integer.parseInt(st.nextToken());
			int MIN = Integer.MAX_VALUE;
			for(int j=0;j<bus;j++) {
				String input = bf.readLine();
				st = new StringTokenizer(input," ");
				StringTokenizer st1 = new StringTokenizer(st.nextToken(),":");
				int arrivehour = Integer.parseInt(st1.nextToken());
				int arrivemin = Integer.parseInt(st1.nextToken());
				int duration = Integer.parseInt(st.nextToken());
				if(arrivehour<hour || (arrivehour==hour && arrivemin<min))
					arrivehour+=24;
				while(true) {
					if(duration>=60) {
						duration-=60;
						arrivehour++;
					}
					else {
						arrivemin+=duration;
						break;
					}
				}
				arrivehour-=hour;
				arrivemin-=min;
				arrivemin+=arrivehour*60;
				if(arrivemin<0) {
					arrivemin+=60;
					arrivehour--;
				}
				if(arrivemin<MIN) 
					MIN=arrivemin;
			}
			System.out.println("Case "+i+": "+MIN);
		}
	}
}
