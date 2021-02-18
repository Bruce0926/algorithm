package basic_class_01;

import utils.Comparator;

/**
 * 荷兰国旗问题
 * 给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，等于num的数放在数组的中间，大于num的数放在数组的右边。
 * 要求额外空间复杂度O(1)，时间复杂度O(N)
 */
public class Code_NetherlandsFlag extends Comparator {

    public static int[] partition(int[] arr, int l, int r, int p) {
        int less = l - 1;
        int more = r + 1;
        while (l < more) {
            if (arr[l] < p) {
                swap(arr, ++less, l++);
            } else if (arr[l] > p) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        return new int[] { less + 1, more - 1 };
    }

    public static void main(String[] args) {
        int[] test = generateRandomArray(20, 10);
        test = new int[]{9,8,7,4,5,5,2,3};
        printArray(test);
        int[] res = partition(test, 0, test.length - 1, 5);
        printArray(test);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }


}
