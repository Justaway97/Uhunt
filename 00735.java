import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Question735 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> all = new ArrayList<Integer>();
		for(int i=0;i<=20;i++)
			all.add(i);
		for(int i=21;i<=60;i++)
			if((i%2==0 && i<=40) || i%3==0 || i==50)
				all.add(i);
		while(true) {
			int n = Integer.parseInt(bf.readLine().trim());
			if(n<=0)
				break;
			int permutation=0,combination=0;
			for(int i=0;i<all.size();i++) 
				for(int j=0;j<all.size();j++) 
					for(int k=0;k<all.size();k++)
						if(all.get(i)+all.get(j)+all.get(k)==n){
							permutation++;
							if(i<=j && j<=k)
								combination++;
						}
			if(permutation>0 && combination>0) {
				sb.append("NUMBER OF COMBINATIONS THAT SCORES ").append(n).append(" IS ").append(combination).append(".\n");
				sb.append("NUMBER OF PERMUTATIONS THAT SCORES ").append(n).append(" IS ").append(permutation).append(".\n**********************************************************************\n");
			}else
				sb.append("THE SCORE OF ").append(n).append(" CANNOT BE MADE WITH THREE DARTS.\n**********************************************************************\n");
		}
		sb.append("END OF OUTPUT\n");
		System.out.print(sb);
	}
}
