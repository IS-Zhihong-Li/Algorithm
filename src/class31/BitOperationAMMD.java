package class31;

/**
 * @author : lizh
 * @date: 2025/9/14 - 09 - 14 - 20:54
 * @Description: class31
 * @version: 1.0
 */

/**
 * 使用位运算实现加减乘除
 */
public class BitOperationAMMD {
    public static void main(String[] args) {
        int a = add(2, 6);
        System.out.println(a);
    }

    public static int add(int a, int b) {
        int ans = 0;

        while (b != 0) {
//            b = (a & b) << 1;
//            a ^= b; 这里搞错了, 应该先与a异或完才变成进位
//            ans = a;

            ans = a ^ b; // 应该借助第三个数储存数据
            b = (a & b) << 1;
            a = ans;
        }
        return ans;
    }


    public static int minus(int a, int b) {
        return add(a, neg(b));
    }

    public static int neg(int b) {
        return ~b + 1;
    }

    //a   01001
    //b   00110
    public int multiply(int a, int b) {
        int ans = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans = add(ans, a);
            }
            b >>>= 1;
            a <<= 1;
        }
        return ans;
    }

    public static int div(int a, int b) {
        int x = a > 0 ? a : neg(a);
        int y = b > 0 ? b : neg(b);
        int ans = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                ans |= (1 << i);
                x = minus(x, (y << i));
            }
        }
        return a > 0 ^ b > 0 ? neg(ans) : ans;
    }

    public static int MIN = Integer.MIN_VALUE;

    // 整数最小值 -2,147,483,648 绝对值大于最大值, 没法转成正数, 要单独处理
    public static int divide(int a, int b) {
        if (a == MIN && b == MIN) {
            // a和b都是整数最小
            return 1;
        }
        if (a != MIN && b != MIN) {
            // a和b都不是整数最小，那么正常去除
            return div(a, b);
        }
        if (b == MIN) {
            // a不是整数最小，b是整数最小
            return 0;
        }
        // a是整数最小，b是-1，返回整数最大，因为题目里明确这么说了
        if (b == neg(1)) {
            return Integer.MAX_VALUE;
        }
        // a是整数最小，b不是整数最小，b也不是-1
        a = add(a, b > 0 ? b : neg(b));
        int ans = div(a, b);
        int offset = b > 0 ? neg(1) : 1;
        return add(ans, offset);
    }
}
