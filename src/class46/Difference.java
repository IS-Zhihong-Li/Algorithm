package class46;

import java.io.*;

/**
 * @author : lizh
 * @date: 2025/11/3 - 11 - 03 - 19:54
 * @Description: class46
 * @version: 1.0
 */
public class Difference {


    // 一维差分
    // https://leetcode.cn/problems/corporate-flight-bookings/description/
    class CorpFlightBookings {

        public int[] corpFlightBookings(int[][] bookings, int n) {

            int[] arr = new int[n + 2];
            // 将[i, j, k]中的i设成k, i+1 设成-k
            for (int i = 0; i < bookings.length; i++) {
                arr[bookings[i][0]] += bookings[i][2];
                arr[bookings[i][1] + 1] -= bookings[i][2];
            }

            // 计算前缀和
            for (int i = 1; i < arr.length; i++) {
                arr[i] = arr[i - 1] + arr[i];
            }

            // 刷回答案数组
            int[] ans = new int[n];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = arr[i + 1];
            }
            return ans;
        }
    }


    // 等差数列差分
    // https://www.luogu.com.cn/problem/P4231
    public static class Code02_ArithmeticSequenceDifference {

        public static int MAXN = 10000005;

        public static long[] arr = new long[MAXN];

        public static int n, m;

        public static void main(String[] args) throws IOException {

        }


    }

    private static void build() {


    }

    private static void set(int l, int r, int s, int e, int d) {


    }

}




