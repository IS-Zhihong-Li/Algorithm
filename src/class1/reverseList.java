package class1;

/**
 * @author : lizh
 * @date: 2025/7/16 - 07 - 16 - 1:36
 * @Description: linked
 * @version: 1.0
 */
public class reverseList {
    public static void main(String[] args) {


    }

    public class LinkedNode{
        int data;
        LinkedNode next;

        LinkedNode(){}

        public LinkedNode(int data, LinkedNode next) {
            this.data = data;
            this.next = next;
        }
    }

    // 反转链表
    public LinkedNode reserveLink(LinkedNode head){
        LinkedNode pre = null;
        LinkedNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }



    // 反转双链表
/*    	public static DoubleListNode reverseDoubleList(DoubleListNode head) {
		DoubleListNode pre = null;
		DoubleListNode next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			head.last = next;
			pre = head;
			head = next;
		}

        return pre;
    }*/
}
