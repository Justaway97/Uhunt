import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question11172 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
	    int cases = Integer.parseInt(bf.readLine());
		for(int i=0;i<cases;i++) {
			String input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			int number1 = Integer.parseInt(st.nextToken());
			int number2 = Integer.parseInt(st.nextToken());
			if(number1>number2)
				System.out.println(">");
			if(number1==number2)
				System.out.println("=");
			if(number2>number1)
				System.out.println("<");
		}
	}
}
