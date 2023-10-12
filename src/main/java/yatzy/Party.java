package yatzy;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;

public abstract class Party {
	
	private final List<Integer> dices;
	
	protected Party(int d1, int d2, int d3, int d4, int d5) {
        this.dices = List.of(d1, d2, d3, d4, d5);
    }
	
	public Map<Integer, Long> getCountsMap() {
        return dices.stream()
            .collect(groupingBy(identity(), counting()));
    }
	
	public abstract int calculateScore();

}
