package interview150;


/**
 * @author : lizh
 * @date: 2025/11/2 - 11 - 02 - 16:14
 * @Description: external
 * @version: 1.0
 */

public class MaxProfit {

    // 121
    public int maxProfit(int[] prices) {
        /*int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int i1 = i + 1; i1 < prices.length; i1++) {
                max = prices[i1] - prices[i] > 0 ? prices[i1] - prices[i] : max;
            }
        }
        return max;*/


        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if(minPrice > price)
                minPrice = price;
            else if(maxPro < price-minPrice)
                maxPro = price-minPrice;
        }
        return maxPro;
    }

    // 122
    public int maxProfit2(int[] prices) {
        // int maxPro = 0;
        int minPrice = prices[0];
        int ans = 0;

        for(int price : prices){
            if(minPrice > price){
                minPrice = price;
            }
            if(price - minPrice > 0){
                ans += price - minPrice;
                minPrice = price;
            }

        }
        return ans;
    }

    // 123
    public int maxProfit3(int[] prices) {



        return 0;
    }


    // 714



}
