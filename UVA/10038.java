public class Question10038 {
	public static String jolly(int[] n) {
		int[] num = new int[3001];
		for(int i=0;i<n.length-1;i++) {
			if(Math.abs(n[i]-n[i+1])>=n.length)
				return "Not jolly";
			if(num[Math.abs(n[i]-n[i+1])]==0)
				num[Math.abs(n[i]-n[i+1])]++;
			else
				return "Not jolly";
		}
		return "Jolly";
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) 
				arr[i]=sc.nextInt();
			System.out.println(jolly(arr));
		}
	}
}
