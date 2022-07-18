import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Question10474 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x=1;
		while(true) {
			String input = bf.readLine();
			while(input.isEmpty())
				input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int[] num = new int[Integer.parseInt(st.nextToken())];
			int n = Integer.parseInt(st.nextToken());
			if(num.length==0 && n==0)
				break;
			sb.append("CASE# ").append(x).append(":\n");
			for(int i=0;i<num.length;i++) {
				String s = bf.readLine();
				while(s.isEmpty())
					s = bf.readLine();
				num[i] = Integer.parseInt(s.trim());
			}
			Arrays.sort(num);
			for(int i=0;i<n;i++) {
				String s = bf.readLine();
				while(s.isEmpty())
					s = bf.readLine();
				int selected = Integer.parseInt(s.trim());
				int index = -1;
				for(int j=0;j<num.length;j++) 
					if(selected==num[j]) {
						index = j+1;
						break;
					}else if(num[j]>selected)
						break;
				if(index!=-1)
					sb.append(selected).append(" found at ").append(index).append("\n");
				else
					sb.append(selected).append(" not found\n");
			}
			x++;
		}
		System.out.print(sb);
	}
}
