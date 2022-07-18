import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Question12555 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		DecimalFormat df = new DecimalFormat("0.00");
		for(int i=0;i<n;i++) {
			String input = bf.readLine();
			String a="",b="";
			double kg=0;
			for(int j=0;j<input.length();j++) {
				if(Character.isDigit(input.charAt(j)))
					a+=input.charAt(j);
				else {
					for(int k=j;k<input.length();k++) 
						if(Character.isDigit(input.charAt(k)))
							b+=input.charAt(k);
					break;
				}
			}
			try {
				kg = Double.parseDouble(a)*0.5+Double.parseDouble(b)*0.05;
			}catch(Exception e) {
				kg = Double.parseDouble(a)*0.5;
			}
			System.out.print("Case "+(i+1)+": ");
			if((int)kg==kg)
				System.out.println((int)kg);
			else if(df.format(kg).charAt(df.format(kg).length()-1)=='0')
				System.out.println(String.valueOf(kg).substring(0, String.valueOf(kg).length()));
			else
				System.out.println(df.format(kg));
		}
	}
}
