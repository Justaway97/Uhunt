import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question573 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		for(;;) {
			String input = bf.readLine();
			if(input.equals("0 0 0 0"))
				break;
			StringTokenizer st = new StringTokenizer(input," ");
			double height = Integer.parseInt(st.nextToken());
			double climb = Integer.parseInt(st.nextToken());
			double fall = Integer.parseInt(st.nextToken());
			double fatigue = Integer.parseInt(st.nextToken());
			double reach=0;
			double decrease = climb*fatigue/100;
			for(int i=1;;i++) {
				reach+=climb;
				climb-=decrease;
				if(climb<0)
					climb=0;
				if(reach>height) {
					System.out.println("success on day "+i);
					break;
				}
				reach-=fall;
				if(reach<0) {
					System.out.println("failure on day "+i);
					break;
				}
			}
		}
	}
}
