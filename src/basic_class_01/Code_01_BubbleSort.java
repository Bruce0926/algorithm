package basic_class_01;

import utils.Comparator;

/**
 * 冒泡排序
 * 相邻元素两两比较，较大的放在后面，一轮比较后最大的数在最后一个位置上
 * 如此进行N-1(N是数组的长度)轮比较后，数组从小到大排好序
 * 平均时间复杂度：N^2/2-N/2，即O(N^2)
 * 无论数组是否已经有序，相邻元素都要两两比较，所以最好最差的时间复杂度都是：O(N^2)
 * 空间复杂度：O(1)
 */
public class Code_01_BubbleSort extends Comparator {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
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
            bubbleSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }

}
