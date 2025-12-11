package class36;

/**
 * @author : lizh
 * @date: 2025/11/8 - 11 - 08 - 13:50
 * @Description: class36
 * @version: 1.0
 */

/**
 * 递归解决嵌套类问题
 * 1） 定义全局变量 int where
 * 2）递归函数f(i)：s[i...]，从i位置出发开始解析，遇到 [字符串终止] 或 [嵌套条件终止] 就返回
 * 3）返回值是f(i)负责这一段的结果
 * 4）f(i)在返回前更新全局变量where，让上级函数通过where知道解析到了什么位置，进而继续
 *
 */
public class Recursion_2 {

    // 含有嵌套的表达式求值
    // https://leetcode.cn/problems/basic-calculator-iii/description/
    class Calculate {
        // 假设是没有括号的表达式, 搞两个栈, 一个放数字, 一个放运算符, 持续填入, 遇到'*', '/'就弹出数字栈运算完放回去
        // 小细节: 运算符栈最后要随便填入一个运算符, 同时才会将最后一个数压进数字栈
        // 含有嵌套: 每次碰到'('直接调用递归运算, 碰到')'返回, 使用全局变量where保存下标位置
        public int calculate(String s) {



            return 1;
        }
    }

    // 含有嵌套的字符串解码
    // https://leetcode.cn/problems/decode-string/description/
    class DecodeString {
        public String decodeString(String s) {
            return null;
        }
    }

    // 含有嵌套的分子式求原子数量
    // 遇到左括号 或 大写字母, 结算前面内容
    // https://leetcode.cn/problems/number-of-atoms/description/
    class CountOfAtoms {
        public String countOfAtoms(String formula) {
            return null;
        }
    }


}
