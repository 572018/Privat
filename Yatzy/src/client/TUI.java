package client;

import java.util.ArrayList;
import java.util.List;

import components.Player;
import components.Square;
import components.ThrowDice;
import games.Yatzy;
import rules.Scoring;

public class TUI {

	private int antall = 0;
	private Square[][] playingField;

	public void createGame(Yatzy yatzy) {
		int neste = 1;
		System.out.println("Welcome to Yatzy!\nHow many are playing?");
		antall = Integer.parseInt(GameClient.SC.nextLine());
		List<Player> playerList = new ArrayList<Player>();
		playingField = new Square[antall][15];
		for (int i = 1; i <= antall; i++) {
			Player player = new Player();
			System.out.println("What is the name of player " + neste + "?");
			playerList.add(yatzy.namePlayers(player, GameClient.SC.nextLine()));
			neste++;
		}
		yatzy.setPlayers(playerList);

	}

	public void turn(Yatzy yatzy) {
		int roundNr = antall * 15;
		int spiller = 0;
		while (roundNr > 0) {
			roundNr--;

			int i = 0;
			int throwNr = 0;
			List<Integer> eyes = new ArrayList<Integer>();
			List<Integer> keep = new ArrayList<Integer>();
			System.out.println(yatzy.getPlayers().get(spiller).getPlayerName() + "'s turn:");

			// Rolling the dices

			while (throwNr < 3) {
				throwNr++;
				i = 0;
				System.out.println("Throw nr. " + throwNr + " is about to start...");
				pressAnyKeyToContinue();

				ThrowDice roll = new ThrowDice();
				eyes = roll.throwDices(5 - keep.size());
				System.out.println("You got:");
				while (i < eyes.size()) {
					System.out.println(eyes.get(i));
					i++;
				}
				// If its the third throw its saving the last dices
				if (throwNr > 2) {
					System.out.println("Saving the last dices");
					keep.addAll(eyes);
				} else {
					// Selecting dices to save
					int saveEye = 0;
					do {
						boolean bool = true;
						while (bool) {
							System.out.println("What would you like to save? (0 to stop)");
							saveEye = Integer.parseInt(GameClient.SC.nextLine());
							if (saveEye != 0) {
								if (yatzy.checkThrow(eyes, saveEye) == true) {
									// Saving the dice
									if ((saveEye >= 1) && (saveEye <= 6)) {
										keep = yatzy.keep(eyes, keep, saveEye);
										System.out.println("You are saving:" + saveEye);
										bool = false;
									} else {
										System.out.println(saveEye + " is not a number on a yatzy dice. "
												+ "Select a number from 1 to 6, or 0 to throw again");
									}
								} else {
									System.out.println("You didn't get " + saveEye);
								}

							}break;
						}

					} while (saveEye != 0 && keep.size() < 5);
				}
			}

			// Selecting square to insert score on
			yatzy.insertScore(playingField, yatzy.getPlayers().get(spiller), keep);

			if (spiller < antall - 1) {
				spiller++;
			} else {
				spiller = 0;

			}

		}
		// summer opp alle felter og legg til evt. bonus poeng.
		Scoring score = new Scoring();
		score.findWinner(yatzy, playingField);

	}

	private void pressAnyKeyToContinue() {
		System.out.println("Press 'Enter' to roll the dices");
		try {
			GameClient.SC.nextLine();
		} catch (Exception e) {
		}
	}
}
