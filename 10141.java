import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question10141 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader( new InputStreamReader (System.in));
		for(int z=1;;z++) {
			String input = bf.readLine();
			if(input.equals("0 0") || input==null)
				break;
			if(z>1)
				System.out.println();
			StringTokenizer st = new StringTokenizer(input," ");
			int numofreq = Integer.parseInt(st.nextToken());
			int numofpro = Integer.parseInt(st.nextToken());
			for(int i=0;i<numofreq;i++)
				input = bf.readLine();
			int max=0;
			double low=0.0;
			String rfp = "";
			for(int i=0;i<numofpro;i++) {
				String input2 = bf.readLine();
				String input1 = bf.readLine();
				st = new StringTokenizer(input1," ");
				double price = Double.parseDouble(st.nextToken());
				int req = Integer.parseInt(st.nextToken());
				for(int j=0;j<req;j++)
					input=bf.readLine();
				if((req==max && low>price)||req>max) {
						rfp=input2;
						low=price;
						max=req;
				}
			}
			System.out.println("RFP #"+z);
			System.out.println(rfp);
		}
	}

}
