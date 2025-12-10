package class46;

/**
 * @author : lizh
 * @date: 2025/11/8 - 11 - 08 - 13:47
 * @Description: class46
 * @version: 1.0
 */
public class Prefix_SubArray {

    // 利用前缀和快速得到区域累加和
    // 测试链接 : https://leetcode.cn/problems/range-sum-query-immutable/
    class NumArray {

        int []sum;
        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            for(int i = 1; i <= sum.length; i++){
                sum[i] = sum[i - 1] + nums[i-1];
            }
        }

        public int sumRange(int left, int right) {
            return sum[right+1] - sum[left];
        }
    }

    // 给出无序数组中累加和为aim的最长子数组长度
    // https://www.nowcoder.com/practice/36fb0fd3c656480c92b569258a1223d5



}
