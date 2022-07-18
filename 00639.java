import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question639 {
	public static void findMax(int[][] ori,int i,int j,int[] tempcount,int curr) {
		if(i>=ori.length || j>=ori.length || ori[i][j]==-1 || ori[i][j]==1)
			return;
		curr++;
		tempcount[0] = Math.max(tempcount[0], curr);
		int[][] temp = new int[ori.length][ori.length];
		for(int k=0;k<ori.length;k++)
			temp[k] = Arrays.copyOf(ori[k],ori.length);
		for(int k=i;k<temp.length;k++)
			if(temp[k][j]!=-1)
				temp[k][j]=1;
			else break;
		for(int k=i-1;k>=0;k--)
			if(temp[k][j]!=-1)
				temp[k][j]=1;
			else break;
		for(int k=j;k<temp.length;k++)
			if(temp[i][k]!=-1)
				temp[i][k]=1;
			else break;
		for(int k=j-1;k>=0;k--)
			if(temp[i][k]!=-1)
				temp[i][k]=1;
			else break;
		for(int k=i;k<temp.length;k++)
			for(int l=0;l<temp.length;l++)
				findMax(temp,k,l,tempcount,curr);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = Integer.parseInt(bf.readLine().trim());
			if(n==0)
				break;
			int[][] mark = new int[n][n];
			for(int i=0;i<n;i++) {
				char[] s = bf.readLine().toCharArray();
				for(int j=0;j<n;j++) 
					if(s[j]=='X') 
						mark[i][j]=-1;
			}
			int max=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					int[] count = new int[1];
					if(mark[i][j]==-1)
						continue;
					int[][] temp = new int[n][n];
					for(int k=0;k<n;k++)
						temp[k] = Arrays.copyOf(mark[k],n);
					findMax(temp,i,j,count,0);
					max = Math.max(max, count[0]);
				}
			}
			sb.append(max).append("\n");
		}
		System.out.print(sb);
	}
}
