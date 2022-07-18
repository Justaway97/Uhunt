import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Question628 {
	public static void build(ArrayList<String> tree,int countZero) {
		int size = tree.size();
		for(int i=0;i<size;i++) {
			for(int j=0;j<10;j++) {
				StringBuilder change = new StringBuilder();
				change.append(tree.get(0));
				change.append(j);
				tree.add(change.toString());
			}
			tree.remove(0);
		}
	}
	public static void build(ArrayList<String> tree,String[] s) {
		int size = tree.size();
		for(int i=0;i<size;i++) {
			for(int j=0;j<s.length;j++) {
				StringBuilder change = new StringBuilder();
				change.append(tree.get(0));
				change.append(s[j]);
				tree.add(change.toString());
			}
			tree.remove(0);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = bf.readLine();
			if(input==null || input.isEmpty())
				break;
			int n = Integer.parseInt(input);
			String[] store = new String[n];
			for(int i=0;i<n;i++)
				store[i] = bf.readLine();
			int pattern = Integer.parseInt(bf.readLine());
			ArrayList<String> tree = new ArrayList<String>();
			tree.add("");
			for(int i=0;i<pattern;i++) {
				char[] s = bf.readLine().toCharArray();
				for(int j=0;j<s.length;j++) {
					if(s[j]=='0')
						build(tree,0);
					else
						build(tree,store);
				}
			}
			sb.append("--\n");
			while(!tree.isEmpty())
				sb.append(tree.remove(0)).append("\n");
		}
		System.out.print(sb);
	}
}
