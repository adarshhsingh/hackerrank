package ai.botbuilding;

import java.util.Scanner;

public class BotCleanr {

	static void nextMove(int posr, int posc, String[] board){
        /*
         * 1. We have bot position
         * 2. search for Dirty Till
         * 3. Make your move by mathematical calculation
         */
		if(board[posr].charAt(posc)=='d')System.out.println("CLEAN");
		else {
			int bot[]=new int[]{posr,posc};
			int dirtyTile[]=getDirtyTilePosition(board);
			int upDown = bot[0]-dirtyTile[0];//+ive if bot if above - go down
			int leftRight = bot[1]-dirtyTile[1];//+ive if bot is in right - go left
			if(upDown!=0)System.out.println((upDown<0)?"DOWN":"UP");
			else System.out.println((leftRight>0)?"LEFT":"RIGHT");
		}

    }
	private static int[] getDirtyTilePosition(String[] board) {
		int j=-1,i=0;
		for(;i<board.length;i++) {
			j = board[i].indexOf('d');
			if(j>=0) break;
		}
		return new int[]{i,j};
	}

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] pos = new int[2];
        String board[] = new String[5];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<5;i++) board[i] = in.next();
        in.close();
        nextMove(pos[0], pos[1], board);
    }
}
