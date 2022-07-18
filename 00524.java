import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Question524 {
	private static boolean[] prime = new boolean[32];
	private static int[] number;
	private static ArrayList<ArrayList<Integer>> ans;
	private static StringBuilder sb = new StringBuilder();
	private static void findPrime() {
		prime[2] = true;
		for(int i=3;i<prime.length;i+=2) {
			boolean flag = true;
			for(int j=3;j<i;j+=2) 
				if(i%j==0) {
					flag=false;
					break;
				}
			prime[i] = flag;
		}
	}
	private static void ring(boolean[] flag,ArrayList<Integer> result) {
		if(result.size()==number.length) {
			if(!prime[result.get(result.size()-1)+1])
				return;
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(result);
			ans.add(temp);
			return;
		}
		for(int i=0;i<number.length;i++) {
			if(flag[i] || (result.get(result.size()-1)+i+1)%2==0 || !prime[result.get(result.size()-1)+i+1])
				continue;
			int remove = result.size();
			result.add(i+1);
			flag[i] = true;
			ring(flag,result);
			result.remove(remove);
			flag[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		findPrime();
		int x=1;
		while(true) {
			String input = bf.readLine();
			if(input==null || input.isEmpty())
				break;
			if(x>1)
				sb.append("\n");
			int n = Integer.parseInt(input);
			number = new int[n];
			for(int i=0;i<n;i++) 
				number[i] = i+1;
			ans = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> result = new ArrayList<Integer>();
			result.add(1);
			boolean[] flag = new boolean[n];
			flag[0] = true;
			sb.append("Case ").append(x).append(":\n");
			ring(flag,result);
			for(int i=0;i<ans.size();i++) {
				sb.append(ans.get(i).get(0));
				for(int j=1;j<ans.get(i).size();j++)
					sb.append(" ").append(ans.get(i).get(j));
				sb.append("\n");
			}
			x++;
		}
		System.out.print(sb);
	}
}
