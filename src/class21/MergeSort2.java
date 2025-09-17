package class21;

import java.util.Scanner;

public class MergeSort2 {
    private static int MAX = 100001;
    private static int[] arr = new int[MAX];
    private static int[] help = new int[MAX];
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // 读取数组长度
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();  // 读取数组元素
        }
        sc.close();  // 关闭Scanner

        mergeSort1(0, n - 1);  // 调用递归版归并排序
        // mergeSort2();  // 也可以调用非递归版

        // 输出排序后的数组
        for (int i = 0; i < n - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[n - 1]);  // 最后一个元素单独处理，避免末尾多余空格
    }

    /**
     * 递归版归并排序
     */
    public static void mergeSort1(int l, int r) {
        if (l >= r) return;  // 递归终止条件：区间长度 <= 1
        int m = l + (r - l) / 2;  // 计算中点，避免溢出
        mergeSort1(l, m);      // 递归排序左半部分
        mergeSort1(m + 1, r);  // 递归排序右半部分
        merge(l, m, r);        // 合并两个有序区间
    }

    /**
     * 合并两个有序区间 [l, m] 和 [m+1, r]
     */
    private static void merge(int l, int m, int r) {
        int i = l;      // help数组的指针
        int a = l;      // 左半部分的指针
        int b = m + 1;  // 右半部分的指针

        // 合并两个有序数组
        while (a <= m && b <= r) {
            help[i++] = arr[a] < arr[b] ? arr[a++] : arr[b++];
        }

        // 处理剩余元素（左半部分）
        while (a <= m) {
            help[i++] = arr[a++];
        }

        // 处理剩余元素（右半部分）
        while (b <= r) {
            help[i++] = arr[b++];
        }

        // 将help数组的数据拷贝回arr
        for (i = l; i <= r; i++) {
            arr[i] = help[i];
        }
    }

    /**
     * 非递归版归并排序（基于步长）
     */
    public static void mergeSort2() {
        for (int step = 1; step < n; step *= 2) {          // 步长从1开始，每次翻倍
            for (int l = 0; l < n; l += 2 * step) {        // 按步长分组
                int m = l + step - 1;                      // 计算中间点
                if (m >= n - 1) break;                     // 没有右半部分，无需合并
                int r = Math.min(l + 2 * step - 1, n - 1); // 计算右边界
                merge(l, m, r);                            // 合并当前组
            }
        }
    }
}
