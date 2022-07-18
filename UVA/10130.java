package Subset_Sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question10130 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			int object = Integer.parseInt(bf.readLine());
			int[] p = new int[object];
			int[] w = new int[object];
			for(int j=0;j<object;j++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				p[j] = Integer.parseInt(st.nextToken());
				w[j] = Integer.parseInt(st.nextToken());
			}
			int[] value = new int[31];
			for(int j=0;j<object;j++) 
				for(int k=value.length-1;k>=0;k--) 
					if(w[j]<=k && value[k] < value[k-w[j]]+p[j]) 
						value[k] = value[k-w[j]]+p[j];
			int ppl = Integer.parseInt(bf.readLine());
			int answer = 0;
			for(int j=0;j<ppl;j++)
				answer += value[Integer.parseInt(bf.readLine())];
			sb.append(answer).append("\n");
		}
		System.out.print(sb.toString());
	}

}
