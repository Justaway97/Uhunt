import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question10177 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = bf.readLine();
			if(input==null || input.isEmpty())
				break;
			double n = Double.parseDouble(input.trim());
			sb.append((long)Math.round(Math.pow(n, 3)/3+Math.pow(n, 2)/2+n/6)).append(" ");
			sb.append((long)Math.round(Math.pow(n, 4)/4 + Math.pow(n, 3)/6 - Math.pow(n, 2)/4 - n/6)).append(" ");
			sb.append((long)Math.round(Math.pow(n, 4)/4 + Math.pow(n, 3)/2 + Math.pow(n, 2)/4)).append(" ");
			sb.append((long)Math.round(Math.pow(n, 6)/8 + 3*Math.pow(n , 5)/8 + Math.pow(n, 4)/8 - 3*Math.pow(n, 3)/8 - Math.pow(n, 2)/4)).append(" ");
			sb.append((long)Math.round(Math.pow(n, 5)/5 + Math.pow(n, 4)/2 + Math.pow(n, 3)/3 -n/30)).append(" ");
			sb.append((long)Math.round(Math.pow(n, 8)/16 + Math.pow(n, 7)/4 + 3*Math.pow(n, 6)/8 + Math.pow(n, 5)/20 - 7*Math.pow(n, 4)/16 - Math.pow(n, 3)/3 + n/30)).append("\n");
		}
		System.out.print(sb);
	}
}
