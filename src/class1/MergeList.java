package class1;

/**
 * @author : lizh
 * @date: 2025/8/4 - 08 - 04 - 0:28
 * @Description: linked
 * @version: 1.0
 */
public class MergeList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null)
            return list1 == null ? list2 : list1;

        ListNode head = list1.val > list2.val ? list2 : list1;
        ListNode cur1 = head.next;
        ListNode cur2 = list1.val > list2.val ? list1 : list2;
        ListNode pre = head;

        while (cur1 != null && cur2 != null)
        {
            if(cur1.val > cur2.val)
            {
                pre.next = cur2;
                cur2 = cur2.next;
            }else{
                pre.next = cur1;
                cur1 = cur1.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
