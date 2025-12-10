package class36;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : lizh
 * @date: 2025/9/20 - 09 - 20 - 16:58
 * @Description: class36
 * @version: 1.0
 */
public class BinaryTree_2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // 普通二叉树上寻找两个节点的最近公共祖先(LCA问题)  --进阶--> tarjan算法
    // 两种情况:
    // 1. 包含: 遇到其中一个直接返回, 此节点必为公共祖先
    // 2. 分开: 必定在某点节点为root时, 左右节点都有返回
    // https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
    class LowestCommonAncestor {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if(root == null || root == p || root == q) // 包含/抵达叶子节点
                return root;
            TreeNode l = lowestCommonAncestor(root.left, p , q);
            TreeNode r = lowestCommonAncestor(root.right, p , q);

            if(l == null && r == null) // 两边都没有, 认为此节点为空
                return null;
            if(l != null && r != null) // 两边都有, 此节点为目标节点
                return root;
            return l != null ? l : r; // 一边有一边没有, 返回有的那个
        }
    }

    // 搜索二叉树上寻找两个节点的最近公共祖先
    // 1. 两个都大于或小于节点值, 往其中一边走
    // 2. 刚好等于某个节点, 此节点就是
    // 3. 在两边, 此节点就是
    // https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/
    class LowestCommonAncestor2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            while(root.val != p.val && root.val != q.val){
                if(root.val > Math.min(p.val, q.val) && root.val < Math.max(p.val, q.val))
                    break;
                root = root.val > Math.max(p.val, q.val) ? root.left : root.right;
            }
            return root;
        }
    }

    // 收集累加和等于aim的所有路径
    // https://leetcode.cn/problems/path-sum-ii/
    class PathSum {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> ans = new ArrayList<>();
            if(root != null)
                Add(targetSum, 0, root, ans, new ArrayList<>());
            return ans;
        }

        public void Add(int aim, int sum, TreeNode cur, List<List<Integer>> ans, List<Integer> path){
            if(cur.left == null &&  cur.right == null){
                if(cur.val + sum == aim){
                    path.add(cur.val);
                    ans.add(copy(path));
                    path.remove(path.size() - 1); // 记得删除
                }
            }else{
                path.add(cur.val); // 进行左右节点递归前先加入当前位置
                if(cur.left != null){
                    Add(aim, sum + cur.val, cur.left, ans, path);
                }
                if(cur.right != null) {
                    Add(aim, sum + cur.val, cur.right, ans, path);
                }
                path.remove(path.size() - 1); // 左右节点递归完删除刚刚加入的节点

            }
        }

        public List<Integer> copy(List<Integer> path){
            List<Integer> cp = new ArrayList<>();
            for (Integer i : path) {
                cp.add(i);
            }
            return cp;
        }
    }

    // 验证平衡二叉树(树型dp)
    // https://leetcode.cn/problems/balanced-binary-tree/
    class IsBalanced {
        public boolean balance;

        public boolean isBalanced(TreeNode root) {
            balance = true;
            height(root);
            return balance;
        }
        public int height(TreeNode root){
            if(root == null || !balance) // 一但发现树不平衡, 不必再递归, 立即终止
                return 0;
            int hl = height(root.left);
            int hr = height(root.right);
            if(Math.abs(hl - hr) > 1){
                balance = false;
            }
            return Math.max(hl, hr) + 1;
        }
    }

    // 验证搜索二叉树
    // https://leetcode.cn/problems/validate-binary-search-tree/
    class IsValidBST {

        public long min, max;

        public boolean isValidBST(TreeNode root) {
            // 中序遍历数一直变大

            // 全局变量更新(树型dp) 每次更新当前子树的最小最大值
            if(root == null){
                max = Long.MIN_VALUE;
                min = Long.MAX_VALUE;
                return true;
            }

            boolean lok = isValidBST(root.left);
            long lmin = min;
            long lmax = max;
            boolean rok = isValidBST(root.right);
            long rmin = min;
            long rmax = max;

            // 这里要更新min 和 max
            max = Math.max(Math.max(lmax, rmax), root.val);
            min = Math.min(Math.min(lmin, rmin), root.val);

            return lok && rok && root.val > lmax && root.val < rmin;
        }
    }

    // 修剪搜索二叉树
    // https://leetcode.cn/problems/trim-a-binary-search-tree/
    class TrimBST {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if(root == null)
                return null;

            if(root.val < low)
                return trimBST(root.right, low, high);
            if(root.val > high)
                return trimBST(root.left, low, high);

            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);

            return root;
        }

    }

    // 二叉树打家劫舍问题(树型dp)
    // https://leetcode.cn/problems/house-robber-iii/
    class Rob {

        public int yes; // 偷取此节点收益
        public int no; // 不偷收益

        public int rob(TreeNode root) {
            f(root);
            return Math.max(yes, no);
        }

        public void f(TreeNode root) {
            if(root == null){ // 根节点没有收益
                yes = 0; no = 0;
            }else{
            int n = 0; // 不偷此节点
            int y = root.val; // 偷此节点

            f(root.left);
            y += no; // 偷此节点加上不偷左节点
            n += Math.max(no, yes);

            f(root.right);
            y += no;
            n += Math.max(no, yes);

            yes = y;
            no = n;
            }
        }
    }
}
