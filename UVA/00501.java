import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Question501 {
	public static void addQueued (ArrayList<Integer> list, int element) {
		int min=0;
		int max=list.size()-1;
		int mid=0;
		
		if (list.size()==0) 
			list.add(element);
		else if (list.get(0)>=element) 
			list.add(0,element);
		else if (list.get(list.size()-1)<=element) 
			list.add(element);
		else {
			while (min<=max) {
				mid=(min+max)/2;
				int midValue=list.get(mid);
				if (midValue==element) 
					break;
				else if (midValue>element) 
					max=mid-1;
				else 
					min=mid+1;
			}
			if (list.get(mid)>=element) 
				list.add(mid,element);
			else 
				list.add(mid+1,element);
		}
	}
	public static void main(String[] args) throws  IOException {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<n;i++) {
			int M=sc.nextInt();
			int N=sc.nextInt();
			int [] add=new int [M];
			for (int j=0;j<M;j++) 
				add[j]=sc.nextInt();
			int [] get=new int [N];
			for (int j=0;j<N;j++) 
				get[j]=sc.nextInt();
			Arrays.sort(get);
			int index=0;
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int j=0;j<add.length;j++) {
				addQueued(list,add[j]);
				while(index<get.length && get[index]==list.size()) {
					sb.append(list.get(index++));
					sb.append("\n");
				}
			}
			if(i!=n-1)
				sb.append("\n");
		}
		System.out.print(sb);
		sc.close();
	}
}