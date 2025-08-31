package algorithm.greedy.knapsack;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        FractionKnapsack knapsack = new FractionKnapsack();

        ArrayList<KnapsackItem> items = new ArrayList<>();
        int[] values = {100, 120, 60};    // 가치
        int[] weights = {20, 30, 10};    // 무게
        int capacity = 50;   // 배낭의 무게

        for (int i = 0; i < values.length ; i++) {
            items.add(new KnapsackItem(i+1, values[i], weights[i]));
        }

        knapsack.knapSack(items, capacity);
    }
}
