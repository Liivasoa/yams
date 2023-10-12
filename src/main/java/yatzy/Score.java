package yatzy;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Score {

	private static final int YATZY_SCORE = 50;
	private static final int SMALL_STRAIGHT_SCORE = 15;
	private static final int LARGE_STRAIGHT_SCORE = 20;

	public static int chance(DiceRoller diceRoller) {
		return diceRoller.sum();
	}

	public static int yatzy(DiceRoller diceRoller) {
		if (diceRoller.isYatzy()) {
			return YATZY_SCORE;
		}
		return 0;
	}

	public static int pair(DiceRoller diceRoller) {
		return diceRoller.getCountsMap().entrySet().stream().filter(entry -> entry.getValue() >= 2)
				.map(Map.Entry::getKey).max(Comparator.naturalOrder()).map(diceNumber -> diceNumber * 2).orElse(0);
	}

	public static int twoPairs(DiceRoller diceRoller) {
		List<Integer> pairs = diceRoller.findTwoPairs();
		if (hasAtLeastTwoPairs(pairs)) {
			return pairs.stream().mapToInt(pair -> pair * 2).sum();
		}
		return 0;
	}

	private static boolean hasAtLeastTwoPairs(List<Integer> pairs) {
		return pairs.size() >= 2;
	}

	public static int threeOfAKind(DiceRoller diceRoller) {
		return diceRoller.getNumberOfKind(3);

	}

	public static int fourOfAKind(DiceRoller diceRoller) {
		return diceRoller.getNumberOfKind(4);
	}

	public static int smallStraight(DiceRoller diceRoller) {
		if (diceRoller.isSmallStraight()) {
			return SMALL_STRAIGHT_SCORE;
		}
		return 0;
	}

	public static int largeStraight(DiceRoller diceRoller) {
		if (diceRoller.isLargeStraight()) {
			return LARGE_STRAIGHT_SCORE;
		}
		return 0;
	}

	public static int fullHouse(DiceRoller diceRoller) {
		if (isAfullHouse(diceRoller)) {
			return diceRoller.sum();
		}
		return 0;
	}

	private static boolean isAfullHouse(DiceRoller diceRoller) {
		return diceRoller.getNumberOfKind(3) != 0 && !diceRoller.findTwoPairs().isEmpty() && !diceRoller.isYatzy();
	}
}
