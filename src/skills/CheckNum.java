package skills;

/**
 * @author : lizh
 * @date: 2025/7/14 - 07 - 14 - 11:48
 * @Description: skills
 * @version: 1.0
 * 为了测试优化解是否可行,先写出一个稳定可行的暴力解,再使用对数器进行比对,下面是一个简单的测试样例
 */
public class CheckNum {

    public static void main(String[] args) {
        int n = 10;//数组长度
        int v = 200;//数字范围

        //测试样例
        int[] arr1 = randomArray(n, v);
        int[] arr2 = copyArray(arr1);
        //RadixSort.Sort();
        System.out.println(checkArray(arr1, arr2));
    }

    public static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * v + 1);
        }
        return arr;
    }

    public static int[] copyArray(int[] arr1) {
        int[] arr2 = new int[arr1.length];
        for(int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
        return arr2;
    }

    public static boolean checkArray(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

}
