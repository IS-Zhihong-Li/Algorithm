package class12;

import java.util.Stack;
//4道题
/**
 * @author : lizh
 * @date: 2025/8/26 - 08 - 26 - 13:58
 * @Description: class12
 * @version: 1.0
 */
//1.系统栈实现
class MinStack {
    Stack<Integer> data;
    Stack<Integer> min;

    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        data.push(val);
        if(min.isEmpty())
            min.push(val);
        else min.push(val < min.peek() ? val : min.peek());
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }

    //2.数组实现栈
    class MinStack1 {
        int[] data;
        int[] min;
        int size;

        public MinStack1() {
            data = new int[8000];
            min = new int[8000];
            size = 0;
        }

        public void push(int val) {
            data[size] = val;
            if (size == 0 || min[size - 1] > val ){
                min[size] = val;
            } else {
                min[size] = min[size - 1 ];
            }
            size++;
        }

        public void pop() {
            size--;
        }

        public int top() {
            return data[size-1];
        }

        public int getMin() {
            return min[size-1];
        }

    }
}
