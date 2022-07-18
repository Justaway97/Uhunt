import java.util.Scanner;

public class Question11496 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n==0)
				break;
			int[] num = new int[n+2];
			for(int i=0;i<n;i++)
				num[i] = sc.nextInt();
			num[n] = num[0];
			num[n+1] = num[1];
			boolean turn = true;
			if(num[1]<num[0])
				turn = false;
			int result = 0;
			for(int i=1;i<num.length-1;i++) {
				if(num[i]<num[i+1] && !turn) {
					result++;
					turn = true;
				}else if(num[i]>num[i+1] && turn) {
					result++;
					turn = false;
				}
			}
			System.out.println(result);
		}
	}
}
