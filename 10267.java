import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Question10267 {
	private static char[][] word = new char[0][0];
	private static int width=0,length=0;
	private static void buildPic(StringBuilder sb) {
		for(int i=0;i<word.length;i++) {
			for(int j=0;j<word[i].length;j++) 
					sb.append(word[i][j]);
			sb.append("\n");
		}
	}
	private static void fillright(char selected,char c,int x,int y) {
		if(x<0 || x>=word.length || y>=word[0].length || y<0)
			return;
		if(word[x][y]==c)
			return;
		if(word[x][y]==selected)
			word[x][y] = c;
		else
			return;
		fillright(selected,c,x,y+1);
		fillright(selected,c,x+1,y);
		fillright(selected,c,x-1,y);
		fillright(selected,c,x,y-1);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = bf.readLine();
			if(input.charAt(0)=='S') {
				StringTokenizer st = new StringTokenizer(input);
				st.nextToken();
				sb.append(st.nextToken()).append("\n");
				buildPic(sb);
			}else if(input.charAt(0)=='I') {
				StringTokenizer st = new StringTokenizer(input);
				st.nextToken();
				length = Integer.parseInt(st.nextToken());
				width = Integer.parseInt(st.nextToken());
				word = new char[width][length];
				for(int i=0;i<word.length;i++)
					Arrays.fill(word[i], 'O');
			}else if(input.charAt(0)=='C') {
				word = new char[width][length];
				for(int i=0;i<word.length;i++)
					Arrays.fill(word[i], 'O');
			}else if(input.charAt(0)=='L') {
				StringTokenizer st = new StringTokenizer(input);
				st.nextToken();
				int y = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());
				word[x-1][y-1]=st.nextToken().charAt(0);
			}else if(input.charAt(0)=='V') {
				StringTokenizer st = new StringTokenizer(input);
				st.nextToken();
				int x = Integer.parseInt(st.nextToken())-1,y1 = Integer.parseInt(st.nextToken()),y2 = Integer.parseInt(st.nextToken());
				char c = st.nextToken().charAt(0);
				for(int i=Math.min(y1, y2)-1;i<Math.max(y1, y2);i++)
					word[i][x] = c;
			}else if(input.charAt(0)=='H') {
				StringTokenizer st = new StringTokenizer(input);
				st.nextToken();
				int x1 = Integer.parseInt(st.nextToken()), x2 = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken())-1;
				char c = st.nextToken().charAt(0);
				for(int i=Math.min(x1, x2)-1;i<Math.max(x1, x2);i++)
					word[y][i] = c;
			}else if(input.charAt(0)=='K') {
				StringTokenizer st = new StringTokenizer(input);
				st.nextToken();
				int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()), x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());
				char c = st.nextToken().charAt(0);
				for(int i=Math.min(y1, y2)-1;i<Math.max(y1, y2);i++) 
					for(int j=Math.min(x1, x2)-1;j<Math.max(x1, x2);j++) 
						word[i][j] = c;
			}else if(input.charAt(0)=='F') {
				StringTokenizer st = new StringTokenizer(input);
				st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				char c = st.nextToken().charAt(0);
				char selected = word[y-1][x-1];
				fillright(selected,c,y-1,x-1);
			}else if(input.charAt(0)=='X')
				break;
		}
		System.out.print(sb);
	}
}