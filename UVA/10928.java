import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question10928 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			String input = bf.readLine();
			while(input.equals(""))
				input = bf.readLine();
			int[] size = new int[Integer.parseInt(input)];
			int min = Integer.MAX_VALUE;
			for(int j=0;j<Integer.parseInt(input);j++) {
				String s = bf.readLine();
				size[j] = s.split(" ").length;
				if(min>size[j])
					min = size[j];
			}
			StringBuilder sb1 = new StringBuilder();
			for(int j=0;j<size.length;j++){
				if(size[j]==min) {
					sb1.append((j+1));
					sb1.append(" ");
				}
			}
			sb.append(sb1.substring(0,sb1.length()-1));
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
