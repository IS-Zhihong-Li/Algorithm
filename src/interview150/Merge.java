package interview150;

/**
 * @author : lizh
 * @date: 2025/11/2 - 11 - 02 - 13:49
 * @Description: external
 * @version: 1.0
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length;

        --m;--n;
        for (int i = len - 1; i >= 0  ; i--) {
            if(m >= 0 && n >= 0){
                nums1[i] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
            }else{
                if(n >= 0)
                    nums1[i] = nums2[n--];
                else
                    nums1[i] = nums1[m--];
            }
        }

    }
}
