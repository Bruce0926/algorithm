package basic_class_01;

import utils.Comparator;

import java.util.HashSet;
import java.util.Set;

/**
 * 逆序对
 * 数组的左边元素比右边大则构成一个逆序对，即i<j,而a[i]>a[j]，打印数组中所有的逆序对
 * 两种方法：
 * 方法一：双循环，时间复杂度：O(N^2)
 * 方法二：类似归并排序，因为归并也是按照从左到右的顺序的，在归并的过程中计算左边比右边大的元素对，时间复杂度O(N*logN)
 */
public class Code_ReversePair extends Comparator {

    public static Set reversePair(int[] arr){
        if(arr == null || arr.length < 2){
            return new HashSet();
        }
        return mergeSort(arr,0,arr.length-1);
    }

    public static Set mergeSort(int[] arr,int l,int r){
        if(l==r){
            return new HashSet();
        }
        int mid = l + ((r-l)>>2);
        Set set1 = mergeSort(arr, l, mid);
        Set set2 = mergeSort(arr, mid + 1, r);
        Set set3 = merge(arr, l, mid, r);
        set1.addAll(set2);
        set1.addAll(set3);
        return set1;
    }

    /**
     * 合并的时候，将两边数组从后向前遍历，不同于归并排序和求小和问题
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    public static Set merge(int[] arr, int l, int mid, int r){
        Set result = new HashSet();
        int[] temp = new int[r-l+1];
        int p1 = mid;
        int p2 = r;
        int index = r-l;
        while (p1 >=l && p2 >= mid+1){
            if(arr[p1]>arr[p2]){
                for (int i = mid+1; i <= p2; i++) {
                    if(arr[p1]>arr[i])
                        result.add(" "+arr[p1]+":"+arr[i]);
                }
                temp[index--] = arr[p1--];
            }else{
                temp[index--] = arr[p2--];
            }
        }
        while (p1 >= l){
            temp[index--] = arr[p1--];
        }
        while (p2 >= mid+1){
            temp[index--] = arr[p2--];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[i+l] = temp[i];
        }
        return result;
    }

    /**
     * 用双循环解决逆序对问题
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(1)
     * @param arr
     */
    public static Set comparator1(int[] arr){
        Set result = new HashSet();
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if(arr[j] > arr[i]){
                    result.add(" "+arr[j] +":"+ arr[i]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (!reversePair(arr1).equals(comparator1(arr2))) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        int[] arr1 = generateRandomArray(maxSize, maxValue);
//        arr1 = new int[]{95,61,36,4,56};
        arr1 = new int[]{23,82,56,6,40,4};
        arr1 = new int[]{23,13,41,15,42,16,98,78};
        printArray(arr1);
        System.out.println(succeed ? "Nice!" : "ERROR!");
        System.out.println(comparator1(arr1));
        System.out.println(reversePair(arr1));
        System.out.println(reversePair(arr1).equals(comparator1(arr1)));
    }
}
