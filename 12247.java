import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA12247 {

  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    while(true) {
      String s = bf.readLine();
      if(s.equals("0 0 0 0 0"))
        break;
      StringTokenizer st = new StringTokenizer(s);
      ArrayList<Integer> list = new ArrayList<Integer>();
      for(int i=1;i<53;i++)
        list.add(i);
      int[] princess = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
      int[] prince = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),53};
      Arrays.sort(princess);
      Arrays.sort(prince);
      for(int i=0;i<princess.length;i++)
        list.remove(new Integer(princess[i]));
      for(int i=0;i<prince.length;i++)
        list.remove(new Integer(prince[i]));
      if(prince[0]>princess[2]) {
        int target = 1;
        while(!list.contains(target) && target<=52)
          target++;
        if(target==53)
          sb.append("-1\n");
        else
          sb.append(target).append("\n");
      }else if(prince[0]>princess[1] && princess[1]<52) {
        int target = princess[1]+1;
        while(!list.contains(target) && target<=52)
          target++;
        if(target==53)
          sb.append("-1\n");
        else
          sb.append(target).append("\n");
      }else if(prince[1]>princess[2] && princess[2]<52){
        int target = princess[2]+1;
        while(!list.contains(target) && target<=52)
          target++;
        if(target==53)
          sb.append("-1\n");
        else
          sb.append(target).append("\n");
      }else
        sb.append("-1\n");
    }
    System.out.print(sb);
  }
}
