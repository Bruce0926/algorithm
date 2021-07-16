package basic_class_02;

/**
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 *
 * 示例 2：
 *
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 *
 *
 *
 * 提示：
 *
 *     1 <= strs.length <= 600
 *     1 <= strs[i].length <= 100
 *     strs[i] 仅由 '0' 和 '1' 组成
 *     1 <= m, n <= 100
 *
 */
public class FindMaxForm {

    public static int findMaxForm(String[] strs, int m, int n) {
        // 一样是可以转化为01背包问题, 物品的大小就是str中0 1的数量, 所以背包有两个维度
        // 物品的价值就是子集数量的多少
        // dp[i][j] 含义: 最多有i个0和j个1的strs的最⼤⼦集的⼤⼩为dp[i][j]
        // 状态转移方程: dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1)  -> 物品价值就是+1个子集
        int[][] dp = new int[m + 1][n + 1]; // m:0    n:1
        dp[0][0] = 0;
        // 先遍历物品, 再遍历背包容量
        for(String str : strs) {
            int zeroNum = 0, oneNum = 0;
            for(char c : str.toCharArray()) {
                if(c == '0') zeroNum++;
                else oneNum++;
            }

            for(int i = m; i >= zeroNum; i--) {
                for(int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"10","0001","111001","1","0"};
        System.out.println(findMaxForm(strs, 3, 4));
//        for (int j = 0; j <= 0; j++) {
//            System.out.println("ssss");
//        }
    }

}
