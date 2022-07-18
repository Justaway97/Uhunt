import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Question10567 {
	private static int BS(ArrayList<Integer> x,int lower) {
		int ans = -1,end = x.size()-1,start = 0;
		while(start<=end) {
			int mid = (end-start)/2+start;
			if(x.get(mid)>lower) {
				ans = x.get(mid);
				end = mid - 1;
			}else
				start = mid + 1;
		}
		return ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] input = bf.readLine().trim().toCharArray();
		int n = Integer.parseInt(bf.readLine().trim());
		ArrayList<Integer>[] word = new ArrayList[58];
		for(int i=0;i<word.length;i++)
			word[i] = new ArrayList<Integer>();
		for(int i=0;i<input.length;i++) 
			word[input[i]-'A'].add(i);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			char[] s = bf.readLine().trim().toCharArray();
			int start = word[s[0]-'A'].get(0);
			int mid=start;
			boolean flag = true;
			for(int j=1;j<s.length && flag;j++) {
				int selected = BS(word[s[j]-'A'],mid);
				if(selected==-1)
					flag=false;
				mid=selected;
			}
			if(flag)
				sb.append("Matched ").append(start).append(" ").append(mid).append("\n");
			else
				sb.append("Not matched\n");
		}
		System.out.print(sb);
	}
}