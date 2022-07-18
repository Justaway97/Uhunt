import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Question755 {
	public static String buildstring(String S) {
		StringBuilder sb = new StringBuilder();
		for(int k=0;k<S.length();k++) {
			if(k==3)
				sb.append("-");
			if(!Character.isDigit(S.charAt(k))) {
				if(S.charAt(k)>'Q')
					sb.append(((S.charAt(k)-1-'A')/3)+2);
				else
					sb.append(((S.charAt(k)-'A')/3)+2);
			}else
				sb.append(S.substring(k, k+1));
		}
		return sb.toString();
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++) {
			TreeMap<String,Integer> map = new TreeMap<>();
			bf.readLine();
			int m = Integer.parseInt(bf.readLine());
			for(int j=0;j<m;j++) {
				String S = bf.readLine();
				S=S.replaceAll("-", "");
				map.put(buildstring(S), map.getOrDefault(buildstring(S).toString(),0)+1);
			}
			StringBuilder sb = new StringBuilder();
			for(String key:map.keySet())
				if(map.get(key).intValue()!=1)
					sb.append(key+" "+String.valueOf(map.get(key))+"\n");
			if(sb.length()==0)
				System.out.println("No duplicates.");
			else {
				System.out.print(sb);
			}
			if(i<n-1)
				System.out.println();
		}
	}
}