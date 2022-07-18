import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA12952 {

  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    while(true) {
      String s = bf.readLine();
      if(s==null || s.isEmpty())
        break;
      StringTokenizer st = new StringTokenizer(s);
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      if(a>=b) 
        sb.append(a).append("\n");
      else
        sb.append(b).append("\n");
    }
    System.out.print(sb);
  }
}
