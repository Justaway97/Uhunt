import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question12148 {
	public static int[] leap(int year) {
		int[]month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if((year%100!=0 && year%4==0) || year%400==0)
			month[2]++;
		return month;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			int[][] record = new int[n][4];
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				record[i][0] = Integer.parseInt(st.nextToken());
				record[i][1] = Integer.parseInt(st.nextToken());
				record[i][2] = Integer.parseInt(st.nextToken());
				record[i][3] = Integer.parseInt(st.nextToken());
			}
			int total=0,count=0;
			for(int i=0;i<n-1;i++) {
				int[] month1 = leap(record[i][2]);
				int[] month2 = leap(record[i][2]);
				if(record[i+1][2]-record[i][2]==1 && record[i+1][0]==1 && record[i+1][1]==1 && record[i][0]==31 && record[i][1]==12) {
					total+=record[i+1][3]-record[i][3];
					count++;
				}else if(record[i+1][2]==record[i][2]) {
					if(record[i+1][1]-record[i][1]==1 && record[i][0]==month1[record[i][1]] && record[i+1][0]==1) {
						total+=record[i+1][3]-record[i][3];
						count++;
					}
					if(record[i+1][1]==record[i][1] && record[i+1][0]-record[i][0]==1 && record[i+1][0]<=month2[record[i][1]]) {
						total+=record[i+1][3]-record[i][3];
						count++;
					}
				}
			}
			sb.append(count).append(" ").append(total).append("\n");
		}
		System.out.print(sb);
	}
}
