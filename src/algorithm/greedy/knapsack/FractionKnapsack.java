package algorithm.greedy.knapsack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FractionKnapsack {
    public void knapSack(ArrayList<KnapsackItem> items, int capacity) {
        Comparator<KnapsackItem> comparator = (o1, o2) -> {
            if (o1.getRatio() < o2.getRatio()) {    // 내림차순
                return 1;
            } else {
                return -1;
            }
        };
        Collections.sort(items, comparator);    // 가치/무게 비율을 기준으로 내림차순 정렬
        int usedCapacity = 0;   // 사용한 무게
        double totalValue = 0;  // 사용한 가치

        for (KnapsackItem item : items) {
            if (usedCapacity + item.getWeight() <= capacity) {   // 무게가 capacity보다 작으면
                usedCapacity += item.getWeight();   // 무게를 넣어줌
                System.out.println("Taken: "+item);
                totalValue += item.getValue();     // 가치를 넣어줌
            } else {
                int usedWeight = capacity - usedCapacity;  // 남은 무게
                double value = item.getRatio() * usedWeight;  // 남은 무게에 대한 가치
                System.out.println("Taken: item index: " + item.getIndex() + ", obtained value: " + value +
                        " used weight: " + usedWeight + ", ratio: " + item.getRatio());
                usedCapacity += usedWeight; // 무게를 넣어줌
                totalValue += value;    // 가치를 넣어줌
            }
            if (usedCapacity == capacity) {
                break;
            }
        }
        System.out.println("Total value obtained: " + totalValue);
    }
}
