package interview150;

import java.util.Arrays;

/**
 * @author : lizh
 * @date: 2025/11/6 - 11 - 06 - 13:39
 * @Description: interview150
 * @version: 1.0
 */
public class HIndex {

    public int hIndex(int[] citations) {
        // 排序解
        Arrays.sort(citations);
        int h = 0;
        int n = citations.length;
        for(int i = 0; i < n; i++){
            if(citations[i] >= n - i) {
              h = n - i;
              break;
            }
        }
        return h;
    }
}
