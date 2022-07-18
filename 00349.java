import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Question349 {
	private static rank[] score;
	private static int[] curr;
	private static int max,maxCount,total,count,min;
	public static void swap(int i,int destroy) {
		for(int j=i;j<score.length;j++)
			if(score[j].candidate[0]==destroy)
				score[j].swap();
			else
				break;
	}
	private static void champion(int n) {
		curr = new int[n+1];
		for(int i=0;i<score.length;i++) 
			if(score[i].candidate[0]!=0) {
				curr[score[i].candidate[0]]++;
				if(curr[score[i].candidate[0]]>max)
					max = curr[score[i].candidate[0]];
			}
		for(int i=1;i<curr.length;i++) {
			if(curr[i]<min)
				min = curr[i];
			if(curr[i]==max)
				maxCount++;
		}
		for(int i=0;i<score.length;i++) {
			if(score[i].candidate[0]!=0 && curr[score[i].candidate[0]]==max)
				total+=max;
			else if(score[i].candidate[0]!=0 && curr[score[i].candidate[0]]==min) {
				swap(i,score[i].candidate[0]);
				maxCount=total=0;
				champion(n);
				break;
			}
		}
		count++;
		if(count==n || maxCount==1 || total==score.length)
			return;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x=1;
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==0 && m==0)
				break;
			score = new rank[m];
			int ballot=maxCount=total=max=count=0;
			min = Integer.MAX_VALUE;
			for(int i=0;i<m;i++) {
				score[i] = new rank(bf.readLine());
				if(!score[i].flag)
					ballot++;
			}
			curr = new int[n+1];
			Arrays.sort(score);
			champion(n);
			sb.append("Election #").append(x).append("\n   ");
			if(ballot!=0)
				sb.append(ballot).append(" bad ballot(s)\n   ");
			if(maxCount==1){
				for(int i=1;i<curr.length;i++)
					if(curr[i]==max) 
						sb.append("Candidate ").append(i).append(" is elected.\n");
			}else {
				sb.append("The following candidates are tied:");
				for(int i=1;i<curr.length;i++)
					if(curr[i]==max)
						sb.append(" ").append(i);
				sb.append("\n");
			}
			x++;
		}
		System.out.print(sb);
	}
}
class rank implements Comparable<rank>{
	boolean flag=true;
	int[] candidate;
	public rank(String input) {
		StringTokenizer st = new StringTokenizer(input);
		candidate = new int[st.countTokens()];
		int count = st.countTokens();
		boolean[] f = new boolean[count+1];
		for(int i=0;i<candidate.length;i++){
			int valid = Integer.parseInt(st.nextToken());
			if(valid<1 || valid>count || f[valid]) {
				flag=false;
				Arrays.fill(candidate, 0);
				break;
			}
			candidate[i]=valid;
			f[valid]=true;
		}
	}	
	public void swap() {
		for(int i=1;i<candidate.length;i++)
			candidate[i-1] = candidate[i];
	}
	@Override
	public int compareTo(rank r) {
		for(int i=0;i<this.candidate.length;i++)
			if(this.candidate[i]!=r.candidate[i])
				return this.candidate[i]-r.candidate[i];
		return 0;
	}
}