import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question617 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x=1;
		while(true) {
			String input = bf.readLine();
			while(input.isEmpty() || input.equals(""))
				input = bf.readLine();
			int n = Integer.parseInt(input.trim());
			if(n==-1)
				break;
			sb.append("Case ").append(x).append(": ");
			double[][] num = new double[n][3]; 
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				num[i][0] = Double.parseDouble(st.nextToken());
				num[i][1] = Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());
				num[i][2] = Integer.parseInt(st.nextToken());
			}
			boolean flag=false;
			boolean[] build = new boolean[62];
			StringBuilder sb1 = new StringBuilder();
			for(double j=30;j<=60;j++) {
				for(int k=0;k<num.length;k++) {
					if(((num[k][0]*60*60/j)%(num[k][1]+num[k][2]))>num[k][1]) {
						flag=false;
						break;
					}else 
						flag=true;
				}
				if(flag) 
					build[(int) j]=true;
			}
			for(int j=30;j<=60;j++) {
				if(build[j] && !build[j+1])
					sb1.append(j).append(", ");
				else if(!build[j-1] && build[j] && build[j+1])
					sb1.append(j).append("-");
			}
			String remake;
			if(sb1.length()>0)
				remake = sb1.toString().substring(0,sb1.toString().length()-2);
			else if(n==0)
				remake = "30-60";
			else
				remake = "No acceptable speeds.";
			sb.append(remake).append("\n");
			x++;
		}
		System.out.print(sb);
	}
}