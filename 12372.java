import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question12372 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
	    int cases = Integer.parseInt(bf.readLine());
		for(int i=1;i<=cases;i++) {
			String input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			int length = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			if(length>20 || width>20 || height>20)
				System.out.println("Case "+i+": bad");
			else
				System.out.println("Case "+i+": good");
		}

	}

}
