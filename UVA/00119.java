import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question119 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		for(int z=1;;z++) {
			String input1 = bf.readLine();
			if(input1==null)
				break;
			if(z>1 && input1!=null)
				System.out.println();
			int cases = Integer.parseInt(input1);
			String[] store = new String[cases];
			int[] money = new int[cases];
			String input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			for(int i=0;st.hasMoreTokens();i++)
				store[i]=st.nextToken();
			for(int i=0;i<cases;i++) {
				String game = bf.readLine();
				StringTokenizer st1 = new StringTokenizer(game," ");
				int player=0;
				String give = st1.nextToken();
				for(int j=0;j<cases;j++) {
					if(give.equals(store[j])) {
						player=j;
						break;
					}
				}
				int minus = Integer.parseInt(st1.nextToken());
				int divide = Integer.parseInt(st1.nextToken());
				if(divide!=0) {
					money[player]-=(minus/divide*divide);
					for(int j=0;j<divide;j++) {
						String receive = st1.nextToken();
						for(int k=0;k<cases;k++) {
							if(receive.equals(store[k])) {
								money[k]+=(minus/divide);
								break;
							}
						}
					}
				}
			}
			for(int i=0;i<cases;i++) { 
				System.out.println(store[i]+" "+money[i]);
			}
		}
	}
}

