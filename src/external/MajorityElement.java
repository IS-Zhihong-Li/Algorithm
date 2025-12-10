package external;

/**
 * @author : lizh
 * @date: 2025/11/2 - 11 - 02 - 15:39
 * @Description: external
 * @version: 1.0
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {

        /*Arrays.sort(nums);
        return nums[nums.length/2];*/

        // 摩尔投票法
        int x = 0, votes = 0;
        for (int num : nums) {
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
