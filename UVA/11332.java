import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question11332 {

	public static int number(String arg) {
			int sum=0;
			for(int i=0;i<arg.length();i++)
				sum+=Character.getNumericValue(arg.charAt(i));
			if(sum<10)
				return sum;
			else 
				return number(String.valueOf(sum));
		}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		for(;;) {
			String input = bf.readLine();
			if(input.equals("0"))
				break;
			if(input.length()==1)
				System.out.println(input);
			if(input.length()>1) {
				System.out.println(number(input));
			}
		}
	}
}
