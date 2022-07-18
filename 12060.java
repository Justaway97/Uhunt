import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question12060 {
	private static int gcd(int a,int b,int k) {
		if(a==0)
			return (int)Math.pow(2, k)*b;
		else if(a%2==0 && b%2==0) 
			return gcd(a/2,b/2,++k);
		else if(a%2==0)
			return gcd(a/2,b,k);
		else if(b%2==0)
			return gcd(a,b/2,k);
		else if(a>=b)
			return gcd((a-b)/2,b,k);
		else if(a<b)
			return gcd(a,(b-a)/2,k);
		return 1;
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x=1;
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n==0)
				break;
			sb.append("Case ").append(x).append(":\n");
			int total = 0;
			for(int i=0;i<n;i++)
				total+=Integer.parseInt(st.nextToken());
			int b = Math.abs(total)%n;
			int avg = total/n;
			int divide = 1;
			if(b!=0)
				divide = gcd(n,b,0);
			n/=divide;
			b/=divide;
			x++;
			if(b==0) {
				if(avg<0)
					sb.append("- ");
				sb.append(Math.abs(avg)).append("\n");
			}else {
				if(total<0)
					sb.append("  ");
				int y=0;
				if(avg==0)
					y++;
				for(;y<String.valueOf(n).length()-String.valueOf(b).length()+String.valueOf(Math.abs(avg)).length();y++) 
					sb.append(" ");
				sb.append(b).append("\n");
				if(total<0)
					sb.append("- ");
				if(avg!=0)
					sb.append(Math.abs(avg));
				for(int i=0;i<String.valueOf(n).length();i++)
					sb.append("-");
				sb.append("\n");
				if(total<0)
					sb.append("  ");
				y=0;
				if(avg==0)
					y++;
				for(;y<String.valueOf(Math.abs(avg)).length();y++)
					sb.append(" ");
				sb.append(n).append("\n");
			}
		}
		System.out.print(sb);
	}
}
