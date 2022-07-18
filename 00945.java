import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Question945 {
	private static int[] cargo;
	private static int[] pkg;
	private static ArrayList<String>[] result;
	private static int selected,cargoWeight,total,unload,unused;
	private static boolean rule1(int p) {
		int min = Integer.MAX_VALUE;
		ArrayList<Integer> index = new ArrayList<Integer>();
		for(int i=0;i<result.length;i++) {
			if(min==result[i].size())
				index.add(i);
			else if(result[i].size()<min) {
				min=result[i].size();
				index.clear();
				index.add(i);
			}
		}
		if(index.size()==0)
			return false;
		return rule2(p,index);
	}
	private static boolean rule2(int p,ArrayList<Integer> index) {
		int size = 0;
		ArrayList<Integer> index1 = new ArrayList<Integer>();
		for(int i=0;i<index.size();i++) {
			if(size==cargo[index.get(i)])
				index1.add(index.get(i));
			else if(cargo[index.get(i)]>size) {
				size = cargo[index.get(i)];
				index1.clear();
				index1.add(index.get(i));
			}
		}
		if(index1.size()==0)
			return false;
		selected = index1.get(0);
		cargo[selected]-=p;
		if(cargo[selected]<0)
			return false;
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int x=0;
		while(true) {
			if(x>0) {
				String input1 = bf.readLine();
				if(input1==null)
					break;
			}
			String input = bf.readLine();
			if(input==null || input.isEmpty())
				break;
			if(x>0)
				System.out.println();
			int n = Integer.parseInt(input.trim());
			StringBuilder sb = new StringBuilder();
			cargo = new int[n];
			cargoWeight = total = unload = unused = 0;
			for(int i=0;i<n;i++) {
				cargo[i] = Integer.parseInt(bf.readLine().trim());
				unused+=cargo[i];
			}
			bf.readLine();
			int m = Integer.parseInt(bf.readLine().trim());
			pkg = new int[m];
			result = new ArrayList[n];
			for(int i=0;i<result.length;i++)
				result[i] = new ArrayList<String>();
			for(int i=0;i<m;i++) {
				pkg[i] = Integer.parseInt(bf.readLine().trim());
				total+=pkg[i];
			}
			for(int i=0;i<m;i++) {
				selected=-1;
				if(rule1(pkg[i])) 
					result[selected].add(String.valueOf(pkg[i]));
				else
					break;
				cargoWeight+=pkg[i];
			}
			unload = total-cargoWeight;
			unused-=cargoWeight;
			int max = 0;
			for(int i=0;i<result.length;i++)
				max = Math.max(result[i].size(), max);
			for(int i=max-1;i>=0;i--) {
				for(int j=0;j<cargo.length;j++) {
					if(i+1<=result[j].size()) {
						if(j==0)
							sb.append(result[j].get(i));
						else	
							sb.append(" ").append(result[j].get(i));
					}else {
						if(j==0)
							sb.append(":");
						else	
							sb.append(" :");
					}
				}
				sb.append("\n");
			}
			for(int i=1;i<n;i++)
				sb.append("==");
			sb.append("=\n");
			for(int i=1;i<n;i++)
				sb.append(i).append(" ");
			sb.append(n).append("\n\n").append("cargo weight: ").append(cargoWeight).append("\n").append("unused weight: ").append(unused).append("\n").append("unloaded weight: ").append(unload).append("\n");
			System.out.print(sb);
			x++;
		}
	}
}