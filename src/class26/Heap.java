package class26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author : lizh
 * @date: 2025/9/19 - 09 - 19 - 19:56
 * @Description: class26
 * @version: 1.0
 */
public class Heap {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    // 合并k个有序链表
    // https://www.nowcoder.com/practice/65cfde9e5b9b4cf2b6bafa5f3ef33fa6
    // https://leetcode.cn/problems/merge-k-sorted-lists/?envType=study-plan-v2&envId=top-100-liked
    public ListNode mergeKLists (ArrayList<ListNode> lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);

        if(lists == null) return null;
        for (ListNode list : lists) {
            if(list != null)
                heap.add(list);
        }
        if(heap.isEmpty())
            return null;

        ListNode h = heap.poll();
        ListNode pre = h;
        if(h.next != null)
            heap.add(h.next);

        while(!heap.isEmpty()){// 不断将数填入堆, 弹出时将数组下一个数加入堆
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if(pre.next != null)
                heap.add(pre.next);

        }
        return h;

    }


    // 最多线段重合问题
    // https://www.nowcoder.com/practice/1ae8d0b6bb4e4bcdbf64ec491f63fc37
    class MinMeetingRooms {
        public int minMeetingRooms(int[][] intervals) {
            int n = intervals.length;
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            Arrays.sort(intervals, (a,b)-> a[0] - b[0]);

            int ans = 0;
            for (int i = 0; i < n; i++) {
                while(!heap.isEmpty() && intervals[i][0] >= heap.peek()){
                    heap.poll();
                }
                //if(intervals[i][1] > heap.peek()){这里不需要if直接添加就行了
                heap.add(intervals[i][1]);
                //}
                ans = Math.max(heap.size(), ans);
            }
            return ans;
        }
    }


    // 将数组累加和减半的最少操作次数
    // https://leetcode.cn/problems/minimum-operations-to-halve-array-sum/
    class HalveArray {
        public int halveArray(int[] nums) {
            PriorityQueue<Double> heap = new PriorityQueue<>((a,b) -> b.compareTo(a));
            double sum = 0;
            for (int num : nums) {
                heap.add((double) num);
                sum += num;
            }
            sum /= 2;
            int ans = 0;
            for(double minus = 0, cur = 0; minus < sum; minus+=(cur/2),ans++){
                cur = heap.poll();
                heap.add(cur/2);
            }

            return ans;
        }
    }


}
