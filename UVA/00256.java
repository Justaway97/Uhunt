import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Question256 {
	public static void find(int i,int ilimit,ArrayList<String>[] result,DecimalFormat df,int pos,int mid) {
		result[pos].add(df.format(0));
		result[pos].add(df.format(1));
		for(;i<ilimit;i++) {
			int s = i*i;
			int left = Integer.parseInt(df.format(s).substring(0, mid));
			int right = Integer.parseInt(df.format(s).substring(mid, df.format(s).length()));
			if(left+right!=i)
				continue;
			result[pos].add(df.format(s));
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String>[] result = new ArrayList[4];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<4;i++) 
			result[i] = new ArrayList<String>();
		find(4,10,result,new DecimalFormat("00"),0,1);
		find(10,100,result,new DecimalFormat("0000"),1,2);
		find(100,1000,result,new DecimalFormat("000000"),2,3);
		find(1000,10000,result,new DecimalFormat("00000000"),3,4);
		while(true) {
			String input = bf.readLine();
			if(input==null || input.isEmpty())
				break;
			int n = Integer.parseInt(input);
			for(int i=0;i<result[n/2-1].size();i++)
				sb.append(result[n/2-1].get(i)).append("\n");
		}
		System.out.print(sb);
	}
}
