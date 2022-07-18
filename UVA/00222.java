import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Question222 {
	public static double destination,tank,MileperGallon;
	public static double cost;
	public static station[] station;
	public static boolean flag(station[] s,double travel,int i,int x,double gasoline) {
		if(i<s.length-1 && (tank*MileperGallon-(station[i+1].distance-station[x].distance))/MileperGallon<0) 
			return false;
		if(gasoline<tank/2)
			return false;
		return true;
	}
	public static void find(double travel,int index,double curr,int x) {
		if(travel>=destination && curr<cost) {
			cost = curr;
			return;
		}
		for(int i=index;i<station.length;i++) {
			double gasolineleft = (tank*MileperGallon-(station[i].distance-station[x].distance))/MileperGallon;
			if(flag(station,travel,i,x,gasolineleft) || gasolineleft<0)
				continue;
			curr += Math.round(((tank-gasolineleft)*station[i].cost/100+2)*100.0)/100.0;
			curr = Math.round(curr*100.0)/100.0;
			travel=station[i].distance+tank*MileperGallon;
			find(travel,i+1,curr,i);
			curr-=(tank-gasolineleft)*station[i].cost/100+2;
			travel-=tank*MileperGallon;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x=1;
		DecimalFormat df = new DecimalFormat("0.00");
		while(true) {
			destination = Double.parseDouble(bf.readLine());
			if(destination==-1)
				break;
			cost = Double.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			tank = Double.parseDouble(st.nextToken());
			MileperGallon = Double.parseDouble(st.nextToken());
			double money = Double.parseDouble(st.nextToken());
			station = new station[Integer.parseInt(st.nextToken())+1];
			station[0] = new station("0.0 0.0");
			for(int i=1;i<station.length;i++) 
				station[i] = new station(bf.readLine());
			find(tank*MileperGallon,0,money,0);
			sb.append("Data Set #").append(x).append("\nminimum cost = $").append(df.format(Math.round(cost*100.0)/100.0)).append("\n");
			x++;
		}
		System.out.print(sb);
	}
}
class station{
	double distance,cost;
	public station(String input) {
		StringTokenizer st = new StringTokenizer(input);
		distance = Double.parseDouble(st.nextToken());
		cost = Double.parseDouble(st.nextToken());
	}
}