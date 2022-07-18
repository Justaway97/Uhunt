import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question253 {
	public static String[] rotation = new String[24];
	public static void rotate() {
		rotation[0]=("1 2 3 4 5 6");
		rotation[1]=("1 3 5 2 4 6");
		rotation[2]=("1 4 2 5 3 6");
		rotation[3]=("1 5 4 3 2 6");
		rotation[4]=("2 1 4 3 6 5");
		rotation[5]=("2 3 1 6 4 5");
		rotation[6]=("2 4 6 1 3 5");
		rotation[7]=("2 6 3 4 1 5");
		rotation[8]=("3 1 2 5 6 4");
		rotation[9]=("3 2 6 1 5 4");
		rotation[10]=("3 5 1 6 2 4");
		rotation[11]=("3 6 5 2 1 4");
		rotation[12]=("4 1 5 2 6 3");
		rotation[13]=("4 2 1 6 5 3");
		rotation[14]=("4 5 6 1 2 3");
		rotation[15]=("4 6 2 5 1 3");
		rotation[16]=("5 1 3 4 6 2");
		rotation[17]=("5 3 6 1 4 2");
		rotation[18]=("5 4 1 6 3 2");
		rotation[19]=("5 6 4 3 1 2");
		rotation[20]=("6 2 4 3 5 1");
		rotation[21]=("6 3 2 5 4 1");
		rotation[22]=("6 4 5 2 3 1");
		rotation[23]=("6 5 3 4 2 1");
	}
	public static boolean exist(String initial,String change,String rotate) {
		StringTokenizer st = new StringTokenizer(rotate);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<initial.length();i++)
			sb.append(initial.charAt(Integer.parseInt(st.nextToken())-1));
		if(change.equals(sb.toString()))
			return true;
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		rotate();
		while(true) {
			String input = bf.readLine();
			if(input==null)
				break;
			String initial = input.substring(0, 6);
			String change = input.substring(6,12);
			boolean flag=false;
			for(int i=0;i<rotation.length;i++) 
				if(exist(initial,change,rotation[i])) {
					sb.append("TRUE\n");
					flag=true;
					break;
				}
			if(!flag)
				sb.append("FALSE\n");
		}
		System.out.print(sb);
	}
}
