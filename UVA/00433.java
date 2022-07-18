import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Question433 {
	private static boolean[][][] led = new boolean[10][3][3];
	private static ArrayList<Integer> ans;
	private static ArrayList<ArrayList<Integer>> possible;
	private static boolean[][][] test;
	private static int fail,failIndex;
	private static void set() {
		led[0][0][1] = led[0][1][0] = led[0][1][2] = led[0][2][0] = led[0][2][1] = led[0][2][2] = true;
		led[1][1][2] = led[1][2][2] = true;
		led[2][0][1] = led[2][1][1] = led[2][1][2] = led[2][2][0] = led[2][2][1] = true;
		led[3][0][1] = led[3][1][1] = led[3][1][2] = led[3][2][1] = led[3][2][2] = true;
		led[4][1][0] = led[4][1][1] = led[4][1][2] = led[4][2][2] = true;
		led[5][0][1] = led[5][1][0] = led[5][1][1] = led[5][2][1] = led[5][2][2] = true;
		led[6][0][1] = led[6][1][0] = led[6][1][1] = led[6][2][0] = led[6][2][1] = led[6][2][2] = true;
		led[7][0][1] = led[7][1][2] = led[7][2][2] = true;
		led[8][0][1] = led[8][1][0] = led[8][1][1] = led[8][1][2] = led[8][2][0] = led[8][2][1] = led[8][2][2] = true;
		led[9][0][1] = led[9][1][0] = led[9][1][1] = led[9][1][2] = led[9][2][1] = led[9][2][2] = true;
	}
	private static void generateAnswer(int index){
		if(index==9)
			return;
		boolean[][] temp = test[index];
		possible.add(new ArrayList<Integer>());
		boolean valid = false;
		for(int i=0;i<led.length;i++) {
			boolean mark = false;
			boolean flag = true;
			for(int j=0;j<led[i].length;j++) {
				for(int k=0;k<led[i][j].length;k++) 
					if(!led[i][j][k]&&temp[j][k]) {
						flag = mark = false;
						break;
					}else if(led[i][j][k]&&!temp[j][k]) 
						mark = true;
				if(!flag) break;
			}
			if(flag) {
				if(mark)
					possible.get(index).add(i);
				else {
					possible.get(index).add(0,i);
					valid = true;
				}
			}
		}
		if(!valid) {
			possible.get(index).add(0, -1);
			fail++;
			failIndex = index;
		}
		generateAnswer(index+1);
	}
	private static void find() {
		boolean[] change = new boolean[9];
		valid(change,0);
		if(fail==0)
			for(int i=0;i<possible.size();i++) {
				for(int j=1;j<possible.get(i).size();j++) {
					change[i] = true;
					valid(change,j);
					change[i] = false;
				}
			}
		else {
			change[failIndex] = true;
			for(int i=1;i<possible.get(failIndex).size();i++) 
				valid(change,i);
		}
	}
	private static void valid(boolean[] change,int selected) {
		int value = 0;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i=0;i<change.length;i++) {
			if(!change[i]) {
				value+=possible.get(i).get(0)*(change.length-i);
				if(possible.get(i).get(0)<0)
					return;
				temp.add(possible.get(i).get(0));
			}else {
				value+=possible.get(i).get(selected)*(change.length-i);
				if(possible.get(i).get(selected)<0)
					return;
				temp.add(possible.get(i).get(selected));
			}
		}
		if(value%11==0)
			ans.addAll(temp);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		set();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++) {
			test = new boolean[9][3][3];
			ans = new ArrayList<Integer>();
			for(int j=0;j<3;j++) {
				String input = bf.readLine();
				for(int k=0;k<input.length();k++)
					if(input.charAt(k)!=' ')
						test[k/3][j][k%3] = true;
			}
			fail = 0;
			possible = new ArrayList<ArrayList<Integer>>();
			generateAnswer(0);
			if(fail<=1)
				find();
			if(ans.size()>9)
				sb.append("ambiguous\n");
			else if(ans.size()!=9)
				sb.append("failure\n");
			else {
				for(int j=0;j<ans.size();j++)
					sb.append(ans.get(j));
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}