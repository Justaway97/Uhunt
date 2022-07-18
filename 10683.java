import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Question10683 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat("0000000");
		while(true) {
			String input = bf.readLine();
			try {
				if(Integer.parseInt(input.substring(0,2))>=0 && Integer.parseInt(input.substring(0,2))<=23 && Integer.parseInt(input.substring(2,4))>=0 && Integer.parseInt(input.substring(2,4))<=59 && Integer.parseInt(input.substring(4,6))>=0 && Integer.parseInt(input.substring(4,6))<=59 && Integer.parseInt(input.substring(6,8))>=0 && Integer.parseInt(input.substring(6,8))<=99) {
					long time = Long.parseLong(input.substring(0,2))*60*60*100;
					time += Long.parseLong(input.substring(2,4))*60*100;
					time += Long.parseLong(input.substring(4,6))*100;
					time += Long.parseLong(input.substring(6,8));
					System.out.println(df.format(time*10000000/8640000));
				}
			}catch(Exception e) {break;}
		}
	}
}
