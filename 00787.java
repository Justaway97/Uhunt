package Max_1D_Range_Sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Question787 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = bf.readLine();
			if(input==null || input.isEmpty())
				break;
			StringTokenizer st = new StringTokenizer(input);
			BigInteger currMax= new BigInteger(st.nextToken()),currMin = currMax,product = currMin; 
			while(st.countTokens()!=1) {
				BigInteger num = new BigInteger(st.nextToken());
				BigInteger nextMax = currMax.multiply(num).max(currMin.multiply(num)).max(num);
				BigInteger nextMin = currMax.multiply(num).min(currMin.multiply(num)).min(num);
				currMax = nextMax;
				currMin = nextMin;
				product = currMax.max(product);
			}
			sb.append(product).append("\n");
		}
		System.out.print(sb);
	}
}
