import java.util.*;
import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Question139 {
        
    private static class Phone {
        private String code = "";
        private String country = "";
        private BigDecimal centPerMin = new BigDecimal("0");
        Phone() {}
        public void setCode(String code){
            this.code = code;
        }
        public String getCode(){
            return this.code;
        }
        public void setCountry(String country){
            this.country = country;
        }
        public String getCountry(){
            return this.country;
        }
        public void setCentPerMin(int centPerMin){
            this.centPerMin = new BigDecimal(String.valueOf(centPerMin)).divide(new BigDecimal("100"));
        }
        public BigDecimal getCentPerMin(){
            return this.centPerMin;
        }
        public String toString(){
            return this.code+" "+this.country+" "+this.centPerMin;
        }
    }
    private static void append(StringBuilder sb, String number, String startFrom, int maxLength) {
        if (startFrom.equals("left")) {
            sb.append(number);
            for (int i=number.length();i<maxLength;i++) {
                sb.append(" ");
            }
        }else if (startFrom.equals("right")) {
            for (int i=number.length();i<maxLength;i++) {
                sb.append(" ");
            }
            sb.append(number);
        }
    }
    
    private static void build(StringBuilder sb, String fullNumber, String country, String number, String callingTime, String centPerMin, String cost) {
        append(sb, fullNumber, "left", 16);
        append(sb, country, "left", 25);
        append(sb, number, "right", 10);
        append(sb, callingTime, "right", 5);
        append(sb, centPerMin, "right", 6);
        append(sb, cost, "right", 7);
        sb.append("\n");
    }
    
    public static void main(String[] args) throws Exception {
        DecimalFormat currency = new DecimalFormat("0.00");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Phone> phoneMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        while(true) {
            String s = bf.readLine();
            if (s.equals("000000")) {
                break;
            }
            String location = s.substring(s.indexOf(' '), s.length());
            Phone p = new Phone();
            p.setCode(s.substring(0, s.indexOf(' ')));
            StringTokenizer st = new StringTokenizer(location.trim(), "$");
            if (st.countTokens()==2) {
                p.setCountry(st.nextToken().trim());
            }
            if (st.countTokens()==1) {
                p.setCentPerMin(Integer.parseInt(st.nextToken().trim()));
            }
            phoneMap.put(p.getCode(), p);
        }
        while(true) {
            String s = bf.readLine();
            if (s.equals("#")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(s);
            String number = st.nextToken();
            int callingTime = 0;
            if (st.hasMoreTokens()) {
               callingTime = Integer.parseInt(st.nextToken()); 
            }
            if (number.startsWith("0")) {
                boolean found = false;
                for (int i = 1 ; i < number.length() ; i++) {
                    if ((number.startsWith("00") && number.length()-i<11 && !number.substring(0,i).equals("00") ||
                        ((number.startsWith("0") && number.length()-i<8))) 
                        && number.length()-i>=4 && phoneMap.get(number.substring(0,i)) != null) {
                        Phone selectedPhone = phoneMap.get(number.substring(0,i));
                        build(sb, number, selectedPhone.getCountry(), number.substring(selectedPhone.getCode().length(), number.length()),
                              String.valueOf(callingTime), currency.format(selectedPhone.getCentPerMin()), 
                              currency.format(selectedPhone.getCentPerMin().multiply(new BigDecimal(String.valueOf(callingTime)))));
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    build(sb, number, "Unknown", "", String.valueOf(callingTime), "", "-1.00");
                }
            } else {
                build(sb, number, "Local", number, String.valueOf(callingTime), String.valueOf("0.00"), String.valueOf("0.00"));
            }
        }
        System.out.print(sb);
    }
}
