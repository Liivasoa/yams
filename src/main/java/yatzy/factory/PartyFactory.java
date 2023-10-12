package yatzy.factory;

import java.util.List;

import yatzy.CategoryEnum;
import yatzy.Party;
import yatzy.factory.minor.Fives;
import yatzy.factory.minor.Fours;
import yatzy.factory.minor.Ones;
import yatzy.factory.minor.Sixes;
import yatzy.factory.minor.Threes;
import yatzy.factory.minor.Twos;

public class PartyFactory {

	private List<Integer> dices;

	public PartyFactory(int d1, int d2, int d3, int d4, int d5) {
		this.dices = List.of(d1, d2, d3, d4, d5);
	}

	public Party createFactory(CategoryEnum categoryEnum) {
		if (categoryEnum.equals(CategoryEnum.ONES)) {
			return new Ones(this.dices.get(0), this.dices.get(1), this.dices.get(2), this.dices.get(3),
					this.dices.get(4));
		}
		if (categoryEnum.equals(CategoryEnum.TWOS)) {
			return new Twos(this.dices.get(0), this.dices.get(1), this.dices.get(2), this.dices.get(3),
					this.dices.get(4));
		}
		if (categoryEnum.equals(CategoryEnum.THREES)) {
			return new Threes(this.dices.get(0), this.dices.get(1), this.dices.get(2), this.dices.get(3),
					this.dices.get(4));
		}
		if (categoryEnum.equals(CategoryEnum.FOURS)) {
			return new Fours(this.dices.get(0), this.dices.get(1), this.dices.get(2), this.dices.get(3),
					this.dices.get(4));
		}
		if (categoryEnum.equals(CategoryEnum.FIVES)) {
			return new Fives(this.dices.get(0), this.dices.get(1), this.dices.get(2), this.dices.get(3),
					this.dices.get(4));
		}
		if (categoryEnum.equals(CategoryEnum.SIXES)) {
			return new Sixes(this.dices.get(0), this.dices.get(1), this.dices.get(2), this.dices.get(3),
					this.dices.get(4));
		}
		return null;
	}

}