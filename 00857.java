import java.util.ArrayList;
import java.util.Scanner;

public class Question857 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n==-1) {
				System.out.println("-1");
				break;
			}
			int[][] store = new int[n][5];
			ArrayList<Integer> num = new ArrayList();
			ArrayList<String> check = new ArrayList();
			for(int i=0;i<n;i++) {
				for(int j=0;j<5;j++) {
					store[i][j]=sc.nextInt();
					if(j==4) {
						if(store[i][j]%60>=30) 
							store[i][j]=(store[i][j]/60+1)*60;
						else
							store[i][j]-=store[i][j]%60;
					}
					if(store[i][j]==480) {
						store[i][j]=0;
						store[i][3]++;
						if(store[i][3]==5) {
							store[i][3]=1;
							store[i][2]++;
						}
					}
				}
				if(!check.contains(String.valueOf(store[i][1])+" "+String.valueOf(store[i][2])+" "+String.valueOf(store[i][3])+" "+String.valueOf(store[i][4]))) {
					check.add(String.valueOf(store[i][1])+" "+String.valueOf(store[i][2])+" "+String.valueOf(store[i][3])+" "+String.valueOf(store[i][4]));
					num.add(store[i][0]);
				}else {
					num.remove(check.indexOf(String.valueOf(store[i][1])+" "+String.valueOf(store[i][2])+" "+String.valueOf(store[i][3])+" "+String.valueOf(store[i][4])));
					check.remove(String.valueOf(store[i][1])+" "+String.valueOf(store[i][2])+" "+String.valueOf(store[i][3])+" "+String.valueOf(store[i][4]));				
				}
			}
			System.out.println(check.size());
			for(int i=0;i<check.size();i++) {
				System.out.println(num.get(i)+" "+check.get(i));
			}
		}
	}
}
