import java.util.ArrayList;
import java.util.Scanner;

public class Question11850 {
	public static ArrayList<Integer> add(ArrayList<Integer> road,int dist) {
		for(int i=0;i<road.size();i++)
			if(dist<=road.get(i)) {
				road.add(i,dist);
				return road;
			}
		return null;
	}
	public static boolean check(ArrayList<Integer>road) {
		for(int i=0;i<road.size()-1;i++)
			if(road.get(i+1)-road.get(i)>200)
				return false;
		if(road.get(road.size()-1)-road.get(road.size()-2)>100)
			return false;
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = sc.nextInt();
			if(n==0)
				break;
			ArrayList<Integer> road = new ArrayList<Integer>();
			road.add(1422);
			for(int i=0;i<n;i++)
				add(road,sc.nextInt());
			if(check(road))
				sb.append("POSSIBLE\n");
			else
				sb.append("IMPOSSIBLE\n");
		}
		System.out.print(sb);
	}
}
