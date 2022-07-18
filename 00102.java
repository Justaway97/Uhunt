import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question102 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = bf.readLine();
			if(input==null || input.isEmpty())
				break;
			StringTokenizer st = new StringTokenizer(input);
			int[] bin = new int[9];
			int total=0;
			for(int i=0;i<bin.length;i++) { 
				bin[i]=Integer.parseInt(st.nextToken());
				total+=bin[i];
			}
			int[] store = {bin[0]+bin[5]+bin[7],bin[0]+bin[4]+bin[8],bin[2]+bin[3]+bin[7],bin[2]+bin[4]+bin[6],bin[1]+bin[3]+bin[8],bin[1]+bin[5]+bin[6]};
			String[] result = {"BCG","BGC","CBG","CGB","GBC","GCB"};
			int max=0,index=0;
			for(int i=0;i<store.length;i++) 
				if(store[i]>max) {
					max = store[i];
					index=i;
				}
			sb.append(result[index]).append(" ").append(total-max).append("\n");
		}
		System.out.print(sb);
	}
}
