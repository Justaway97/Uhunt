import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question11140 {
	private static char[][] form(ArrayList<ArrayList<Character>> put) {
		if(put.size()==0) 
			return new char[][] {{'.'}};
		for(int i=put.size()-1;i>=0;i--) {
			boolean flag=true;
			for(int j=0;j<put.get(i).size();j++)
				if(put.get(i).get(j)=='*')
					flag=false;
			if(flag)
				put.remove(i);
			else
				break;
		}
		for(int i=0;i<put.get(0).size();i++) {
			boolean flag = true;
			for(int j=0;j<put.size();j++)
				if(put.get(j).get(i)!='.')
					flag=false;
			if(flag) {
				for(int j=0;j<put.size();j++)
					put.get(j).remove(i);
				i--;
			}else
				break;
		}
		for(int i=put.get(0).size()-1;i>=0;i--) {
			boolean flag = true;
			for(int j=0;j<put.size();j++)
				if(put.get(j).get(i)!='.')
					flag=false;
			if(flag) {
				for(int j=0;j<put.size();j++)
					put.get(j).remove(i);
			}else
				break;
		}
		char[][] form = new char[put.size()][put.get(0).size()];
		for(int i=0;i<put.size();i++) 
			for(int j=0;j<put.get(i).size();j++)
				form[i][j] = put.get(i).get(j);
		return form;
	}
	private static boolean check(char[][] put,char[][] element) {
		if(put.length>element.length || put[0].length>element[0].length)
			return false;
		for(int i=0;i<=element.length-put.length;i++) {
			for(int j=0;j<=element[0].length-put[0].length;j++) { 
				if(match(i,j,put,element))
					return true;
			}
		}
		return false;
	}
	private static boolean match(int x,int y,char[][] put, char[][] element) {
		for(int i=x,a=0;i<element.length && a<put.length;i++,a++) {
			for(int j=y,b=0;j<element[i].length && b<put[a].length;j++,b++) {
				if(put[a][b]=='*' && element[i][j]=='.')
					return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<cases;i++) {
			String s = bf.readLine();
			while(s.isEmpty())
				s = bf.readLine();
			StringTokenizer st = new StringTokenizer(s);
			char[][] element = new char[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
			int piece = Integer.parseInt(st.nextToken());
			for(int j=0;j<element.length;j++) {
				String input = bf.readLine();
				for(int k=0;k<element[j].length;k++)
					element[j][k] = input.charAt(k);
			}
			for(int l=0;l<piece;l++) {
				s = bf.readLine();
				while(s.isEmpty())
					s = bf.readLine();
				st = new StringTokenizer(s);
				ArrayList<ArrayList<Character>> put = new ArrayList<ArrayList<Character>>();
				int size = Integer.parseInt(st.nextToken());
				boolean flag=true;
				for(int j=0;j<size;j++) {
					String input = bf.readLine();
					StringBuilder sb1 = new StringBuilder();
					if(flag) {
						for(int k=0;k<input.length();k++)
							sb1.append(".");
						if(sb1.toString().equals(input)) 
							continue;
					}
					flag=false;
					ArrayList<Character> temp = new ArrayList<Character>();
					for(int k=0;k<input.length();k++)
						temp.add(input.charAt(k));
					put.add(temp);
				}
				if(check(form(put),element))
					sb.append("Yes\n");
				else
					sb.append("No\n");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}