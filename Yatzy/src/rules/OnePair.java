package rules;

import java.util.HashMap;
import java.util.List;

import gamesADT.RuleADT;

public class OnePair implements RuleADT {

	@Override
	public int calculate(List<Integer> keep, int square) {

		HashMap<Integer,Integer>map = new HashMap<Integer, Integer>();
		
		for(int i = 1;i < 7;i++) {
			map.put(i, 0);
		}
		for (Integer i : keep) {
	        map.put(i, map.get(i)+1);
	    }
		for(int i = 6; i > 0; i--) {
			if(map.get(i)>=2) {
				keep.remove(keep.indexOf(i));
				keep.remove(keep.indexOf(i));
				return 2*i;
			}
		}
		return 0;
	}
}
