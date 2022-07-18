import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question161 {
	public static DecimalFormat df = new DecimalFormat("00");
	public static String format(int time) {
		int hour = time/60/60;
		int min = time/60 - hour*60;
		int second = time - min*60 - hour*60*60;
		return df.format(hour)+":"+df.format(min)+":"+df.format(second);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> pick = new ArrayList<Integer>();
		int min=Integer.MAX_VALUE;
		boolean token = true;
		StringTokenizer st = new StringTokenizer("LOL","O");
		String input = "";
		while(true) {
			boolean flag=false;
			if(!st.hasMoreTokens()) {
				input = bf.readLine();
				token=true;
			}
			if(input.equals("0 0 0"))
				break;
			if(token) {
				st = new StringTokenizer(input," ");
				token=false;
			}
			while (st.hasMoreTokens()){
				int p = Integer.parseInt(st.nextToken());
				if(p==0) {
					flag=true;
					break;
				}
				pick.add(p);
				if(p<min) 
					min=p;
			}
			if(flag) {
				boolean[][] light = new boolean[pick.size()][5*60*60+1];
				for(int k=0;k<light.length;k++)
					for(int i=0;i<light[k].length;i+=pick.get(k)*2) 
						for(int j=i;j<i+pick.get(k)-5 && j<light[k].length;j++) 
							light[k][j]=true;
				for(int i=min;i<=5*3600;i++) {
					boolean f=true;
					for(int j=0;j<light.length;j++) 
						if(!light[j][i]) 
							f=false;
					if(f) 
						System.out.println(format(i));
					else if(i==5*3600)
						System.out.println("Signals fail to synchronise in 5 hours");
					if(f || i==5*3600) {
						pick.clear();
						min=Integer.MAX_VALUE;
						break;
					}
				}
			}
		}
	}	
}

