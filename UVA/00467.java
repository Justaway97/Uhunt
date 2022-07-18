import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question467 {
	public static boolean answer(int[] num,int time) {
		for(int i=0;i<num.length;i++) 
			if(time%(num[i]*2)>=num[i]-5)
				return false;
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int x=1;
		while(true) {
			String s = bf.readLine();
			if(s==null)
				break;
			StringTokenizer st = new StringTokenizer(s," ");
			int[] n = new int[st.countTokens()];
			int min=Integer.MAX_VALUE,count=0;
			while(st.hasMoreTokens()) {
				int light = Integer.parseInt(st.nextToken());
				if(light<min)
					min=light;
				n[count]=light;
				count++;
			}
			int timer = min*2;
			while(!answer(n,timer) && timer<=3600)
				++timer;
			if(timer<=3600)
				System.out.println("Set "+x+" synchs again at "+timer/60+" minute(s) and "+timer%60+" second(s) after all turning green.");
			else
				System.out.println("Set "+x+" is unable to synch after one hour.");
			x++;
		}
	}
}
