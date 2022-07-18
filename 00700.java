import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question700 {
	public static boolean flag(int x,int[][] result) {
		for(int i=0;i<result.length;i++) {
			if(x-result[i][0]==0)
				continue;
			if(x-result[i][0]<0)
				return true;
			if((x-result[i][0])%result[i][1]!=0)
				return true;
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x = 1;
		while(true) {
			int n = Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			int[][] result = new int[n][2];
			int max = Integer.MIN_VALUE,index=-1;
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine()," ");
				result[i][0] = Integer.parseInt(st.nextToken());
				result[i][1] = Math.abs(Integer.parseInt(st.nextToken())-Integer.parseInt(st.nextToken()));
				if(result[i][1]>max) {
					max = result[i][1];
					index = i;
				}
			}
			max = result[index][0];
			while(flag(max,result) && max<=10000) 
				max+=result[index][1];
			if(max>=10000)
				sb.append("Case #"+x+":\nUnknown bugs detected.\n\n");
			else
				sb.append("Case #"+x+":\nThe actual year is "+max+".\n\n");
			x++;
		}
		System.out.print(sb);
	}
}
