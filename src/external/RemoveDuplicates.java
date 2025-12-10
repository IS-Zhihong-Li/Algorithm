package external;

import java.util.Stack;

/**
 * @author : lizh
 * @date: 2025/9/20 - 09 - 20 - 18:40
 * @Description: external
 * @version: 1.0
 */
// 移除相邻重复元素 1047
public class RemoveDuplicates {
    public String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();

        int n = s.length();
        for(int i = 0; i < n; i++){
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
            }else{
                if(stack.peek() == s.charAt(i))
                    stack.pop();
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }
        String result = sb.toString();
        return result;
    }


    public class RemoveDuplicates2 {

    /*
    int[] arr = new int[202];
    public int removeDuplicates(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] += 100;
        }
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(arr[nums[i]] == 0)
                arr[nums[i]]++;
        }
        int j = 0;
        for (int i = 0; i < 202; i++) {
            if(arr[i] == 1){
                nums[j++] = i;
                k++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= 100;
        }
        return k;
    }
    */

        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            if(n == 0)
                return 0;

            int fast = 1, slow = 1;
            while(fast < n){
                if(nums[fast] != nums[fast - 1]) {
                    nums[slow++] = nums[fast];
                }
                ++fast;

            }
            return slow;
        }
    }




}
