import java.util.Scanner;

public class Question12150 {
	public static boolean check(int[] board,int change,int i,int[] start) {
		try {
			if(i+change==0)
				return false;
			if(start[i+change]!=0)
				return false;
			start[i+change] = board[i];
		}catch(Exception e) {return false;}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(true) {
			int size = sc.nextInt();
			if(size==0)
				break;
			int[] board = new int[size+1];
			int[] start = new int[size+1];
			boolean flag=true;
			for(int i=1;i<=size;i++) {
				board[i]=sc.nextInt();
				int change = sc.nextInt();
				if(!check(board,change,i,start) && flag) 
					flag=false;
			}
			if(flag) {
				for(int i=1;i<start.length;i++) {
					if(i!=start.length-1)
						sb.append(String.valueOf(start[i])+" ");
					else
						sb.append(String.valueOf(start[i])+"\n");
				}
			}else
				sb.append("-1\n");
		}
		System.out.print(sb);
	}
}
