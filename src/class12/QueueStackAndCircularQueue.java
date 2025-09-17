package class12;

/**
 * @author : lizh
 * @date: 2025/8/4 - 08 - 04 - 10:45
 * @Description: stackandqueue
 * @version: 1.0
 */
public class QueueStackAndCircularQueue {

    class Queue{
        int[] queue;
        int l, r;

        public Queue(int n) {
            queue = new int[n];
            l = 0;
            r = 0;
        }
        //判断是否为空
        public boolean isEmpty(){
            return l == r;
        }
        //加到尾
        public void offer(int n){
            queue[r++] = n;
        }

        //从头拿
        public int poll(){
            return queue[l++];
        }

        //头
        public int head(){
            return queue[l];
        }
        //尾
        public int tail(){
            return queue[r-1];
        }

        //大小
        public int size(){
            return r-l+1;
        }


    }


    class Stack{
        int[] stack;
        int size;

        Stack(int n){
            stack = new int[n];
            size = 0;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public void push(int n){
            stack[size++] = n;
        }
        public int pull(){
            return stack[--size];
        }
        public int peek(){
            return stack[size - 1];
        }
        public int size(){
            return size;
        }

    }






    class MyCircularQueue {
        int[] queue;
        int l, r, limit, size;

        public MyCircularQueue(int k) {
            queue = new int[k];
            l = 0;
            r = 0;
            limit = k;
            size = 0;
        }

        //加入一个元素
        public boolean enQueue(int value) {
            if(isFull()){
                return false;
            }
            else{
                queue[r] = value;
                r = r == limit - 1 ? 0 : r + 1;
                size++;
                return true;
            }
        }

        //删除一个元素
        public boolean deQueue() {
            if(isEmpty()){
                return false;
            }else{
                l = l == limit - 1 ? 0 : l + 1;
                size--;
                return true;
            }
        }

        public int Front() {
            if(isEmpty()){
                return -1;
            }else{
                return queue[l];
            }
        }

        public int Rear() {
            if(isEmpty()){
                return -1;
            }else{
                int last = r==0?limit-1:r-1;
                return queue[last];
            }
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }
}
