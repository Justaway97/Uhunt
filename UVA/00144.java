import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question144 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String input = bf.readLine();
			if(input.equals("0 0"))
				break;
			StringTokenizer st = new StringTokenizer(input," ");
			int[] stu = new int[Integer.parseInt(st.nextToken())+1];
			int limit = Integer.parseInt(st.nextToken());
			ArrayList<Integer> result = new ArrayList<Integer>();
			for(int i=1,j=1,currj=1;result.size()<stu.length-1;i++) {
				if(j==0)
					j=currj;
				if(i==stu.length)
					i=1;
				if(j==limit+1)
					j=currj=1;
				if(stu[i]+j<=40) {
					stu[i]+=j;
					if(j==currj) {
						j++;
						currj=j;
					}else {
						currj++;
						j=currj;
					}
					if(stu[i]==40 && !result.contains(i))
						result.add(i);
				}else if(stu[i]<40 && stu[i]+j>40) {
					j=stu[i]+j-40;
					stu[i]=40;
					if(!result.contains(i))
						result.add(i);
				}else {
					if(!result.contains(i))
						result.add(i);
				}
			}
			for(int i=0;i<result.size();i++) {
				if(result.get(i)<10)
					System.out.print(" ");
				System.out.print(" "+result.get(i));
			}System.out.println();
		}
	}
}