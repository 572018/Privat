package components;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import gamesADT.ThrowDiceADT;

public class ThrowDice implements ThrowDiceADT {

	public ThrowDice() {
	}

	@Override
	public List<Integer> throwDices(int n) {
		List<Integer> eyes = new ArrayList<Integer>();
		int i = 0;
		while (i < n) {
			eyes.add(ThreadLocalRandom.current().nextInt(1, 6 + 1));
			i++;
		}
		return eyes;
	}

}
