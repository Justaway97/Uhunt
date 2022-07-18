import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Question10424 {
	static int recurseSum (int i) {
		if (i<10) {
			return i;
		} else {
			int sum=0;
			while (i>0) {
				sum+=i%10;
				i/=10;
			}
			return recurseSum(sum);
		}
	}
	static int number(String n) {
		n=n.toLowerCase();
		int sum=0;
		for (int i=0;i<n.length();i++) 
			if(Character.isLetter(n.charAt(i)))
			sum+=n.charAt(i)-'a'+1;
		return recurseSum(sum);
	}
	public static void main (String [] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));
		String s;
		StringBuilder sb = new StringBuilder();
		DecimalFormat df = new DecimalFormat("0.00");
		while ((s=bf.readLine())!=null) {
			double num1 = number(s);
			double num2 = number(bf.readLine());
			if(num1==0 && num2==0)
				sb.append("\n");
			else {
				double ratio=(Math.min(num1,num2)/Math.max(num1, num2))*100;
				sb.append(df.format(ratio)).append(" ").append("%\n");
			}
		}
		System.out.print(sb);
	}
}