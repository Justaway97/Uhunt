import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question331 {
	static int counter;
	static int[] sort;
	public static boolean correct(int[] sort) {
		for(int i=0;i<sort.length-1;i++)
			if(sort[i]>sort[i+1])
				return false;
		return true;
	}
	public static void swap(int[] sort,int i) {
		int temp = sort[i];
		sort[i] = sort[i+1];
		sort[i+1] = temp;
	}
	public static void sort() {
		if(correct(sort)) {
			++counter;
			return;
		}
		for(int i=0;i<sort.length-1;i++) {
			if(sort[i]>sort[i+1]) {
				swap(sort,i);
				sort();
				swap(sort,i);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x=1;
		while(true) {
			String input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int n = Integer.parseInt(st.nextToken());
			if(n==0)
				break;
			counter = 0;
			sort = new int[n];
			for(int i=0;i<n;i++) 
				sort[i] = Integer.parseInt(st.nextToken());
			sort();
			if(correct(sort))
				sb.append("There are ").append(0).append(" swap maps for input data set ").append(x).append(".\n");
			else
				sb.append("There are ").append(counter).append(" swap maps for input data set ").append(x).append(".\n");
			x++;
		}
		System.out.print(sb);
	}
}
