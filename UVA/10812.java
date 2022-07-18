import java.util.Scanner;

public class Question10812 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if((x+y)%2!=0 || (x+y)/2<y)
				System.out.println("impossible");
			else
				System.out.println(((x+y)/2)+" "+((x+y)/2-y));
		}
	}
}
