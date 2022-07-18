import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question127 {
	public static void matchNext(ArrayList<card> c,int x) {
		for(int i=x;i<c.size();i++) {
			if(c.get(i).card.size()==0) {
				c.remove(i);
				i--;
				continue;
			}
			if(i>=3 && (c.get(i).lastIndexChar0()==c.get(i-3).lastIndexChar0() || c.get(i).lastIndexChar1()==c.get(i-3).lastIndexChar1())) {
				c.get(i-3).add(c.get(i).getlast());
				c.get(i).remove();
				matchNext(c,i-3);
				return;
			}
			if(i>=1 && (c.get(i).lastIndexChar0()==c.get(i-1).lastIndexChar0() || c.get(i).lastIndexChar1()==c.get(i-1).lastIndexChar1())) {
				c.get(i-1).add(c.get(i).getlast());
				c.get(i).remove();
				matchNext(c,i-1);
				return;
			}
		}
	}
	public static void input(String input,ArrayList<card>c) {
		StringTokenizer st = new StringTokenizer(input," ");
		while(st.hasMoreTokens()) {
			c.add(new card(st.nextToken()));
			matchNext(c,c.size()-1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			ArrayList<card> c = new ArrayList<card>();
			String input = bf.readLine();
			if(input.equals("#"))
				break;
			input(input,c);
			input(bf.readLine(),c);
			if(c.size()>1)
				sb.append(String.valueOf(c.size())+" piles remaining:");
			else
				sb.append(String.valueOf(c.size())+" pile remaining:");
			for(int i=0;i<c.size();i++)
				sb.append(" "+String.valueOf(c.get(i).cardsize()));
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
class card{
	ArrayList<String> card = new ArrayList<String>();
	public card(String card) {
		this.card.add(card);
	}
	char lastIndexChar0() {
		return card.get(card.size()-1).charAt(0);
	}
	char lastIndexChar1() {
		return card.get(card.size()-1).charAt(1);
	}
	void add(String s) {
		card.add(s);
	}
	String getlast() {
		return card.get(card.size()-1);
	}
	void remove() {
		card.remove(card.size()-1);
	}
	int cardsize() {
		return card.size();
	}
}
