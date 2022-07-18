import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question11687 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for(;;) {
			String input = bf.readLine();
			if(input.equals("END"))
				break;
			if(input.equals("1"))
				System.out.println(1);
			else {
				int length=input.length(),i=0;
				for(i=1;;i++) {
					length = input.length();
					input = String.valueOf(length);
					if(length==1 && input.length()==1)
						break;
				}
				System.out.println(i+1);
			}
		}
	}
}