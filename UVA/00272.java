import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Question272 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		int count=0;
		while(true) {
			String input=bf.readLine();
			if(input==null)
				break;
			for(int i=0;i<input.length();i++) {
				if(input.charAt(i)=='"') {
					count++;
					if(count%2!=0)
						System.out.print("``");
					else
						System.out.print("''");
				}
				else
					System.out.print(input.charAt(i));
			}
			System.out.println();
		}
	}
}