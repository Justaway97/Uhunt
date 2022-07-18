public class Question591 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count=1;
		while(true) {
			int n = sc.nextInt();
			if(n==0)
				break;
			int sum=0,diff=0;
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
				sum+=arr[i];
			}
			for(int i=0;i<arr.length;i++)
				if(sum/n<arr[i])
					diff+=arr[i]-sum/n;
			System.out.println("Set #"+count+"\nThe minimum number of moves is "+diff+".");
			count++;System.out.println();
		}
	}
}
