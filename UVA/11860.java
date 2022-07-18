import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Question11860 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			String s;
			String[] word = new String[100001];
			int count=0;
			HashMap<String,Integer> map = new HashMap<String,Integer>();
			while(!(s = bf.readLine()).equals("END")) {
				StringTokenizer st = new StringTokenizer(s.toLowerCase()," 1234567890`~!@#$%^&*()_+-=[]\\{}|;':\"<>?,./\t");
				int k = st.countTokens();
				for(int j=count;j<count+k;j++) {
					word[j] = st.nextToken();
					map.put(word[j], 1);
				}
				count+=k;
			}
			int min = 0,max = 0,currdiff = Integer.MAX_VALUE;
			HashMap<String,Integer> find = new HashMap<String,Integer>();
			for(int j=0,k=0;j<count;j++) {
				find.put(word[j],find.getOrDefault(word[j],0)+1);
				while(map.size()==find.size()) {
					String delete = word[k];
					if(find.get(delete)==1) {
						int diff = j-k;
						if(currdiff>diff) {
							currdiff = diff;
							min = k;
							max = j;
						}
						find.remove(delete);
					}else 
						find.put(delete, find.get(delete)-1);
					k++;
				}
			}
			sb.append("Document ").append(i).append(": ").append(min+1).append(" ").append(max+1).append("\n");
		}
		System.out.print(sb);
	}
}
