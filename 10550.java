import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Question10550 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
	       for(;;) {
	    	   String input = bf.readLine();
	    	   if(input.equals("0 0 0 0"))
					break;
	    	   StringTokenizer st = new StringTokenizer(input," ");
	    	   int start = Integer.parseInt(st.nextToken());
	    	   int start1 = Integer.parseInt(st.nextToken());
	    	   int start2 = Integer.parseInt(st.nextToken());
	    	   int start3 = Integer.parseInt(st.nextToken());
	    	   int first = (start-start1)*360/40;
	    	   if(start1>start)
	    		   first = 360+first;
	    	   int second = (start2-start1)*360/40;
	    	   if(start1>start2)
	    		   second = 360+second;
	    	   int third = (start2-start3)*360/40;
	    	   if(start3>start2)
	    		   third = 360+third;
	    	   System.out.println(360*3+first+second+third);
		}
	}
}
//question wrong not dial clockwise is anti-clockwise