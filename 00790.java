import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Question790 {
	public static void add(int t,ArrayList<team> acm,String input) {
		for(int i=0;i<acm.size();i++) 
			if(acm.get(i).team==t) {
				acm.get(i).addsolved(input);
				return;
			}
		acm.add(new team(input));
	}
	public static String buildString(int[] space,String r,String t,String solve,String time) {
		StringBuilder sb = new StringBuilder();
		String[] ar = {r,t,solve,time};
		if(solve.equals("0"))
			ar = new String[]{r,t};
		for(int i=0;i<ar.length;i++) {
			for(int j=0;j<space[i]+1-ar[i].length();j++)
				sb.append(" ");
			sb.append(ar[i]);
		}
		sb.append("\n");
		return sb.toString();
	}
	public static boolean existTeam(ArrayList<team>acm,int i) {
		for(int j=0;j<acm.size();j++)
			if(acm.get(j).team==i)
				return false;
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(bf.readLine());
		bf.readLine();
		for(int j=0;j<n;j++) {
			ArrayList<sortTime> random = new ArrayList<sortTime>();
			ArrayList<team> acm = new ArrayList<team>();
			if(j>0) 
				sb.append("\n");
			while(true) {
				String input = bf.readLine();
				if(input==null || input.equals("")) 
					break;
				random.add(new sortTime(input));
			}
			Collections.sort(random);
			int max=0;
			for(int i=0;i<random.size();i++) {
				StringTokenizer st = new StringTokenizer(random.get(i).getInput()," ");
				int t = Integer.parseInt(st.nextToken());
				if(t>max)
					max=t;
				add(t,acm,random.get(i).getInput());
			}
			for(int i=1;i<max;i++) 
				if(existTeam(acm,i))
					acm.add(new team(String.valueOf(i)+" A 0:00 N"));
			Collections.sort(acm);
			sb.append("RANK TEAM PRO/SOLVED TIME\n");
			int checktime=-1,solved=-1;
			int[] space = {3,4,4,10};
			for(int i=0,rank=0;i<acm.size();i++) {
				if(acm.get(i).time!=checktime || solved!=acm.get(i).problem.size())  
					rank=i+1;
				sb.append(buildString(space,String.valueOf(rank),String.valueOf(acm.get(i).team),String.valueOf(acm.get(i).problem.size()),String.valueOf(acm.get(i).time)));
				checktime = acm.get(i).time;
				solved = acm.get(i).problem.size();
			}
		}
		System.out.print(sb);
	}
}
class team implements Comparable<team>{
	int team,time,currtime;
	ArrayList<Character> problem = new ArrayList<Character>();
	ArrayList<Integer>[] checktime = new ArrayList['G'+1];
	char prob;
	public team(String input) {
		for(int i=0;i<checktime.length;i++)
			checktime[i] = new ArrayList();
		StringTokenizer st = new StringTokenizer(input," ");
		team = Integer.parseInt(st.nextToken());
		addsolved(input);
	}
	void addsolved(String input) {
		StringTokenizer st = new StringTokenizer(input," ");
		st.nextToken();
		prob = st.nextToken().charAt(0);
		StringTokenizer st1 = new StringTokenizer(st.nextToken(),":");
		currtime = Integer.parseInt(st1.nextToken())*60+Integer.parseInt(st1.nextToken());
		if(st.nextToken().equals("Y")){
			if(!problem.contains(prob)) {
				problem.add(prob);
				time+=currtime;
				for(int i=0;i<checktime[prob].size();i++)
					if(checktime[prob].get(i)<=currtime)
						time+=20;
			}
		}else 
			checktime[prob].add(currtime);
	}
	@Override
	public int compareTo(team t) {
		int compare = t.problem.size() - problem.size();
		if(compare==0)
			compare = time - t.time;
		if(compare==0)
			compare = team - t.team;
		return compare;
	}
}
class sortTime implements Comparable<sortTime>{
	private String input;
	private int time;
	private String correct;
	public sortTime(String input) {
		this.input=input;
		StringTokenizer st = new StringTokenizer(input," ");
		st.nextToken();st.nextToken();
		StringTokenizer st1 = new StringTokenizer(st.nextToken(),":");
		this.time = Integer.parseInt(st1.nextToken())*60+Integer.parseInt(st1.nextToken());
		correct = st.nextToken();
	}
	public String getInput() {
		return input;
	}
	@Override
	public int compareTo(sortTime st) {
		int compare = this.time-st.time;
		if(compare==0)
			compare = this.correct.compareTo(st.correct);
		return compare;
	}
}