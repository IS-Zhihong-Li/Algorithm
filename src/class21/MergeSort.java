package class21;

/**
 * @author : lizh
 * @date: 2025/8/27 - 08 - 27 - 13:51
 * @Description: class21
 * @version: 1.0
 */

import java.io.*;


/**
 * 此后统一采用ACM写法
 */

public class MergeSort {
    /**
     * 时间O(nlogn)
     * 空间O(n)
     */
    private static int MAX = 100001;

    private static int[] arr = new int[MAX];

    private static int[] help = new int[MAX];

    private static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        n = (int) in.nval;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            arr[i] = (int) in.nval;
        }
        //mergeSort1(0, n - 1);
        mergeSort2();
        for (int i = 0; i < n - 1; i++) {
            out.print(arr[i] + " ");
        }

        out.println(arr[n - 1]);
        out.flush();
        out.close();
        br.close();

    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();  // 读取数组长度
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();  // 读取数组元素
//        }
//        sc.close();
//
//        mergeSort2();
//        for (int i = 0; i < n - 1; i++) {
//
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println(arr[n - 1]);
//    }


    /**
     * 递归版
     */
    public static void mergeSort1(int l, int r) {
        if (l == r) return;
        int m = (l + r) / 2;

        mergeSort1(l, m);
        mergeSort1(m + 1, r);
        merge(l, m, r);
    }

    private static void merge(int l, int m, int r) {
        int i = l;

        int a = l;
        int b = m + 1;
        while (a <= m && b <= r) {
            help[i++] = arr[a] < arr[b] ? arr[a++] : arr[b++];
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
    }


    /**
     * 非递归版: 步长
     */
    private static void mergeSort2() {
        for (int l, r, m, step = 1; step <= n; step <<= 1) {
            l = 0;
            while (l < n) {
                m = l + step - 1;
                if (m + 1 >= n) {
                    break;
                }
                r = Math.min(l + (step << 1) - 1, n - 1);
                merge(l, m, r);
                l = r + 1;
            }
        }
    }
}
