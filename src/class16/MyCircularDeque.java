package class16;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : lizh
 * @date: 2025/8/26 - 08 - 26 - 16:09
 * @Description: class16
 * @version: 1.0
 */
//https://leetcode.cn/problems/design-circular-deque/
class MyCircularDeque {
    Deque<Integer> deque = null;
    int limit;
    int size;

    public MyCircularDeque(int k) {
        deque = new LinkedList<>();
        limit = k;
        size = 0;
    }

    public boolean insertFront(int value) {
        if(isFull()) return false;
        else{
            size++;
            return deque.offerFirst(value);
        }
    }

    public boolean insertLast(int value) {
        if(isFull()) return false;
        else{
            size++;
            return deque.offerLast(value);
        }
    }

    public boolean deleteFront() {
        if(isEmpty()) return false;
        else{
            deque.pollFirst();
            size--;
            return true;
        }
    }

    public boolean deleteLast() {
        if(isEmpty()) return false;
        else{
            deque.pollLast();
            size--;
            return true;
        }
    }

    public int getFront() {
        if(isEmpty()) return -1;
        else return deque.peekFirst();
    }

    public int getRear() {
        if(isEmpty()) return -1;
        else return deque.peekLast();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == limit;
    }

    //数组实现双端队列
    class MyCircularDeque1{
        int[] deque;
        int size, limit, l, r;


        public MyCircularDeque1(int k) {
            deque = new int[k];
            size = l = r;
            limit = k;
        }

        public boolean insertFront(int value) {
            if(isFull()){
                return false;
            }else{
                if(isEmpty()){
                    l = r = 0;
                    deque[r] = value;

                }else {
                    r = r == limit - 1 ? 0 : r+1;
                    deque[r] = value;
                }
                size++;
                return true;
            }
        }

        public boolean insertLast(int value) {
            if(isFull()){
                return false;
            }else{
                if(isEmpty()){
                    l = r = 0;
                    deque[l] = value;
                }else {
                    l = l == 0 ? limit -1 : l-1;
                    deque[l] = value;
                }
                size++;
                return true;
            }
        }

        public boolean deleteFront() {
            if(isEmpty()) return false;
            else {
                r = r == 0 ? limit-1 : r-1;
                size--;
                return true;
            }
        }

        public boolean deleteLast() {
            if(isEmpty()) return false;
            else {
                l = l == limit-1 ? 0 : l+1;
                size--;
                return true;
            }
        }

        public int getFront() {
            if(isEmpty()) return -1;
            else {
                return deque[r];
            }
        }

        public int getRear() {
            if(isEmpty()) return -1;
            else {
                return deque[l];
            }
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return limit == size;
        }

    }
}

