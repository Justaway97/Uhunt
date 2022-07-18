import java.util.Scanner;

public class Question541 {
	public static String result(int[] row,int[] col) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<row.length;i++)
			if(row[i]%2!=0)
				sb.append(String.valueOf(i+1)+",");
		for(int i=0;i<col.length;i++)
			if(col[i]%2!=0)
				sb.append(String.valueOf(i+1));
		if(sb.length()==0)
			return "OK";
		else if(sb.length()==3)
			return "Change bit ("+sb+")";
		else
			return "Corrupt";
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = sc.nextInt();
			if(n==0)
				break;
			int[] row = new int[n];
			int[] col = new int[n];
			for(int i=0;i<n;i++) 
				for(int j=0;j<n;j++) {
					int num = sc.nextInt();
					if(num==1) {
						row[i]++;
						col[j]++;
					}
				}
			sb.append(result(row,col)+"\n");
		}
		System.out.print(sb);
	}
}
