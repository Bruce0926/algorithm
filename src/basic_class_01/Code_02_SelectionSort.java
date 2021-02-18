package basic_class_01;

import utils.Comparator;

/**
 * 选择排序
 * 选择第一个元素与其余元素比较，一轮比较后将最小的值放在第一个位置上
 * 每轮比较确定一个值，共进行N-1轮比较
 * 平均时间复杂度：N^2/2-N/2，即O(N^2)
 * 无论数组是否已经有序，选定元素都要其他元素比较，所以最好最差的时间复杂度都是：O(N^2)
 * 空间复杂度：O(1)
 */
public class Code_02_SelectionSort extends Comparator {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            if(i != minIndex)
                swap(arr, i, minIndex);
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
            selectionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }

}
