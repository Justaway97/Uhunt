import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question1241 {
	public static void main(String[]args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			ArrayList<Integer> team = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			int size = Integer.parseInt(st.nextToken());st.nextToken();
			for(int j=1;j<=Math.pow(2, size);j++) 
				team.add(j);
			st = new StringTokenizer(bf.readLine()," ");
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				team.set(team.indexOf(num),-team.get(team.indexOf(num)));
			}
			int wo = 0;
			while(team.size()>1) {
				ArrayList<Integer> bracket = new ArrayList<Integer>();
				for(int j=0;j<team.size();j+=2) {
					if((team.get(j)>0 && team.get(j+1)>0) || (team.get(j)<0 && team.get(j+1)<0)) {
						bracket.add(team.get(j));
					}else {
						bracket.add(Math.max(team.get(j),team.get(j+1)));
						wo++;
					}
				}
				team = bracket;
			}
			sb.append(wo+"\n");
		}
		System.out.print(sb);
	}
}
