package rules;

import java.util.List;

import gamesADT.RuleADT;

public class SmallStraight implements RuleADT {

	@Override
	public int calculate(List<Integer> keep, int square) {
		int score = 0;
		for(int i = 1; i < 6; i++) {
			if(keep.get(keep.indexOf(i)) == i){
				score = score +1;
			}
			if(score >=5) {
				return 15;
			}
		}
		return 0;
		
	}

}
