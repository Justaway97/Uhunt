import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Question154 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			ArrayList<String[]> bin = new ArrayList<String[]>();
			String input="";
			while(true) {
				input = bf.readLine();
				if(input.charAt(0)=='e' || input.equals("#"))
					break;
				String[] add = input.split(",");
				Arrays.sort(add);
				bin.add(add);
			}
			if(input.equals("#"))
				break;
			int[] count = new int[bin.size()];
			for(int i=0;i<count.length;i++) 
				for(int j=0;j<bin.get(i).length;j++) 
					for(int k=0;k<bin.size();k++) 
						if(!bin.get(i)[j].equals(bin.get(k)[j])) 
							count[i]++;
			int minIndex=0;
			for(int i=0;i<count.length;i++) 
				if(count[i]<count[minIndex])
					minIndex=i;
			if(bin.size()!=0)
				sb.append(minIndex+1).append("\n");
		}
		System.out.print(sb);
	}
}