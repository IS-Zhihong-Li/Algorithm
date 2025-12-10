import java.util.Stack;

// 递归函数逆序栈
class Main{
    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }else {
            int num = bottomOut(stack);
            reverse(stack);
            stack.push(num);
        }
    }

    // 栈底元素移除掉, 上面的元素盖下来
    // 返回移除掉的栈底元素
    public static int bottomOut(Stack<Integer> stack){
        int ans = stack.pop();
        if(stack.isEmpty()){
            return ans;
        }else{
            int last = bottomOut(stack);
            stack.push(ans); // 最后往上返回的时候, 应该把栈空间里得到的元素压回去, 而栈底元素没有执行过这一句就实现了将其移出
            return last;// return 的这个last就是最后一层栈得到的ans, 即栈底元素
        }

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}