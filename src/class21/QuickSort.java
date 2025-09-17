package class21;

import java.io.*;

/**
 * @author : lizh
 * @date: 2025/8/30 - 08 - 30 - 17:53
 * @Description: class21
 * @version: 1.0
 */
//https://www.luogu.com.cn/problem/P1177
public class QuickSort {
    /**
     * <=x放左边, >=x放右边, 并且<=x的最后一个数是x
     *
     */


    /**
     * 优化点
     * 将=x的部分放中间, 并引入两个全局变量记录=区域的大小
     *
     * 1.i<x, a,i交换, a++, i++
     * 2.i=x, i++
     * 3.i>x, b,i交换, b--
     */
    private static int MAX = 100001;

    private static int[] arr = new int[MAX];

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
        quickSort(0, n-1);
        for (int i = 0; i < n - 1; i++) {
            out.print(arr[i] + " ");
        }

        out.println(arr[n - 1]);
        out.flush();
        out.close();
        br.close();
    }
//        public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();  // 读取数组长度
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();  // 读取数组元素
//        }
//        sc.close();
//
//        quickSort(0, n-1);
//        for (int i = 0; i < n - 1; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println(arr[n - 1]);
//    }

    private static void quickSort(int l, int r) {
        if(l>=r) {
            return;
        }

        int x = arr[l + (int)(Math.random()*(r - l + 1))];// x是在区间内挑选出来的值

        partition(l, r, x);

        int left = first - 1;
        int right = last + 1;
        quickSort(l, left);
        quickSort(right, r);

    }

    public static int first;
    public static int last;

    public static void partition(int l, int r, int x) {
        int a = l;
        int b = r;
        int i = l;

        while(i <= b){
            if(arr[i] < x){
                swap(a++,i++);
            }else if(arr[i] == x){
                i++;
            }else{
                swap(b--, i);
            }
        }
        first = a;
        last = b;

    }

    public static void swap(int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
/*
7
6 3 7 9 4 8 4
*/