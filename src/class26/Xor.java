package class26;

/**
 * @author : lizh
 * @date: 2025/9/13 - 09 - 13 - 20:11
 * @Description: class26
 * @version: 1.0
 */
public class Xor {

    //https://leetcode.cn/problems/missing-number/
    //给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
    class MissingNumber {

        public int missingNumber(int[] nums) {
            int xor = 0;
            int xor2 = 0;
            for (int i = 0; i < nums.length; i++) {
                xor2 ^= i;
            }
            xor ^= nums.length;
            for (int num : nums) {
                xor ^= num;
            }
            return xor ^ xor2;
        }

    }


    // 找出唯一一个只出现了奇数次的数
    // https://leetcode.cn/problems/single-number/
    class SingleNumber {
        public int singleNumber(int[] nums) {
            int xor = 0;
            for (int num : nums) {
                xor ^= num;
            }
            return xor;
        }
    }

    // 数组中有两个数出现了奇数次, 找出它们
    // https://leetcode.cn/problems/single-number-iii/
    class DoubleNumber {
        public int[] singleNumber(int[] nums) {
            int xor = 0;
            for (int num : nums) {
                xor ^= num;
            }
            int rightOne = xor & (-xor);// 取出结果中最右侧的1, 证明这两个不同的数a,b一定会在某一位上不同
            int xor2 = 0;
            for (int num : nums) {
                if ((num & rightOne) != 0) {// 借这个不同的位, 划分成两大部分, 一部分含a, 另一部分含b
                    xor2 ^= num;
                }
            }
            return new int[]{xor2, xor ^ xor2};

        }
    }


    // 数组中有一个数出现次数小于m次, 其它数出现m次, 找出那个出现小于m次的数(这道题目已经给出m=3,所以不必传入参数m)
    // https://leetcode.cn/problems/single-number-ii/
    class OneKindNumberLessMtimes {
        public int singleNumber(int[] nums) {
            int[] cnt = new int[32];

            for (int num : nums) {
                for (int i = 0; i < 32; i++) {
                    /*if (((num >>> i) & 1) == 1) {
                        cnt[i]++;
                    }*/
                    cnt[i] += (num >> i & 1);// 优化if判断
                }
            }

            int ans = 0;
            for (int i = 0; i < 32; i++) {
                if (cnt[i] % 3 != 0) {
                    ans |= (1 << i);
                }
            }
            return ans;
        }
    }


}
