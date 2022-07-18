import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Question435 {
	public static void incIndex(boolean[] temp,int[] index) {
		for(int i=0;i<index.length;i++)
			if(temp[i])
				index[i]++;
			else
				index[i]--;
	}
	public static void find(int[] value,int size,int majority,boolean[] prev,int start,int total,int[] index) {
		if(start==value.length)
			return;
		boolean[] temp = Arrays.copyOf(prev, size);
		temp[start] = true;
		total+=value[start];
		if(total>=majority) 
			incIndex(temp,index);
		for(int i=start+1;i<value.length;i++)
			find(value,size,majority,temp,i,total,index);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int m = Integer.parseInt(st.nextToken());
			int[] value = new int[m],p = new int[m];
			int majority = 0;
			for(int j=0;j<m;j++) {
				value[j]=Integer.parseInt(st.nextToken());
				p[j]=j;
				majority+=value[j];
			}
			majority = majority/2+1;
			int[] index = new int[value.length];
			for(int j=0;j<value.length;j++)
				find(value,value.length,majority,new boolean[value.length],j,0,index);
			for(int j=0;j<index.length;j++)
				sb.append("party "+(j+1)+" has power index "+index[j]).append("\n");
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
