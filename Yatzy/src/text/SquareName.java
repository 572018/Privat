package text;

public class SquareName {

	public SquareName() {

	}

	public String squareToString(int square) {

		switch (square) {

		case 1:
			return "Ones";
		case 2:
			return "Twoes";
		case 3:
			return "Threes";
		case 4:
			return "Fours";
		case 5:
			return "Fives";
		case 6:
			return "Sixes";
		case 7:
			return "One pair";
		case 8:
			return "Two pair";
		case 9:
			return "Three of a kind";
		case 10:
			return "Four of a kind";
		case 11: 
			return "Small straight";
		case 12:
			return "Big straight";
		case 13: 
			return "House";
		case 14:
			return "Chance";
		case 15: 
			return "Yatzy";
		default: return "";
		}
		
		
	}
}
