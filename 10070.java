import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Question10070 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for(int i=1;;i++) {
			try {
				BigInteger b = new BigInteger(bf.readLine());
				if(i>1)
					System.out.println();
				BigInteger four = new BigInteger("4");
				BigInteger fifteen = new BigInteger("15");
				BigInteger fiftyfive = new BigInteger("55");
				BigInteger onehundred = new BigInteger("100");
				BigInteger fourhundred = new BigInteger("400");
				BigInteger zero = new BigInteger("0");
				boolean flag=true;
				if(b.mod(fourhundred).equals(zero) || (b.mod(four).equals(zero) && !b.mod(onehundred).equals(zero))) {
					System.out.println("This is leap year.");
					flag=false;
				}if(b.mod(fifteen).equals(zero)) {
					System.out.println("This is huluculu festival year.");
					flag=false;
				}if((b.mod(fourhundred).equals(zero) || (b.mod(four).equals(zero) && !b.mod(onehundred).equals(zero))) && b.mod(fiftyfive).equals(zero)) {
					System.out.println("This is bulukulu festival year.");
					flag=false;
				}if(flag)
					System.out.println("This is an ordinary year.");
			}catch(Exception e) {break;}
		}
	}
}
