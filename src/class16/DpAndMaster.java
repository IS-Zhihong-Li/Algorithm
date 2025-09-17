package class16;

/**
 * @author : lizh
 * @date: 2025/8/26 - 08 - 26 - 17:10
 * @Description: class16
 * @version: 1.0
 */
public class DpAndMaster {
    /**
     * 任何递归都能改成非递归,工程上有必要性,除非数据怎么大也开不深,如归并排序,平衡树等
     * 做题中能提交就不需改
     *
     * 1)master公式
     *      a.所有子问题规模相同的递归才能用master公式,rT(n)=a*T(n/b)+O(n^c), a、b、c都是常数
     *      b.如果log(b,a)< c，复杂度为：O(n^c)
     *      c.如果log(b,a)> c，复杂度为：O(n^log(b,a))
     *      d.如果log(b,a) == c，复杂度为：O(n^c * logn)
     * 2)一个补充
     *      T(n)=2*T(n/2)+0(n*logn)，时间复杂度是0(n*((logn)的平方))，证明过程比较复杂，记住即可
     */


}
