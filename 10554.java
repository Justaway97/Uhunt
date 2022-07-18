import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question10554 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int count=0;
		ArrayList<String> store = new ArrayList();
		double[] content = {9,4,4,4,7};
		while(true) {
			String input = bf.readLine();
			if(input.equals("-")) {
				count++;
				if(count==2)
					break;
				if(store.size()>0) {
					double total = 0;
					double curr = 0;
					for(int i=0;i<store.size();i++) {
						StringTokenizer st = new StringTokenizer(store.get(i)," ");
						double calory = 0;
						double percent = 0;
						boolean flag1=false;
						double currpercent = 0;
						for(int j=0;j<5;j++) {
							String element = st.nextToken();
							if(element.charAt(element.length()-1)=='g') {
								calory += content[j]*Double.parseDouble(element.substring(0,element.length()-1));
								if(j==0)
									curr += calory;
							}else if(element.charAt(element.length()-1)=='C') {
								calory += Double.parseDouble(element.substring(0,element.length()-1));
								if(j==0)
									curr += calory;
							}else {
								percent += Double.parseDouble(element.substring(0,element.length()-1));
								if(j==0) {
									flag1=true;
									currpercent = percent;
								}
							}
						}
						total += calory*100/(100-percent);
						if(flag1) 
							curr += calory*currpercent/(100-percent);
					}
					System.out.println((int)(curr*100/total+0.5)+"%");
				}
				store.clear();
			}else {
				count=0;
				store.add(input);
			}
		}
	}
}
