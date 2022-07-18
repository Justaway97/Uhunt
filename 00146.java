import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question146 {
	public static boolean successor(char[] letter) {
		for(int i=letter.length-2;i>=0;i--) {
			int min=Integer.MAX_VALUE,indexToChange=-1,indexBeChanged=-1;
			for(int j=letter.length-1;j>i;j--) {
				if(letter[i]<letter[j] && letter[j]<min) {
					min = letter[j];
					indexToChange = i;
					indexBeChanged = j;
				}
			}
			if(indexToChange!=-1 && indexBeChanged!=-1) {
				char temp = letter[indexBeChanged];
				letter[indexBeChanged] = letter[indexToChange];
				letter[indexToChange] = temp;
				Arrays.sort(letter,indexToChange+1,letter.length);
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = bf.readLine();
			if(input.equals("#"))
				break;
			char[] letter = input.toCharArray();
			if(successor(letter)) 
				sb.append(letter);
			else
				sb.append("No Successor");
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
