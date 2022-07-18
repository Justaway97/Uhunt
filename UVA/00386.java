import java.util.TreeSet;

public class Question386 {
	public static void count(TreeSet<number>tree) {
		for(int i=2;i<=200;i++) 
			for(int j=i+1;j<=147;j++) 
				for(int k=j+1;k<=197;k++) {
					int x = i*i*i+j*j*j+k*k*k;
					if(x>8000000)
						continue;
					if(Math.cbrt(x)==(int)Math.cbrt(x)) {
						StringBuilder sb1 = new StringBuilder();
						sb1.append("Cube = ").append((int)Math.cbrt(x)).append(", Triple = (").append(i).append(",").append(j).append(",").append(k).append(")\n");
						tree.add(new number((int)Math.cbrt(x),sb1.toString(),i,j,k));
					}
				}
	}
	public static void main(String[] args) {
		TreeSet<number> tree = new TreeSet<number>();
		StringBuilder sb = new StringBuilder();
		count(tree);
		while(!tree.isEmpty()) {
			number n = tree.pollFirst();
			if(n.a>200)
				break;
			sb.append(n.s);
		}
		System.out.print(sb);
	}
}
class number implements Comparable<number>{
	int a,b,c,d;
	String s;
	public number(int x,String s,int i,int j,int k) {
		a=x;
		this.s=s;
		b=i;
		c=j;
		d=k;
	}
	@Override
	public int compareTo(number n) {
		int compare = this.a-n.a;
		if(compare==0)
			compare = this.b-n.b;
		if(compare==0)
			compare = this.c-n.c;
		if(compare==0)
			compare = this.d-n.d;
		if(compare==0)
			compare = this.s.compareTo(n.s);
		return compare;
	}
}