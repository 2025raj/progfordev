import java.util.Arrays;

public class que1b {

    public static int minCoinsDistribution(int[] ratings) {
        int n = ratings.length;
        int[] coins = new int[n];

        // Initially, assign 1 coin to each rider
        Arrays.fill(coins, 1);

        // Traverse from left to right and update the coins if the current rating is higher than the previous rider
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                coins[i] = coins[i - 1] + 1;
            }
        }

        // Traverse from right to left and update the coins if the current rating is higher than the next rider
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                coins[i] = Math.max(coins[i], coins[i + 1] + 1);
            }
        }

        // Calculate the total minimum number of coins required
        int totalCoins = 0;
        for (int coin : coins) {
            totalCoins += coin;
        }

        return totalCoins;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        int minCoins = minCoinsDistribution(ratings);
        System.out.println("Minimum number of coins required: " + minCoins);
    }
}
