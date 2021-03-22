package components;

public class Dice {

	private int eyes;
	
	public Dice () {
		
	}
	public Dice (int eyes) {
		this.setEyes(eyes);
	}
	public int getEyes() {
		return eyes;
	}
	public void setEyes(int eyes) {
		this.eyes = eyes;
	}
}
