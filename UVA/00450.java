import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Question450 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		ArrayList<Employee> emp = new ArrayList<Employee>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			String d = bf.readLine();
			while(true) {
				String input = bf.readLine();
				if(input.equals(""))
					break;
				emp.add(new Employee(d,input));
			}
		}
		Collections.sort(emp);
		for(int i=0;i<emp.size();i++)
			sb.append(emp.get(i).format());
		System.out.print(sb);
	}
}
class Employee implements Comparable<Employee>{
	String gen,FName,LName,location,HPhone,WPhone,box,dept;
	public Employee(String d,String input) {
		StringTokenizer st = new StringTokenizer(input,",");
		gen = st.nextToken();
		FName = st.nextToken();
		LName = st.nextToken();
		location = st.nextToken();
		HPhone = st.nextToken();
		WPhone = st.nextToken();
		box = st.nextToken();
		this.dept = d;
	}
	public String format() {
		StringBuilder sb = new StringBuilder();
		sb.append("----------------------------------------\n");
		sb.append(gen+" "+this.FName+" "+this.LName+"\n");
		sb.append(location+"\n");
		sb.append("Department: "+this.dept+"\n");
		sb.append("Home Phone: "+this.HPhone+"\n");
		sb.append("Work Phone: "+this.WPhone+"\n");
		sb.append("Campus Box: "+this.box+"\n");
		return sb.toString();
	}
	@Override
	public int compareTo(Employee e) {
		return this.LName.compareTo(e.LName);
	}
}