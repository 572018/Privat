package rules;

import java.util.List;
public class TwoPair extends OnePair {

	
	public int resolveTwoPair(List<Integer> keep, int square) {
		return calculate(keep, square) + calculate(keep, square);
	}
}
