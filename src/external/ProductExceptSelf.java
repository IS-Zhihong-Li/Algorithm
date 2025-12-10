package external;

/**
 * @author : lizh
 * @date: 2025/10/25 - 10 - 25 - 21:25
 * @Description: external
 * @version: 1.0
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] ans = new int[n];

        arr1[0] = 1;
        arr2[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            arr1[i] = arr1[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            arr2[i] = arr2[i + 1] *  nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = arr1[i] * arr2[i];
        }
        return ans;
    }
}
