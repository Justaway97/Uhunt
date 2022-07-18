import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Question170 {
	static DecimalFormat df = new DecimalFormat("00");
	public static String count(String[] store,String currCard,int count) {
		int position = number(currCard);
		String remove="";
		try {
			remove = store[position].substring(0,2);
		}catch(Exception e) {return df.format(count)+","+currCard;}
		store[position]=store[position].substring(2, store[position].length());
		count++;
		return count(store,remove,count);
	} 		 
	public static int number(String input) {
		if(input.charAt(0)=='A')
			return 1;
		String letter = "TJQK";
		for(int i=0;i<letter.length();i++)
			if(input.charAt(0)==letter.charAt(i))
				return i+10;
		return Character.getNumericValue(input.charAt(0));
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));
		boolean flag=true;
		while(flag) {
			String[] store = new String[14];
			Arrays.fill(store,"");
			String first = "";
			for(int i=0;i<4;i++) {
				String input=bf.readLine();
				if(input.equals("#")) {
					flag=false;
					break;
				}
				StringTokenizer st = new StringTokenizer(input," ");
				for(int j=13;j>0 && flag;j--) {
					String s = st.nextToken();
					store[j]+=s;
					if(i==0 && j==13) {
						first=store[13];
						store[13]="";
					}
				}
			}
			if(flag)
				System.out.printf("%s\n", count(store,first,1));
		}
	}
}
