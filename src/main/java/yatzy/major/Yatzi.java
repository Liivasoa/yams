package yatzy.major;

import java.util.List;

import yatzy.Party;

public class Yatzi extends Party implements CanBeYatzi {
	
	private static final int YATZY_SCORE = 50;

	public Yatzi(List<Integer> dices) {
		super(dices);
	}

	@Override
	public int calculateScore() {
		if(isYatzi(this)) {
			return YATZY_SCORE;
		}
		return 0;
	}

}