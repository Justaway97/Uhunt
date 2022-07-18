import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question12289 {

	public static boolean tow(String input) {
		int count=0;
		if(input.charAt(0)=='t')
			count++;
		if(input.charAt(1)=='w')
			count++;
		if(input.charAt(2)=='o')
			count++;
		if(count>=2)
			return true;
		return false;
	}
	
	public static boolean one(String input) {
		int count=0;
		if(input.charAt(0)=='o')
			count++;
		if(input.charAt(1)=='n')
			count++;
		if(input.charAt(2)=='e')
			count++;
		if(count>=2)
			return true;
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
	    int cases = Integer.parseInt(bf.readLine());
		for(int i=0;i<cases;i++) {
			String input = bf.readLine();
			if(input.length()==5)
				System.out.println(3);
			else {
				if(one(input))
					System.out.println(1);
				if(tow(input))
					System.out.println(2);
			}
		}

	}

}
