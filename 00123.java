import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Question123 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<String> NotCount = new ArrayList<String>();
		while(true) {
			String input = bf.readLine();
			if(input.equals("::"))
				break;
			NotCount.add(input);
		}
		ArrayList<title> sorted = new ArrayList<title>();
		while(true) {
			String input = bf.readLine();
			if(input==null || input.equals(""))
				break;
			input = input.toLowerCase();
			StringTokenizer st = new StringTokenizer(input," ");
			int length = st.countTokens();
			while(st.hasMoreTokens()) {
				String word = st.nextToken();
				if(!NotCount.contains(word))
					sorted.add(new title(input,word,length-st.countTokens()));
			}
		}
		Collections.sort(sorted);
		for(int i=0;i<sorted.size();i++) 
			sb.append(sorted.get(i).sb+"\n");
		System.out.print(sb);
		
	}
}
class title implements Comparable<title>{
	String selectedWord;
	StringBuilder sb = new StringBuilder();
	title(String input,String selected,int position){
		int x=0,index=0;
		boolean flag=true;
		for(index=0;x<position;index++) {
			if(input.charAt(index)!=' ' && flag) {
				x++;
				flag=false;
				index--;
			}else if(input.charAt(index)==' ')
				flag=true;
		}
		sb.append(input.substring(0, index)+selected.toUpperCase()+input.substring(index+selected.length(),input.length()));
		selectedWord = selected;
	}
	@Override
	public int compareTo(title newtitle) {
		int compare = selectedWord.compareTo(newtitle.selectedWord);
		return compare;
	}
}
