package basic_class_01;

import utils.Comparator;

/**
 * 插入排序
 * 想象打扑克牌时候抓牌，每抓一张牌前手里的牌是有序的，抓之后进行比较，将牌放在合适的位置保持整体有序
 * 其中可能也有相邻比较的过程
 * 平均时间复杂度：N^2/2-N/2，即O(N^2)
 * 最好的情形，本来就有序的话，只用比较N-1就行，所以最好时间复杂度是：O(N)
 * 最差时间复杂度是：O(N^2)
 * 空间复杂度：O(1)
 */
public class Code_03_InsertionSort extends Comparator {

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
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
            insertionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "ERROR!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        insertionSort(arr);
        printArray(arr);
    }

}
