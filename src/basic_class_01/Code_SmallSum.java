package basic_class_01;

import utils.Comparator;

/**
 * 小和问题：求数组每个元素的左边比它小的元素之和的累加
 * 两种方法：
 * 方法一：双循环，时间复杂度：O(N^2)
 * 方法二：类似归并排序，因为归并也是按照从左到右的顺序的，在归并的过程中计算右边比当前数大的个数乘以当前数，时间复杂度O(N*logN)
 */
public class Code_SmallSum  extends Comparator {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;
    }

    /**
     * 用双循环解决小和问题
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(1)
     * @param arr
     * @return
     */
    public static int comparator1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (smallSum(arr1) != comparator1(arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        int[] arr1 = generateRandomArray(maxSize, maxValue);
//        arr1 = new int[]{95,61,36,4,56};
        printArray(arr1);
        System.out.println(succeed ? "Nice!" : "ERROR!");
        System.out.println(comparator1(arr1));
        System.out.println(smallSum(arr1));
    }

}
