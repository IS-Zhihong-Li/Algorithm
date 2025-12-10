package tools;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : lizh
 * @date: 2025/11/13 - 11 - 13 - 2:11
 * @Description: tools 这是一个工具类, 快速生成并返回 链表, 树, 等算法常用结构
 * @version: 1.0
 */
public class GenerateU {

    public static void main(String[] args) {
        ListNode head = createList(6, 5, 3, 4, 2, 1, 1, 7);

        Integer[] nodes = {3, 2, 3, null, 3, null, 1};
        TreeNode root = buildTree(nodes);

    }

    // 链表节点
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

    // 树节点
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 传入数组生成树
    public static TreeNode buildTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0 || nodes[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode current = queue.poll();

            // 处理左子节点
            if (index < nodes.length && nodes[index] != null) {
                current.left = new TreeNode(nodes[index]);
                queue.offer(current.left);
            }
            index++;

            // 处理右子节点
            if (index < nodes.length && nodes[index] != null) {
                current.right = new TreeNode(nodes[index]);
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }

}
