import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class UVA11678 {

  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    while(true) {
      String s = bf.readLine();
      if(s.trim().equals("0 0"))
        break;
      HashSet<Integer> alice = new HashSet<Integer>();
      StringTokenizer st = new StringTokenizer(bf.readLine());
      while(st.hasMoreTokens()) 
        alice.add(Integer.parseInt(st.nextToken()));
      HashSet<Integer> betty = new HashSet<Integer>();
      st = new StringTokenizer(bf.readLine());
      while(st.hasMoreTokens()) 
        betty.add(Integer.parseInt(st.nextToken()));
      int aliceSize = 0, bettySize = 0;
      for (Integer i : alice)
        if(!betty.contains(i))
          aliceSize++;
      for (Integer i : betty) 
        if(!alice.contains(i))
          bettySize++;
      sb.append(Math.min(aliceSize, bettySize)).append("\n");
    }
    System.out.print(sb);
  }

}
