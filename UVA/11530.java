import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question11530 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] phone = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		for(int i=1;i<=n;i++) {
			String input = bf.readLine();
			int count=0;
			for(int j=0;j<input.length();j++) {
				boolean flag=true;
				if(input.charAt(j)!=' ')
					for(int k=0;k<phone.length && flag;k++) {
						for(int l=0;l<phone[k].length();l++) {
							if(phone[k].charAt(l)==input.charAt(j)) {
								count+=l+1;
								flag=false;
								break;
							}
						}
					}
				else
					count++;
			}
			System.out.println("Case #"+i+": "+count);
		}
	}
}
