import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question11586 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		int cases = Integer.parseInt(bf.readLine());
		for(int i=0;i<cases;i++) {
			String input = bf.readLine();
			String test="";
			StringTokenizer st = new StringTokenizer(input," ");
			for(;st.hasMoreTokens();) {
				test += st.nextToken();
			}
			int count=0;
			for(int j=0;j<test.length();j++) {
				if(test.charAt(j)=='F')
					count++;
				else if(test.charAt(j)=='M')
					count--;
			}
			if(count==0 && test.length()!=2)
				System.out.println("LOOP");
			else
				System.out.println("NO LOOP");
		}
	}
}
