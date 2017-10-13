import java.util.Scanner;

public class Controller {

	public static final int MARKER_UP = 1;
	public static final int MARKER_DOWN = 2;
	public static final int TURN_RIGHT = 3;
	public static final int TURN_LEFT = 4;
	public static final int MOVE_FWD = 5;
	public static final int DISPLAY = 6;
	public static final int EXIT = 9;
	public static final int QUIT = 0;
	
	public static final int MIN_SIZE = 0;
	public static final int MAX_SIZE = 24;
		
	int currentXPos = 0;
	int currentYPos = 0;
	String currentDir;
	int currentFloor[][];
	
	public void processCommand(Dog d, PlayGround pg, int command, int n) {
		currentDir = d.getDirection();
		currentXPos = d.getxPos();
		currentYPos = d.getyPos();
		currentFloor = pg.getFloor();
		
		switch(command) {
			case MARKER_UP:
				d.setMarkerPos(MARKER_UP);
				break;
				
			case MARKER_DOWN:
				d.setMarkerPos(MARKER_DOWN);
				break;
				
			case TURN_RIGHT:
				turnRight(d);
				break;
		
			case TURN_LEFT:
				turnLeft(d);
				break;
				
			case MOVE_FWD:	
				moveForward(pg, d, n);
				break;
				
			case DISPLAY:
				display(currentFloor);
				break;
		}
		
	}
	
	private void display(int[][] floor) {
		for(int i = 0; i < floor.length; i++) {
	        for(int j = 0; j < floor[i].length; j++) {
	            System.out.print(floor[i][j] == 1 ? "*" : " ");
	        }
	        System.out.println("");
	    }
	}

	private void moveForward(PlayGround pg, Dog d, int n) {
		int newXPosition;
		int newYPosition;
		if(currentDir.equals("EAST")) {
			newXPosition = currentXPos + n;
			if(newXPosition > MAX_SIZE) {
				newXPosition = newXPosition - MAX_SIZE;
				currentXPos = MIN_SIZE;
			}
		} else if(currentDir.equals("WEST")) {
			newXPosition = currentXPos - n;
			if(newXPosition < MIN_SIZE) {
				newXPosition = newXPosition + MAX_SIZE;
				currentXPos = MAX_SIZE;
			}
		} else if(currentDir.equals("SOUTH")) {
			newYPosition = currentYPos + n;
			if(newYPosition > MAX_SIZE) {
				newXPosition = newYPosition - MAX_SIZE;
				currentYPos = MIN_SIZE;
			}
		} else if(currentDir.equals("NORTH")) {
			newYPosition = currentYPos - n;
			if(newYPosition < MIN_SIZE) {
				newYPosition = newYPosition + MAX_SIZE;
				currentYPos = MAX_SIZE;
			}
		}
		if(currentDir.equals("EAST")) {
			if(d.getMarkerPos() == MARKER_DOWN) {
				for (int i = currentXPos; i<= (currentXPos + n); i++) {
					currentFloor[currentYPos][i] = 1;
				}
			}
			currentXPos = currentXPos + n;
		} else if(currentDir.equals("WEST")) {
			if(d.getMarkerPos() == MARKER_DOWN) {
				for (int i = currentXPos; i> (currentXPos - n); i--) {
					currentFloor[currentYPos][i] = 1;
				}
			}
			currentXPos = currentXPos - n;
		} else if(currentDir.equals("SOUTH")) {
			if(d.getMarkerPos() == MARKER_DOWN) {
				for (int i = currentYPos; i<= (currentYPos + n); i++) {
					currentFloor[i][currentXPos] = 1;
				}
			}
			currentYPos = currentYPos + n;
		} else if(currentDir.equals("NORTH")) {
			if(d.getMarkerPos() == MARKER_DOWN) {
				for (int i = currentYPos; i> (currentYPos - n); i--) {
					currentFloor[i][currentXPos] = 1;
				}
			}
			currentYPos = currentYPos - n;
		} 
		d.setxPos(currentXPos);
		d.setyPos(currentYPos);
	
	}
	
	private void turnRight(Dog d) {
		if(currentDir.equals("NORTH")) {
			currentDir = "EAST";
		} else if(currentDir.equals("EAST")) {
			currentDir = "SOUTH";
		} else if(currentDir.equals("SOUTH")) {
			currentDir = "WEST";
		} else if(currentDir.equals("WEST")) {
			currentDir = "NORTH";
		}
		d.setDirection(currentDir);
	}
	
	private void turnLeft(Dog d) {
		if(currentDir.equals("NORTH")) {
			currentDir = "WEST";
		} else if(currentDir.equals("EAST")) {
			currentDir = "NORTH";
		} else if(currentDir.equals("SOUTH")) {
			currentDir = "EAST";
		} else if(currentDir.equals("WEST")) {
			currentDir = "SOUTH";
		}
		d.setDirection(currentDir);
	}

	private int[] getUserInput() {
		Scanner scan = new Scanner(System.in);
		int command[] = new int[100];
		
		
		System.out.print("Enter 1 for interactive mode, 2 for batch mode: ");
		int mode = scan.nextInt();
		if(mode == 1) {
			command = getInteractiveUserInput(scan);
		} else if(mode == 2) {
			command = getBatchUserInput(scan);
		} else {
			System.out.print("Please enter 1 for interactive mode, 2 for batch mode.");
			quitProgram();
		}
		
		scan.close();
		return command;
	}
	
	private void quitProgram() {
		System.out.println("Exiting...");
		System.exit(0);
	}
	
	private int[] getBatchUserInput(Scanner scan) {
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Enter the commands (comma seperated): ");
		String str = scan2.nextLine();
		String[] input = str.split(",");

		int command[] = new int[input.length];
		
		for (int i = 0; i < command.length; i++) {
			command[i] = Integer.parseInt(input[i]);
			if(command[i] == QUIT) {quitProgram();} 
		}		
		scan2.close();
		return command;
	}

	private int[] getInteractiveUserInput(Scanner scan) {
		int command[] = new int[100];
		System.out.print("Enter command (9 to end input, 0 to quit): ");
		int com = scan.nextInt();
		int i = 0;
		boolean gotFwdSpaces = false;
		while(com != EXIT) {
			if(com == QUIT ){ quitProgram();}
			command[i] = com;
			i++;
			
			if(com == 5 && !gotFwdSpaces) {
				gotFwdSpaces = true;
				System.out.print("Enter forward spaces: ");
			} else {
				gotFwdSpaces = false;
				System.out.print("Enter command (9 to end input, 0 to quit): ");
			}
			com = scan.nextInt();
			
		}
		return command;
	}

	public static void main(String a[]) {
		
		PlayGround pg = new PlayGround();
		Dog d = new Dog(0, 0, 2, "EAST"); // initializing Sherlock to face east and in the center of the playground with marker down
		Controller c = new Controller();
		
		int command[] = c.getUserInput();
		
//		int command[] = {2, 5, 12, 3, 5, 12, 3, 5, 12, 3, 5, 12, 1, 6, 9};
		for (int x = 0; x < command.length; x++) {
			if(command[x] == 5) {
				c.processCommand(d, pg, command[x], command[x + 1]);
				x++;
			} else {
				c.processCommand(d, pg, command[x], 0);
			}
		}
	}
	
}
