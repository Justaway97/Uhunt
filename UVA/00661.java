import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question661 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		for(int a=1;;a++) {
			String input = bf.readLine();
			if(input.equals("0 0 0"))
				break;
			StringTokenizer st = new StringTokenizer(input," ");
			int cases = Integer.parseInt(st.nextToken());
			int operation = Integer.parseInt(st.nextToken());
			int fuse = Integer.parseInt(st.nextToken());
			int[] ampere = new int[cases];
			for(int i=0;i<cases;i++) 
				ampere[i]=Integer.parseInt(bf.readLine());
			int[] count = new int[cases];
			int result = 0;
			int max=0;
			boolean flag=true;
			for(int i=0;i<operation;i++) {
				int toggle = Integer.parseInt(bf.readLine());
				count[toggle-1]++;
				if(count[toggle-1]%2!=0)
					result+=ampere[toggle-1];
				if(count[toggle-1]%2==0)
					result-=ampere[toggle-1];
				if(result>max)
					max=result;
				if(result>fuse)
					flag=false;
				if(i==operation-1) {
					if(flag) {
						System.out.println("Sequence "+a);
						System.out.println("Fuse was not blown.");
						System.out.println("Maximal power consumption was "+max+" amperes.");
						System.out.println();
					}else {
						System.out.println("Sequence "+a);
						System.out.println("Fuse was blown.");
						System.out.println();
					}
				}
			}
		}
	}
}