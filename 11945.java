import java.text.DecimalFormat;
import java.util.Scanner;

public class Question11945 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			double sum=0;
			for(int j=0;j<12;j++) 
				sum+=sc.nextDouble();
			sum/=12;
			double test = sum;
			int count=0;
			while(test>999) {
				test/=1000;
				count++;
			}
			String result = df.format(sum);
			System.out.print(i+" $");
			for(int j=0;j<result.length();j++) {
				if(j%3==1 && count>0) {
					System.out.print(",");
					count--;
				}
				System.out.print(result.charAt(j));
			}
			System.out.println();
		}
	}
}
