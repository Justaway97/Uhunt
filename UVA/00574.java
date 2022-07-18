import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question574 {
	private static int[] number;
	private static int sum;
	private static ArrayList<ArrayList<Integer>> ans;
	private static StringBuilder sb = new StringBuilder();
	private static boolean flag;
	private static void sum(ArrayList<Integer> result,int start,int curr) {
		if(curr>=sum || start==number.length) {
			if(curr==sum) {
				flag = true;
				if(!ans.contains(result)) {
					for(int i=0;i<result.size();i++) {
						if(i>0 && i<=result.size()-1)
							sb.append("+");
						sb.append(result.get(i));
					}
					sb.append("\n");
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.addAll(result);
					ans.add(temp);
				}
			}else return;
		}
		for(int i=start;i<number.length;i++) {
			curr+=number[i];
			int remove = result.size();
			result.add(number[i]);
			sum(result,i+1,curr);
			curr-=number[i];
			result.remove(remove);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			sum = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(sum==0 && m==0)
				break;
			flag=false;
			sb.append("Sums of ").append(sum).append(":\n");
			ans = new ArrayList<ArrayList<Integer>>();
			number = new int[m];
			for(int i=0;i<m;i++)
				number[i] = Integer.parseInt(st.nextToken());
			sum(new ArrayList<Integer>(),0,0);
			if(!flag)
				sb.append("NONE\n");
		}
		System.out.print(sb);
	}
}
