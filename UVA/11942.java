import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question11942 {

	public static boolean Lumberjacks(String input) {
		StringTokenizer st = new StringTokenizer(input," ");
		int[] num = new int[10];
		for(int i=0;st.hasMoreTokens();i++) {
			int x = Integer.parseInt(st.nextToken());
			num[i]=x;
		}
		int countInc=0;
		int countDec=0;
		for(int i=0;i<num.length-1;i++) {
			if(num[i]-num[i+1]>0)
				countInc++;
			if(num[i]-num[i+1]<0)
				countDec++;
			if(countDec==9 || countInc==9)
				return true;
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		int cases = Integer.parseInt(bf.readLine());
		System.out.println("Lumberjacks:");
		for(int i=0;i<cases;i++) {
			String input = bf.readLine();
			if(Lumberjacks(input))
				System.out.println("Ordered");
			else
				System.out.println("Unordered");
			}
		}
	}

