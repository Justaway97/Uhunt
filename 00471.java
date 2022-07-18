import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question471 {
	public static boolean check(long j) {
		boolean[] num = new boolean[10];
		while(j>0) {
			if(num[(int)(j%10)])
				return false;
			num[(int)(j%10)]=true;
			j/=10;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			bf.readLine();
			long picked = Long.parseLong(bf.readLine().trim());
			long max =  9876543210L /picked ;
			for(int j=1;j<=max;j++) 
				if(check((long)j) && check(picked*j))
					sb.append(picked*j).append(" / ").append(j).append(" = ").append(picked).append("\n");
			if(i!=n-1)
				sb.append("\n");
		}
		System.out.print(sb);
	}
}
