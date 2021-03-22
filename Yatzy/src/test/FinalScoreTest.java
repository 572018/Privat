package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import client.GameClient;
import components.Player;
import components.Square;
import games.Yatzy;
import rules.Scoring;

class FinalScoreTest {

	// Test class where the selection of the winner and final score methods are
	// tested
	// Testing 0 score vs 1 in every field
	@Test
	void endScoreTester() {
		Yatzy yatzy = new Yatzy();
		List<Player> playerList = new ArrayList<Player>();
		Square[][] playingField = new Square[2][15];
		Player player = new Player();
		Player player2 = new Player();
		playerList.add(yatzy.namePlayers(player, "Tester1"));
		playerList.add(yatzy.namePlayers(player2, "tester2"));
		yatzy.setPlayers(playerList);
		
		Scoring scorer = new Scoring();
		

		for (int i = 0; i < 15; i++) {
			playingField[0][i] = new Square();
			playingField[0][i].setScore(0);
			
			playingField[1][i] = new Square();
			playingField[1][i].setScore(1);
			
		}
		player2.setScore(15);
		assertEquals(player2.getScore(), scorer.findWinner(yatzy, playingField).getScore());

	}

}
