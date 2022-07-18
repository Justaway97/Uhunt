import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question362 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int i=1;;i++) {
			String s="";
			if(i>1)
				System.out.println();
			int size = Integer.parseInt(bf.readLine());
			if(size==0)
				break;
			s+="Output for data set "+i+", "+size+" bytes:\n";
			long compare = 0,remain = 0,interval=0;
			for(int j=1;;j++) {
				long packet = Integer.parseInt(bf.readLine());
				compare+=packet;
				interval+=packet;
				if(j%5==0 && interval==0)
					s+="   Time remaining: stalled\n";
				else if(j%5==0) {
					remain += interval;
					s+="   Time remaining: "+(int)Math.ceil((double)(size-remain)*(double)5/(double)interval)+" seconds\n";
					interval=0;
				}
				if(compare==size) {
					s+="Total time: "+j+" seconds\n";
					System.out.print(s);
					break;
				}
			}
		}
	}
}
