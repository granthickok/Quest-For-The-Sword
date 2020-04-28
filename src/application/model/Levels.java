/*
 * Class to handle various changes to the map layout
 */

package application.model;

public class Levels {
	private int level[][];	// Copy of the map
	public int x;	// Current x position
	public int y;	// current y position
	public boolean upValid;	// Boolean for upward movement
	public boolean leftValid;	// Boolean for leftward movement
	public boolean rightValid;	// Boolean for rightward movement
	
	/*
	 * Constructor for initializing a level object
	 * 
	 * Parameters:
	 * 	int l[][] - int matrix for valid movements
	 */
	public Levels(int l[][]) {
		level=l;	// copy layout passed in
		getCurrentPos();	// Get the current players x and y
		getValidMoves();	// Check what moves are valid from current position
	}
	
	/*
	 * Method to get the current position for the player when a new layout is passed in
	 */
	private void getCurrentPos() {
		for(int y=0; y<level.length; y++) {	// Iterate over all rows
			for(int x=0; x<level[y].length; x++) {	// Iterate over all columns
				if(level[y][x]==0) {	// if position in int matrix is 0 that is where the player starts
					this.x=x;
					this.y=y;
				}
			}
		}
	}
	
	/*
	 * Method to check what moves are valid from the players current position
	 */
	public void getValidMoves() {
		upValid=false; leftValid=false; rightValid=false;	// Assume all movements are invalid to begin with
		
		if(level[y-1][x]!=-1)	// Check if up is a valid move
			upValid=true;
		
		if(level[y][x+1]!=-1)	// Check if right is a valid move
			rightValid=true;
		
		if(level[y][x-1]!=-1)	// Check if left is a valid move
			leftValid=true;
	}
	
	/*
	 * Update the players current position for moving left
	 */
	public void moveLeft() {
		x-=1;
	}
	
	/*
	 * Update the players current position for moving up
	 */
	public void moveUp() {
		y-=1;
	}
	
	/*
	 * Update the players current position for moving right
	 */
	public void moveRight() {
		x+=1;
	}

}
