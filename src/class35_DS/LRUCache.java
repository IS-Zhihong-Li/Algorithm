package class35_DS;

/**
 * @author : lizh
 * @date: 2025/9/17 - 09 - 17 - 21:12
 * @Description: class35_pp
 * @version: 1.0
 */
// 设计一个LRU数据结构
// 双向链表 + 哈希表, 哈希表记录链表节点地址
// https://leetcode.cn/problems/lru-cache/

public class LRUCache {

    class DoubleNode {
        DoubleNode last;
        DoubleNode next;
        int k;
        int v;

        DoubleNode(int key, int val) {k = key;v = val;}
    }

    public LRUCache(int capacity) {

    }

    public int get(int key) {
        return 0;
    }

    public void put(int key, int value) {

    }
}
