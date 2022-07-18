import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question10300 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		int cases = Integer.parseInt(bf.readLine());
		for(int i=0;i<cases;i++) {
			long product=0L;
			int farmer = Integer.parseInt(bf.readLine());
			for(int j=0;j<farmer;j++) {
				String input = bf.readLine();
				StringTokenizer st = new StringTokenizer(input," ");
				long area = Long.parseLong(st.nextToken());
				long animalspace = Long.parseLong(st.nextToken());
				long parameter = Long.parseLong(st.nextToken());
				product+=(area*parameter);
			}
			System.out.println(product);
		}
		
		

	}

}
