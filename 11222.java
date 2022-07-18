import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Question11222 {
	public static ArrayList<Integer>[] add(ArrayList<Integer>[] curr,int problem,int j){
		for(int i=1;i<j;i++) 
			if(curr[i].contains(problem)) {
				curr[i].removeAll(Arrays.asList(problem));
				curr[0].add(problem);
			}
		if(curr[0].contains(problem)) {
			if(curr[j].contains(problem))
				curr[j].removeAll(Arrays.asList(problem));
			return curr;
		}
		if(curr[j].contains(problem))
			return curr;
		for(int i=0;i<curr[j].size();i++) {
			if(problem<curr[j].get(i)) {
				curr[j].add(i, problem);
				return curr;
			}
		}
		curr[j].add(problem);
		return curr;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			ArrayList<Integer>[] curr = new ArrayList[4];
			for(int j=0;j<curr.length;j++)
				curr[j]= new ArrayList<Integer>();
			StringBuilder sb = new StringBuilder();
			sb.append("Case #"+String.valueOf(i)+":\n");
			for(int j=1;j<=3;j++) {
				int solve = sc.nextInt();
				for(int k=0;k<solve;k++) 
					add(curr,sc.nextInt(),j);
			}
			int max=0;
			for(int j=1;j<curr.length;j++)
				if(curr[j].size()>max) 
					max=curr[j].size();
			for(int j=1;j<curr.length;j++)
				if(curr[j].size()==max) {
					if(curr[j].size()>0)
						sb.append(String.valueOf(j)+" "+String.valueOf(max)+" ");
					else
						sb.append(String.valueOf(j)+" "+String.valueOf(max)+"\n");
					for(int k=0;k<curr[j].size();k++) {
						if(k==curr[j].size()-1)
							sb.append(String.valueOf(curr[j].get(k))+"\n");
						else
							sb.append(String.valueOf(curr[j].get(k))+" ");
					}
				}
			System.out.print(sb);
		}
	}
}
