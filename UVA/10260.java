import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question10260 {
	public static String[] alphabet = {"AEIOUHWY","BFPV","CGJKQSXZ","DT","L","MN","R"};
	public static String num(char z) {
		for(int i=0;i<alphabet.length;i++) {
			for(int j=0;j<alphabet[i].length();j++) {
				if(alphabet[i].charAt(j)==z)
					return String.valueOf(i);
			}
		}
		return null;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String input = bf.readLine();
			if(input==null)
				break;
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<input.length();i++)
				sb.append(num(input.charAt(i)));
			StringBuilder sb1 = new StringBuilder();
			for(int i=1;i<sb.length();i++) 
				if(sb.charAt(i)!=sb.charAt(i-1) && sb.charAt(i-1)!='0')
					sb1.append(sb.charAt(i-1));
			if(sb.charAt(sb.length()-1)!='0')
				sb1.append(sb.charAt(sb.length()-1));
			if(sb1.length()==0)
				System.out.println();
			else
				System.out.println(sb1);
		}
	}
}

