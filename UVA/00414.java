import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question414 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int n = Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			int max=0;
			int[] num = new int[n];
			for(int i=0;i<n;i++) {
				String input = bf.readLine();
				int count=0;
				for(int j=0;j<input.length();j++) 
					if(input.charAt(j)=='X')
						count++;
				if(count>max)
					max=count;
				num[i]=count;
			}
			int result=0;
			for(int i=0;i<num.length;i++)
				result+=max-num[i];
			System.out.println(result);
		}
	}

}
