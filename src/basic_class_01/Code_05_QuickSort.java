package basic_class_01;

import utils.Comparator;

/**
 * 经典快排
 * 选定数组最后一个元素作为基准数，将数组分为两部分，左部分小于基准数，右部分大于等于基准数
 * 然后将左部分最后一个数作为基准数，又分为两部分，以此递归下去。
 * 核心思想：类似归并排序的分而治之，利用左右索引表示小于基准数和大于基准数
 * 随机快排
 * 与经典快排相同，只不过基准数不同，随机选定数组的一个元素作为基准数。
 *
 * 时间复杂度O(N*logN)，额外空间复杂度O(logN)
 */
public class Code_05_QuickSort extends Comparator {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[] { less + 1, more };
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            quickSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "ERROR!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        quickSort(arr);
        printArray(arr);

    }

}
