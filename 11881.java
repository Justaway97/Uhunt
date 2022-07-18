import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Question11881 {
	private static double[] num;
	private static double f(double x) {
		double result=0;
		for(int i=1;i<num.length;i++)
			result+=(num[i]/Math.pow(1+x,i));
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		DecimalFormat df = new DecimalFormat("0.00");
		while(true) {
			int input = Integer.parseInt(bf.readLine().trim());
			if(input==0)
				break;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			num = new double[st.countTokens()];
			for(int i=0;i<num.length;i++) 
				num[i] = Double.parseDouble(st.nextToken());
			double min=-0.99,max=10000.0,mid=0.0;
			int count=0;
			while(min<=max && count++<=100) {
				mid = (max+min)/2;
				double f = f(mid);
				if(f>Math.abs(num[0]))
					min=mid;
				else 
					max=mid;
			}
			sb.append(df.format(mid)).append("\n");
		}
		System.out.print(sb);
	}
}
