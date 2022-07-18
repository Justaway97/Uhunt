package Longest_Increasing_Subsequence;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Question481 {
	public static int binarySearch(int min,int max,int[] list,int target) {
		if(list[0]>target)
			return 0;
		return BS(min,max,list,target);
	}
	public static int BS(int min,int max,int[] list,int target) {
		int mid = (min+max)/2;
		int select = list[mid];
		if((select<target && list[mid+1]>target)) 
			return mid+1;
		else if(select==target)
			return mid;
		if(select-target<0)
			return BS(mid,max,list,target);
		else
			return BS(min,mid,list,target);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> num = new ArrayList<Integer>();
		while(true) {
			String s = bf.readLine();
			if(s==null || s.isEmpty())
				break;
			num.add(Integer.parseInt(s));
		}
		int[] n = new int[num.size()];
		for(int i=0;i<num.size();i++)
			n[i] = num.get(i);
		int[] position = new int[num.size()];
		int[] list = new int[num.size()];
		list[0] = n[0];
		position[0] = 1;
		int sequence = 1;
		for(int i=0,j=0;i<n.length-1;i++) {
			if(n[i+1]>list[j]) {
				list[j+1] = n[i+1];
				sequence++;
				position[i+1] = sequence;
				j++;
			}else if(n[i+1]<list[j]) {
				int index = binarySearch(0,j+1,list,n[i+1]);
				list[index] = n[i+1];
				position[i+1] = index+1;
			}else {
				position[i+1] = j+1;
			}
		}
		sb.append(sequence).append("\n-\n");
		int[] lis = new int[sequence];
		for(int i=position.length-1;i>=0;i--)  
			if(position[i]==sequence) {
				lis[sequence-1] = n[i];
				sequence--;
			}
		for(int i=0;i<lis.length;i++)
			sb.append(lis[i]).append("\n");
		System.out.print(sb);
	}
}
