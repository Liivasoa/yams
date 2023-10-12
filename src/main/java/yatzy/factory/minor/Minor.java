package yatzy.factory.minor;

import yatzy.Party;

public abstract class Minor extends Party {

	protected int diceNumber;

	public Minor(int d1, int d2, int d3, int d4, int d5) {
		super(d1, d2, d3, d4, d5);
	}

	private int getDiceNumberCount() {
        return getCountsMap()
            .getOrDefault(this.diceNumber, 0L)
            .intValue() * this.diceNumber;
    }

	@Override
	public int calculateScore() {
		return getDiceNumberCount();
	}

}