import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Question10341 {
	private static double p,q,r,s,t,u;
	private static double f(double x) {
		return p*Math.exp(-x)+q*Math.sin(x)+r*Math.cos(x)+s*Math.tan(x)+t*x*x+u;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		DecimalFormat df = new DecimalFormat("0.0000");
		while(true) {
			String input = bf.readLine();
			if(input==null || input.isEmpty())
				break;
			StringTokenizer st = new StringTokenizer(input);
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			u = Integer.parseInt(st.nextToken());
			double xMin = 0.0,xMax = 1.0;
			if(f(0)*f(1)>0)
				sb.append("No solution\n");
			else {
				double x =0.0;
				for(int i=0;i<50;i++) {
					x = (xMin+xMax)/2;
					if(f(x)<0)
						xMax=x;
					else if(f(x)>0)
						xMin=x;
				}
				sb.append(df.format(x)).append("\n");
			}
		}
		System.out.print(sb);
	}
}
