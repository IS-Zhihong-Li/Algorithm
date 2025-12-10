package external;

/**
 * @author : lizh
 * @date: 2025/11/2 - 11 - 02 - 14:41
 * @Description: external
 * @version: 1.0
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        /*int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                nums[i] = 51;
                k++;
            }
        }
        Arrays.sort(nums);
        return nums.length - k;*/


        int l = -1;
        for (int r = 0; r < nums.length; r++) {
            if(nums[r] != val)
                nums[++l] = nums[r];
        }
        return l+1;
    }
}
