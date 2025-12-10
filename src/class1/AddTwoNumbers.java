package class1;

/**
 * @author : lizh
 * @date: 2025/8/4 - 08 - 04 - 1:05
 * @Description: linked
 * @version: 1.0
 */
public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = null, cur = null;

        if(l1 == null||l2 == null)
            return l1 == null?l2 : l1;
        int carry = 0;
        for(int sum, value;
            l1 != null || l2 != null;// 判断本身就可以了, 不要想着判断下一个
            l1 = l1 == null ? null : l1.next,
            l2 = l2 == null ? null : l2.next
        ){
            sum = (l1 == null ? 0 : l1.val) +
                    (l2 == null ? 0 : l2.val) + carry;
            value = sum%10;
            carry = sum/10;

            if (ans == null) {
                ans = new ListNode(value);
                cur = ans;
            }else{
                cur.next = new ListNode(value);
                cur = cur.next;
            }
        }

        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return ans;
    }
}
