import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question12195 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] letter = {'W','H','Q','E','S','T','X'};
		double[] num = {1,0.5,0.25,0.125,0.0625,0.03125,0.015625};
		while(true) {
			String input = bf.readLine();
			if(input.equals("*"))
				break;
			int count=0;
			StringTokenizer st = new StringTokenizer(input,"/");
			while(st.hasMoreTokens()) {
				double curr=0;
				String element = st.nextToken();
				for(int i=0;i<element.length();i++) {
					for(int j=0;j<letter.length;j++) {
						if(element.charAt(i)==letter[j]) 
							curr+=num[j];
					}
				}
				if(curr==1)
					count++;
			}
			System.out.println(count);
		}
	}
}
