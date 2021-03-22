package rules;

import java.util.List;

import gamesADT.RuleADT;

public class BigStraight implements RuleADT {

	@Override
	public int calculate(List<Integer> keep, int square) {
		int score = 0;
		for(int i = 2; i < 7; i++) {
			if(keep.get(keep.indexOf(i)) == i){
				score = score +1;
			}
			if(score >=5) {
				return 20;
			}
		}
		return 0;
		
	}

}
