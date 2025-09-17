package class21;

/**
 * @author : lizh
 * @date: 2025/8/31 - 08 - 31 - 21:32
 * @Description: class21
 * @version: 1.0
 */

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 不是返回第k个不同元素中最大的
 */
public class RandomizedSelect {
    public int findKthLargest(int[] nums, int k) {
        int ans = -1;

        k = nums.length - k;
        for(int l = 0,r = nums.length-1; l<=r; ){

            int x = nums[l + (int)(Math.random()*(r-l+1))];
            partition(nums, l, r, x);

            if(k < first){
                r = first - 1;
            }else if(k > last){
                l = last + 1;
            }else{
                ans = nums[k];
                break;
            }

        }
        return ans;

    }

    public static int first, last;

    public void partition(int[] arr, int l, int r, int x){
        first = l;
        last = r;
        int i = l;

       while(i <= last){
            if(arr[i] < x){
                swap(arr, first++, i++);
            }else if(arr[i] == x){
                i++;
            }else{
                swap(arr, last--, i);
            }
       }
    }

    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
