import java.util.Scanner;

public class Question637 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int page = sc.nextInt();
			int sheet = page;
			if(page==0)
				break;
			if(page==1)
				sheet = 1;
			else if(page%4!=0)
				sheet = (page+4-(page%4))/2;
			else if(page%4==0)
				sheet = page/2;
			System.out.println("Printing order for "+page+" pages:");
			boolean flag=false,flag1=false;
			for(double i=1,j=1,k=1;k<=sheet;i+=0.5,j++,k++) {
				if(i==(int)i) {
					System.out.print("Sheet "+(int)i+", front: ");
					if((page+j)%4!=1) {
						System.out.println("Blank, "+(int)j);
					}else {
						System.out.println(page+", "+(int)j);
						flag=true;
						page--;
					}
				}else {
					System.out.print("Sheet "+(int)i+", back : ");
					if((page+j)%4!=1) {
						System.out.println((int)j+", Blank");
					}else {
						System.out.println((int)j+", "+page);
						flag1=true;
						page--;
					}
				}
			}
		}
	}
}
