import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Question603 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cases = Integer.parseInt(bf.readLine());
		bf.readLine();
		for(int i=0;i<cases;i++) {
			if(i>0 && i<cases)
				sb.append("\n");
			ArrayList<Integer> pos = new ArrayList<Integer>();
			ArrayList<Integer> ori = new ArrayList<Integer>();
			while(true) {
				int car = Integer.parseInt(bf.readLine());
				if(car==99)
					break;
				pos.add(car);
				ori.add(car);
			}
			boolean[] flag = new boolean[pos.size()];
			String[] result = new String[pos.size()];
			ArrayList<Integer> location = new ArrayList<Integer>();
			while(true) {
				String input = bf.readLine();
				if(input==null || input.isEmpty())
					break;
				location.add(Integer.parseInt(input));
			}
			while(!location.isEmpty()) {
				int min = Integer.MAX_VALUE,index=-1;
				int locate = location.remove(0);
				for(int k=0;k<pos.size();k++) {
					if(!flag[k]) {
						int temp = locate-pos.get(k);
						if(temp<0)
							temp+=20;
						if(temp<min) {
							min = temp;
							index = k;
						}
					}
				}
				if(index==-1)
					break;
				for(int k=0;k<pos.size();k++) {
					pos.set(k, pos.get(k)+min);
					if(pos.get(k)>20)
						pos.set(k, pos.get(k)-20);
				}
				flag[index] = true;
				StringBuilder sb1 = new StringBuilder();
				sb1.append("Original position ").append(ori.get(index)).append(" parked in ").append(locate).append("\n");
				result[index] = sb1.toString();
				
			}
			for(int j=0;j<result.length;j++) {
				if(result[j]==null)
					sb.append("Original position ").append(ori.get(j)).append(" did not park\n");
				else
					sb.append(result[j]);
			}
		}
		System.out.print(sb);
	}	
}
