import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question11507 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		for(;;) {
			int input = Integer.parseInt(bf.readLine());
			if(input==0)
				break;
			String input1 = bf.readLine();
			StringTokenizer st = new StringTokenizer(input1," ");
			String currentposition = "+x";
			for(int i=0;i<input-1;i++) {
				String position = st.nextToken();
				if(position.equals("+y")) {
					if(currentposition.equals("+x"))
						currentposition="+y";
					else if(currentposition.equals("+y"))
						currentposition="-x";
					else if(currentposition.equals("-y"))
						currentposition="+x";
					else if(currentposition.equals("-x"))
						currentposition="-y";				
					}
				if(position.equals("-y")) {
					if(currentposition.equals("+x"))
						currentposition="-y";
					else if(currentposition.equals("-y"))
						currentposition="-x";
					else if(currentposition.equals("+y"))
						currentposition="+x";
					else if(currentposition.equals("-x"))
						currentposition="+y";
				}
				if(position.equals("-z")) {
					if(currentposition.equals("+x"))
						currentposition="-z";
					else if(currentposition.equals("-z"))
						currentposition="-x";
					else if(currentposition.equals("+z"))
						currentposition="+x";
					else if(currentposition.equals("-x"))
						currentposition="+z";
				}
				if(position.equals("+z")) {
					if(currentposition.equals("+x"))
						currentposition="+z";
					else if(currentposition.equals("+z"))
						currentposition="-x";
					else if(currentposition.equals("-z"))
						currentposition="+x";
					else if(currentposition.equals("-x"))
						currentposition="-z";
				}
			}
			System.out.println(currentposition);
		}
	}
}
