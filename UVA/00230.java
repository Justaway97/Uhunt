import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Question230 {
	public static String returnBook(ArrayList<book>book,String name) {
		for(int i=0;i<book.size();i++)
			if(book.get(i).name.equals(name)) {
				if(i>0)
					return "Put \""+book.get(i).name+"\" after \""+book.get(i-1).name+"\"\n";
				else
					return "Put \""+book.get(i).name+"\" first\n";
			}
		return null;
	}
	public static int indexToRemove(ArrayList<book> book,String name) {
		for(int i=0;i<book.size();i++)
			if(book.get(i).name.equals(name))
				return i;
		return -1;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<book> book = new ArrayList<book>();
		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = bf.readLine();
			if(input.equals("END"))
				break;
			book.add(new book(input));
		}
		Collections.sort(book);
		ArrayList<book> borrow = new ArrayList<book>();
		ArrayList<book> Return = new ArrayList<book>();
		while(true) {
			String input = bf.readLine();
			if(input.equals("END"))
				break;
			StringTokenizer st = new StringTokenizer(input,"\"");
			String command = st.nextToken();
			if(command.equals("BORROW ")) {
				int indexToRemove = indexToRemove(book,st.nextToken());
				if(indexToRemove!=-1) {
					borrow.add(book.get(indexToRemove));
					book.remove(indexToRemove);
				}
			}else if(command.equals("RETURN ")) {
				String Name = st.nextToken();
				int indexToRemove = indexToRemove(borrow,Name);
				if(indexToRemove!=-1) {
					book.add(borrow.get(indexToRemove));
					Return.add(borrow.get(indexToRemove));
					borrow.remove(indexToRemove);
					Collections.sort(book);
				}
			}else {
				Collections.sort(Return);
				for(book e:Return)
					sb.append(returnBook(book,e.name));
				sb.append("END\n");
				Return.clear();
			}
		}
		System.out.print(sb);
	}
}
class book implements Comparable<book>{
	String author;
	String name;
	public book(String input) {
		StringTokenizer st = new StringTokenizer(input,"\"");
		name = st.nextToken();
		author = st.nextToken().substring(4);
	}
	@Override
	public int compareTo(book b) {
		int compare = this.author.compareTo(b.author);
		if(compare==0)
			compare = this.name.compareTo(b.name);
		return compare;
	}
	
}
