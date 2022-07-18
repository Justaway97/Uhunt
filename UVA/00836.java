import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question836 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(bf.readLine().trim());
		bf.readLine();
		for(int i=0;i<n;i++) {
			if(i>0)
				sb.append("\n");
			int currMax=0,Max=0;
			String m = bf.readLine();
			int length = m.length();
			int[][] matric = new int[length][length];
			for(int j=0;j<matric.length;j++) {
				for(int k=0;k<matric[j].length;k++)
					matric[j][k]=Character.getNumericValue(m.charAt(k));
				m = bf.readLine();
			}
			int[] temp = new int[matric.length];
			for(int k=0;k<matric.length;k++) {
				int min=26,max=0;
				for(int l=0;l<temp.length;l++) {
					if(matric[l][k]!=0) {
						temp[l]+=matric[l][k];
						if(temp[l]<min && temp[l]>0)
							min=temp[l];
						if(temp[l]>max)
							max=temp[l];
					}else
						temp[l]=0;
				}for(int l=min;l<=max;l++) {
					currMax=0;
					for(int o=0;o<temp.length;o++) {
						if(temp[o]>=l)
							currMax+=l;
						else
							currMax=0;
						if(currMax>Max) {
							Max=currMax;
						}
					}
				}
			}
			sb.append(Max).append("\n");
		}
		System.out.print(sb);
	}	
}
