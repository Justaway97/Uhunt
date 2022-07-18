import java.util.ArrayList;
import java.util.Scanner;

public class Question11093 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			int N = sc.nextInt();
			ArrayList<Integer> fuel = new ArrayList<Integer>();
			int total=0;
			for(int j=0;j<N;j++) {
				fuel.add(sc.nextInt());
				total+=fuel.get(j);
			}
			int num=0,count=1;
			for(int j=0;j<N;j++) {
				int fuelneeded = sc.nextInt();
				num+=fuel.get(j)-fuelneeded;
				if(num<0) {
					count=j+2;
					num=0;
				}
				total-=fuelneeded;
			}
			if(total<0)
				System.out.println("Case "+i+": Not possible");
			else
				System.out.println("Case "+i+": Possible from station "+count);
		}
	}
}
