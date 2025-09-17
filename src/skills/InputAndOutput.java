package skills;

/**
 * @author : lizh
 * @date: 2025/8/26 - 08 - 26 - 16:55
 * @Description: skills
 * @version: 1.0
 */
public class InputAndOutput {
    /**
     * 1.填函数写法: 力扣
     * 2.ACM风格
     *      不使用Scanner, println
     *      而是使用BufferedReader, PrintWriter等
     *
     *          // 把文件里的内容，load进来，保存在内存里，很高效，很经济，托管的很好
     * 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     * 		    // 一个一个读数字
     * 		StreamTokenizer in = new StreamTokenizer(br);
     * 		    // 提交答案的时候用的，也是一个内存托管区
     * 		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
     *
     *      // 1.按字符读
     * 	    while (in.nextToken() != StreamTokenizer.TT_EOF) { // 文件没有结束就继续
     * 			// n，二维数组的行
     * 			int n = (int) in.val;// 以int类型写入文件中的内容
     * 		}
     *
     * 	    // 2.按行读
     * 	    while ((line = in.readLine()) != null) {
     * 			parts = line.split(" ");
     * 			sum = 0;
     * 			for (String num : parts) {
     * 				sum += Integer.valueOf(num);
     * 			            }
     * 			out.println(sum);
     * 		}
     *
     * 	    out.flush();// 刷新一次性将答案填入
     * 		br.close();
     * 		out.close();
     * 3.使用全局静态空间, 不动态创建空间
     */
}
