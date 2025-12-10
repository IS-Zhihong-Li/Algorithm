package class35_DS;

import java.util.PriorityQueue;

/**
 * @author : lizh
 * @date: 2025/9/20 - 09 - 20 - 17:24
 * @Description: class35_DS
 * @version: 1.0
 */
// 快速获得数据流的中位数的结构
// https://leetcode.cn/problems/find-median-from-data-stream/
public class MedianFinder {

    PriorityQueue<Integer> maxHeap;// 放较小的那部分数  [3] 2 1
    PriorityQueue<Integer> minHeap;// 放较大的那部分数, [4] 5 6 这样它们的堆顶平均值就是中位数

    // 大根堆 + 小根堆
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
        minHeap = new PriorityQueue<>((a,b) -> a - b);
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.add(num);
        else minHeap.add(num);
        balance();
    }

    public void balance(){
        if(Math.abs(maxHeap.size() - minHeap.size()) > 1){
            if(maxHeap.size() > minHeap.size()){
                minHeap.add(maxHeap.poll());
            }else{
                maxHeap.add((minHeap.poll()));
            }
        }
    }

    public double findMedian() {
        if(maxHeap.size() != minHeap.size())
            return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
        else{
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

}
