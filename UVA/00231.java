package Longest_Increasing_Subsequence;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Question231 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x=1;
		while(true) {
			ArrayList<Integer> number = new ArrayList<Integer>();
			ArrayList<Integer> lis = new ArrayList<Integer>();
			while(true) {
				int m = Integer.parseInt(bf.readLine().trim());
				if(m==-1)
					break;
				lis.add(1);
				for(int i=0;i<number.size();i++) 
					if(m<=number.get(i))
						lis.set(lis.size()-1,Math.max(lis.get(i)+1, lis.get(lis.size()-1)));
				number.add(m);
			}
			if(number.size()==0)
				break;
			if(x>1)
				sb.append("\n");
			int max = 0;
			for(int i=0;i<lis.size();i++)
				if(lis.get(i)>max)
					max = lis.get(i);
			sb.append("Test #"+x+++":\n  maximum possible interceptions: "+max+"\n");
		}
		System.out.print(sb);
	}
}
