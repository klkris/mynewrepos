
public class Dog {

	int xPos;
	int yPos;
	int markerPos;
	String direction; // north, south, east or west - which direction is the dog facing
	
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	public int getMarkerPos() {
		return markerPos;
	}
	public void setMarkerPos(int markerPos) {
		this.markerPos = markerPos;
	}
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	

	public Dog() {
		super();
		this.xPos = 0;
		this.yPos = 0;
		this.markerPos = 1;
		this.direction = "NORTH";
	}
	
	public Dog(int xPos, int yPos, int markerPos, String direction) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.markerPos = markerPos;
		this.direction = direction;
	}
	
}
