package class26;

/**
 * @author : lizh
 * @date: 2025/9/14 - 09 - 14 - 20:18
 * @Description: class26
 * @version: 1.0
 */
public class SortSummary {
    /**
     *                  时间        空间        稳定性(实例化对象)
     * SelectionSort    O(N^2)      O(1)        无
     * BubbleSort       O(N^2)      O(1)        有
     * InsertionSort    O(N^2)      O(1)        有
     * MergeSort        O(N*logN)   O(N)        有
     * QuickSort        O(N*logN)   O(logN)     无
     * HeapSort         O(N*logN)   O(1)        无
     * CountSort        O(N)        O(M)        有
     * RadixSort        O(N)        O(M)        有
     *
     *
     * 数据量非常小的情况下可以做到非常迅速：                                   插入排序
     * 性能优异、实现简单且利于改进（面对不同业务可以选择不同划分策略）、不在乎稳定性：随机快排
     * 性能优异、不在乎额外空间占用、具有稳定性：                                归并排序
     * 性能优异、额外空间占用要求0(1)、不在乎稳定性：                            堆排序
     */
}
