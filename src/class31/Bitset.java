package class31;

/**
 * @author : lizh
 * @date: 2025/9/14 - 09 - 14 - 17:15
 * @Description: class31
 * @version: 1.0
 */

/**
 * 设计位图
 * Bitset(int size)
 * void add(int num)
 * void remove(int num)
 * void reverse(int num)
 * boolean contains(int num)
 */

/*public class Bitset {
    public int[] set;


    public Bitset(int n) {
        set = new int[(n + 31) / 32];
    }

    public void add(int num) {
        set[num / 32] |= 1 << (num % 32);
    }

    public void remove(int num) {
        set[num / 32] &= ~(1 << num % 32);
    }

    public void reverse(int num) {
        set[num / 32] ^= 1 << (num % 32);
    }

    public boolean contains(int num) {
        return (((set[num/32] >> (num%32)) & 1)  == 1);
    }

    // 对数器测试
    public static void main(String[] args) {
        int n = 1000;
        int testTimes = 10000;
        System.out.println("测试开始");
        // 实现的位图结构
        Bitset bitSet = new Bitset(n);
        // 直接用HashSet做对比测试
        HashSet<Integer> hashSet = new HashSet<>();
        System.out.println("调用阶段开始");
        for (int i = 0; i < testTimes; i++) {
            double decide = Math.random();
            // number -> 0 ~ n-1，等概率得到
            int number = (int) (Math.random() * n);
            if (decide < 0.333) {
                bitSet.add(number);
                hashSet.add(number);
            } else if (decide < 0.666) {
                bitSet.remove(number);
                hashSet.remove(number);
            } else {
                bitSet.reverse(number);
                if (hashSet.contains(number)) {
                    hashSet.remove(number);
                } else {
                    hashSet.add(number);
                }
            }
        }
        System.out.println("调用阶段结束");
        System.out.println("验证阶段开始");
        for (int i = 0; i < n; i++) {
            if (bitSet.contains(i) != hashSet.contains(i)) {
                System.out.println(i + "出错了!");
            }
        }
        System.out.println("验证阶段结束");
        System.out.println("测试结束");
    }

}
*/

class Bitset {
    int[] set;
    int size;
    int ones;
    int zeros;
    boolean reverse;

    public Bitset(int size) {
        set = new int[(size + 31) / 32];
        this.size = size;
        ones = 0;
        zeros = size;
        reverse = false;
    }

    public void fix(int num) {
        int idx = num / 32;
        int bit = num % 32;
        if (!reverse) {
            if(((set[idx] >> bit) & 1) != 1){// 或者(set[index] & (1 << bit)) == 0
                set[idx] |= 1 << bit;
                ones++;
                zeros--;
            }
        } else {
            if(((set[idx] >> bit) & 1) == 1){
                set[idx] &= ~(1 << bit);
                ones++;
                zeros--;
            }
        }
    }

    public void unfix(int num) {
        int idx = num / 32;
        int bit = num % 32;
        if (!reverse) {
            if(((set[idx] >> bit) & 1) == 1){
                set[idx] &= ~(1 << bit);
                ones--;
                zeros++;
            }
        } else {
            if(((set[idx] >> bit) & 1) != 1){
                set[idx] |= 1 << bit;
                ones--;
                zeros++;
            }
        }
    }

    // 翻转每一位上的值
    public void flip() {
        reverse = !reverse;
        int temp = ones;
        ones = zeros;
        zeros = temp;
    }

    // 检查是否全为1
    public boolean all() {
        return ones == size;
    }

    // 检查是否有任何一个1
    public boolean one() {
        return ones != 0;
    }

    // 检查1的总数
    public int count() {
        return ones;
    }

    // 将位图以字符串返回
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i = 0, k = 0, number, status;i < size; k++){
            number = set[k];
            for(int j = 0; j < 32 && i < size; j++, i++){
                status = (number >> j) & 1;
                status ^= reverse ? 1 : 0;// ^1 反转, ^0 不变
                builder.append(status);
            }
        }
        return builder.toString();
    }

}
