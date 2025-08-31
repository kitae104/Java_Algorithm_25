package algorithm.greedy.coinchange;

import java.util.Arrays;

public class CoinChangeProblem {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int index = coins.length - 1;
        int cnt = 0;
        while(true){
            int coinValue = coins[index];   // 코인 액면값 중 가장 큰 값부터 시작
            index--;
            int maxAmount = (amount / coinValue) * coinValue;  // 코인 액면값으로 나눈 몫에 코인 액면값을 곱해 최대 금액을 구함
            if(maxAmount > 0){
                int count = amount / coinValue; // 코인 액면값으로 나눈 몫을 구함
                cnt += count;
                System.out.println("Coin value " + coinValue + " count = " + (count));
                amount = amount - maxAmount;    // 총금액에서 최대 금액을 뺌
            }
            if(amount == 0) break;
        }
        return cnt;
    }
}
