package class12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author : lizh
 * @date: 2025/8/26 - 08 - 26 - 13:08
 * @Description: class12
 * @version: 1.0
 */
public class QueueToStack {

    /*两个准则
    * 1.out栈空了才能倒数据
    * 2.in栈倒数据必须倒完
    */
    class MyQueue {
        Stack<Integer> in ;
        Stack<Integer> out;
        int size;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
            size = 0;
        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            if(out.isEmpty()){
                while(!in.isEmpty()){
                    out.push(in.pop());
                }
            }
            return out.pop();
        }

        public int peek() {
            if(out.isEmpty()){
                while(!in.isEmpty()){
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty()&& out.isEmpty();
        }
    }

    class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            int n = queue.size();
            queue.offer(x);
            for(int i = 0;i<n;i++){
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }




}
