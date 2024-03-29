package basic_class_02;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 *
 *
 * 提示：
 *
 *     2 <= nums.length <= 10^4
 *     -10^9 <= nums[i] <= 10^9
 *     -10^9 <= target <= 10^9
 *     只会存在一个有效答案
 *
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 *
 */
public class TwoNumAdd {
    public static int[] twoSum(int[] nums, int target) {
        /*for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;*/
        int[] temp = new int[nums.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < nums.length; i++) {
            if(temp[(target-nums[i])] > Integer.MIN_VALUE){
                return new int[]{temp[(target-nums[i])],i};
            }else{
                temp[nums[i]]=i;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        int[] twoSum = twoSum(nums, 5);
        for (int i = 0; i < twoSum.length; i++) {
            System.out.print(twoSum[i]+"\t");
        }
    }
}
