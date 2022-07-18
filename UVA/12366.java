import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class UVA12366 {
  private static int[] sort(int a,int b,int c) {
    if(a==b) 
      return new int[] {a,b,c};
    else if(b==c) 
      return new int[] {b,c,a};
    else
      return new int[] {a,c,b};
  }
  private static String sortResult(int[] sort) {
    Arrays.sort(sort);
    StringBuilder sb = new StringBuilder();
    sb.append(sort[0]).append(" ").append(sort[1]).append(" ").append(sort[2]).append("\n");
    return sb.toString();
  }
  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    while(true) {
      String s = bf.readLine();
      if(s.equals("0 0 0"))
        break;
      StringTokenizer st = new StringTokenizer(s);
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      if(a!=b && b!=c && a!=c) {
        sb.append("1 1 2\n");
      }else if(a==b && b==c) {
        if(a!=13) 
          sb.append(sortResult(new int[] {a+1,b+1,c+1}));
        else
          sb.append("*\n");
      }else {
        int[] sort = sort(a,b,c);
        if(sort[2]!=13) {
          if(sort[2]+1!=sort[0])
            sb.append(sortResult(new int[] {sort[0],sort[1],sort[2]+1}));
          else if(sort[0]!=13)
            sb.append(sortResult(new int[] {sort[0],sort[1],sort[2]+2}));
          else
            sb.append("1 1 1\n");
        }else {
          if(sort[0]!=13) {
            sb.append(sortResult(new int[] {1,sort[0]+1,sort[1]+1}));
          }else {
            sb.append("1 1 1\n");
          }
        }
      }
    }
    System.out.print(sb);
  }

}
