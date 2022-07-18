import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question111 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		int[] original = new int[n];
		for(int i=0;i<n;i++)
			original[i] = Integer.parseInt(st.nextToken());
		while(true) {
			String s = bf.readLine();
			if(s==null)
				break;
			st = new StringTokenizer(s);
			int[] temp = new int[n];
			for(int i=0;i<temp.length;i++)
				temp[Integer.parseInt(st.nextToken())-1] = original[i];
			int[] value = new int[n];
			for(int i=0;i<n;i++) {
				value[i] = Math.max(1, value[i]);
				for(int j=0;j<i;j++) 
					if(temp[i]>temp[j])
						value[i] = Math.max(value[i],value[j]+1);
			}
			int max = 0;
			for(int i=0;i<n;i++)
					max = Math.max(max,value[i]);
			sb.append(max).append("\n");
		}
		System.out.print(sb);
	}
}