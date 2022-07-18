import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Question140 {
	public static int getFirst(int[] p) {
		for(int i=p.length-2;i>=0;i--)
			if(p[i]<p[i+1])
				return i;
		return -1;
	}
	public static void swap(int[]p,int index,int last) {
		int temp = p[index];
		p[index] = p[last];
		p[last] = temp;
	}
	public static boolean Next_permutation(int[] p) {
		int index = getFirst(p);
		if(index==-1)
			return false;
		int last = p.length-1;
		while(p[index]>p[last])
			--last;
		swap(p,index++,last);
		last = p.length-1;
		while(index<last) 
			swap(p,index++,last--);
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = bf.readLine();
			if(input.equals("#"))
				break;
			StringTokenizer st = new StringTokenizer(input,";");
			ArrayList<Integer>[] node = new ArrayList[26];
			BitSet valid = new BitSet(26);
			for(int i=0;i<node.length;i++) 
				node[i] = new ArrayList<Integer>();
			while(st.hasMoreTokens()) {
				String s = st.nextToken();
				int index=0;
				while(index<s.length() && !Character.isAlphabetic(s.charAt(index)))
					index++;
				if(index==s.length())
					break;
				int add = s.charAt(index)-'A';
				valid.set(add);
				for(int i=index+1;i<s.length();i++) {
					if(Character.isAlphabetic(s.charAt(i))) {
						node[add].add(s.charAt(i)-'A');
						valid.set(s.charAt(i)-'A');
					}
				}
			}
			int size = valid.cardinality();
			int[] p = new int[size];
			for(int i=0,j=0;i<26;++i)
				if(valid.get(i))
					p[j++] = i;
			Arrays.sort(p);
			int[] ans = new int[size];
			int cur=size;
			while(true) {
				int[] position = new int[26];
				for(int i=0;i<size;i++) 
					position[p[i]]=i;
				int min=0;
				for(int i=0;i<26;i++) 
					for(int j=0;j<node[i].size();j++) 
						min = Math.max(min, Math.abs(position[i]-position[node[i].get(j)]));
				if(min<cur) {
					cur=min;
					ans = Arrays.copyOf(p, size);
				}
				if(!Next_permutation(p))
					break;
			}
			for(int i=0;i<p.length;i++) 
				sb.append((char)(ans[i]+'A')).append(" ");
			sb.append("-> ").append(cur).append("\n");
		}
		System.out.print(sb);
	}
}
