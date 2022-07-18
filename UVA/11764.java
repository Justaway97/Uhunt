import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question11764 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		int cases = Integer.parseInt(bf.readLine());
		for(int i=0;i<cases;i++) {
			String input = bf.readLine();
			int countup=0;
			int countlow=0;
			input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			int height = Integer.parseInt(st.nextToken());
			int current=height;
			while(st.hasMoreTokens()) {
				height = Integer.parseInt(st.nextToken());
				if(height>current)
					countup++;
				if(current>height)
					countlow++;
				current=height;
			}
			System.out.println("Case "+(i+1)+": "+countup+" "+countlow);
		}

	}

}
