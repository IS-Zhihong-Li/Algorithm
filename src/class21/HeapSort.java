package class21;

import java.io.*;

/**
 * @author : lizh
 * @date: 2025/9/2 - 09 - 02 - 22:44
 * @Description: class21
 * @version: 1.0
 */
public class HeapSort {

    public static int MAXN = 100001;

    public static int[] arr = new int[MAXN];

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        n = (int) in.nval;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            arr[i] = (int) in.nval;
        }
        heapSort1();
        //heapSort2();
        for (int i = 0; i < n - 1; i++) {
            out.print(arr[i] + " ");
        }
        out.println(arr[n - 1]);
        out.flush();
        out.close();
        br.close();
    }

    // 由顶到底建堆 TODO花点时间再理解一下
    private static void heapSort1() {
        for(int i = 0; i < n; i++){
            heapInsert(i);
        }
        int size = n;
        while(size > 1){
            swap(0, --size);
            heapify(0, size);
        }

    }

    // 由底到顶建堆
    private static void heapSort2() {
        for(int i = n-1; i >= 0;i--){
            heapify(i, n);
        }
        int size = n;
        while (size > 1) {
            swap(0, --size);
            heapify(0, size);
        }
    }

    private static void heapInsert(int i) {// 插入大根堆
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    private static void heapify(int i, int size) {// i位置数变小,维持大根堆, 自上往下堆化
        int l = i * 2 + 1;
        while (l < size) {
            int best = l + 1 < size && arr[l + 1] > arr[l] ? l + 1 : l;// 选取左右节点中较大的
            best = arr[best] > arr[i] ? best : i;// 比较父节点和子节点
            if(best == i) break;

            swap(i, best);// 根据下标,把大的子节点和父节点的值交换
            i = best;// 把要判断的节点移动到最强的子节点上
            l = i * 2 + 1;// 计算左子树,while判断是否越界
        }

    }


    public static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
