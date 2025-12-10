package interview150;

import java.util.Stack;

/**
 * @author : lizh
 * @date: 2025/11/6 - 11 - 06 - 15:16
 * @Description: interview150
 * @version: 1.0
 */
// 加油站
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        int gasc = 0;
        int costc = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            gasc += gas[i];
            costc += cost[i];
            arr[i] = gas[i] - cost[i];
        }
        if(costc >= gasc)
            return -1;
        int maxGas = 0;
        int index = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            arr[i] += arr[i + 1];
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > maxGas) {
                maxGas = arr[i];
                index = i;
            }
        }

        return index;
    }

    // 20
    // https://leetcode.cn/problems/valid-parentheses/?envType=study-plan-v2&envId=top-interview-150
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // 碰到左括号时塞入相应右括号, 碰到右括号时判断是否相等, 相等删除, 不相等return false
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                // 遇到右括号时，栈为空或不匹配则无效
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }


    // 67 二进制求和
    public String addBinary(String a, String b) {

        return null;
    }

}
