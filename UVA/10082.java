import java.util.Scanner;

public class Question10082 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String[] line = {"`1234567890-=","QWERTYUIOP[]\\","ASDFGHJKL;'","ZXCVBNM,./"};
		while(sc.hasNext()) {
			String s = sc.nextLine();
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)==' ')
					System.out.print(" ");
				else
					for(int j=0;j<line.length;j++) {
						for(int k=0;k<line[j].length();k++) {
							if(s.charAt(i)==line[j].charAt(k)) {
								if(k==0)
									System.out.print(line[j].charAt(k));
								else
									System.out.print(line[j].charAt(k-1));
							}
					}
				}
			}
			System.out.println();
		}
	}
}
