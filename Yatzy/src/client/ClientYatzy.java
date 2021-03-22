package client;

import games.Yatzy;

public class ClientYatzy {

	public ClientYatzy() {
	}
	
	public void start() {
		Yatzy yatzy = new Yatzy();
		YatzyMenu yatzyMenu = new YatzyMenu(yatzy);
		yatzyMenu.start();
	}
}
