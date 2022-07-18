import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA10530 {

  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    while(true) {
      boolean honest = true,existMax = false, existMin = false;
      int max = Integer.MAX_VALUE,min = 0;
      int s = Integer.parseInt(bf.readLine().trim());
      if(s==0)
        break;
      String t = bf.readLine();
      if(t.equals("right on")) {
        sb.append("Stan may be honest\n");
        continue;
      }
      if(t.equals("too high")) {
        existMax = true;
        max = Math.min(s, max);
      }else if(t.equals("too low")) {
        existMin = true;
        min = Math.max(s, min);
      }
      while(true) {
        s = Integer.parseInt(bf.readLine().trim());
        t = bf.readLine();
        if(t.equals("right on")) {
          if((existMax && s>=max) || (existMin && s<=min))
            honest = false;
          break;
        }
        if(t.equals("too high")) {
          existMax = true;
          max = Math.min(s, max);
        }
        if(t.equals("too low")) { 
          existMin = true;
          min = Math.max(s, min);
        }
      }
      if(honest)
        sb.append("Stan may be honest\n");
      else
        sb.append("Stan is dishonest\n");
    }
    System.out.print(sb);
  }
}
