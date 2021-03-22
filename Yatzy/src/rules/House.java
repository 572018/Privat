package rules;

import java.util.HashMap;
import java.util.List;

import gamesADT.RuleADT;

public class House implements RuleADT {

	@Override
	public int calculate(List<Integer> keep, int square) {
		HashMap<Integer,Integer>map = new HashMap<Integer, Integer>();
		
		for(int i = 1;i < 7;i++) {
			map.put(i, 0);
		}
		for(int i = 0;i < 6;i++) {
			if(keep.get(i)==i) {
				map.put(keep.get(i), map.get(i)+1);
			}
		}
		int score = 0;
		for(int i = 6; i > 0; i--) {
			if(map.get(i)>=3) {
				score = 3*i;
				map.put(i, 0);
				for(int j = 6; j > 0; j--) {
					if(map.get(j)>=2) {
						score = score + 2*j;
						return score;
					}
				}
				
			}
		}
		return 0;
	}

}
