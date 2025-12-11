package class46;

/**
 * @author : lizh
 * @date: 2025/11/8 - 11 - 08 - 13:48
 * @Description: class46
 * @version: 1.0
 */

import java.util.Arrays;

/**
 * 滑动窗口：维持左、右边界都不回退的一段范围，来求解很多子数组（串）的相关问题
 * 滑动窗口的关键：找到 [范围]和 [答案指标]之间的单调性关系（类似贪心）
 * 滑动过程：滑动窗口可以用 [简单变量] 或者 [结构] 来维护信息
 * 求解大流程：求子数组在每个位置 [开头]或 [结尾]情况下的答案（开头还是结尾在于个人习惯）
 */
public class SildingWindow {

    // 累加和大于等于target的最短子数组长度
    // https://leetcode.cn/problems/minimum-size-subarray-sum/
    class MinSubArrayLen {
        public int minSubArrayLen(int target, int[] nums) {
            int min = Integer.MAX_VALUE, sum = 0;
            for(int l = 0, r = 0; r < nums.length; r++){
                sum += nums[r];
                while(sum - nums[l] >= target){
                    sum -= nums[l++];
                }
                if(sum >= target) // 一旦符合条件的情况发生才记录答案
                    min = Math.min(min, r - l + 1);
            }
            return min == Integer.MAX_VALUE ? 0 : min;// 判断min是否有被修改过
        }
    }


    // 无重复字符的最长子串
    // https://leetcode.cn/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-interview-150
    class LengthOfLongestSubstring {
        public int lengthOfLongestSubstring(String s) {
            char[] str = s.toCharArray();
            int[] hash = new int[256];
            Arrays.fill(hash,-1);
            int max = 0;
            for(int l = 0, r = 0; r < str.length;r++){
                if(hash[str[r]] != 0 && hash[str[r]] + 1 > l) {
                    l = hash[str[r]] + 1; // abba情况下 a会发生回退, 补充hash[str[r]] + 1 > l额外判断条件
                }
                hash[str[r]] = r;
                max = Math.max(max, r - l + 1);
            }
            return max;
        }
    }

    // 最小覆盖子串
    // https://leetcode.cn/problems/minimum-window-substring/


    // 加油站
    // https://leetcode.cn/problems/gas-station/


    // 替换子串得到平衡字符串
    // https://leetcode.cn/problems/replace-the-substring-for-balanced-string/


    // K个不同整数的子数组
    // https://leetcode.cn/problems/subarrays-with-k-different-integers/


    // 至少有K个重复字符的最长子串
    // https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/


}
