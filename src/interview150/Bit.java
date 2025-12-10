package interview150;

/**
 * @author : lizh
 * @date: 2025/11/8 - 11 - 08 - 0:09
 * @Description: interview150
 * @version: 1.0
 */

public class Bit {

    // 191
    class HammingWeight {
        public int hammingWeight(int n) {
            int ans = 0;
            while(n > 0){
                if((n & -n) != 0){
                    n -= (n & -n);
                    ans++;
                }
            }
            return ans;
        }
    }



}


