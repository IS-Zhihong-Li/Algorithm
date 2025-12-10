package class31;

/**
 * @author : lizh
 * @date: 2025/9/15 - 09 - 15 - 19:48
 * @Description: class31
 * @version: 1.0
 */

// (n & -n) 获取二进制串中最右边的1
public class BitOperation {

    // 判断是否2的幂次
    class IsPowerOfTwo {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & -n) == n;
        }
    }

    // 判断是否3的幂次
    class IsPowerOfThree {
        public boolean isPowerOfThree(int n) {
            return 1162261467 % 3 == 0;
        }
    }

    // 返回大于等于n的最小2次幂
    class Near2Power {
        public int near2Power(int n) {
            if (n <= 0)
                return 1;

            n--;
            n |= n >>> 1;
            n |= n >>> 2;
            n |= n >>> 4;
            n |= n >>> 8;
            n |= n >>> 16;
            return n + 1;
        }
    }

    // 返回区间内所有数字&和
    // https://leetcode.cn/problems/bitwise-and-of-numbers-range/
    class LeftToRightAnd {
        // 可以理解为求区间内数字二进制码的共同前缀
        public int rangeBitwiseAnd(int left, int right) {
            while (left < right) {
                right -= right & -right;// 不断减去最右测的1, 直到数字相同退出循环
            }
            return right;
        }
    }


    // 颠倒给定的二进制位
    // https://leetcode.cn/problems/reverse-bits/
    class ReverseBits {
        // 不断交换划定步长的两位数
        public int reverseBits(int n) {
            n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
            n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
            n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
            n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
            n = (n << 16) | (n >>> 16);
            return n;
        }
    }


    // 返回两个整数间的翰明距离, 即不相同的位数, 只需将两数异或可得
    // https://leetcode.cn/problems/hamming-distance/
    class HammingDistance {
        public int xor(int x, int y) {
            return x ^ y;
        }

        public int hammingDistance(int x, int y) {
            int n = xor(x,y);
            n = ((n & 0xaaaaaaaa) >>> 1) + (n & 0x55555555);
            n = ((n & 0xcccccccc) >>> 2) + (n & 0x33333333);
            n = ((n & 0xf0f0f0f0) >>> 4) + (n & 0x0f0f0f0f);
            n = ((n & 0xff00ff00) >>> 8) + (n & 0x00ff00ff);
            n = ((n & 0xffff0000) >>> 16) + (n & 0x0000ffff);

            return n;
        }
    }



}
