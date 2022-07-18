import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question10978 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int n = Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			String[] card = new String[n];
			int curr = 0;
			for(int i=0;i<n;i++) {
				String s = bf.readLine();
				int count = s.length()-3;
				for(int j=curr;;j++) {
					if(j==n)
						j=0;
					if(card[j]==null) {
						count--;
					}if(count==0) {
						card[j] = s.substring(0, 2);
						curr=j;
						break;
					}
				}
			}
			for(int i=0;i<card.length;i++) {
				if(i==card.length-1)
					System.out.println(card[i]);
				else
					System.out.print(card[i]+" ");
			}
		}
	}
}
