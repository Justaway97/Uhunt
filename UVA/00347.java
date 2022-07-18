import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Question347 {
	public static boolean isRun(int i) {
		String input = String.valueOf(i);
		boolean[] check = new boolean[10];
		for(int z=0,y=0;z<input.length();z++) {
			if(check[Character.getNumericValue(input.charAt(y))])
				return false;
			check[Character.getNumericValue(input.charAt(y))]=true;
			y = (y+Character.getNumericValue(input.charAt(y))%input.length())%input.length();
			if(z==input.length()-1 && y==0)
				return true;
		}
		return false;
	}
	public static int binarySearch(int num,ArrayList<Integer> all,int min,int max) {
		int mid = (min+max)/2;
		int select = all.get(mid);
		if((all.get(mid-1)<num && all.get(mid)>num))
			return select;
		if(all.get(mid)==num)
			return all.get(mid+1);
		if(num>select)
			return binarySearch(num,all,mid,max);
		else
			return binarySearch(num,all,min,mid);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> all = new ArrayList<Integer>();
		for(int i=1;i<10000000;i++)
			if(isRun(i))
				all.add(i);
		StringBuilder sb = new StringBuilder();
		int x=1;
		while(true) {
			int num = Integer.parseInt(bf.readLine().trim());
			if(num==0)
				break;
			sb.append("Case ").append(x).append(": ").append(binarySearch(num,all,0,all.size())).append("\n");
			x++;
		}
		System.out.print(sb);
	}
}
