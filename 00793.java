import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Question793 {
	public static void found(HashMap<Integer,String> map,int left,int right,boolean[] found,ArrayList<Integer> correct) {
		if(left==right) {
			found[left]=true;
			correct.add(left);
			return;
		}
		found[left]=true;
		String find = map.getOrDefault(left, "");
		if(find.equals(""))
			return;
		StringTokenizer st = new StringTokenizer(find,",");
		while(st.hasMoreTokens()) {
			int link = Integer.parseInt(st.nextToken());
			if(link<found.length && !found[link])
				found(map,link,right,found,correct);
		}
	}
	public static void mapping(HashMap<Integer,String> map,int first,int second) {
		StringBuilder sb1 = new StringBuilder();
		sb1.append(map.getOrDefault(first, "")).append(",").append(second);
		map.put(first,sb1.toString());
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		StringBuilder sb = new StringBuilder();
		bf.readLine();
		for(int i=0;i<n;i++) {
			int size = Integer.parseInt(bf.readLine().trim());
			HashMap<Integer,String> map = new HashMap<Integer,String>();
			int success=0,unsuccess=0;
			while(true) {
				String input = bf.readLine();
				if(input==null || input.isEmpty())
					break;
				StringTokenizer st = new StringTokenizer(input," ");
				if(st.nextToken().equals("c")) {
					int first = Integer.parseInt(st.nextToken());
					int second = Integer.parseInt(st.nextToken());
					mapping(map,first,second);
					mapping(map,second,first);
				}else {
					int left = Integer.parseInt(st.nextToken());
					int right = Integer.parseInt(st.nextToken());
					ArrayList<Integer> correct = new ArrayList<Integer>();
					found(map,left,right,new boolean[size+1],correct);
					if(correct.size()>0)	
						success++;
					else	
						unsuccess++;
				}
			}
			sb.append(success).append(",").append(unsuccess).append("\n");
			if(i!=n-1)
				sb.append("\n");
		}
		System.out.print(sb);
	}
}