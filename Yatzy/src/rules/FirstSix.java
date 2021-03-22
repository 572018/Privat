package rules;

import java.util.List;

import gamesADT.RuleADT;

public class FirstSix implements RuleADT{

	@Override
	public int calculate(List<Integer> keep, int square) {

		int score = 0;
		for(int k = 0; k<keep.size(); k++) {
			if(keep.get(k)== square) {
				score = score + keep.get(k); 
			}
		}
		return score;
	}

}
