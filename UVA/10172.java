import java.util.LinkedList;
import java.util.Scanner;

public class Question10172 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			int N = sc.nextInt();
			int S = sc.nextInt();
			int Q = sc.nextInt();
			LinkedList<Integer>[] station = new LinkedList[N+1];
			LinkedList<Integer> cargoStack = new LinkedList<Integer>();
			int count=0,time=0;
			for(int j=0;j<station.length;j++)
				station[j] = new LinkedList<Integer>();
			for(int j=1;j<=N;j++) {
				int Qi = sc.nextInt();
				count+=Qi;
				for(int k=1;k<=Qi;k++) 
					station[j].add(sc.nextInt());
			}
			while(count>0) {
				for(int j=1;j<station.length && count>0;j++) {
					while(station[j].size()<Q && cargoStack.size()>0 && count>0) {
						if(cargoStack.getFirst()==j) {
							cargoStack.removeFirst();
							count--;
						}else 
							station[j].addLast(cargoStack.removeFirst());
						time++;
					}
					while(cargoStack.size()>0 && cargoStack.peekFirst()==j && count>0) {
						cargoStack.removeFirst();
						count--;
						time++;
					}
					while(cargoStack.size()<S && station[j].size()>0 && count>0) {
						cargoStack.addFirst(station[j].removeFirst());
						time++;
					}
					if(count>0)
						time+=2;
				}
			}
			sb.append(String.valueOf(time));
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
