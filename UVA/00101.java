import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question101 {
	public static void checkposition(int[] position,ArrayList<Integer>[] block) {
		for(int i=0;i<block.length;i++) 
			for(int j=0;j<block[i].size();j++) 
				position[block[i].get(j)]=i;
	}
	public static void remove(ArrayList<Integer>[] block,int x,int i) {
		for(int j=block[i].size()-1;j>block[i].indexOf(x);j--) {
			block[block[i].get(j)].add(block[i].get(j));
			block[i].remove(j);
		}
		block[i].remove(block[i].indexOf(x));
	}
	public static void op1(ArrayList<Integer>[] block,int a,int b) {
		int indexB = -1;
		for(int i=0;i<block.length;i++) {
			if(block[i].contains(a)) 
				remove(block,a,i);
			if(block[i].contains(b)) {
				remove(block,b,i);
				indexB=i;
			}
		}
		block[indexB].add(b);
		block[indexB].add(a);
	}
	public static void op2(ArrayList<Integer>[] block,int a,int b) {
		int indexB = -1;
		for(int i=0;i<block.length;i++) {
			if(block[i].contains(b)) 
				indexB = i;
			if(block[i].contains(a)) 
				remove(block,a,i);
		}
		block[indexB].add(a);
	}
	public static void remove2(ArrayList<Integer>[] block,int indexA,int indexB,int a) {
		for(int i=block[indexA].indexOf(a);i<block[indexA].size();) {
			block[indexB].add(block[indexA].get(i));
			block[indexA].remove(i);
		}
	}
	public static void op3(ArrayList<Integer>[] block,int a,int b) {
	int indexB=-1,indexA=-1;
		for(int i=0;i<block.length;i++) {
			if(block[i].contains(b)) {
				remove(block,b,i);
				indexB=i;
				block[i].add(b);
			}
			if(block[i].contains(a))
				indexA=i;
		}
		remove2(block,indexA,indexB,a);
	}
	public static void op4(ArrayList<Integer>[] block,int a,int b) {
		int indexA=-1,indexB=-1;
		for(int i=0;i<block.length;i++) {
			if(block[i].contains(a)) 
				indexA=i;
			if(block[i].contains(b))
				indexB=i;
		}
		remove2(block,indexA,indexB,a);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		ArrayList<Integer>[] block = new ArrayList[n];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<block.length;i++) {
			block[i] = new ArrayList<Integer>();
			block[i].add(i);
		}
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			if(st.countTokens()==1)
				break;
			String ins1 = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			String ins2 = st.nextToken();
			int b = Integer.parseInt(st.nextToken());
			int[] position = new int[n];
			checkposition(position,block);
			if(a==b || position[a]==position[b])continue;
			if(ins1.equals("move") && ins2.equals("onto"))
				op1(block,a,b);
			else if(ins1.equals("move") && ins2.equals("over"))
				op2(block,a,b);
			else if(ins1.equals("pile") && ins2.equals("onto"))
				op3(block,a,b);
			else if(ins1.equals("pile") && ins2.equals("over"))
				op4(block,a,b);
		}
		for(int i=0;i<n;i++) {
			sb.append(String.valueOf(i)+":");
			if(block[i].size()==0)
				sb.append("\n");
			else {
				for(int j=0;j<block[i].size();j++) 
					sb.append(String.valueOf(" "+block[i].get(j)));
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}
