import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question12403 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
	    int cases = Integer.parseInt(bf.readLine());
		int sum=0;
		for(int i=0;i<cases;i++) {
			String donate = bf.readLine();
			if(donate.substring(0,6).equals("donate")) {
				sum+=Integer.parseInt(donate.substring(7,donate.length()));
			}
			if(donate.equals("report")) {
				System.out.println(sum);
			}
		}
	}
}
