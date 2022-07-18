import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question598 {
	private static ArrayList<String> combine;
	private static StringBuilder sb = new StringBuilder();
	private static void build(int n,int start,ArrayList<String> temp) {
		if(temp.size()==n) {
			sb.append(temp.get(0));
			for(int i=1;i<temp.size();i++)
				sb.append(", ").append(temp.get(i));
			sb.append("\n");
			return;
		}
		for(int i=start;temp.size()+combine.size()-i>=n;i++) {
			int remove = temp.size();
			temp.add(combine.get(i));
			build(n,(i+1),temp);
			temp.remove(remove);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		bf.readLine();
		for(int i=0;i<n;i++) {
			String input = bf.readLine();
			if(i>0 && i<=n-1)
				sb.append("\n");
			int start = 1,end = 0;
			boolean flag = false;
			if(input.equals("*"))
				flag = true;
			StringTokenizer st = new StringTokenizer(input);
			if(st.countTokens()==1 && !input.equals("*")) 
				start = end = Integer.parseInt(st.nextToken());
			else if(!input.equals("*")){
				start = Integer.parseInt(st.nextToken());
				end = Integer.parseInt(st.nextToken());
			}
			combine = new ArrayList<String>();
			while(true) {
				String s = bf.readLine();
				if(s==null || s.equals(""))
					break;
				combine.add(s);
				if(flag)
					end++;
			}
			for(int j=start;j<=end;j++) {
				sb.append("Size ").append(j).append("\n");
				build(j,0,new ArrayList<String>());
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}
