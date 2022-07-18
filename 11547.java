import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question11547 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
	    int cases = Integer.parseInt(bf.readLine());
		for(int i=0;i<cases;i++) {
			int input = Integer.parseInt(bf.readLine());
			String Input = String.valueOf(((input)*567/9+7492)*235/47-498);
			System.out.println(Input.charAt(Input.length()-2));
		}
	}
}
