package rules;

import java.util.List;

import gamesADT.RuleADT;

public class Chance implements RuleADT {

	@Override
	public int calculate(List<Integer> keep, int square) {
		int score = 0;
		for (Integer i : keep) {
			score = score + i;
		}
		return score;
	}

}
