package class31;

/**
 * @author : lizh
 * @date: 2025/9/17 - 09 - 17 - 19:01
 * @Description: 这一章思路较简单, 但是非常考验coding能力
 * @version: 1.0
 */

public class List {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    // 1.返回两个链表的第一个相交节点
    // https://leetcode.cn/problems/intersection-of-two-linked-lists/
    public class GetIntersectionNode {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            if (headA == null || headB == null)
                return null;

            ListNode h1 = headA, h2 = headB;
            int LA = 0, LB = 0;
            while (h1 != null) {
                LA++;
                h1 = h1.next;
            }
            while (h2 != null) {
                LB++;
                h2 = h2.next;
            }

            // 让较长的链表先走差值长度的步数, 就会在交点相遇
            int LC = LA - LB;
            if (LC > 0) {
                for (int i = LC; i > 0; i--) {
                    headA = headA.next;
                }
            } else {
                for (int i = -LC; i > 0; i--) {
                    headB = headB.next;
                }
            }
            while (headA != null) {
                if (headA == headB)
                    return headA;
                headA = headA.next;
                headB = headB.next;
            }
            return null;
        }
    }


    // 2.每k个节点为一组翻转链表(困难)
    // https://leetcode.cn/problems/reverse-nodes-in-k-group/
    class ReverseListByGroup {
        // 容器化:装填进数组,翻转后再组成链表
        // 非容器化:老老实实翻转, !判断边界条件!
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) return null;


            return head;
        }


        // 判断能否进行翻转
        public boolean checkRev(ListNode head, int k) {
            while (k-- > 0) {
                if (head == null)
                    return false;
                head = head.next;
            }
            return true;
        }


        // TODO翻转区间内链表
        public void reverse(ListNode head, int k, ListNode tail) {// 传入尾节点, 让原本的头节点指向它
            ListNode pre = tail;
            ListNode next = null;

            while (k-- > 0) {// 判断条件待斟酌
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }

        }


    }

    // 3.复制含有随机指针的链表
    // https://leetcode.cn/problems/copy-list-with-random-pointer/
    class CopyRandomList {
        public Node copyRandomList(Node head) {
            // 容器化:使用原链表a作key, 新建链表a'做value, 每次需要原链表数据时直接从map中获取
            // 非容器化:在原链表中插入新建节点 a->a' ->b->b' ->c->c' ->null,
            //         这样就可以直接从原链表获取数据, 复制完成之后再分离链表




            return null;
        }
    }


    // 4.判断链表是否回文结构
    // https://leetcode.cn/problems/palindrome-linked-list/
    class IsPalindrome {
        public boolean isPalindrome(ListNode head) {
            // 容器化:使用栈, 先进后出
            // 非容器化:快慢指针获取中点, 翻转包括s位置的后半段链表, 从两个头遍历判断, 直到有一条链表指向空
            if(head == null || head.next == null)
                return true;
            ListNode f = head;
            ListNode s = head;

            while(f.next != null && f.next.next != null){
                f = f.next.next;
                s = s.next;
            }

            ListNode tail = reverse(s);
            while(head != null && tail != null){
                if(head.val != tail.val) return false;
                head = head.next;
                tail = tail.next;
            }
            return true;

            // 链表翻转完要翻转回去, 这里偷个懒
        }

        public ListNode reverse(ListNode head){
            ListNode pre = null;
            ListNode next = null;

            while (head != null) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }
    }

    // 5.找出入环节点
    // https://leetcode.cn/problems/linked-list-cycle-ii/
    public class DetectCycle {
        public ListNode detectCycle(ListNode head) {

            // 设置快慢指针, 当指针相遇时, 快指针回到头节点一步一步移动, 最终一定与慢指针在入环处相遇
            ListNode f = head;
            ListNode s = head;

            // 循环判断之前先走一步
            if (s != null && s.next != null && f.next.next != null) {
                f = f.next.next;
                s = s.next;
            } else {
                return null;
            }
            while (f != s) {
                if (f.next == null || f.next.next == null)// 边界判断, 非成环列表直接null
                    return null;
                f = f.next.next;
                s = s.next;
            }
            f = head;
            while (f != s) {
                f = f.next;
                s = s.next;
            }
            return s;

        }
    }


}
