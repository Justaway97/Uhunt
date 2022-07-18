import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question12015 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		int cases = Integer.parseInt(bf.readLine());
		for(int i=0;i<cases;i++) {
			String[] store = new String[10];
			int[] num = new int[10];
			int max=0;
			for(int j=0;j<10;j++) {
				String input = bf.readLine();
				for(int k=0;k<input.length();k++) {
					if(input.charAt(k)==' ') {
						store[j]=input.substring(0,k);
						num[j]=Integer.parseInt(input.substring(k+1,input.length()));
						if(num[j]>max) 
							max=num[j];
					}
				}
			}
			System.out.println("Case #"+(i+1)+":");
			for(int j=0;j<10;j++)
				if(num[j]==max)
					System.out.println(store[j]);
		}
	}
}
