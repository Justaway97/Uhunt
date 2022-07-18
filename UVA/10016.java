import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question10016 {
	public static void swap(int[][] square,int i,int j,int is,int js) {
		int temp = square[i][j];
		square[i][j] = square[is][js];
		square[is][js] = temp;
	}
	public static void option1(int[][] square,int indexA,int indexB) {
		for(int i=indexA;i<square.length/2;i++) 
			for(int j=indexA;j<=indexB;j++) 
				if(i==indexA || j==indexB || j==indexA || i==indexB) 
					swap(square,i,j,square.length-1-i,j);
	}
	public static void option2 (int[][] square,int indexA,int indexB) {
		for(int i=indexA;i<square.length/2;i++)
			for(int j=indexA;j<=indexB;j++)
				if(i==indexA || j==indexB || j==indexA || i==indexB) 
					swap(square,j,i,j,square.length-1-i);
	}
	public static void option3(int[][] square,int indexA,int indexB) {
		for(int i=indexA;i<=indexB;i++) 
			for(int j=indexA;j<i;j++) 
				if(i==indexA || j==indexB || i==indexB || j==indexA) 
					swap(square,i,j,j,i);
	}
	public static void option4(int[][] square,int indexA,int indexB) {
		for(int i=indexA;i<square.length;i++)
			for(int j=indexA;j<square.length-1-i;j++)
				if(i==indexA || j==indexB || i==indexB || j==indexA) 
					swap(square,i,j,square.length-j-1,square.length-i-1);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			int size = Integer.parseInt(bf.readLine());
			int[][] square = new int[size][size];
			for(int j=0;j<size;j++) {
				StringTokenizer st = new StringTokenizer(bf.readLine()," ");
				for(int k=0;k<size;k++) 
					square[j][k] = Integer.parseInt(st.nextToken());
			}
			for(int j=0;j<(size+1)/2;j++) {
				StringTokenizer st = new StringTokenizer(bf.readLine()," ");
				int op = Integer.parseInt(st.nextToken());
				for(int k=0;k<op;k++) {
					int option = Integer.parseInt(st.nextToken());
					if(option==1) 
						option1(square,j,square.length-1-j);
					else if(option==2) 
						option2(square,j,square.length-1-j);
					else if(option==3) 
						option3(square,j,square.length-1-j);
					else if(option==4) 
						option4(square,j,square.length-1-j);
				}
			}
			for(int j=0;j<square.length;j++) {
				for(int k=0;k<square[j].length;k++)
					if(k==square[j].length-1) 
						sb.append(String.valueOf(square[j][k])+"\n");
					else 
						sb.append(String.valueOf(square[j][k])+" ");
			}
		}
		System.out.print(sb);
	}
}
