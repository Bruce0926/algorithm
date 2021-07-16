package basic_class_02;

/**
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 *     例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 *
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 *
 * 示例 2：
 *
 * 输入：nums = [1], target = 1
 * 输出：1
 *
 *
 *
 * 提示：
 *
 *     1 <= nums.length <= 20
 *     0 <= nums[i] <= 1000
 *     0 <= sum(nums[i]) <= 1000
 *     -1000 <= target <= 100
 */
public class FindTargetSumWays {
    public static int findTargetSumWays(int[] nums, int target) {
        int[] count = new int[1];
        int[] solutionNums = new int[nums.length];
        circus(nums,solutionNums,0,0,count,target);
        return count[0];
    }

    public static void circus(int[] nums,int[] solutionNums,int start,int lastResult,int[] count,int target){
        if(start > nums.length - 1 ){

            return ;
        }
        int num = nums[start];
        //相加
        int sumResult = lastResult + num;
        solutionNums[start] = num;
        if(target == sumResult && start == nums.length-1){
            count[0] = count[0] + 1;
            for (int i = 0; i < solutionNums.length; i++) {
                System.out.print(solutionNums[i]+"\t");
            }
            System.out.println();
        }
        circus(nums,solutionNums,start+1,sumResult,count,target);
        //相减
        int minusResult = lastResult - num;
        solutionNums[start] = -num;
        if(target == minusResult && start == nums.length-1){
            count[0] = count[0] + 1;
            for (int i = 0; i < solutionNums.length; i++) {
                System.out.print(solutionNums[i]+"\t");
            }
            System.out.println();
        }
        circus(nums,solutionNums,start+1,minusResult,count,target);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        System.out.println(findTargetSumWays(nums,3));
    }
}
