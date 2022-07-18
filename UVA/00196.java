package Non_Classical_Easier;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question196 {
	private static int dp(int[][] map, String s,int orix,int oriy, String[][] op) {
		if(s!=null) {
			StringTokenizer st = new StringTokenizer(s,"+=");
			while(st.hasMoreTokens()) {
				String sub = st.nextToken();
				int index = -1;
				for(int i=0;i<sub.length();i++)
					if(sub.charAt(i)<65) {
						index = i;
						break;
					}
				String x = sub.substring(0,index);
				String y = sub.substring(index,sub.length());
				int j = 0, i = Integer.parseInt(y)-1;
				int x1 = 0,x2 = 0, x3= 0;
				if(x.length()>=1)
					x1 = x.charAt(x.length()-1)-64;
				if(x.length()>=2)
					x2 = x.charAt(x.length()-2)-64;
				if(x.length()>=3)
					x3 = x.charAt(x.length()-3)-64;
				j = 676*x3 + 26*x2 + x1 -1;
				op[orix][oriy] = null;
				map[orix][oriy]+=dp(map,op[i][j],i,j,op);
			}
			return map[orix][oriy];
		}
		return map[orix][oriy];
	}
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			String s = bf.readLine();
			while(s.isEmpty())
				s = bf.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int y = Integer.parseInt(st.nextToken());
			int[][] map = new int[Integer.parseInt(st.nextToken())][y];
			String[][] op = new String[map.length][map[0].length];
			for(int j=0;j<map.length;j++) 
				for(int k=0;k<map[0].length;k++) {
					while(!st.hasMoreTokens())
						st = new StringTokenizer(bf.readLine());
					s = st.nextToken();
					if(s.startsWith("="))
						op[j][k] = s;
					else
						map[j][k] = Integer.parseInt(s);
			}
			for(int j=0;j<map.length;j++) {
				for(int k=0;k<map[0].length;k++) {
					if(op[j][k]==null || !op[j][k].startsWith("="))
						sb.append(map[j][k]);
					else {
						map[j][k] = dp(map,op[j][k],j,k,op);
						sb.append(map[j][k]);
					}
					if(k!=map[0].length-1)
						sb.append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}
