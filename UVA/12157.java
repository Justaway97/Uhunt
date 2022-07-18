import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question12157 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader (System.in));
		int cases = Integer.parseInt(bf.readLine());
		for(int i=0;i<cases;i++) {
			String numofcall = bf.readLine();
			int Mile=0;
			int Juice=0;
			String input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			for(;st.hasMoreTokens();) {
				int duration=Integer.parseInt(st.nextToken());
				if(duration%30!=0)
					Mile+=(((duration/30)+1)*10);
				else if(duration%30==0)
					Mile+=(((duration/30)+1)*10);
				if(duration%60!=0)
					Juice+=(((duration/60)+1)*15);
				else if(duration%60==0)
					Juice+=(((duration/60)+1)*15);
				}
			if(Juice>Mile)
				System.out.println("Case "+(i+1)+": Mile "+Mile);
			else if(Juice<Mile)
				System.out.println("Case "+(i+1)+": Juice "+Juice);
			else if(Juice==Mile)
				System.out.println("Case "+(i+1)+": Mile Juice "+Mile);
		}
	}

}
