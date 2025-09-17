package search;

/**
 * @author : lizh
 * @date: 2025/7/14 - 07 - 14 - 12:42
 * @Description: search
 * @version: 1.0
 */
public class BinarySearch {
    public static void main(String[] args) {

//        int n = 20;
//        int v = 200;
//        int[] arr1 = randomArray(n, v);
//        Arrays.sort(arr1);

//        int[] arr2 = new int[]{1, 2, 2, 3, 3, 4, 5, 5, 5, 6, 7};
//        System.out.println(findRight(arr2, 5));

        int[] arr3 = new int[]{1, 5, 7, 3, 4, 2, 3, 6, 5, 6, 4};
        System.out.println(findPeakElement(arr3));
        //boolean a = search(arr1, 32);
        //System.out.println(a);
    }
    //在有序数组中确定num是否存在
    public static boolean search(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = (l + r)/ 2;
            if (arr[m] == target) {
                return true;
            }else if (arr[m] < target) {
                l = m + 1;
            }else  if (arr[m] > target) {
                r = m - 1;
            }
        }
        return false;
    }
    //在有序数组中查找>=num的最左位置
    //若大于等于num
    public static int findLeft(int arr[], int num){
        int  l = 0; int r = arr.length - 1;
        int ans = -1;
        while (l <= r) {
            int m = (l + r)/2;
            if (arr[m] >= num){
                ans = m;
                r = m - 1;
            }else if (arr[m] < num){
                l = m + 1;
            }
        }
        return ans;
    }
    //在有序数组中查找<=num的最右位置
    public static int findRight(int arr[], int num){
        int  l = 0; int r = arr.length - 1;
        int ans = -1;
        while (l <= r) {
            int m = (l + r)/2;
            if (arr[m] <= num){
                ans = m;
                l = m + 1;
            }else if (arr[m] > num){
                r = m - 1;
            }
        }
        return ans;
    }

    //二分搜索不一定发生在有序数组上(寻找峰值)
    public static int findPeakElement(int[] arr) {
        int n = arr.length;
        if(n == 1)
            return 0;
        if(arr[0] > arr[1])
            return 0;
        if(arr[n-1] > arr[n-2])
            return n-1;
        int l = 1, r = n-2;
        int m; int ans = -1;
        while(l <= r){
            m = (l + r)/2;
            if(arr[m] < arr[m+1]){
                l = m+1;
            }else if(arr[m] < arr[m-1]){
                r = m-1;
            }else{
                ans = m;
                break;
            }
        }
        return ans;
    }
}
