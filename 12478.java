public class Question12478 {
	static String[] name = {"RAKIBUL","ANINDYA","MOSHIUR","SHIPLU","KABIR","SUNNY","OBAIDA","WASI"};
	
	public static boolean check(String arg,String arg1) {
		for(int i=0;i<arg.length();i++) {
			for(int k=0;k<arg1.length();k++) { 
				if(arg.charAt(i)==arg1.charAt(k)) {
					arg1=arg1.replaceFirst(arg1.substring(k,k+1),"");
					break;
				}
			}
		}
		if(arg1.length()>0)
			return false;
		return true;
	}
	public static void main(String[] args) {
		String[] gridhori = {"OBIDAIBKR","RKAULHISP","SADIYANNO","HEISAWHIA","IRAKIBULS","MFBINTRNO","UTOYZIFAH","LEBSYNUNE","EMOTIONAL"};
		String[] gridverti = {"ORSHIMULE","BKAERFTEM","IADIABOBO","DUISKIYST","ALYAINZYI","IHAWBTINO","BINHURFUN","KSNILNANA","RPOASOHEL"};
		int[] count=new int[8];
		boolean flag=true;
		for(int i=0;i<gridhori.length && flag;i++) {
			for(int j=0;j<name.length && flag;j++) {
				if(check(gridhori[i],name[j])) {
					count[j]++;
					if(count[j]==2) {
						System.out.println(name[j]);
						flag=false;
					}
				}
			}
		}
		for(int i=0;i<gridverti.length && flag;i++) {
			for(int j=0;j<name.length && flag;j++) {
				if(check(gridverti[i],name[j])) {
					count[j]++;
					if(count[j]==2) {
						System.out.println(name[j]);
						flag=false;
					}
				}
			}
		}
	}		
}
