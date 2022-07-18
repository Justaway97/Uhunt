import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question10919 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		for(;;) {
			String input = bf.readLine();
			if(input.equals("0"))
				break;
			StringTokenizer st = new StringTokenizer(input," ");
			int numofcourse = Integer.parseInt(st.nextToken());
			int setofpickedcourse = Integer.parseInt(st.nextToken());
			String input1 = bf.readLine();
			st = new StringTokenizer(input1," ");
			String[] store = new String[numofcourse];
			for(int i=0;i<numofcourse;i++) {
				store[i]=st.nextToken();
			}
			boolean flag=true;
			for(int i=0;i<setofpickedcourse;i++) {
				int count=0;
				String input2 = bf.readLine();
				st = new StringTokenizer(input2," ");
				int coursegiven = Integer.parseInt(st.nextToken());
				int courseselected = Integer.parseInt(st.nextToken());
				for(int j=0;j<coursegiven;j++) {
					String code = st.nextToken();
					for(int k=0;k<store.length;k++) {
						if(code.equals(store[k])) {
							count++;
							break;
						}
					}
				}
				if(flag && count<courseselected)
					flag=false;
			}
			if(flag)
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
}
