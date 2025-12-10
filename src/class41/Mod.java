package class41;

/**
 * @author : lizh
 * @date: 2025/11/6 - 11 - 06 - 21:46
 * @Description: class41
 * @version: 1.0
 */
public class Mod {

    // 辗转相除法
    // 最大公约数 O((log a)^3)
    public static long gcb(long a, long b) {
        return b == 0 ? a : gcb(b, a % b);
    }

    // 最小公倍数
    public static long lcm(long a, long b) {
        return a / gcb(a, b) * b;
    }

    // 第N个神奇的数字(困难)
    // https://leetcode.cn/problems/nth-magical-number/
    class NthMagicalNumber {
        public int nthMagicalNumber(int n, int a, int b) {
            long m = 0;
            long ans = 0;
            long lcm = lcm(a,b);
            for(long l = 0, r = n * Math.min(a,b); l <= r;){
                m = (l + r)/2;
                if(m / a + m / b - m / lcm >= n){ // 说明答案在右边
                    ans = m;
                    r = m - 1;
                }else l = m + 1;
            }

            return (int) (ans % 100000007);// 这里应该先取模再转类型!! 否则溢出
        }
        public  long gcb(long a, long b) {
            return b == 0 ? a : gcb(b, a % b);
        }

        // 最小公倍数
        public  long lcm(long a, long b) {
            return a / gcb(a, b) * b;
        }
    }

    // 加法, 减法, 乘法的同余原理
    class SameMod{
        // 对两个数 加法乘法 的结果取模, 可以先对乘数被乘数取模之后再运算
        // 对于减法比较特殊, 应该先加上mod, (a - b + mod)(mod m)
    }

}
