package ai.botbuilding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/botcleanlarge
 * 
 * Solved Score :  54.3
 * 
 * Solution:
 * https://www.hackerrank.com/challenges/botcleanlarge/submissions/game/16762700
 * @author adarsing
 *
 */
public class BotCleanLarge {
	static void next_move(int posr, int posc, int dimh, int dimw, String[] board){
		/*
		 * Given :
		 * 1. We have bot position
		 * 2. We have board - dimensions
		 * 
		 * Algo:
		 * 1. if you are at dirty tile : clean it
		 * 2. else search for nearest dirty tile
		 * 3. make your move accordingly
		 */
		int bot[]={posr,posc};
		
		if(board[posr].charAt(posc)=='d')System.out.println("CLEAN");
		else {
			int nearestDirtySpot[]=getNearestDirtySpot(bot,dimh,dimw,board);
			int upDown = bot[0]-nearestDirtySpot[0];//+ive if bot if above - go down
			int leftRight = bot[1]-nearestDirtySpot[1];//+ive if bot is in right - go left
			
			if(leftRight!=0)System.out.println((leftRight>0)?"LEFT":"RIGHT");
			else System.out.println((upDown<0)?"DOWN":"UP");
		  
		}
    }
	
private static int[] getNearestDirtySpot(int[] bot, int dimh, int dimw, String[] board) {
		/*
		 * Idea :
		 * 1. The size of board is random , max - 50*50
		 * 2. We may use BFS to get the nearest dirty tile
		 * 
		 * Algo:
		 * [Take pos - r*dimw+c]
		 * 1. Put surrounding unchecked positions in Queue
		 * 2. get position from queue
		 * 3. check position for dirty tile
		 * 4. When you dont get dirty tile on position - mark it checked - start from 1 again
		 * 5. If got a dirty tile - return its position
		 */
    	Queue<Integer> q = new LinkedList<Integer>();
    	boolean checked[]=new boolean[dimh*dimw];
    	Arrays.fill(checked, false);
    	q.add(dimw*bot[0]+bot[1]);
    	while(!q.isEmpty() && board[q.peek()/dimw].charAt(q.peek()%dimw) != 'd') {
    		int pos[] = {q.peek()/dimw, q.peek()%dimw};
    		checked[q.peek()]= true;
    		q.poll();
    		if(pos[0]-1>=0 && checked[dimw*(pos[0]-1)+pos[1]]==false) {
    			q.add(dimw*(pos[0]-1)+pos[1]);
    		}
    		if(pos[0]+1<dimh && checked[dimw*(pos[0]+1)+pos[1]]==false) {
    			q.add(dimw*(pos[0]+1)+pos[1]);
    		}
    		if(pos[1]-1>=0 && checked[dimw*pos[0]+pos[1]-1]==false) {
    			q.add(dimw*pos[0]+pos[1]-1);
    		}
    		if(pos[1]+1<dimw && checked[dimw*pos[0]+pos[1]+1]==false) {
    			q.add(dimw*pos[0]+pos[1]+1);
    		}
    	}
		return new int[]{q.peek()/dimw,q.peek()%dimw};
	}
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] pos = new int[2];
        int [] dim = new int[2];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<2;i++) dim[i] = in.nextInt();
        String board[] = new String[dim[0]];
        for(int i=0;i<dim[0];i++) board[i] = in.next();
        in.close();
        next_move(pos[0], pos[1], dim[0], dim[1], board);
    }
}
