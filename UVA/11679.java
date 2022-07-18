import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question11679 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		for(;;) {
			String input = bf.readLine();
			if(input.equals("0 0"))
				break;
			StringTokenizer st = new StringTokenizer(input," ");
			int numofbank = Integer.parseInt(st.nextToken());
			int numofdebenture = Integer.parseInt(st.nextToken());
			int[] check = new int[numofbank];
			input = bf.readLine();
			st = new StringTokenizer(input," ");
			for(int i=0;i<numofbank;i++)
				check[i]= Integer.parseInt(st.nextToken());
			for(int i=0;i<numofdebenture;i++) {
				input = bf.readLine();
				st = new StringTokenizer(input," ");
				int debtor = Integer.parseInt(st.nextToken());
				int creditor = Integer.parseInt(st.nextToken());
				int debenturevalue = Integer.parseInt(st.nextToken());
				check[debtor-1]-=debenturevalue;
				check[creditor-1]+=debenturevalue;
			}
			int count=0;
			for(int i=0;i<check.length;i++) {
				if(check[i]<0) {
					System.out.println("N");
					break;
				}
				if(i==check.length-1)
					System.out.println("S");
			}
		}

	}

}
