import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question11219 {

	public static int count(String currentdate,String birthdate) {
		if(Integer.parseInt(currentdate.substring(3,5))==Integer.parseInt(birthdate.substring(3,5))) {
			if(Integer.parseInt(currentdate.substring(0,2))==Integer.parseInt(birthdate.substring(0,2)))
				return Integer.parseInt(currentdate.substring(6,10))-Integer.parseInt(birthdate.substring(6,10));
			if(Integer.parseInt(currentdate.substring(0,2))<Integer.parseInt(birthdate.substring(0,2)))
				return Integer.parseInt(currentdate.substring(6,10))-Integer.parseInt(birthdate.substring(6,10))-1;
		}
		if(Integer.parseInt(currentdate.substring(3,5))<Integer.parseInt(birthdate.substring(3,5)))
			return Integer.parseInt(currentdate.substring(6,10))-Integer.parseInt(birthdate.substring(6,10))-1;
		else
			return Integer.parseInt(currentdate.substring(6,10))-Integer.parseInt(birthdate.substring(6,10));
	}
	public static boolean zero(String currentdate,String birthdate) {
		if(Integer.parseInt(birthdate.substring(6,10))==Integer.parseInt(currentdate.substring(6,10)))
			return true;
		if(Integer.parseInt(birthdate.substring(6,10))==Integer.parseInt(currentdate.substring(6,10))+1) {
			if(Integer.parseInt(birthdate.substring(3,5))==Integer.parseInt(currentdate.substring(3,5)))
				if(Integer.parseInt(birthdate.substring(6,10))>Integer.parseInt(currentdate.substring(6,10)))
					return true;
				else
					return false;
			else if(Integer.parseInt(birthdate.substring(3,5))>Integer.parseInt(currentdate.substring(3,5)))
				return true;
			else	
				return false;
		}
		return false;
	}
	public static boolean check(String currentdate,String birthdate) {
		if(Integer.parseInt(birthdate.substring(6,10))<Integer.parseInt(currentdate.substring(6,10))-131)
			return true;
		if(Integer.parseInt(birthdate.substring(6,10))<Integer.parseInt(currentdate.substring(6,10))-130) {
			if(Integer.parseInt(birthdate.substring(3,5))==Integer.parseInt(currentdate.substring(3,5)))
				if(Integer.parseInt(birthdate.substring(0,2))<=Integer.parseInt(currentdate.substring(0,2)))
					return true;
				else
					return false;
			else if(Integer.parseInt(birthdate.substring(3,5))<Integer.parseInt(currentdate.substring(3,5)))
				return true;
			else	
				return false;
		}
		return false;
	}
	public static boolean invalid (String currentdate,String birthdate) {
		if(Integer.parseInt(birthdate.substring(6,10))>Integer.parseInt(currentdate.substring(6,10)))
			return true;
		if(Integer.parseInt(birthdate.substring(6,10))==Integer.parseInt(currentdate.substring(6,10))) {
			if(Integer.parseInt(birthdate.substring(3,5))==Integer.parseInt(currentdate.substring(3,5)))
				if(Integer.parseInt(birthdate.substring(0,2))>Integer.parseInt(currentdate.substring(0,2)))
					return true;
				else
					return false;
			else if(Integer.parseInt(birthdate.substring(3,5))>Integer.parseInt(currentdate.substring(3,5)))
				return true;
			else	
				return false;
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(bf.readLine());
		for(int i=1;i<=cases;i++) {
			bf.readLine();
			String currentdate = bf.readLine();
			String birthdate = bf.readLine();
			System.out.print("Case #"+i+": ");
			if(currentdate.equals(birthdate))
				System.out.println("0");
			else if(invalid(currentdate,birthdate))
				System.out.println("Invalid birth date");
			else if(check(currentdate,birthdate))
				System.out.println("Check birth date");
			else if(zero(currentdate,birthdate))
				System.out.println("0");
			else 
				System.out.println(count(currentdate,birthdate));
		}
	}
}
