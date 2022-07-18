import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question11727 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
	    int cases = Integer.parseInt(bf.readLine());
		for(int i=1;i<=cases;i++) {
			String input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			int three = Integer.parseInt(st.nextToken());
			if(one > two ^ one > three)
				System.out.println("Case "+i+": "+one);
			if(two > one ^ two > three)
				System.out.println("Case "+i+": "+two);
			if(three > one ^ three > two)
				System.out.println("Case "+i+": "+three);
		}
	}
}
