package class41;

/**
 * @author : lizh
 * @date: 2025/11/8 - 11 - 08 - 13:45
 * @Description: class41
 * @version: 1.0
 */
public class GuessByData {

    /**
     * 根据数据量才解法, 一般常数操作量在 10^7 ~ 10^8 以内
     *              logn    n       n*logn  n*根号n    n^2      2^n      n!
     * n <= 11      Yes     Yes     Yes     Yes       Yes     Yes     Yes
     * n <= 25      Yes     Yes     Yes     Yes       Yes     Yes     No
     * n <= 5000    Yes     Yes     Yes     Yes       Yes     No      No
     * n <= 10^5    Yes     Yes     Yes     Yes       No      No      No
     * n <= 10^6    Yes     Yes     Yes     No        No      No      No
     * n <= 10^7    Yes     Yes     No      No        No      No      No
     * n >= 10^8    Yes     No      No      No        No      No      No
     */



}
