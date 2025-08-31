package algorithm.greedy.coinchange;

public class Main {
    public static void main(String[] args) {
        CoinChangeProblem ccp = new CoinChangeProblem();
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int amount = 2035;
        int cnt = ccp.coinChange(coins, amount);
        System.out.println("Total coins : " + cnt);
    }
}
