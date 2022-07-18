import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question466 {
	public static String TwoHundredSeventyReflect(int[][] before,int[][] after) {
		for(int i=0;i<before.length;i++) 
			for(int j=0;j<before[i].length;j++) 
				if(before[i][j]==1 && after[before.length-1-j][before.length-1-i]!=1)
					return Reflect(before,after);
		return " was reflected vertically and rotated 270 degrees.";
	}
	public static String TwoHundredSeventy(int[][] before,int[][] after) {
		for(int i=0;i<before.length;i++) 
			for(int j=0;j<before[i].length;j++) 
				if(before[i][j]==1 && after[before.length-1-j][i]!=1)
					return TwoHundredSeventyReflect(before,after);
		return " was rotated 270 degrees.";
	}
	public static String HundredEightyReflect(int[][] before,int[][] after) {
		for(int i=0;i<before.length;i++) 
			for(int j=0;j<before[i].length;j++) 
				if(before[i][j]==1 && after[i][before.length-1-j]!=1)
					return TwoHundredSeventy(before,after);
		return " was reflected vertically and rotated 180 degrees.";
	}
	public static String HundredEighty(int[][] before,int[][] after) {
		for(int i=0;i<before.length;i++) 
			for(int j=0;j<before[i].length;j++) 
				if(before[i][j]==1 && after[before.length-1-i][before.length-1-j]!=1)
					return HundredEightyReflect(before,after);
		return " was rotated 180 degrees.";
	}
	public static String NinetyReflect(int[][] before,int[][] after) {
		for(int i=0;i<before.length;i++) 
			for(int j=0;j<before[i].length;j++) 
				if(before[i][j]==1 && after[j][i]!=1)
					return HundredEighty(before,after);
		return " was reflected vertically and rotated 90 degrees.";
	}
	public static String Ninety(int[][] before,int[][] after) {
		for(int i=0;i<before.length;i++) 
			for(int j=0;j<before[i].length;j++) 
				if(before[i][j]==1 && after[j][before.length-1-i]!=1)
					return NinetyReflect(before,after);
		return " was rotated 90 degrees.";
	}
	public static String Reflect(int[][] before,int[][] after) {
		for(int i=0;i<before.length;i++) 
			for(int j=0;j<before[i].length;j++)
				if(before[i][j]==1 && after[before.length-1-i][j]!=1)
					return " was improperly transformed.";
		return " was reflected vertically.";
	}
	public static String Preserved(int[][] before,int[][] after) {
		for(int i=0;i<before.length;i++) 
			for(int j=0;j<before[i].length;j++)
				if(before[i][j]!=after[i][j])
					return Ninety(before,after);
		return " was preserved.";
	}
	public static int getIndex(String input,int i,int[][] result) {
		int count=0;
		for(int j=0;j<input.length();j++) 
			if(input.charAt(j)=='X') {
				result[i][j]++;
				count++;
			}
		return count;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x=1;
		while(true) {
			int n=0;
			try {
				n = Integer.parseInt(bf.readLine());
			}catch(Exception e) {break;}
			int[][] before = new int[n][n];
			int[][] after = new int[n][n];
			int countXbefore = 0;
			int countXafter = 0;
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine()," ");
				countXbefore += getIndex(st.nextToken(),i,before);
				countXafter += getIndex(st.nextToken(),i,after);
			}
			if(countXbefore==countXafter)
				sb.append("Pattern "+x+Preserved(before,after)+"\n");
			else
				sb.append("Pattern "+x+" was improperly transformed.\n");
			x++;
		}
		System.out.print(sb);
	}
}
