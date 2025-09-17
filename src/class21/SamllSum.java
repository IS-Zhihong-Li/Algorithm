package class21;

/**
 * @author : lizh
 * @date: 2025/8/30 - 08 - 30 - 13:06
 * @Description: class21
 * @version: 1.0
 */

import java.io.*;

/**
 * 归并分治
 * 1.如果解决一个大范围上的问题答案可以被简化为, 左部分答案 + 右部分答案 + 跨左右的部分的答案
 * 2.如果数据有序能否简化问题, 如果可以, 就大概率可以使用归并分治
 */
//https://www.nowcoder.com/practice/edfe05a1d45c4ea89101d936cac32469
public class SamllSum {

    private static int MAX = 100001;

    private static int[] arr = new int[MAX];

    private static int[] help = new int[MAX];

    private static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            out.println(smallSum(0, n - 1));
        }
        out.flush();
        out.close();

    }

    public static long smallSum(int l, int r) {
        if (l == r) return 0L;
        int m = l + (r-l) / 2;

        return smallSum(l, m) + smallSum(m + 1, r) + merge(l, m, r);

    }

    public static long merge(int l, int m, int r) {
        long ans = 0;

        for (int i = l, j = m + 1,sum = 0; j <= r; j++) {
            while (i <= m && arr[i]<=arr[j]) {
                sum += arr[i++];
            }
//            while (i <= m) {三目不行的,会导致无限循环,不符合条件就应该直接跳出循环
//                sum += arr[i] < arr[j] ? arr[i++] : 0;
//            }
            ans += sum;
        }

        int i = l;
        int a = l;
        int b = m + 1;
        while(a <= m && b <= r){
            help[i++] = arr[a] < arr[b] ? arr[a++] :arr[b++];
        }
        while(a <= m){
            help[i++] = arr[a++];
        }
        while(b <= r){
            help[i++] = arr[b++];
        }
        for(i=l;i<=r;i++){
            arr[i] = help[i];
        }


        return ans;

    }

}
