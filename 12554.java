import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question12554 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		String[] arg = {"Happy","birthday","to","you","Happy","birthday","to","you","Happy","birthday","to","Rujia","Happy","birthday","to","you"};
		int person = Integer.parseInt(bf.readLine());
		String[] name= new String[person];
		for(int i=0;i<person;i++) {
			name[i] = bf.readLine();
		}
		if(person<16) {
			int k=0;
			for(int i=0;i<16;i++) {
				System.out.println(name[k]+": "+arg[i]);
				if(k==person-1)
					k=-1;
				k++;
			}
		}
		if(person>16 && person%16!=0) {
			int k=0;
			int x=0;
			for(int i=0;i<((person/16)+1)*16;i++) {
				System.out.println(name[k]+": "+arg[x]);
				if(k==person-1)
					k=-1;
				if(x==arg.length-1)
					x=-1;
				k++;
				x++;
			}
		}
		if(person%16==0) {
			int x=0;
			for(int i=0;i<(person%16)*16;i++) {
				System.out.println(name[i]+": "+arg[x]);
				if(x==arg.length-1)
					x=-1;
				x++;
			}
		}
	}

}
