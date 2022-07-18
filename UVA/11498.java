import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question11498 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
	    for(;;) {
			int cases = Integer.parseInt(bf.readLine());
			if(cases==0)
				break;
			String input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			int start = Integer.parseInt(st.nextToken());
			int start1 = Integer.parseInt(st.nextToken());
			for(int i=0;i<cases;i++) {
				input = bf.readLine();
				st = new StringTokenizer(input," ");
				int test = Integer.parseInt(st.nextToken());
				int test1 = Integer.parseInt(st.nextToken());
				if(start==test || start1==test1)
					System.out.println("divisa");
				if(test>start && test1>start1)
					System.out.println("NE");
				if(test>start && test1<start1)
					System.out.println("SE");
				if(test<start && test1<start1)
					System.out.println("SO");
				if(test<start && test1>start1)
					System.out.println("NO");
			}
		}
	}
}
