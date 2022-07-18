package Max_1D_Range_Sum;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question507 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(bf.readLine().trim());
		for(int i=0;i<n;i++) {
			int m = Integer.parseInt(bf.readLine().trim());
			int[] num = new int[m-1];
			for(int j=0;j<m-1;j++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				num[j]=Integer.parseInt(st.nextToken());
			}
			int start = 0,end=-1,max_curr=0,max=0,curr_max_start=0,curr_max_end=-1;
			for(int j=0;j<m-1;j++) {
				if(max_curr+num[j]<0) {
					max_curr=0;
					curr_max_start=j+1;
				}else {
					max_curr+=num[j];
					curr_max_end=j+1;
				}
				if(max_curr>max || (max_curr==max && end-start<curr_max_end-curr_max_start)) {
					max=max_curr;
					start=curr_max_start;
					end=curr_max_end;
				}
			}
			if(max==0)
				sb.append("Route ").append(i+1).append(" has no nice parts\n");
			else
				sb.append("The nicest part of route ").append(i+1).append(" is between stops ").append(start+1).append(" and ").append(end+1).append("\n");
		}
		System.out.print(sb);
	}
}
