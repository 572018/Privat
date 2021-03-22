package components;

public class Player {

	private String playerName;
	private int score;
	private int playerNr;
	
	public Player() {
		
	}
	
	public Player(String playerName, int score) {
		this.playerName = playerName;
		this.score = score;
		this.playerNr = playerNr;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getPlayerNr() {
		return playerNr;
	}
	public void setPlayerNr(int playerNr) {
		this.playerNr = playerNr;
	}
}
