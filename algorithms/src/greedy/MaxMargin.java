package src.greedy;

public class MaxMargin {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int soFarMin = prices[0], max = 0;

        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - soFarMin);
            soFarMin = Math.min(soFarMin, prices[i]);
        }

        return max;
    }
}
