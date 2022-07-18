import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Question296 {
//Without brute force
//create a 2d array --> boolean[4][10]
//example --> 9793 0/1 this means the position is wrong
//boolean[0][9]=false	boolean[1][7]=false and so on to reduce the candidate
//then will get something like this
//	1 1 0 1 1 0 0 0 1 0 	0,1,3,4,8
//	1 1 0 0 1 0 1 0 1 0 	0,1,4,5,8	all this is candidate in the respective location
//	1 1 0 1 1 0 0 0 0 0 	0,1,3,4
//	1 1 0 0 0 0 1 0 1 0 	0,1,6,8
//if there is some number with xxxx 0/0 then put all the x into an arraylist to further reduce the candidate
//with this can reduce the candidate like 9793 to ---3 to skip unnecessary check
//perform the checking on the number again with the boolean array
//u can further reduce the number like 3383 to 3---
//since 3383 has one correct candidate and u reduce the 3383 to 3---
//u can conclude that the first number is 3
//so the candidate further reduce until
//	[3]
//	[0,1,4,5,8]
//	[0,1,3,4]
//	[0,1,6,8]
//from here and so on you can calculate by combining these number with respective location
//with this can prevent O(10000n) when you perform checking
	public static boolean correct(ArrayList<code> code,char[] temp) {
		ArrayList<Character> curr = new ArrayList<Character>();
		for(int i=0;i<temp.length;i++)
			curr.add(temp[i]);
		for(int i=0;i<code.size();i++) {
			int left=0,right=0;
			ArrayList<Character> used = new ArrayList<Character>(),used2 = new ArrayList<Character>();;
			for(int j=0;j<4;j++) {
				used.add(curr.get(j));
				used2.add(code.get(i).ori.get(j));
			}
			for(int j=0;j<used2.size();j++) 
				if(used.get(j)==used2.get(j)) {
					left++;
					used.set(j, '-');
					used2.set(j, '-');
				}
			for(int j=0;j<used2.size();j++) 
				if(used.contains(used2.get(j)) && used.indexOf(used2.get(j))!=j && used2.get(j)!='-') { 
					right++;
					used.set(used.indexOf(used2.get(j)), '-');
					used2.set(j, '-');
				}
			if(code.get(i).left!=left || code.get(i).right!=right)
				return false;
		}
		return true;
	}
	public static void check(ArrayList<ArrayList<Character>> answer,int index,char[] temp,StringBuilder sb,ArrayList<code> code) {
		if(index==4 && correct(code,temp)) {
			for(int i=0;i<temp.length;i++)
				sb.append(temp[i]);
			return;
		}
		if(index==4)
			return;
		for(int j=0;j<answer.get(index).size();j++) {
			temp[index]=answer.get(index).get(j);
			check(answer,(index+1),temp,sb,code);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			int size = Integer.parseInt(bf.readLine().trim());
			boolean[][] num = new boolean[4][10];
			for(int j=0;j<num.length;j++)
				Arrays.fill(num[j], true);
			ArrayList<code> code = new ArrayList<code>();
			HashSet<Character> wrong = new HashSet<Character>();
			char[] result = new char[4];
			for(int j=0;j<size;j++) {
				String input = bf.readLine();
				code.add(new code(input));
				StringTokenizer st = new StringTokenizer(input);
				char[] temp = st.nextToken().toCharArray();
				String check = st.nextToken();
				if(check.charAt(0)=='0' && check.charAt(2)!='0') {
					for(int k=0;k<temp.length;k++)
						num[k][Character.getNumericValue(temp[k])]=false;
				}else if(check.charAt(0)=='0' && check.charAt(2)=='0') {
					for(int k=0;k<temp.length;k++) {
						wrong.add(temp[k]);
						for(int l=0;l<num.length;l++) 
							num[l][Character.getNumericValue(temp[k])]=false;
					}
				}
			}
			for(int j=0;j<num.length;j++) {
				for(int k=0;k<num[j].length;k++) {
					if(num[j][k])
						System.out.print("1 ");
					else
						System.out.print("0 ");
				}
				System.out.println();
			}
			for(int j=code.size()-1;j>=0;j--) 
				if(code.get(j).left>=1 && code.get(j).right==0) {
					for(int k=0;k<code.get(j).change.size();k++)
						if(code.get(j).change.get(k)!='-' && !num[k][Character.getNumericValue(code.get(j).change.get(k))]) 
							code.get(j).update(k);
				}else {
					for(int k=0;k<code.get(j).change.size();k++)
						if(code.get(j).change.get(k)!='-' && wrong.contains(code.get(j).change.get(k)))
							code.get(j).update(k);
				}
			for(int j=0;j<code.size();j++) 
				if(code.get(j).left==code.get(j).count) 
					for(int k=0;k<code.get(j).change.size();k++)
						if(Character.isDigit(code.get(j).change.get(k))) 
							result[k]=code.get(j).change.get(k);
			ArrayList<ArrayList<Character>> answer = new ArrayList<ArrayList<Character>>();
			for(int j=0;j<num.length;j++) {
				ArrayList<Character> temp = new ArrayList<Character>();
				if(Character.isDigit(result[j])) 
					temp.add(result[j]);
				else 
					for(int k=0;k<num[j].length;k++) 
						if(num[j][k])
							temp.add(Integer.toString(k).charAt(0));
				answer.add(temp);
			}
			StringBuilder sb1 = new StringBuilder();
			check(answer,0,new char[4],sb1,code);
			if(sb1.toString().length()==4)
				sb.append(sb1).append("\n");
			else if(sb1.toString().length()>4)
				sb.append("indeterminate\n");
			else
				sb.append("impossible\n");
		}
		System.out.print(sb);
	}
}
class code{
	ArrayList<Character> ori = new ArrayList<Character>(),change = new ArrayList<Character>();
	int left=0,right=0,count=4;
	public code(String s) {
		char[] temp = s.substring(0, 4).toCharArray();
		for(int i=0;i<temp.length;i++) {
			ori.add(temp[i]);
			change.add(temp[i]);
		}
		left = Character.getNumericValue(s.charAt(5));
		right = Character.getNumericValue(s.charAt(7));
	}
	void update(int c){
		change.set(c,'-');
		count--;
	}
}