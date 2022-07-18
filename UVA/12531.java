import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question12531 {
	static int[] memoization = new int[720];
	public static void setmemo() {
		int countmemo=0;
		for(int hour=0;hour<60;hour++) 
			for(int min=0;min<60;min++) {
				if(min%12==0 && min!=0)
					hour++;
				memoization[countmemo]=minangle(hour,min);
				countmemo++;
			}
	}
	public static int minangle(int hour,int min) {
		if((Math.max(hour,min)-Math.min(hour,min))*6>180)
			return 360-(Math.max(hour,min)-Math.min(hour,min))*6;
		return (Math.max(hour,min)-Math.min(hour,min))*6;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
			int angle = Integer.parseInt(bf.readLine());
			setmemo();
			boolean flag=true;
			for(int j=0;j<memoization.length;j++) {
				if(angle==memoization[j]) {
					System.out.println("Y");
					flag=false;
					break;
				}
			}
			if(flag)
				System.out.println("N");
			}catch(Exception e) {break;}
		}
	}
}
