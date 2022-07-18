import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question482 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++) {
			bf.readLine();
			String line1 = bf.readLine();
			String line2 = bf.readLine();
			StringTokenizer st = new StringTokenizer(line1," ");
			String[] arr = new String[st.countTokens()+1];
			StringTokenizer st1 = new StringTokenizer(line2," ");
			for(int j=1;j<arr.length;j++) 
				arr[Integer.parseInt(st.nextToken())] = st1.nextToken();
			for(int j=1;j<arr.length;j++)
				System.out.println(arr[j]);
			if(i<n-1)
				System.out.println();
		}
	}
}
