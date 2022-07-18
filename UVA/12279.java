import java.util.Scanner;

public class Question12279 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		for(int i=1;;i++) {
			int cases = sc.nextInt();
			if(cases==0)
				break;
			int count=0;
			for(int j=0;j<cases;j++) {
				int input = sc.nextInt();
				if(input==0)
					count--;
				else
					count++;
			}
			System.out.println("Case "+i+": "+count);
		}
	}
}
