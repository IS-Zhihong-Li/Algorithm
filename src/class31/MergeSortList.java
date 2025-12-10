package class31;

/**
 * @author : lizh
 * @date: 2025/9/17 - 09 - 17 - 20:19
 * @Description: class31
 * @version: 1.0
 */

/**
 * 在O(NlogN)时间复杂度, O(1)空间复杂度下, 对list进行排序, 要求稳定 -> 归并排序
 * https://leetcode.cn/problems/sort-list/
 */
public class MergeSortList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode sortList(ListNode head) {
        if( head == null) return null;
        int n = 0;
        ListNode cur = head;
        while (cur != null){
            n++;
            cur = cur.next;
        }

        ListNode l1, r1, l2, r2, next, lastTeamEnd;
        for (int i = 1; i < n; i <<= 1) {
            l1 = head;
            r1 = findStep(l1, i);
            l2 = r1.next;
            r2 = findStep(l2, i);
            next = r2.next;

            r1.next = null;
            r2.next = null;
            merge(l1, r1, l2, r2);

            head = start;
            lastTeamEnd = end;
            while(next != null){
                l1 = next;
                r1 = findStep(l1, i);
                l2 = r1.next;
                if(l2 == null){
                    lastTeamEnd.next = l1;
                    break;
                }
                r2 = findStep(l2, i);
                next = r2.next;

                r1.next = null;
                r2.next = null;

                merge(l1, r1, l2, r2);
                lastTeamEnd.next = start;
                lastTeamEnd = end;
            }


        }






        return head;
    }

    // 步长判断结尾
    public ListNode findStep(ListNode s, int k){
        while(s != null && --k !=0){
            s = s.next;
        }
        return s;
    }


    // 标识merge之后那一段的头和尾
    public ListNode start = null;
    public ListNode end = null;


    public void merge(ListNode l1, ListNode r1, ListNode l2, ListNode r2){
        ListNode pre = l1;
        if(l1.val <= l2.val){// 决定头结点
            start = l1;
            pre = l1;
            l1 = l1.next;
        }else{
            start = l2;
            pre = l2;
            l2 = l2.next;
        }
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            }
        }
        if(l1 != null){// 决定尾节点
            pre.next = l1;
            end = r1;
        }else{
            pre.next = l2;
            end = r2;
        }

    }

}
