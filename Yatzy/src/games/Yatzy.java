package games;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import client.GameClient;
import client.TUI;
import components.Player;
import components.Square;
import gamesADT.RuleADT;
import rules.BigStraight;
import rules.Chance;
import rules.FirstSix;
import rules.FourOfAKind;
import rules.House;
import rules.OnePair;
import rules.SmallStraight;
import rules.ThreeOfAKind;
import rules.TwoPair;
import rules.YatzyRule;
import text.SquareName;

public class Yatzy {

	private Square[][] playingField;
	private List<Player> players = new ArrayList<Player>();
	private int neste = 0;

	public Yatzy() {
	}

	public Player namePlayers(Player player, String name) {
		player.setPlayerName(name);
		player.setPlayerNr(neste + 1);
		neste++;
		return player;
	}

	public List<Integer> keep(List<Integer> eyes, List<Integer> keep, int saveEye) {
		for (int j = 0; j < eyes.size(); j++) {
			if (eyes.get(j) == saveEye) {
				keep.add(saveEye);
				eyes.remove(j);
				break;
			}
		}
		return keep;
	}
	
	public boolean checkThrow (List<Integer> eyes, int saveEye) {
		for (int j = 0; j < eyes.size(); j++) {
			if (eyes.get(j) == saveEye) {
				return true;
			}
		}
		return false;
	}

	public void insertScore(Square[][] playingField, Player player, List<Integer> keep) {
		boolean bool = true;
		while (bool) {
			try {

				System.out.println("Which square do you want to insert the score on? (1-15)");
				int square = Integer.parseInt(GameClient.SC.nextLine());
				if((square <=15)&&(square>=1)) {
					if (playingField[player.getPlayerNr() - 1][square - 1] == null) {

						playingField[player.getPlayerNr() - 1][square - 1] = new Square();
						playingField[player.getPlayerNr() - 1][square - 1].setScore(calculateScore(keep, square));
						// This prints your score, but its missing what square you scored on
						SquareName squareName = new SquareName();
						System.out
								.println("You have scored " + playingField[player.getPlayerNr() - 1][square - 1].getScore()
										+ " points in " + squareName.squareToString(square));
						bool = false;
						// Need to return a message about what they scored on
					} else {
						System.out.println("You have already inserted points into this square");
					}
				} else {
					System.out.println(square + " is not a valid square. Select something between 1 and 15");
				}
				

			} catch (NullPointerException e) {
				System.out.println("This Square does not exist");
			}
		}

	}

	public int calculateScore(List<Integer> keep, int square) {
		switch (square) {

		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6: // numbers 1 - 6 score, simple
			RuleADT rulesSum = new FirstSix();
			return rulesSum.calculate(keep, square);
		case 7: // 1 pair
			RuleADT onePair = new OnePair();
			return onePair.calculate(keep, square);
		case 8: // 2 pair
			RuleADT twoPair = new TwoPair();
			return twoPair.calculate(keep, square);
		case 9: // 3 of a kind
			RuleADT threeOfAKind = new ThreeOfAKind();
			return threeOfAKind.calculate(keep, square);
		case 10: // 4 of a kind
			RuleADT fourOfAKind = new FourOfAKind();
			return fourOfAKind.calculate(keep, square);
		case 11: // small straight 1+2+3+4+5
			RuleADT smallStraight = new SmallStraight();
			return smallStraight.calculate(keep, square);
		case 12: // big straight 2+3+4+5+6
			RuleADT bigStraight = new BigStraight();
			return bigStraight.calculate(keep, square);
		case 13: // house 2 + 3
			RuleADT house = new House();
			return house.calculate(keep, square);
		case 14: // chance, everything
			RuleADT chance = new Chance();
			return chance.calculate(keep, square);
		case 15: // Yatzy, 6 of a kind = 50 points
			RuleADT yatzyRule = new YatzyRule();
			return yatzyRule.calculate(keep, square);
		default:
			System.out.println("There was no square with that number");
			return 0;
		}
	}

	public Square[][] getSquare() {
		return playingField;
	}

	public void setSquare(Square[][] playingField) {
		this.playingField = playingField;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public int getNeste() {
		return neste;
	}

	public void setNeste(int neste) {
		this.neste = neste;
	}

}
