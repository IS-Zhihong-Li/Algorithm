package class26;

import java.io.*;
import java.util.Arrays;

/**
 * @author : lizh
 * @date: 2025/9/11 - 09 - 11 - 17:57
 * @Description: class26
 * @version: 1.0
 */
// 基数排序
// https://www.luogu.com.cn/problem/P1177
public class RadixSort {

    public static int BASE = 10;

    public static int MAX = 100001;

    public static int[] arr = new int[MAX];

    public static int[] help = new int[MAX];

    public static int[] cnts = new int[BASE];

    public static int n;// 数组实际位数

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
        Sort();
        for (int i = 0; i < n - 1; i++) {
            out.print(arr[i] + " ");
        }
        out.println(arr[n - 1]);
        out.flush();
        out.close();
        br.close();
    }

    // 如果要排序负数, 要对每个数先减去最小值, 排完序再转回
    public static void Sort() {
        int min = arr[0];
        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] -= min;
            max = Math.max(arr[i], max);
        }
        radixSort(bit(max));

        for (int i = 0; i < n; i++) {
            arr[i] += min;
        }
    }

    // 获取最大值的位数
    private static int bit(int num) {
        int bit = 0;
        while (num > 0) {
            num /= 10;
            bit++;
        }
        return bit;
    }


    public static void radixSort(int num) {
        for (int offset = 1; num > 0; offset *= BASE, num--) {
            Arrays.fill(cnts, 0);
            // 提取位数
            for (int i = 0; i < n; i++) {
                cnts[(arr[i] / offset) % BASE]++;
            }
            // 处理成前缀累加和
            for (int i = 1; i < BASE; i++) {
                cnts[i] = cnts[i] + cnts[i - 1];
            }
            // 数字提取
            for (int i = n - 1; i >= 0; i--){
                help[ --(cnts[(arr[i] / offset) % BASE]) ] = arr[i];
            }
            // 数组回填
            for (int i = 0; i < n; i++) {
                arr[i] = help[i];
            }
        }
    }


}
