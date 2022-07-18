public class Question10050 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			boolean[] day = new boolean[sc.nextInt()+1];
			int pol = sc.nextInt();
			for(int j=0;j<pol;j++) {
				int hartal = sc.nextInt();
				for(int k=hartal;k<day.length;k+=hartal)
					day[k] = true;
			}
			int count=0;
			for(int j=1;j<day.length;j++)
				if(day[j] && j%7!=6 && j%7!=0) {
					count++;System.out.println(j);}
			System.out.println("\t"+count);
		}
	}

}
