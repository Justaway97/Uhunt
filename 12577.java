import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question12577 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
	    for(int i=1;;i++) {
			String input = bf.readLine();
			if(input.equals("*"))
				break;
			if(input.equals("Hajj"))
				System.out.println("Case "+i+": Hajj-e-Akbar");
			if(input.equals("Umrah"))
				System.out.println("Case "+i+": Hajj-e-Asghar");
		}

	}

}
