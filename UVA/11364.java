import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question11364 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
	    int cases = Integer.parseInt(bf.readLine());
		for(int i=0;i<cases;i++) {
			bf.readLine();
			int max=0,min=Integer.MAX_VALUE;
			String input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			while(st.hasMoreTokens()) {
				int park = Integer.parseInt(st.nextToken());
				if(park>max)
					max=park;
				if(park<min)
					min=park;
			}
			System.out.println((max-min)*2);
		}
	}
}
