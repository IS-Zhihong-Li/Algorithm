import java.util.Stack;

// 递归函数逆序栈
class Main{
    public static void sort(Stack<Integer> stack){
        int deep = deep(stack);
        while(deep > 0){
            int max = max(stack, deep);
            int times = times(stack, deep, max);
            down(stack, deep, max, times);
            deep -= times;
        }
    }

    // 查询栈深度
    public static int deep(Stack<Integer> stack){
        if(stack.isEmpty()){
            return 0;
        }else{
            int num = stack.pop();
            int deep = deep(stack) + 1;
            stack.push(num);
            return deep;
        }
    }

    // 查询最大值
    public static int max(Stack<Integer> stack, int deep){
        if(deep == 0){
            return Integer.MIN_VALUE;
        }else {
            int num = stack.pop();
            int max = max(stack, deep - 1);
            max = Math.max(num, max);
            stack.push(num);
            return max;
        }
    }

    // 查询最大值出现次数
    public static int times(Stack<Integer> stack, int deep, int max){
        if(deep == 0){
            return 0;
        }else{
            int num = stack.pop();
            int times = times(stack, deep - 1, max);
            times += (num == max ? 1 : 0);
            stack.push(num);
            return times;
        }
    }

    // 所有最大值沉底
    public static void down(Stack<Integer> stack, int deep, int max, int times){
        if(deep == 0){
            for (int i = 0; i < times; i++) {
                stack.push(max);
            }
        }else{
            int num = stack.pop();
            down(stack, deep - 1, max, times);
            if(num != max){
                stack.push(num);
            }
        }
    }

    public static void main(String[] args) {
//        Stack<Integer> test = new Stack<Integer>();
//        test.add(1);
//        test.add(5);
//        test.add(4);
//        test.add(5);
//        test.add(3);
//        test.add(2);
//        test.add(3);
//        test.add(1);
//        test.add(4);
//        test.add(2);
//        sort(test);
//        /*System.out.println(deep(test));
//        System.out.println(max(test, deep(test)));
//        System.out.println(times(test, deep(test), max(test, deep(test))));*/
//
//        //down(test, deep(test), max(test, deep(test)), times(test, deep(test), max(test, deep(test))));
//
//        while (!test.isEmpty()) {
//            System.out.println(test.pop());
//        }


        hanoi(3);
    }

    public static void hanoi(int num){
        if(num > 0){
            f(num, "左", "右", "中" );
        }
    }

    public static void f(int num, String from, String to, String other){
        if(num == 1){
            System.out.println("将圆盘1从" + from + "移动到" + to);
        }else {
            f(num - 1, from, other, to);// 将N-1的圆盘移动到other上
            System.out.println("将圆盘" + num + "从" + from + "移动到" + to);// 这里的num是最大的盘的编号, 将它移动到to上
            f(num - 1, other, to, from);// 将N-1的圆盘从other移动到to上
        }
    }

}