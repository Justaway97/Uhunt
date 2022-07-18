import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question10134 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(bf.readLine());
		bf.readLine();
		for(int i=0;i<n;i++) {
			if(i>0)
				sb.append("\n");
			int fish = 3;
			int bait = 0;
			int interval = 7;
			int caught = 0;
			int baitInstruction = 0;
			while(true) {
				String input = bf.readLine();
				if(input==null || input.isEmpty())
					break;
				if(bait==3 && input.equals("bait"))
					input = "lunch";
				if(bait==0 && input.equals("fish"))
					input = "lunch";
				if(input.trim().equals("fish")) {
					fish++;
					interval++;
					if(fish>=3 && interval>=7 && bait>=1) {
						caught++;
						fish = interval = 0;
						bait--;
					}
				}else if(input.trim().equals("bait")) {
					baitInstruction++;
					if(baitInstruction==2){
						bait++;
						baitInstruction=0;
					}
					interval++;
				}
				else if(input.trim().equals("lunch"))
					interval++;
			}
			sb.append(caught).append("\n");
		}
		System.out.print(sb);
	}
}
