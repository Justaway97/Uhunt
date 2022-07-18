import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Question12503 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		int cases = Integer.parseInt(bf.readLine());
		for(int i=0;i<cases;i++) {
			int count = Integer.parseInt(bf.readLine());
			String[] store = new String[count];
			int total=0;
			for(int j=0;j<count;j++) {
				String input = bf.readLine();
				if(input.length()<6)
					store[j]=input;
				if(input.length()>6) {
					if(input.substring(0,8).equals("SAME AS "))
						store[j]=store[Integer.parseInt(input.substring(8,input.length()))-1];
				}
				if(store[j].equals("LEFT"))
					total--;
				if(store[j].equals("RIGHT"))
					total++;
			}
			System.out.println(total);
		}

	}

}
