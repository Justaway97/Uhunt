import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question927 {
//	d is interval
//	k is position
//	to find n, use the first example(1,2,2,3,3,3,4,4,4,4) where d=1,
//		k=1, n=1
//		k=2 or k=3, n=2
//		k=4 or k=5 or k=6, n=3
//		k=7 or k=8 or k=9 or k=10, n=4
//	by using the maximum value of k, we get
//		k=1, n=1
//		k=3, n=2
//		k=6, n=3
//		k=10, n=4
//	by ploting the graph k against n, we get a quadratic graph, so our formula will start with n^2 + n,
//		when n=1, n^2 + n = 2	where k = 1
//		when n=2, n^2 + n = 6	where k = 3
//		when n=3, n^2 + n = 12	where k = 6
//		when n=4, n^2 + n = 20	where k = 10
//	so, the formula will be n^2 + n -2k/d = 0
//	from the first example 4 3 0 0 0 23 where d=25, k=100
//	4 is number of c, 3 is c0, 0 is c2, 0 is c3, 0 is c4, 23 is c5
//	formula will be 3(n^0)+0(n^1)+0(n^2)+0(n^3)+0(n^4)+23(n^5) where n will be equal 3
//	the answer is 1866
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		for(int i=0;i<t;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int[] formula = new int[Integer.parseInt(st.nextToken())+1];
			for(int j=0;j<formula.length;j++) 
				formula[j] = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(bf.readLine().trim());
			int k = Integer.parseInt(bf.readLine().trim());
			int n = (int)Math.ceil(((Math.sqrt(1+8*k/d))-1)/2);
			long sum = 0;
			for(int j=0;j<formula.length;j++) 
				sum+=formula[j]*(long)Math.pow(n, j);
			sb.append(sum).append("\n");
		}
		System.out.print(sb);
	}
}
