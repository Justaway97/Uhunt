import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question621 {

	public static String character(String arg) {
		if(arg.equals("1") || arg.equals("4") || arg.equals("78"))
			return "+";
		if(arg.substring(arg.length()-2, arg.length()).equals("35"))
			return "-";
		if(arg.charAt(0)=='9' && arg.charAt(arg.length()-1)=='4')
			return "*";
		else
			return"?";
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		int cases = Integer.parseInt(bf.readLine());
		for(int i=0;i<cases;i++) {
			String input = bf.readLine();
			System.out.println(character(input));
		}

	}

}
