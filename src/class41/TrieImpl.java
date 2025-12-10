package class41;

/**
 * @author : lizh
 * @date: 2025/11/3 - 11 - 03 - 20:14
 * @Description: class41
 * @version: 1.0
 */
public class TrieImpl {

    class Trie {

        public int MAXN = 150001;

        int[][] tree = new int[MAXN][26];
        int[] pass = new int[MAXN];
        int[] end = new int[MAXN];
        int cnt;

        // 静态数组法实现
        public Trie() {
            cnt = 1;
        }

        public void insert(String word) {
            int cur = 1;
            pass[cur]++;// 根节点有效告诉你这里写了多少个单词
            for(int i = 0, path; i < word.length(); i++){
                path = word.charAt(i) - 'a';
                if(tree[cur][path] == 0){
                    tree[cur][path] = ++cnt;
                }
                cur = tree[cur][path];
                pass[cur]++;
            }
            end[cur]++;
        }

        public int countWordsEqualTo(String word) {
            int cur = 1;
            for(int i = 0, path; i < word.length(); i++){
                path = word.charAt(i) - 'a';
                if(tree[cur][path] == 0){
                    return 0;
                }
                cur = tree[cur][path];
            }
            return end[cur];
        }

        public int countWordsStartingWith(String prefix) {
            int cur = 1;
            for(int i = 0, path; i < prefix.length(); i++){
                path = prefix.charAt(i) - 'a';
                if(tree[cur][path] == 0){
                    return 0;
                }
                cur = tree[cur][path];
            }
            return pass[cur];
        }

        public void erase(String word) {
            if(countWordsEqualTo(word) > 0){
                int cur = 1;
                pass[cur]--;
                for(int i = 0, path; i < word.length(); i++) {
                    path = word.charAt(i) - 'a';
                    if(--pass[tree[cur][path]] == 0){
                        tree[cur][path] = 0;
                        return;
                    }
                    // pass[tree[cur][path]]--; if判断已经减过了, 不需要再减
                    cur = tree[cur][path];
                }
                end[cur]--;
            }
        }
    }




}
