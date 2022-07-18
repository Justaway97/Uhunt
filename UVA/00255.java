package GameChess;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question255 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = bf.readLine();
			if(input==null || input.isEmpty())
				break;
			StringTokenizer st = new StringTokenizer(input);
			int king = Integer.parseInt(st.nextToken());
			int queen = Integer.parseInt(st.nextToken());
			int move = Integer.parseInt(st.nextToken());
			if(queen==king)
				sb.append("Illegal state\n");
			else if(queen/8!=move/8 && queen%8!=move%8 || move==queen || (move>king && king>queen && (queen/8==move/8 && move/8==king/8 || queen%8==move%8 && queen%8==king%8)) || (move<king && queen>king && (queen/8==move/8 && queen/8==king/8 || queen%8==move%8 && king%8==queen%8)) || king==move)
				sb.append("Illegal move\n");
			else if(king==56 && move==49 || king==63 && move==54 || king==0 && move==9 || king==7 && move==14)
				sb.append("Stop\n");
			else if(((move+1==king || move-1==king) && move/8==king/8 ) || move-8==king || move+8==king )
				sb.append("Move not allowed\n");
			else
				sb.append("Continue\n");
		}
		System.out.print(sb);
	}
}
