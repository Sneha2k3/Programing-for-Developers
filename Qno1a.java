// e minimum cost to decorate all the venues
public class Qno1a{

    public static int calculateMinimumCost(int[][] expenses) {
        if (expenses == null || expenses.length == 0 || expenses[0].length == 0) {
            return 0;
        }

        int n = expenses.length;
        int k = expenses[0].length;
        int[][] dp = new int[n][k];

        for (int j = 0; j < k; j++) {
            dp[0][j] = expenses[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int prevTheme = 0; prevTheme < k; prevTheme++) {

                    if (prevTheme == j) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][prevTheme] + expenses[i][j]);
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            minCost = Math.min(minCost, dp[n - 1][j]);
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[][] expenses = {{1, 3, 2}, {4, 6, 8}, {3, 1, 5}};
        System.out.println("Minimum cost: " + calculateMinimumCost(expenses));
    }
}
