/** 
 * This is our class for general game configuration including the 2d array implimented throughout our game
 * 
 * @author Neil Pohlman, Harold MacDonald, Mubeen Khalid, Justin Currie Leslie
 * @version demo 3 Nov 18, 2014
 */


public class GameConfiguration {
    //Constructed variables for AI and human to be added onto the grid
	User u1 = new User(10,15);
	Ghost g1 = new Ghost(9,7, 1);
	Ghost g2 = new Ghost(9,8, 2);
	Ghost g3 = new Ghost(11,7, 3);
	Ghost g4 = new Ghost(11,8, 4);
    //2D array grid used to store and update game state
	private String[][] gameGrid = new String[][]{
			{"xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx"},
			{"xxx", "[P]", "[P]", "[P]", "[P]", "[P]", "xxx", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "xxx", "[P]", "[P]", "[P]", "[P]", "[P]", "xxx"},
			{"xxx", "[P]", "xxx", "xxx", "xxx", "[P]", "xxx", "[P]", "xxx", "xxx", "xxx", "xxx", "xxx", "[P]", "xxx", "[P]", "xxx", "xxx", "xxx", "[P]", "xxx"},
			{"xxx", "[P]", "xxx", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "xxx", "[P]", "xxx"},
			{"xxx", "[P]", "xxx", "[P]", "xxx", "[P]", "xxx", "[P]", "xxx", "xxx", "xxx", "xxx" ,"xxx", "[P]", "xxx", "[P]", "xxx", "[P]", "xxx", "[P]", "xxx"},
			{"xxx", "[P]", "[P]", "[P]", "xxx", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "xxx", "[P]", "[P]", "[P]", "xxx"},
			{"xxx", "xxx", "xxx", "[P]", "xxx", "[P]", "xxx", "[P]", "xxx", "xxx", "xxx", "xxx", "xxx", "[P]", "xxx", "[P]", "xxx", "[P]", "xxx", "xxx", "xxx"},
			{"xxx", "[P]", "[P]", "[P]", "[P]", "[P]", "xxx", "[P]", "xxx", "[ ]", "[ ]", "[ ]", "xxx", "[P]", "xxx", "[P]", "[P]", "[P]", "[P]", "[P]", "xxx"},
			{"xxx", "[P]", "xxx", "[P]", "xxx", "[P]", "[P]", "[P]", "xxx", "[ ]", "[ ]", "[ ]", "xxx", "[P]", "[P]", "[P]", "xxx", "[P]", "xxx", "[P]", "xxx"},
			{"xxx", "[P]", "xxx", "[P]", "xxx", "[P]", "xxx", "xxx", "xxx", "[ ]", "[ ]", "[ ]", "xxx", "xxx", "xxx", "[P]", "xxx", "[P]", "xxx", "[P]", "xxx"},
			{"xxx", "[P]", "xxx", "[P]", "xxx", "[P]", "xxx", "xxx", "xxx", "[ ]", "[ ]", "[ ]", "xxx", "xxx", "xxx", "[P]", "xxx", "[P]", "xxx", "[P]", "xxx"},
			{"xxx", "[P]", "xxx", "[P]", "xxx", "[P]", "[P]", "[P]", "xxx", "[ ]", "[ ]", "[ ]", "xxx", "[P]", "[P]", "[P]", "xxx", "[P]", "xxx", "[P]", "xxx"},
			{"xxx", "[P]", "xxx", "[P]", "[P]", "[P]", "xxx", "[P]", "xxx", "xxx", "xxx", "xxx", "xxx", "[P]", "xxx", "[P]", "[P]", "[P]", "xxx", "[P]", "xxx"},
			{"xxx", "[P]", "[P]", "[P]", "xxx", "[P]", "xxx", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "xxx", "[P]", "xxx", "[P]", "[P]", "[P]", "xxx"},
			{"xxx", "xxx", "xxx", "[P]", "xxx", "[P]", "xxx", "[P]", "xxx", "xxx", "[P]", "xxx", "xxx", "[P]", "xxx", "[P]", "xxx", "[P]", "xxx", "xxx", "xxx"},
			{"xxx", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[ ]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "xxx"},
			{"xxx", "[P]", "xxx", "[P]", "xxx", "[P]", "xxx", "[P]", "xxx", "xxx", "xxx", "xxx", "xxx", "[P]", "xxx", "[P]", "xxx", "[P]", "xxx", "[P]", "xxx"},
			{"xxx", "[P]", "xxx", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "xxx", "[P]", "xxx"},
			{"xxx", "[P]", "xxx", "xxx", "xxx", "[P]", "xxx", "[P]", "xxx", "xxx", "xxx", "xxx", "xxx", "[P]", "xxx", "[P]", "xxx", "xxx", "xxx", "[P]", "xxx"},
			{"xxx", "[P]", "[P]", "[P]", "[P]", "[P]", "xxx", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "xxx", "[P]", "[P]", "[P]", "[P]", "[P]", "xxx"},
			{"xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx"},
	};
	
	public GameConfiguration(){
		populateBoard();
		won = false;
		lost = false;
	}

	//since game board is a square, the length of gameGrid[0] will be the same for all other values;
	private int boardSize = gameGrid[0].length;
	private GameObject[][] board = new GameObject[boardSize][boardSize];
	private boolean won, lost;
	private String moveUser = "invalid";
	private int releaseGhostCount = 1;
	private String ghost1Choice, ghost2Choice,ghost3Choice,ghost4Choice;
    //getter functions to allow information transmisions from private instance 	
	public int getBoardSize(){return boardSize;}
	public boolean getWon(){return won;}
	public boolean getLost(){return lost;}
	public User getUser(){return u1;}
	public Ghost getGhost1(){return g1;}
	public Ghost getGhost2(){return g2;}
	public Ghost getGhost3(){return g3;}
	public Ghost getGhost4(){return g4;}
	
	public String [][] getGameGrid(){return gameGrid;}
	public GameObject getGameBoardElement(int x, int y){return board[y][x];}
	
    // populates board - for each variable in the ray it creates a specific point for the grid
	public void populateBoard(){
		for (int y = 0; y < boardSize; y++){
			for (int x = 0; x < boardSize; x++){
				if (gameGrid[y][x].equals("[P]")){
					board[y][x] = new Point(x, y);
				}
				if (gameGrid[y][x].equals("xxx")){
					board[y][x] = new Wall(x, y);
				}
				
				if (gameGrid[y][x].equals("[ ]")){
					board[y][x] = new GameObject(x,y);
				}
			}
		}
	}
	
     /**
     * Helper method to detect collisions between the player and ghost.
     *@param User U1 
     *@param Ghost g1
     *@return returns ether a print statement/loss of life if x and y locations are the same
     */

	public void detectGhost(User u, Ghost g){

		if (u.getXCord() == g.getXCord() && u.getYCord() == g.getYCord()){
			//put user in start position and reduce lives by 1
			board[u.getYCord()][u.getXCord()] = new GameObject(u.getXCord(),u.getYCord());
			u.lossLife();
			u.setXCord(10);
			u.setYCord(15);
			g1.setXCord(9);
			g1.setYCord(7);
			g2.setXCord(9);
			g2.setYCord(8);
			g3.setXCord(11);
			g3.setYCord(7);
			g4.setXCord(11);
			g4.setYCord(8);
			u.setAteByGhost(true);
			releaseGhostCount = 1;
		}	
	}
	
	public void detectAllGhost( ){
		detectGhost(u1, g1);
		detectGhost(u1, g2);
		detectGhost(u1, g3);
		detectGhost(u1, g4);
		
	}

      /**
     * Lose condition 
     *@return return if lives = 0 true, else returns false
     */
	public boolean gameLost(){
		if (u1.getLives() == 0){
			return true;
		}
		return false;
	}
	
	     /**
     * win condition: all points captured
     *@return if total points is left then or = to zero returns true, otherwise false
     */
	
	public boolean gameWon(){
		int totalPoints = 0;
		for (int i = 0; i < boardSize; i++){
			for (int j = 0; j < boardSize; j++){
				if (board[i][j].getType() == "POINT"){
					totalPoints++;
				}
			}
		}

		if (totalPoints == 0){
			return true;
		}
		return false;
	}
	

     /**
     * Checks collision with wall
     *@param GameObject spite
     *@param string Direction
     *@return if user tries to move into wall returns true, otherwise returns false
     */
	public boolean collideWithWall(GameObject sprite, String direction){
		switch(direction) {
		case ("Left"):
			if (board[sprite.getYCord() ][sprite.getXCord()-1].getType()!= "WALL"){
				return true;
			}
			break;
		case ("Right"):
			if (board[sprite.getYCord() ][sprite.getXCord()+1].getType() != "WALL"){
				return true;
			}
			break;
		case ("Down"):
			if (board[sprite.getYCord()+1][sprite.getXCord()].getType() != "WALL"){
				return true;
			}
			break;
		case ("Up"):
			if (board[sprite.getYCord()-1][sprite.getXCord()].getType() != "WALL"){
				return true;
			}
			break;	
		}
		return false;
	}
    
      /**
     * gets ghost starting in the box like origial pacman game
     */
	private void releaseGhost(){

		if ((releaseGhostCount >= 4) && (g1.getXCord() >= 9) && (g1.getXCord() <= 11) && (g1.getYCord() >= 6) && (g1.getYCord() <= 11) ){
			ghost1Choice = "U";
		}
		
		if ((releaseGhostCount >= 4) && (g2.getXCord() >= 9) && (g2.getXCord() <= 11) && (g2.getYCord() >= 6) && (g2.getYCord() <= 11) ){
			ghost2Choice = "U";
		}
		
		if ((releaseGhostCount >= 4) && (g3.getXCord() >= 9) && (g3.getXCord() <= 11) && (g3.getYCord() >= 6) && (g3.getYCord() <= 11) ){
			ghost3Choice = "U";
		}
		
		if ((releaseGhostCount >= 4) && (g4.getXCord() >= 9) && (g4.getXCord() <= 11) && (g4.getYCord() >= 6) && (g4.getYCord() <= 11) ){
			ghost4Choice = "U";
		}
		
		releaseGhostCount++;
	}
	
     /**
     * Helper method to detect collisions between the player and ghost.
     *@param userChoice
     *@return depends on a lot of if statements, noted in in line comments 
     */

	public void step(String userChoice){
		
		if (collideWithWall(u1, userChoice)){
				moveUser = userChoice;
		}
		//stops player from moving into wall
		if (!collideWithWall(u1, moveUser)){
				moveUser = "invalid";
		}
		
		//lose Condition: pacman lives  = 0
		if (gameLost()){lost = true;}
			
		//Win Condition: No more points left on the screen
		if (gameWon()){won = true;}
		
		//u1.playerMove(gameGrid, moveUser);
		u1.playerMove(moveUser);
		if (board[u1.getYCord()][u1.getXCord()].getType() == "POINT"){
			Point pointToAdd = new Point(u1.getXCord(), u1.getYCord());
			board[u1.getYCord()][u1.getXCord()] = new GameObject(u1.getXCord(), u1.getYCord());
			u1.addPoints(pointToAdd);
		}	
		
		//Detect Collisions between user and ghost
		detectAllGhost();
	}
	
	public void step2(){
		
		//Get move for each ghost
		ghost1Choice = g1.getMove(board[g1.getYCord() - 1][g1.getXCord()],board[g1.getYCord()+1][g1.getXCord()],board[g1.getYCord()][g1.getXCord()-1],board[g1.getYCord()][g1.getXCord()+1]);
		ghost2Choice = g2.getMove(board[g2.getYCord() - 1][g2.getXCord()],board[g2.getYCord()+1][g2.getXCord()],board[g2.getYCord()][g2.getXCord()-1],board[g2.getYCord()][g2.getXCord()+1]);
		ghost3Choice = g3.getMove(board[g3.getYCord() - 1][g3.getXCord()],board[g3.getYCord()+1][g3.getXCord()],board[g3.getYCord()][g3.getXCord()-1],board[g3.getYCord()][g3.getXCord()+1]);
		ghost4Choice = g4.getMove(board[g4.getYCord() - 1][g4.getXCord()],board[g4.getYCord()+1][g4.getXCord()],board[g4.getYCord()][g4.getXCord()-1],board[g4.getYCord()][g4.getXCord()+1]);
		
		//release ghost onto the board
		if (releaseGhostCount < 15) {releaseGhost();}
		
		//Moves each ghost
		g1.ghostMove(ghost1Choice);
		g2.ghostMove(ghost2Choice);
		g3.ghostMove(ghost3Choice);
		g4.ghostMove(ghost4Choice);
		
		//Detect Collisions between user and ghost
		detectAllGhost();
		
	}



}
