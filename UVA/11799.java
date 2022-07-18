import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question11799 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		int cases = Integer.parseInt(bf.readLine());
		for(int i=0;i<cases;i++) {
			String input = bf.readLine();
			int max=0;
			StringTokenizer st = new StringTokenizer(input," ");
			while(st.hasMoreTokens()) {
				int x = Integer.parseInt(st.nextToken());
				if(x>max)
					max=x;
			}
			System.out.println("Case "+(i+1)+": "+max);
		}	
	}
}
