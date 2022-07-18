import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question11044 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
	    int cases = Integer.parseInt(bf.readLine());
		for(int i=0;i<cases;i++) {
			String input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			int length = Integer.parseInt(st.nextToken())/3;
			int width = Integer.parseInt(st.nextToken())/3;
			System.out.println(length*width);
		}
	}
}
