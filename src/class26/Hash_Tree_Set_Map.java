package class26;

/**
 * @author : lizh
 * @date: 2025/9/4 - 09 - 04 - 22:11
 * @Description: class26
 * @version: 1.0
 */
public class Hash_Tree_Set_Map {
    /**
     *Integer、Long、Double、Float
     *Byte、Short、Character、Boolean
     *String等引用数据类型, 在new一个新的值的时候, 即便内容一样, 地址也不一样, ==判断为false, 应使用equals
     *
     * 1.HashSet HashMap 进行判断时, 依据其中内容而非地址
     * 2.一般情况下未必需要申请哈希表, 当key的范围是固定的、可控的, 可使用数组下标可平替键
     * 3.TreeMap的底层是红黑树, 提供了floorKey, ceilingKey方法
     * 4.TreeSet是去重版的TreeMap
     * 5.PriorityQueue默认小根堆
     * 6.
     *  o1.age - o2.age
     *  •返回负数 → 认为 o1优先级更高（排在前面）
     *  •返回正数 → 认为 o2优先级更高（排在后面）
     *  •返回 0 → 认为两者优先级相同（可能触发去重逻辑，如 TreeSet）
     */
}
