package class36;

import java.util.*;

/**
 * @author : lizh
 * @date: 2025/9/18 - 09 - 18 - 15:58
 * @Description: class35_pp
 * @version: 1.0
 */
public class Recursion {

    // 字符串的全部子序列
    // https://www.nowcoder.com/practice/92e6247998294f2c933906fdedbc6e6a
    public class GeneratePermutation {
        public String[] generatePermutation (String s) {
            HashSet<String> set = new HashSet<>();
            f(0, set, new StringBuilder(), s);
            String[] ans = new String[set.size()];
            int cur = 0;
            for (String sb : set) {
                ans[cur++] = sb;
            }
            return ans;
        }

        public void f(int i, HashSet<String> set, StringBuilder path, String s){
            if(i == s.length())
                set.add(path.toString());
            else{
                path.append(s.charAt(i));
                f(i + 1, set, path, s);
                path.deleteCharAt(path.length() - 1); // 删除最后一个字符
                f(i + 1, set, path, s);
            }
        }
    }


    // 返回所有不重复子集
    // https://leetcode.cn/problems/subsets-ii/
    class SubsetsWithDup {

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            //答案       path数组         内容  光标位置  子集大小
            f(ans, new int[nums.length], nums, 0, 0);
            return ans;
        }

        public void f(List<List<Integer>> ans, int[] path, int[] nums, int i, int size){
            if(i == nums.length){
                List<Integer> cur = new ArrayList<>();
                for (int i1 = 0; i1 < size; i1++) {
                    cur.add(path[i1]);
                }
                ans.add(cur);
            }else{
                int j = i + 1;
                // 找到下一个数开头
                while(j < nums.length && nums[i] == nums[j]){
                    j++;
                }
                f(ans, path, nums, j, size); // 数字一个都不选, 直接下一部分递归
                for(;i < j; i++){
                    path[size++] = nums[i];// 选一个, 选两个, ... 依次
                    f(ans, path, nums, j, size);
                }

            }
        }

    }

    // 没有重复数字的全排列
    // https://leetcode.cn/problems/permutations/
    class Permute {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            f(nums, 0, ans);
            return ans;
        }

        public void f(int[] nums, int i, List<List<Integer>> ans){
            if(i == nums.length){
                List<Integer> cur = new ArrayList<>();
                for (int num : nums) {
                    cur.add(num);
                }
                ans.add(cur);
            }else{
                for(int j = i; j < nums.length; j++){
                    swap(nums, i, j);
                    f(nums, i + 1, ans);
                    swap(nums, i, j);
                }
            }
        }

        public void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    // 有重复项数组的去重全排列
    // https://leetcode.cn/problems/permutations-ii/
    class PermuteUnique{
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            f(nums, 0, ans);

            return new ArrayList<>(ans);
        }

        public void f(int[] nums, int i, List<List<Integer>> ans){
            if(i == nums.length){
                List<Integer> cur = new ArrayList<>();
                for (int num : nums) {
                    cur.add(num);
                }
                ans.add(cur);
            }else{// 提前剪枝, 如果后面的数与要交换的数相同则丢弃整个分支
                HashSet<Integer> set = new HashSet<>();
                for(int j = i; j < nums.length; j++){ // 这个i 是传进来的变量, j位置不断变化, 换一个数跟i交换
                    if(!set.contains(nums[j])) {
                        set.add(nums[j]);
                        swap(nums, i, j);
                        f(nums, i + 1, ans);
                        swap(nums, i, j);
                    }
                }
            }
        }

        public void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    // 递归函数逆序栈
    // 核心思想: 可以利用开辟栈出现的空间
    class ReverseStackWithRecursive{
        public void reverse(Stack<Integer> stack){
            if(stack.isEmpty()){
                return;
            }
            int num = bottomOut(stack);
            reverse(stack);
            stack.push(num);
        }

        // 栈底元素移除掉, 上面的元素盖下来
        // 返回移除掉的栈底元素
        public int bottomOut(Stack<Integer> stack){
            int ans = stack.pop();
            if(stack.isEmpty()){
                return ans;
            }else{
                int last = bottomOut(stack);
                stack.push(ans); // 最后往上返回的时候, 应该把栈空间里得到的元素压回去, 而栈底元素没有执行过这一句就实现了将其移出
                return last;// return 的这个last就是最后一层栈得到的ans, 即栈底元素
            }
        }
    }


    // 递归函数排序栈
    //
    class SortStackWithRecursive{

    }

    // 打印汉诺塔问题
    class TowerOfHanoi{



    }


}
