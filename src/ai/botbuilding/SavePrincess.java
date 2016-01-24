package ai.botbuilding;

import java.util.Scanner;

/**
 * Problem :
 * https://www.hackerrank.com/challenges/saveprincess
 * 
 * My solution :
 * https://www.hackerrank.com/showgame/5558279
 * 
 * @author adarsing
 *
 */
public class SavePrincess {
	
	static void displayPathtoPrincess(int n, String [] grid){
		/*
		 * 1. get position of princess
		 * 2. get position of bot
		 * 3. mathematicaly calculate the down/up and left/right
		 */
		
		int princess[]=getPrincessPosition(grid);
		int bot[] = getBotPosition(grid);
		
		int upDown = bot[0]-princess[0];//+ive if bot if above - go down
		int leftRight = bot[1]-princess[1];//+ive if bot is in right - go left
		for(int i=0;i<Math.abs(upDown);i++) {
			System.out.println((upDown<0)?"DOWN":"UP");
		}
		for(int i=0;i<Math.abs(leftRight);i++) {
			System.out.println((leftRight>0)?"LEFT":"RIGHT");
		}
		
	}
	private static int[] getBotPosition(String[] grid) {
		int j=-1,i=0;
		for(;i<grid.length;i++) {
			j = grid[i].indexOf('m');
			if(j>=0) break;
		}
		
		return new int[]{i,j};
	}
	private static int[] getPrincessPosition(String[] grid) {
		int n[] = new int[2];
		if(grid[0].charAt(0)=='p') {
			n[0]=0;n[1]=0;
		}
		else if(grid[0].charAt(grid.length-1)=='p') {
			n[0]=0;n[1]=grid.length-1;
		}
		else if(grid[grid.length-1].charAt(0)=='p') {
			n[0]=grid.length-1;n[1]=0;
		}
		else {
			n[0]=grid.length-1;n[1]=grid.length-1;
		}
		
		return n;
	}
	public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int m;
	        m = in.nextInt();
	        String grid[] = new String[m];
	        for(int i = 0; i < m; i++) {
	            grid[i] = in.next();
	        }
	        in.close();

	    displayPathtoPrincess(m,grid);
	    }
}
