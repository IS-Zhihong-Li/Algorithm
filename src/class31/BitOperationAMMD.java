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
        int a = add(2,6);
        System.out.println(a);
    }

    public static int add(int a, int b){
        int ans = 0;

        while(b != 0){
//            b = (a & b) << 1;
//            a ^= b; 这里搞错了, 应该先与a异或完才变成进位
//            ans = a;

            ans = a ^ b; // 应该借助第三个数储存数据
            b = (a & b) << 1;
            a = ans;
        }
        return ans;
    }


    public int minus(int a, int b){
        return add(a, neg(b));
    }

    public int neg(int b) {
        return ~b + 1;
    }



}
