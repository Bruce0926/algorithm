package basic_class_01;

import utils.Comparator;

/**
 * 归并排序
 * 使用递归，将数组分为两半部分，左边有序，右边有序，再进行合并，所以讲归并排序
 * 当递归到左右两边只有一个元素时，终止递归，因为一个元素肯定是有序的，进行合并后成为两个元素的有序数组，再与其他有序数组合并，以此类推
 * 计算递归的时间复杂度，master公式
 * T [n] = aT[n/b] + O (N^d)
 * ①当d<logb a时，时间复杂度为O(n^(logb a))
 * ②当d=logb a时，时间复杂度为O((n^d)*logn)
 * ③当d>logb a时，时间复杂度为O(n^d)
 *
 * 归并是分为两半，所以a，b都是2，归并时间复杂度是O(N)，所以d是1
 * 归并的平均时间复杂度O(N*logN)
 * 最好最差的时间复杂度都是O(N*logN)
 * 因为归并的过程需要一个临时数组接受排序后的元素，所以空间复杂度是O(N)
 */
public class Code_04_MergeSort extends Comparator {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
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
            mergeSort(arr1);
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
        mergeSort(arr);
        printArray(arr);

    }

}
