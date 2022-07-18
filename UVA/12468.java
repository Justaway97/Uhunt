import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question12468 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		for(;;) {
			String input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			if(input.equals("-1 -1"))
				break;
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken(" "));
			int result=0;
			if(y>x) {
				if(y-x>50)
					result=100-y+x;
				else if(x-y<50)
					result=y-x;
			}
			if(x>y) {
				if(x-y>50)
					result=100-x+y;
				else if(y-x<50)
					result=x-y;
			}
			System.out.println(result);
		}
	}
}

