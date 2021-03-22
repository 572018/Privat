package rules;

import java.util.List;

import gamesADT.RuleADT;

public class YatzyRule implements RuleADT {

	@Override
	public int calculate(List<Integer> keep, int square) {
		for(int i = 0; i < 5; i++) {
			if(keep.get(i) != keep.get(i+1)) {
				return 0;
			}
		}	
		return 50;
	}	
}

