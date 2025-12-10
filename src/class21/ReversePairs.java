package class21;

/**
 * @author : lizh
 * @date: 2025/8/30 - 08 - 30 - 13:06
 * @Description: class21
 * @version: 1.0
 */

// 翻转对(困难)
// 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
// https://leetcode.cn/problems/reverse-pairs/
class ReversePairs {
    public static int MAX = 50001;

    public static int[] help = new int[MAX];

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 5, 1};
        System.out.println(reversePairs(arr));
    }

    public static int reversePairs(int[] nums) {
        return counts(nums, 0, nums.length - 1);
    }

    private static int counts(int[] arr, int l, int r) {
        if (l == r) return 0;
        int m = l + (r - l) / 2;

        return counts(arr, l, m) + counts(arr, m + 1, r) + merge(arr, l, m, r);
    }


    // 使用归并有效优化时间复杂度
    public static int merge(int[] arr, int l, int m, int r) {
        int ans = 0;
        for (int i = l, j = m + 1; i <= m; i++) {
            while (j <= r && (long)arr[i] > (long)arr[j]<<1) {
                j++;
            }
            ans += j - m - 1;
        }

        int a = l;
        int b = m + 1;
        int i = l;
        while (a <= m && b <= r) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        while (a <= m) {
            help[i++] = arr[a++];
        }
        while (b <= r) {
            help[i++] = arr[b++];
        }
        for (i = l; i <= r; i++) {
            arr[i] = help[i];
        }
        return ans;
    }
}
