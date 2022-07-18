import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Question1203 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Register> queue = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = bf.readLine();
			if(input.equals("#"))
				break;
			StringTokenizer st = new StringTokenizer(input);
			st.nextToken();
			queue.add(new Register(st.nextToken(),Integer.parseInt(st.nextToken())));
		}
		int result = Integer.parseInt(bf.readLine());
		for(int i=0;i<result;i++) {
			Register r = queue.poll();
			sb.append(r.name);
			sb.append("\n");
			r.update();
			queue.offer(r);
		}
		System.out.print(sb);
	}
}
class Register implements Comparable<Register>{
	String name;
	int value;
	int add;
	public Register(String name,int add) {
		this.name = name;
		value = add;
		this.add = add;
	}
	void update() {
		this.value+=add;
	}
	@Override
	public int compareTo (Register r) {
		if (this.value!=r.value) 
			return this.value-r.value;
		return Integer.parseInt(this.name)-Integer.parseInt(r.name);
	}
}
