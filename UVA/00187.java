import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question187 {
	public static DecimalFormat df = new DecimalFormat("0.00");
	public static DecimalFormat df1 = new DecimalFormat("000");
	public static String[] store = new String[1000];
	public static ArrayList<String>[] transaction = new ArrayList[1000];
	public static double[] balance = new double[1000];
	public static ArrayList<Integer> position = new ArrayList<Integer>();
	public static String space(String r2) {
		String space="";
		for(int i=r2.length();i<10;i++)
			space+=" ";
		return space;
	}
	public static void display(double[] balance,ArrayList<String>[] transaction,ArrayList<Integer>position) {
		for(int i=0;i<position.size();i++) {
			if(balance[position.get(i)]!=0) {
				System.out.println("*** Transaction "+df1.format(position.get(i))+" is out of balance ***");
				for(int j=0;j<transaction[position.get(i)].size();j++) {
					StringTokenizer result = new StringTokenizer(transaction[position.get(i)].get(j),"\t");
					System.out.print(result.nextToken()+" ");
					String r = result.nextToken();
					System.out.print(r);
					for(int k=r.length();k<31;k++)
						System.out.print(" ");
					String r2 = result.nextToken();
					r2 = df.format(Double.parseDouble(r2));
					System.out.println(space(r2)+r2);
				}
				String b = df.format(balance[position.get(i)]*-1);
				System.out.println("999 Out of Balance                 "+space(b)+b+"\n");
			}
		}
	}
	public static void main(String[] args) throws Exception {
		for(int i=0;i<transaction.length;i++)
			transaction[i]=new ArrayList<String>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String input = bf.readLine();
			String front = input.substring(0, 3);
			if(front.equals("000"))
				break;
			store[Integer.parseInt(front)]=input.substring(3, input.length());
		}
		String c="";
		while(true) {
			String input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			String token = st.nextToken();
			if(token.equals("000000") || token.substring(0,3).equals("000"))
				break;
			String b = st.nextToken();
			transaction[Integer.parseInt(token.substring(0,3))].add(token.substring(3,6)+"\t"+store[Integer.parseInt(token.substring(3,6))]+"\t"+String.valueOf(Double.parseDouble(b)/100));
			balance[Integer.parseInt(token.substring(0,3))]+=Double.parseDouble(b)/100;
			if(!c.equals(token.substring(0,3))) {
				position.add(Integer.parseInt(token.substring(0,3)));
				c = token.substring(0,3);
			}
		}
		display(balance,transaction,position);
	}
}
