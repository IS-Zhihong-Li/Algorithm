package class58;

/**
 * @author : lizh
 * @date: 2025/12/9 - 12 - 09 - 14:22
 * @Description: class58
 * @version: 1.0
 */
public class FloodFill {

    // 岛屿数量
    // 将碰到的岛屿整个刷成0, 记录岛屿数量++, 遍历整个图
    // https://leetcode.cn/problems/number-of-islands/description/
    class NumIslands {
        public int numIslands(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int islandCnt=0;
            for(int i = 0; i < m; i++){
                for (int j = 0; j < n; j++) {
                    if(grid[i][j] == '1'){
                        islandCnt++; // 发现一个岛屿, cnt++
                        dfs(grid,i,j); // dfs淹没整个岛屿
                    }
                }
            }
            return islandCnt;
        }

        public void dfs(char[][] grid, int i, int j){
            if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' ){
                return;
            }
            grid[i][j] = '0'; //  淹没岛屿
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }

    // 被围绕的区域
    // https://leetcode.cn/problems/surrounded-regions/
    class Solve {
        public void solve(char[][] board) {
            int n = board.length;
            int m = board[0].length;

            // 淹没与边缘接触的岛屿
            for (int i = 0; i < n; i++) { // 遍历图左右两条边
                dfs(board, i, 0);
                dfs(board, i, m - 1);
            }
            for (int j = 1; j < m - 1; j++) { // 遍历上下两条边
                dfs(board, 0, j);
                dfs(board, n - 1, j);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(board[i][j] != 'F')
                        board[i][j] = 'X';
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(board[i][j] == 'F')
                        board[i][j] = 'O';
                }
            }
        }

        public void dfs(char[][] board, int i, int j){
            if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O'){
                return;
            }
            board[i][j] = 'F'; //  淹没岛屿
            dfs(board, i - 1, j);
            dfs(board, i + 1, j);
            dfs(board, i, j - 1);
            dfs(board, i, j + 1);
        }

    }

    // 最大人工岛
    // https://leetcode.cn/problems/making-a-large-island/
    class LargestIsland {
        public int largestIsland(int[][] grid) {
            return 0;
        }
    }

    // 打砖块
    // https://leetcode.cn/problems/bricks-falling-when-hit/


}
