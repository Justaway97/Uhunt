import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class Question1262 {
	private static ArrayList<ArrayList<Character>> set3 = new ArrayList<ArrayList<Character>>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			int count = Integer.parseInt(bf.readLine().trim());
			ArrayList<HashSet<Character>> set1 = new ArrayList<HashSet<Character>>();
			for(int j=0;j<5;j++)
				set1.add(new HashSet<Character>());
			for(int j=0;j<6;j++) {
				char[] input = bf.readLine().toCharArray();
				for(int k=0;k<input.length;k++)
					set1.get(k).add(input[k]);
			}
			ArrayList<HashSet<Character>> set2 = new ArrayList<HashSet<Character>>();
			for(int j=0;j<5;j++)
				set2.add(new HashSet<Character>());
			for(int j=0;j<6;j++) {
				char[] input = bf.readLine().toCharArray();
				for(int k=0;k<input.length;k++)
					set2.get(k).add(input[k]);
			}
			set3 = new ArrayList<ArrayList<Character>>();
			for(int j=4;j>=0;j--) {
				Iterator<Character> itr = set1.get(4-j).iterator();
				ArrayList<Character> temp = new ArrayList<Character>();
				while(itr.hasNext()) {
					char x = itr.next();
					if(set2.get(4-j).contains(x))
						temp.add(x);
				}
				Collections.sort(temp);
				set3.add(temp);
			}
			int total=1;
			for(int j=0;j<set3.size();j++)
				total*=set3.get(j).size();
			if(count>total) {
				sb.append("NO\n");
				continue;
			}
			char[] temp = new char[5];
			for(int j=set3.size()-1;j>=0;j--) {
				int selected=1;
				boolean flag = true;
				if(count>set3.get(j).size())
					selected = count%set3.get(j).size();
				else {
					selected = count;
					flag = false;
				}
				if(selected==0 && flag)
					selected = set3.get(j).size()-1;
				else if(selected!=0)
					selected--;
				temp[j] = set3.get(j).get(selected);
				count = (int)Math.ceil((double)count/(double)set3.get(j).size());
			}
			for(int j=0;j<temp.length;j++) 
				sb.append(temp[j]);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
