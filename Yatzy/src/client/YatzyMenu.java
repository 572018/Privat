package client;

import components.Player;
import components.Square;
import components.ThrowDice;
import games.Yatzy;

public class YatzyMenu {

	private TUI userint;
	private Yatzy yatzy;

	public YatzyMenu(Yatzy yatzy) {
		userint = new TUI();
		this.yatzy = yatzy;

	}

	public void start() {
		boolean bool = true;
		while (bool) {
			System.out.println("Type 'start' to play Yatzy or 'exit' to cancel");
			String command = GameClient.SC.nextLine();
			switch (command) {

			case "start":
				userint.createGame(yatzy);
				userint.turn(yatzy);
				break;
			case "exit":
				bool = false;
				System.out.println("Going back to the game menu...");
				break;
			default:
				System.out.println("Invalid command, write in lovercase");
			}
		}
	}
}
