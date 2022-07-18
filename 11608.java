import java.util.Scanner;

public class Question11608 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x=1;
		while(true) {
			StringBuilder sb = new StringBuilder();
			sb.append("Case "+x+":\n");
			int[] probcreate = new int[13];
			probcreate[0]=sc.nextInt();
			if(probcreate[0]<0)
				break;
			for(int i=1;i<probcreate.length;i++) 
				probcreate[i] = sc.nextInt();
			int curr=0;
			for(int i=0;i<12;i++) {
				curr+=probcreate[i];
				int need = sc.nextInt();
				if(curr>=need) {
					sb.append("No problem! :D\n");
					curr -= need;
				}else {
					sb.append("No problem. :(\n");
				}
			}
			System.out.print(sb);
			x++;
		}
	}
}
