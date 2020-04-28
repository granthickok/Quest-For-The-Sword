package application.model;

public class Levels {
	private int level[][];
	public int x;
	public int y;
	public boolean upValid;
	public boolean leftValid;
	public boolean rightValid;
	
	public Levels(int l[][]) {
		level=l;
		getCurrentPos();
		getValidMoves();
	}
	
	private void getCurrentPos() {
		for(int y=0; y<level.length; y++) {
			for(int x=0; x<level[y].length; x++) {
				if(level[y][x]==0) {
					this.x=x;
					this.y=y;
				}
			}
		}
	}
	
	public void getValidMoves() {
		upValid=false; leftValid=false; rightValid=false;
		
		if(level[y-1][x]!=-1)
			upValid=true;
		
		if(level[y][x+1]!=-1)
			rightValid=true;
		
		if(level[y][x-1]!=-1)
			leftValid=true;
	}
	
	public void moveLeft() {
		x-=1;
	}
	
	public void moveUp() {
		y-=1;
	}
	
	public void moveRight() {
		x+=1;
	}

}
