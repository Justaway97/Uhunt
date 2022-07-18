package Longest_Increasing_Subsequence;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Question437 {
	public static class number implements Comparable<number>{
		int value,left,right;
		int[] array;
		number(String s){
			StringTokenizer st = new StringTokenizer(s);
			sort(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			value = array[0];
			left = array[1];
			right = array[2];
		}
		public static void add(int[] number) {
			Arrays.sort(number);
			int temp = number[0];
			number[0] = number[2];
			number[2] = number[1];
			number[1] = temp;
		}
		public void sort(int x,int y,int z) {
			array = new int[3];
			array[0] = x;
			array[1] = y;
			array[2] = z;
			Arrays.sort(array);
		}
		public number(int value, int left, int right) {
			sort(value,left,right);
			this.value = array[1];
			this.left = array[0];
			this.right = array[2];
		}
		public number(int value,int left,int right,int x) {
			sort(value,left,right);
			this.value = array[2];
			this.left = array[0];
			this.right = array[1];
		}
		@Override
		public int compareTo(number i) {
			return i.right-this.right;
		}
	}
	public static void main (String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x=1;
		while(true) {
			int n = Integer.parseInt(bf.readLine().trim());
			if(n==0)
				break;
			ArrayList<number> number = new ArrayList<number>();
			int range = n*3;
			for(int i=0;i<range;i+=3) {
				number.add(new number(bf.readLine()));
				if(number.get(i).left!=number.get(i).right || number.get(i).left!=number.get(i).value) {
					number.add(new number(number.get(i).value,number.get(i).left,number.get(i).right));
					number.add(new number(number.get(i).value,number.get(i).left,number.get(i).right,0));
				}else {
					range-=2;
					i-=2;
				}
			}
			Collections.sort(number);
			int[] value = new int[number.size()];
			for(int i=0;i<number.size();i++)
				value[i] = number.get(i).value;
			for(int i=1;i<value.length;i++) 
				for(int j=0;j<i;j++) 
					if(number.get(i).right<number.get(j).right && number.get(i).left<number.get(j).left)
						value[i] = Math.max(value[i], value[j]+number.get(i).value);
			int max=0;
			for(int i=0;i<value.length;i++) 
				if(value[i]>max)
					max = value[i];
			sb.append("Case "+x+++": maximum height = "+max).append("\n");
		}
		System.out.print(sb);
	}
}