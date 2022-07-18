import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Question400{
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		while(true) {
			String input = bf.readLine();
			if(input==null)
				break;
			ArrayList<String> word = new ArrayList<String>();
			int max = 0;
			for(int i=0;i<Integer.parseInt(input);i++) {
				word.add(bf.readLine());
				if(word.get(i).length()+2>max)
					max=word.get(i).length()+2;
			}
			int col = 62/max;
			if(col==0)
				col=word.size();
			Collections.sort(word);
			result.append("------------------------------------------------------------\n");
			for(int i=0;i<Math.ceil((double)word.size()/col);i++) {
				StringBuilder sb = new StringBuilder();
				for(int j=i;j<word.size();j+=Math.ceil((double)word.size()/col)) {
					sb.append(word.get(j));
					for(int k=0;k<max-word.get(j).length()-2;k++)
						sb.append(" ");
					if(j+Math.ceil((double)word.size()/col)<word.size())
						sb.append("  ");
				}
				result.append(sb.toString()+"\n");
			}
		}
		System.out.print(result);
	}
}