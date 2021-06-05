package basic_class_02;

/**
 * 假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
 *
 * 在每一步操作中，你可以选择任意 m （1 ≤ m ≤ n） 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
 *
 * 给定一个非负整数数组代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的最少的操作步数。
 * 如果不能使每台洗衣机中衣物的数量相等，则返回 -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入: [1,0,5]
 *
 * 输出: 3
 *
 * 解释:
 * 第一步:    1     0 <-- 5    =>    1     1     4
 * 第二步:    1 <-- 1 <-- 4    =>    2     1     3
 * 第三步:    2     1 <-- 3    =>    2     2     2
 *
 * 示例 2：
 *
 * 输入: [0,3,0]
 *
 * 输出: 2
 *
 * 解释:
 * 第一步:    0 <-- 3     0    =>    1     2     0
 * 第二步:    1     2 --> 0    =>    1     1     1
 *
 * 示例 3:
 *
 * 输入: [0,2,0]
 *
 * 输出: -1
 *
 * 解释:
 * 不可能让所有三个洗衣机同时剩下相同数量的衣物。
 *
 *
 *
 * 提示：
 *
 *     n 的范围是 [1, 10000]。
 *     在每台超级洗衣机中，衣物数量的范围是 [0, 1e5]。
 */
public class WashingMachineMin {
    
    public static int minOperationClotheEqual(int[] machineClothe){
        //判断是否能使每个洗衣机里的衣服数量相等
        int total = 0;
        int length = machineClothe.length;
        for (int i : machineClothe) {
            total += i;
        }
        int remainder = total % length;
        if(remainder != 0){
            return -1;
        }
        //获取使得每个洗衣机里的衣服数量相等的操作步骤数量
        int average = total / length;
        int operationCount = 0;
        while (true){
            int allAverageCount = 0;
            //表示当前元素可以从前一个元素获取一个数
            boolean canGetFromLeft = Boolean.FALSE;
            //表示当前元素可以给下一个元素一个数
            boolean canGiveToLeft = Boolean.FALSE;
            for (int i = 0; i < length; i++) {
                int item = machineClothe[i];
                if(canGetFromLeft){
                    int pre = i-1;
                    machineClothe[pre]--;
                    machineClothe[i]++;
                    item++;
                }
                if(canGiveToLeft && item > 0){
                    int pre = i-1;
                    machineClothe[pre]++;
                    machineClothe[i]--;
                    item--;
                }
                if(item > average){
                    canGetFromLeft =  Boolean.TRUE;
                }
                if(item < average){
                    canGiveToLeft = Boolean.TRUE;
                }
                if(item == average){
                    canGetFromLeft =  Boolean.FALSE;
                    canGiveToLeft = Boolean.FALSE;
                    allAverageCount++;
                }
            }
            if(allAverageCount == length){
                break;
            }
            operationCount++;
        }
        return operationCount;
    }

    public static void main(String[] args) {
        System.out.println(minOperationClotheEqual(new int[]{1,0,5}));
    }

}
