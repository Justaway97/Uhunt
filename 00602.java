import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA00602 {
  private static int[] checkLeap(int year) {
    int[] dayOfMonth = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
    if(leapYear(year))
      dayOfMonth[1]++;
    return dayOfMonth;
  }
  private static int newYearDay(int year) {
    int count = 1;
    for(int i=0;i<year;i++) 
      if(leapYear(i))
        count+=2;
      else
        count++;
    if(year>0)
      count--;
    return count+3;
  }
  private static boolean leapYear(int year) {
    if((year<=1700 && year%4==0) || (year>1700 && (year%400==0 || (year%100!=0 && year%4==0))))
      return true;
    return false;
  }
  public static void main(String[] args) throws Exception {
    String[] date = new String[]{"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    String[] m = new String[] {"January","February","March","April","May","June","July","August","September","October","November","December"};
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    while(true) {
      StringTokenizer st = new StringTokenizer(bf.readLine());
      int month = Integer.parseInt(st.nextToken());
      int day = Integer.parseInt(st.nextToken());
      int year = Integer.parseInt(st.nextToken());
      if(month==0 && day==0 && year==0)
        break;
      int[] dayOfMonth = checkLeap(year);
      if(year<0 || month<=0 || month>=13 || (month<13 && dayOfMonth[month-1]<day) || (year==1752 && month==9 && day>2 && day<14))
        sb.append(month).append("/").append(day).append("/").append(year).append(" is an invalid date.\n");
      else {
        int sumofDay = newYearDay(year)%7;
        for(int i=0;i<month-1;i++) 
          sumofDay+=dayOfMonth[i];
        sumofDay+=day-1;
        if(year>1752 || year==1752 && (month>9 || month==9 && day>=14))
          sumofDay+=3;
        sb.append(m[month-1]).append(" ").append(day).append(", ").append(year).append(" is a ").append(date[sumofDay%7]).append("\n");
      }
    }
    System.out.print(sb);
  }

}
