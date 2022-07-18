import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Question10191 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("00");
		int x=0;
		while(sc.hasNext()) {
			x++;
			String cases = sc.nextLine();
			if(cases.equals("") || cases==null)
				break;
			int n = Integer.parseInt(cases);
			String nap= "";
			int longest = 0,curr=0;
			boolean[] time = new boolean[1081];
			for(int i=0;i<n;i++) {
				String s = sc.nextLine();
				StringTokenizer st = new StringTokenizer(s," ");
				StringTokenizer st1 = new StringTokenizer(st.nextToken(),":");
				int hour = Integer.parseInt(st1.nextToken());
				int min = Integer.parseInt(st1.nextToken());
				st1 = new StringTokenizer(st.nextToken(),":");
				int hr = Integer.parseInt(st1.nextToken());
				int m = Integer.parseInt(st1.nextToken());
				for(int j=hour*60+min;j<hr*60+m;j++)
					time[j]=true;
			}
			for(int i=600;i<1080;i++) {
				if(time[i]) 
					curr=0;
				else
					curr++;
				if(curr>longest) {
					longest=curr;
					nap = String.valueOf((i+1-longest)/60)+":"+df.format((i+1-longest)%60);
				}
			}
			if(longest>=60)
				System.out.println("Day #"+x+": the longest nap starts at "+nap+" and will last for "+longest/60+" hours and "+longest%60+" minutes.");
			else
				System.out.println("Day #"+x+": the longest nap starts at "+nap+" and will last for "+longest+" minutes.");
		}
	}
}
