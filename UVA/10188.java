import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question10188 {
	private static int x;
	private static String find(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s.length();i++) {
			try{
				if(Character.isDigit(s.charAt(i)))
					sb.append(s.charAt(i));
			}catch(Exception e) {}
		}
		return sb.toString();
	}
	private static void check(String longer,String shorter) {
		String temp1 = find(longer);
		String temp2 = find(shorter);
		if(temp1.length()!=temp2.length()) {
			x=3;
			return;
		}
		for(int i=0;i<temp1.length();i++) 
			if(temp1.charAt(i)!=temp2.charAt(i)) {
				x=3;
				return;
			}
		x=Math.max(2, x);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int index=1;
		while(true) {
			x = 0;
			int n = Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			StringBuilder temp1 = new StringBuilder();
			for(int i=0;i<n;i++)
				temp1.append(bf.readLine());
			int m = Integer.parseInt(bf.readLine());
			StringBuilder temp2 = new StringBuilder();
			for(int i=0;i<m;i++)
				temp2.append(bf.readLine());
			String s1 = temp1.toString();
			String s2 = temp2.toString();
			if(n!=m)
				x=2;
			if(s1.equals(s2)) {
				x=Math.max(x, 1);
			}else if(s1.length()>s2.length() && x!=3)
				check(s1,s2);
			else
				check(s1,s2);
			sb.append("Run #").append(index++);
			if(x==1)
				sb.append(": Accepted\n");
			else if(x==3)
				sb.append(": Wrong Answer\n");
			else if(x==2)
				sb.append(": Presentation Error\n");
		}
		System.out.print(sb);
	}
}
