package external;

/**
 * @author : lizh
 * @date: 2025/10/25 - 10 - 25 - 20:40
 * @Description: external
 * @version: 1.0
 */
public class ReverseWords {

    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        String words[] = s.trim().split("\\s+"); //TODO
        for (int i = words.length - 1; i > 0; i--) {
            ans.append(words[i]);
            ans.append(' ');
        }
        ans.append(words[0]);

        String ansstr = ans.toString();
        return ansstr;
    }

    public int lengthOfLastWord(String s) {
        String words[] = s.trim().split("\\s+");
        return words[words.length - 1].length();
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        // 使用数组替代哈希表
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] charCount = new int[26];

        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (charCount[c - 'a'] <= 0) {
                return false;
            }
            charCount[c - 'a']--;
        }

        return true;
    }
}
