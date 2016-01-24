package ai.botbuilding;

import java.util.Scanner;

/**
 * Problem :
 * https://www.hackerrank.com/challenges/saveprincess2
 * 
 * Solution :
 * https://www.hackerrank.com/showgame/5558285
 * 
 * @author adarsing
 *
 */
public class SavePrincess2 {

	static void nextMove(int n, int r, int c, String [] grid){
		
		/*
		 * 1. get pricess position 
		 * 2. mathematically check for first move
		 */
		int bot[]={r,c};
		int princess[]=getPrincessPosition(grid);
		
		int upDown = bot[0]-princess[0];//+ive if bot if above - go down
		int leftRight = bot[1]-princess[1];//+ive if bot is in right - go left
		
		if(upDown!=0)System.out.println((upDown<0)?"DOWN":"UP");
		else System.out.println((leftRight>0)?"LEFT":"RIGHT");
	  }
	private static int[] getPrincessPosition(String[] grid) {
		int j=-1,i=0;
		for(;i<grid.length;i++) {
			j = grid[i].indexOf('p');
			if(j>=0) break;
		}
		
		return new int[]{i,j};
	}
	public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n,r,c;
	        n = in.nextInt();
	        r = in.nextInt();
	        c = in.nextInt();
	        in.useDelimiter("\n");
	        String grid[] = new String[n];


	        for(int i = 0; i < n; i++) {
	            grid[i] = in.next();
	        }
	        in.close();

	    nextMove(n,r,c,grid);

	    }
}
