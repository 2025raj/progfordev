public class que1 {

    public static int minCostForMatchingOutfits(int[][] price) {
        int N = price.length;

        // Initialize variables to store the minimum cost for each person
        int minCostPerson1 = price[0][0];
        int minCostPerson2 = price[0][1];
        int minCostPerson3 = price[0][2];

        // Iterate through the 'price' array
        for (int i = 1; i < N; i++) {
            int cost1 = price[i][0];
            int cost2 = price[i][1];
            int cost3 = price[i][2];

            // Calculate the minimum cost for each person
            int newMinCostPerson1 = cost1 + Math.min(minCostPerson2, minCostPerson3);
            int newMinCostPerson2 = cost2 + Math.min(minCostPerson1, minCostPerson3);
            int newMinCostPerson3 = cost3 + Math.min(minCostPerson1, minCostPerson2);

            // Update the minimum costs for each person
            minCostPerson1 = newMinCostPerson1;
            minCostPerson2 = newMinCostPerson2;
            minCostPerson3 = newMinCostPerson3;
        }

        // Calculate the total minimum cost for the last person
        int totalMinCost = Math.min(minCostPerson1, Math.min(minCostPerson2, minCostPerson3));

        return totalMinCost;
    }

    public static void main(String[] args) {
        int[][] price = {
            {14, 4, 11},
            {11, 14, 3},
            {14, 2, 10}
        };
        int output = minCostForMatchingOutfits(price);
        System.out.println(output); 
    }
}




