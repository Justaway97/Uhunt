import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Question10261 {
	
	private static boolean[] path(int[][] knapsack, int[] cars, boolean[] path, int x, int y, int last) {
		if(last==0)
			return path;
		while(x!=0 && knapsack[x][y]==knapsack[x-1][y])
			x--;
		while(y!=0 && knapsack[x][y]==knapsack[x][y-1])
			y--;
		path[x] = true;
		last -= cars[x];
		y-=cars[x];
		return path(knapsack,cars,path,x,y,last);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			bf.readLine();
			int ferry = Integer.parseInt(bf.readLine().trim())*200;
			int limit = 0;
			ArrayList<Integer> car = new ArrayList<>();
			boolean flag = false;
			int s = -1;
			int car_limit = 0;
			while(s!=0) {
				String temp = "";
				while(temp.isEmpty())
					temp = bf.readLine();
				s = Integer.parseInt(temp.trim());
				if(car_limit++>200)
					continue;
				if(s>ferry/2 || s==0 || limit+s>ferry)
					flag = true;
				if(!flag) {
					car.add(s);
					limit+=s;
				}
			}
			int[] cars = new int[car.size()];
			for(int j=0;j<cars.length;j++) 
				cars[j] = car.get(j);
			int[][] knapsack = new int[cars.length][ferry/2+1];
			int index=0;
			boolean[] path = new boolean[0];
			if(cars.length!=0) {
				for(int j=cars[0];j<knapsack[0].length;j++)
					knapsack[0][j] = cars[0];
				int count=cars[0];
				for(int j=1;j<knapsack.length;j++) {
					count+=cars[j];
					for(int k=1;k<knapsack[0].length;k++) 
						if(cars[j]<k)
							knapsack[j][k] = Math.max(cars[j]+knapsack[j-1][k-cars[j]],knapsack[j-1][k]);
						else
							knapsack[j][k] = knapsack[j-1][k];
					if(count-knapsack[j][ferry/2]>ferry/2) 
						break;
					index++;
				}
				path = path(knapsack,cars,new boolean[index+1],index,knapsack[0].length-1,knapsack[index][knapsack[0].length-1]);
			}
			if(i>0)
				sb.append("\n");
			sb.append(path.length).append("\n");
			for(int j=0;j<path.length;j++)
				if(!path[j])
					sb.append("starboard\n");
				else
					sb.append("port\n");
		}
		System.out.print(sb);
	}
}
