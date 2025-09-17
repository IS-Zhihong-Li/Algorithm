package class16;
//4
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : lizh
 * @date: 2025/8/26 - 08 - 26 - 16:23
 * @Description: class16
 * @version: 1.0
 */


public class BinaryTree {
    /**
     * 了解递归序即可
     * 根据递归序,
     * 时间复杂度O(n),每个节点固定会被访问三次
     * 空间复杂度O(h),保存路劲方便回到上级节点
     */


    /**
     * 非递归遍历一样
     * 时间复杂度O(n)
     * 空间复杂度O(h)
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root != null) {
                Stack<TreeNode> stack = new Stack<>();
                stack.push(root);
                while(!stack.isEmpty()){

                    root = stack.pop();
                    list.add(root.val);
                    if(root.right != null) {
                        stack.push(root.right);
                    }
                    if(root.left != null){
                        stack.push(root.left);
                    }

                }
            }
            return list;
        }


        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if(root != null){
                Stack<TreeNode> stack = new Stack<>();
                //stack.push(root);
                while(!stack.isEmpty()|| root != null){
                    if(root != null){
                        stack.push(root);
                        root = root.left;
                    }else{
                        root = stack.pop();
                        list.add(root.val);
                        root = root.right;
                    }
                }
            }
            return list;
        }

        // 利用两个栈实现后序遍历
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root != null) {
                Stack<TreeNode> stack = new Stack<>();
                Stack<TreeNode> stack2 = new Stack<>();
                stack.push(root);
                while(!stack.isEmpty()){//中右左
                    root = stack.pop();
                    stack2.push(root);
                    //list.add(root.val);
                    if(root.left != null){
                        stack.push(root.left);
                    }
                    if(root.right != null) {
                        stack.push(root.right);
                    }
                }
                while(!stack2.isEmpty()){
                    list.add(stack2.pop().val);
                }
            }
            return list;

        }


        // 一个栈实现后序遍历
        public List<Integer> postorderTraversal1(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if(root != null){
                Stack<TreeNode> stack = new Stack<>();
                stack.push(root);
                while(!stack.isEmpty()){
                    TreeNode cur = stack.peek();
                    if(cur.left != null && root != cur.left && root != cur.right){
                        //有左树且左树未被处理
                        stack.push(cur.left);
                    }else if(cur.right != null && root != cur.right){
                        //有右树且右树未被处理
                        stack.push(cur.right);
                    }else{
                        root = stack.pop();
                        list.add(root.val);
                    }

                }
            }
            return list;
        }
    }


}
