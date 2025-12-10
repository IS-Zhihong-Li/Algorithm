package class12;

/**
 * @author : lizh
 * @date: 2025/8/25 - 08 - 25 - 22:14
 * @Description: class12
 * @version: 1.0
 */
public class partitionList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

    // 传入数组生成链表
    public static ListNode createList(int... values) {
        if (values.length == 0) return null;

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // 正确创建链表的方式
        ListNode head = createList(6, 5, 3, 4, 2, 1, 1, 7);

        // 假设 partition 方法已经实现
        ListNode partition = partition(head, 4);

        while (partition != null)
        {
            System.out.println(partition.val);
            partition = partition.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode leftHead = null, leftTail = null;
        ListNode rightHead = null, rightTail = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < x) {
                if(leftHead == null) {
                    leftHead = head;
                    leftTail = leftHead;
                }else {
                    leftTail.next = head;
                    leftTail = leftTail.next;
                }
            }else{
                if(rightHead == null) {
                    rightHead = head;
                    rightTail = rightHead;
                }else {
                    rightTail.next = head;
                    rightTail = rightTail.next;
                }
            }
            head = next;
        }
        if(leftHead == null)
            return rightHead;
        leftTail.next = rightHead;
        return leftHead;
    }

}
