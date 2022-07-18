import java.text.DecimalFormat;
import java.util.Scanner;

public class Question11984 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		DecimalFormat df = new DecimalFormat("0.00");
		for(int i=0;i<n;i++) {
			double d = sc.nextDouble();
			double f = sc.nextDouble();
			d += f*5/9;
			System.out.println("Case "+(i+1)+": "+df.format(d));
		}
	}
}
