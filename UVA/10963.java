import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question10963 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		int cases = Integer.parseInt(bf.readLine());
		for(int i=0;i<cases;i++) {
			String input = bf.readLine();
			int test = Integer.parseInt(bf.readLine());
			int sum=0;
			for(int j=0;j<test;j++) {
				input = bf.readLine();
				StringTokenizer st = new StringTokenizer(input," ");
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				sum+=num1-num2;
			}
			if(sum%test==0)
				System.out.println("yes");
			else
				System.out.println("no");
			if(i<cases-1)
				System.out.println();
		}
	}
}
