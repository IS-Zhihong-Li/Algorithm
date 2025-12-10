package interview150;

import java.util.Arrays;

/**
 * @author : lizh
 * @date: 2025/11/6 - 11 - 06 - 15:56
 * @Description: interview150
 * @version: 1.0
 */
// 135(困难)
// https://leetcode.cn/problems/candy/?envType=study-plan-v2&envId=top-interview-150
public class Candy {

    public static void main(String[] args) {

        int[] arr = new int[]{3,2,1,0,2,1,2,0,1,2,3,4,5};
        int[] arr2 = new int[]{1,3,4,5,2};
        int[] arr3 = new int[]{1,6,10,8,7,3,2};
        candy(arr3);
    }
    // 从左往右,再从右往左两次遍历
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        for (int i = 1; i < ratings.length ; i++) {
            if(ratings[i] > ratings[i - 1]){
                ans[i] = ans[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0 ; i--) {
            if(ratings[i + 1] < ratings[i]){
                ans[i + 1] = Math.max(ans[i + 1] + 1, ans[i]); // 原本会一直修改我已经正确的答案, 但是保留最大的值即可正确
            }
        }
        int ansc = 0;
        for (int an : ans) {
            ansc+=an;
        }

        return ansc;
    }
}
