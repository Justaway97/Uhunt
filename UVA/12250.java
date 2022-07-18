import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question12250 {

	public static String language(String arg) {
		String[] hello = {"HELLO","HOLA","HALLO","BONJOUR","CIAO","ZDRAVSTVUJTE"};
		String[] language = {"ENGLISH","SPANISH","GERMAN","FRENCH","ITALIAN","RUSSIAN"};
		for(int i=0;i<hello.length;i++) {
			if(arg.equals(hello[i]))
				return language[i];
		}
		return "UNKNOWN";
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		for(int i=1;;i++) {
			String language = bf.readLine();
			if(language.equals("#"))
				break;
			System.out.println("Case "+i+": "+language(language));
		}

	}

}
