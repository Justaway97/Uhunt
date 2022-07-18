import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Question10114 {
	public static String result(int record,double owe,double monthlyPay,double carValue,double[] rate,int[] month) {
		int k=0;
		int i=0;
		for(i=0;;i++) {
			if(i>0)
				owe-=monthlyPay;
			if(k>=record)
				carValue*=(1-rate[rate.length-1]);
			if(k<record) {
				if(i<month[k])
					carValue*=(1-rate[k-1]);
				if(i==month[k]) {
					carValue*=(1-rate[k]);
					k++;
				}
			}
			if(owe<carValue) {
				if(i==1)
					return String.valueOf(i)+" month";
				else
					return String.valueOf(i)+" months";
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		for(;;) {
			String input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			int duration = Integer.parseInt(st.nextToken());
			double downPayment = Double.parseDouble(st.nextToken());
			double owe = Double.parseDouble(st.nextToken());
			int record = Integer.parseInt(st.nextToken());
			if(duration<=0 || downPayment<=0 && owe<=0 && record<=0)
				break;
			double carValue = downPayment+owe;
			double monthlyPay = owe/duration;
			int[] month = new int[record];
			double[] rate = new double[record];
			for(int i=0;i<record;i++) {
				input = bf.readLine();
				st = new StringTokenizer(input," ");
				month[i] = Integer.parseInt(st.nextToken());
				rate[i] = Double.parseDouble(st.nextToken());
			}
			System.out.println(result(record,owe,monthlyPay,carValue,rate,month));
		}
	}
}