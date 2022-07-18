import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question11559 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		for(;;) {
			int min=Integer.MAX_VALUE;
			String input = bf.readLine();
			if(input==null)
				break;
			StringTokenizer st = new StringTokenizer(input," ");
			int participant = Integer.parseInt(st.nextToken());
			int budget = Integer.parseInt(st.nextToken());
			int hotel = Integer.parseInt(st.nextToken());
			int week = Integer.parseInt(st.nextToken());
			for(int i=0;i<hotel;i++) {
				int singlecost = Integer.parseInt(bf.readLine());
				input = bf.readLine();
				st = new StringTokenizer(input," ");
				for(int j=0;j<week;j++) {
					int bednumber = Integer.parseInt(st.nextToken());
					if(bednumber>=participant && min>=participant*singlecost && budget>participant*singlecost)
						min=participant*singlecost;
				}
			}
			if(min<Integer.MAX_VALUE)
				System.out.println(min);
			else
				System.out.println("stay home");
		}
	}
}
