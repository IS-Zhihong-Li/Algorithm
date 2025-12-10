package interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : lizh
 * @date: 2025/11/10 - 11 - 10 - 22:12
 * @Description: interview150
 * @version: 1.0
 */
public class AverageOfLevels {
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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();

        TreeNode[] queue = new TreeNode[2001];
        int l = 0, r = 0, size = 0;
        if (root == null) return new ArrayList<>();
        queue[r++] = root;
        while (l < r) {
            size = r - l;// 根据大小一层一层处理
            Double aa = 0D;
            for (int i = 0; i < size; i++) {
                root = queue[l++];
                aa += root.val;
                if (root.left != null) {
                    queue[r++] = root.left;// 加入左节点
                }
                if (root.right != null) {
                    queue[r++] = root.right;// 加入右节点
                }

            }
            ans.add(aa / size);
        }

        return ans;
    }

    class RrightSideView {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();

            TreeNode[] queue = new TreeNode[101];
            int l = 0, r = 0, size = 0;
            if (root == null) return new ArrayList<>();
            queue[r++] = root;
            while (l < r) {
                size = r - l;// 根据大小一层一层处理
                ans.add(queue[r - 1].val);
                for (int i = 0; i < size; i++) {
                    root = queue[l++];
                    if (root.left != null) {
                        queue[r++] = root.left;// 加入左节点
                    }
                    if (root.right != null) {
                        queue[r++] = root.right;// 加入右节点
                    }
                }
            }
            return ans;
        }
    }

    class IsSameTree {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            f(p, sb);
            f(q, sb2);
            return sb.toString().contentEquals(sb2);

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

    class IsPalindrome {
        public boolean isPalindrome(String s) {
            String ans1 = s.replaceAll("[^a-zA-Z]", "");
            String ans = ans1.toLowerCase();
            for (int l = 0, r = ans.length() - 1; l < r; l++, r--) {
                if (ans.charAt(l) != ans.charAt(r))
                    return false;
            }
            System.out.println(ans1);
            return true;
        }
    }

    class IsSubsequence {
        public boolean isSubsequence(String s, String t) {
            if (s.isEmpty()) return true;
            char[] sArray = s.toCharArray();
            char[] tArray = t.toCharArray();
            for (int sidx = 0, tidx = 0; sidx < s.length() && tidx < t.length(); tidx++) {
                if (sArray[sidx] == tArray[tidx]) {
                    sidx++;
                }
                if (sidx == s.length()) return true;
            }
            return false;
        }
    }

    class IsIsomorphic {

        /* 人才解法
        public boolean isIsomorphic(String s, String t) {
            for (int i = 0; i < s.length(); i++)
                if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) return false;
            return true;
        }*/

        public boolean isIsomorphic(String s, String t) {
            // 需要两个映射表
            int[] tToS = new int[256];  // t字符 → s字符的映射
            int[] sToT = new int[256];  // s字符 → t字符的映射

            for (int i = 0; i < s.length(); i++) {
                char charS = s.charAt(i);
                char charT = t.charAt(i);

                if (tToS[charT] != 0 && tToS[charT] != charS) {
                    return false;
                }

                if (sToT[charS] != 0 && sToT[charS] != charT) {
                    return false;
                }

                tToS[charT] = charS;
                sToT[charS] = charT;
            }
            return true;
        }

    }


    class IsSymmetric {

        public boolean isSymmetric(TreeNode root) {
            return check(root.left, root.right);
        }

        public boolean check(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
        }

    }

    class RemoveDuplicates {
        public int removeDuplicates(int[] nums) {
            return 0;
        }
    }

}
