package class36;

import java.util.List;

/**
 * @author : lizh
 * @date: 2025/11/8 - 11 - 08 - 13:50
 * @Description: class36
 * @version: 1.0
 */
// N皇后问题    O(n!)
// https://leetcode.cn/problems/n-queens-ii/
public class NQueen {

    // 数组递归版本
    public int solveNQueens(int n) {
        int ans = 0;
        return f1(0, n, new int[n],ans);
    }

    public int f1(int i, int n, int[] path, int ans){
        if(i == n) //下标大于n
            return ans;
        for(int j = 0; j < n; j++){ // 验证列冲突

            for(int k = 0; k < path.length; k++){
                if(path[k] != j && Math.abs(path[k] - j) / Math.abs(k - i) != 1){ // 说明没有冲突
                    ans += f1(i + 1, n, path, ans);
                }
            }
        }
        return ans;
    }
    public int check(int i, int n, int[] path){
        return 1;
    }



    // 位运算版本
    /*
    使用limit,  column,   left,     right
       放多少个  哪列有放  右上到左下  左上到右下
    变量记录当前位置是否可以放皇后, 通过左右移动 "位信息" 判断是否能放皇后
     */
    public List<List<String>> solveNQueens2(int n) {
        return null;
    }

}
