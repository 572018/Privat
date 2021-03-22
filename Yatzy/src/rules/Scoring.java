package rules;

import java.util.List;

import components.Player;
import components.Square;
import games.Yatzy;

public class Scoring {

	public Scoring() {
	}
	
	private int bonusPoints(Square[][] playingField, Player player) {
		int score = 0;
		for (int i = 0; i < 6; i++) {
			score = score + playingField[player.getPlayerNr()-1][i].getScore();
		}
		return score >= 41 ? 50 : 0;
	}

	private int endScore(Square[][] playingField, Player player) {
		int score = 0;
		for (int i = 0; i < 15; i++) {
			score = score + playingField[player.getPlayerNr()-1][i].getScore();

		}
		score = score + bonusPoints(playingField, player);
		player.setScore(score);
		return score;
	}

	public Player findWinner(Yatzy yatzy, Square[][] playingField) {
		for (int i = 0; i < yatzy.getPlayers().size(); i++) {
			Player player = yatzy.getPlayers().get(i);
			yatzy.getPlayers().get(i).setScore(endScore(playingField, player));
		}
		List<Player> players = yatzy.getPlayers();
		Player winner = new Player();
		winner.setScore(0);
		for (Player p : players) {
			System.out.println(p.getPlayerName() + " scored " + p.getScore() + " points");
			if (p.getScore() > winner.getScore()) {
				winner = p;
			}
		}
		System.out.println("Winner is " + winner.getPlayerName() + " with " + winner.getScore());
		return winner;
	}
}
