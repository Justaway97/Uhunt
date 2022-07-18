package Max_2D_Range_Sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question108 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = bf.readLine();
			if(input==null || input.isEmpty())
				break;
			int size = Integer.parseInt(input.trim());
			int[][] num = new int[size][size];
			size*=size;
			int index=0;
			while(size>0) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				size-=st.countTokens();
				while(st.hasMoreTokens()) {
					num[index/num.length][index%num.length] = Integer.parseInt(st.nextToken());
					index++;
				}
			}
			int MAX=Integer.MIN_VALUE;
			for(int i=0;i<num[0].length;i++) {
				int[] temp = new int[num.length];
				for(int j=i;j<num.length;j++) {
					for(int k=0;k<num.length;k++)
						temp[k]+=num[k][j];
					System.out.println(temp[0]+"\t"+temp[1]+"\t"+temp[2]+"\t"+temp[3]);
					int max=Integer.MIN_VALUE,total=0;
					for(int k=0;k<temp.length;k++) {
						if(total+temp[k]<0 || total<0)
							total=temp[k];
						else if(total>=0)
							total+=temp[k];
						if(total>max)
							max=total;
					}
					if(max>MAX)
						MAX=max;
				}
			}
			sb.append(MAX).append("\n");
		}
		System.out.print(sb);
	}
}
