package algorithm.greedy.knapsack;

import lombok.Data;

@Data
public class KnapsackItem {
    private int index;
    private int value;
    private int weight;
    private double ratio;

    public KnapsackItem(int index, int value, int weight) {
        this.index = index;
        this.value = value;
        this.weight = weight;
        ratio = value * 1.0 / weight;
    }
}
