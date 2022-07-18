import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class UVA00185 {
  private static HashMap<String,Integer> base = new HashMap<String,Integer>();
  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    base.put("i", 14);
    base.put("v", 5);
    base.put("x", 1);
    int[][] number = new int[10][3];
    number[0] = new int[]{1,0,0};
    number[1] = new int[]{2,0,0};
    number[2] = new int[]{3,0,0};
    number[3] = new int[]{1,1,0};
    number[4] = new int[]{0,1,0};
    number[5] = new int[]{1,1,0};
    number[6] = new int[]{2,1,0};
    number[7] = new int[]{3,1,0};
    number[8] = new int[]{1,0,1};
    number[9] = new int[]{0,0,1};
    StringBuilder sb = new StringBuilder();
    while(true) {
      int s = Integer.parseInt(bf.readLine());
      if(s==0)
        break;
      int i = base.get("i")*(s/10);
      int v = base.get("v")*(s/10);
      int x = base.get("x")*(s/10);
      int l = 0;
      int c = 0;
      for(int a=0;a<s/10;a++) {
        if(a!=s/10-1) {
          x += number[a][0]*10;
          l += number[a][1]*10;
          c += number[a][2]*10;
        }else {
          x += number[a][0]*(s%10+1);
          l += number[a][1]*(s%10+1);
          c += number[a][2]*(s%10+1);
        }
      }
      for(int a=0;a<s%10;a++) {
        i += number[a][0];
        v += number[a][1];
        x += number[a][2];
      }
      sb.append(s).append(": ")
      .append(i).append(" i, ")
      .append(v).append(" v, ")
      .append(x).append(" x, ")
      .append(l).append(" l, ")
      .append(c).append(" c")
      .append("\n");
    }
    System.out.print(sb);
  }
}
