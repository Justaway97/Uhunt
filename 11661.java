import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question11661 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for(;;) {
			int cases = Integer.parseInt(bf.readLine());
			if(cases==0)
				break;
			String input=bf.readLine();
			int countr=-1;
			int countd=-1;
			int min = Integer.MAX_VALUE;
			for(int i=0;i<input.length();i++) {
				if(input.charAt(i)=='R')
					countr=i;
				if(input.charAt(i)=='D')
					countd=i;
				if(countr!=-1 && countd!=-1) {
					if(countr>countd)
						if(countr-countd<min)
							min=countr-countd;
					if(countd>countr)
						if(countd-countr<min)
							min=countd-countr;
				}
				if(input.charAt(i)=='Z') {
					min=0;
					break;
				}
			}
			System.out.println(min);
		}

	}

}
