package external;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. 统计数字频率
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // 2. 创建最小堆（按频率升序），堆大小为 k
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue()
        );

        // 3. 遍历频率表，维护堆的大小为 k
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (heap.size() < k) {
                heap.offer(entry);
            } else if (entry.getValue() > heap.peek().getValue()) {
                heap.poll();
                heap.offer(entry);
            }
        }

        // 4. 提取结果
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll().getKey();
        }
        return ans;
    }
}
