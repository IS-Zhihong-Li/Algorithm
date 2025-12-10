package class36;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : lizh
 * @date: 2025/9/18 - 09 - 18 - 15:57
 * @Description: class35_pp
 * @version: 1.0
 */

// 二叉树高频题目
public class BinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 二叉树层序遍历
    // https://leetcode.cn/problems/binary-tree-level-order-traversal/
    class LevelOrder {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();

            TreeNode[] queue = new TreeNode[2001];
            int l = 0, r = 0, size = 0;
            if (root == null) return new ArrayList<>();
            queue[r++] = root;
            while (l < r) {
                List<Integer> aa = new ArrayList<>();

                size = r - l;// 根据大小一层一层处理
                for (int i = 0; i < size; i++) {
                    root = queue[l++];
                    aa.add(root.val);
                    if (root.left != null) {
                        queue[r++] = root.left;// 加入左节点
                    }
                    if (root.right != null) {
                        queue[r++] = root.right;// 加入右节点
                    }

                }
                ans.add(aa);
            }

            return ans;
        }
    }

    // 二叉树锯齿型层序遍历
    // https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
    class ZigzagLevelOrder {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            TreeNode[] queue = new TreeNode[2001];

            int l = 0, r = 0, size = 0;
            if (root == null) return new ArrayList<>();
            boolean reserve = false;
            queue[r++] = root;
            while (l < r) {
                List<Integer> arr = new ArrayList<>();
                size = r - l;
                // 只是修改了读的方法, 入队的循环不要改, 使用k保存要读取的数据量, i j控制起点和方向
                for (int i = reserve ? r - 1 : l, j = reserve ? -1 : 1, k = 0; k < size; i += j, k++) {
                    TreeNode cur = queue[i];
                    arr.add(cur.val);
                }
                // 依然按照层序遍历入队
                for (int i = 0; i < size; i++) {
                    root = queue[l++];
                    if (root.left != null) {
                        queue[r++] = root.left;// 加入左节点
                    }
                    if (root.right != null) {
                        queue[r++] = root.right;// 加入右节点
                    }
                }
                ans.add(arr);
                reserve = !reserve;
            }
            return ans;
        }
    }

    // 返回二叉树的最大特殊宽度
    // https://leetcode.cn/problems/maximum-width-of-binary-tree/
    class WidthOfBinaryTree {
        TreeNode[] nq = new TreeNode[3001];
        int[] iq = new int[3001];

        public int widthOfBinaryTree(TreeNode root) {
            int ans = 0;
            int l = 0, r = 0;
            nq[r] = root;
            iq[r++] = 1;
            int size = 0;
            while (l < r) {
                size = r - l;
                ans = Math.max(iq[r - 1] - iq[l] + 1, ans);// 在入队之前查看队列里有多少数, 并根据iq算出其差值
                for (int i = 0; i < size; i++) {
                    root = nq[l]; // 统一写法每次都要同时操作两个队列 /* 这里已经将索引移动, 下面必须使用l - 1 */
                    int id = iq[l++];
                    if (root.left != null) {
                        nq[r] = root.left;
                        iq[r++] = id * 2;
                    }
                    if (root.right != null) {
                        nq[r] = root.right;
                        iq[r++] = id * 2 + 1;
                    }
                }
            }

            return ans;
        }
    }

    // 返回二叉树的最小深度
    // https://leetcode.cn/problems/minimum-depth-of-binary-tree/
    // 最大深度
    // https://leetcode.cn/problems/maximum-depth-of-binary-tree/
    class MaxMinDepth {
        public int maxDepth(TreeNode root) {
            return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }

        public int minDepth(TreeNode root) {
            return 0;
        }

    }


    // 二叉树先序序列化和反序列化(困难)
    // https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
    public class PreSerialize {

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            f(root, sb);
            return sb.toString();
        }

        public void f(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("#,");
                return;
            }
            sb.append(root.val).append(',');
            f(root.left, sb);
            f(root.right, sb);
        }


        public int cnt = 0;
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] arr = data.split(",");
            cnt = 0;
            return g(arr);
        }

        public TreeNode g(String[] arr){
            String cur = arr[cnt++];
            if(cur.equals("#")){
                return null;
            }else{
                TreeNode root = new TreeNode(Integer.valueOf(cur));
                root.left = g(arr);
                root.right = g(arr);
                return root;
            }
        }
    }


    // 二叉树按层序列化和反序列化(困难)
    // https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
    public class LevelSerialize {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        // Encodes a tree to a single string.
        TreeNode[] queue = new TreeNode[10001];
        int l, r;

        public String serialize(TreeNode root) {
             StringBuilder ans = new StringBuilder();
             TreeNode[] queue = new TreeNode[10001];
             l = 0;
             r = 0;
             queue[l++] = root;
             while(l < r){
                 int size = r - l;
                 ans.append(queue[l].val);
                 for(int i = 0; i < size; i++){
                    if(root.left == null)
                        ans.append("#,");
                    else
                        ans.append(queue[l].val).append(',');
                    if(root.right == null)
                        ans.append("#,");
                    else
                        ans.append(queue[l].val).append(',');
                 }

             }
            // System.out.println(ans.toString());
            return ans.toString();

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) { // 这里不要用size处理一整行了, 队列即可
            return null;
        }
    }


    // 利用先序与中序遍历序列构造二叉树
    // https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    class BuildTree {
        public TreeNode buildTree(int[] preorder, int[] inorder) {


            return null;
        }

    }


    // 验证完全二叉树
    // https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
    class IsCompleteTree {
        public boolean isCompleteTree(TreeNode root) {
            // 层序遍历成数组, 再判断?


            return true;
        }
    }

    // 求完全二叉树的节点个数
    // https://leetcode.cn/problems/count-complete-tree-nodes/
    class CountNodes {
        public int countNodes(TreeNode root) {


            return 0;
        }
    }

}