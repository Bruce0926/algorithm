package basic_class_02;

import java.util.HashSet;
import java.util.Set;

/**
 * 求岛屿数量
 * 海洋是0，岛屿是1，左右上下相邻的1是一座岛屿
 * 比如初始化二维数组A[3][4]
 * -------------------------------
 * 0 0 0 0
 * 0 0 0 0
 * 0 0 0 0
 * -------------------------------
 * 输入的二维数组B[3][2]
 * -------------------------------
 * 1 1
 * 2 2
 * 2 3
 * -------------------------------
 * 根据B[i][0],B[i][1]将二维数组A[B[i][0]][B[i][0]]的0变成1
 * 如A[1][1]的0变成1
 * 结果二维数组A[3][4]
 * -------------------------------
 * 0 0 0 0
 * 0 1 0 0
 * 0 0 1 1
 * -------------------------------
 * 最终岛屿数量是2
 */
public class Code_0_1 {
    public static int islandAndOcean(int[][] A,int[][] B){
        //将海洋变成岛屿
        for (int i = 0; i < B.length; i++) {
            int i1 = B[i][0];
            int i2 = B[i][1];
            if(i1 >= 0 && i1 < A.length && i2 >= 0 && i2 < A[0].length){
                A[i1][i2] = 1;
            }
        }
        //计算岛屿的个数
        int islandCount = 0;
        Set<String> alreadyHas = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if(A[i][j] == 1){
                    String key = i + ":" + j;
                    if(alreadyHas.contains(key)){
                        continue;
                    }else{
                        alreadyHas.add(key);
                        islandCount++;
                        getAdjoinIsland(A,i,j,alreadyHas);
                    }
                }
            }
        }
        return islandCount;
    }

    public static void getAdjoinIsland(int[][] A,int i,int j,Set<String> alreadyHas){
        //左边的点
        if(i >= 0 && i < A.length && j-1 >= 0 && j-1 < A[0].length && A[i][j-1] == 1 && !alreadyHas.contains(i+":"+(j-1))){
            alreadyHas.add(i+":"+(j-1));
            getAdjoinIsland(A,i,j-1,alreadyHas);
        }
        //右边的点
        if(i >= 0 && i < A.length && j+1 >= 0 && j+1 < A[0].length && A[i][j+1] == 1 && !alreadyHas.contains(i+":"+(j+1))){
            alreadyHas.add(i+":"+(j+1));
            getAdjoinIsland(A,i,j+1,alreadyHas);
        }
        //上面的点
        if(i-1 >= 0 && i-1 < A.length && j >= 0 && j < A[0].length && A[i-1][j] == 1 && !alreadyHas.contains((i-1)+":"+j)){
            alreadyHas.add((i-1)+":"+(j));
            getAdjoinIsland(A,i-1,j,alreadyHas);
        }
        //下面的点
        if(i+1 >= 0 && i+1 < A.length && j >= 0 && j < A[0].length && A[i+1][j] == 1 && !alreadyHas.contains((i+1)+":"+j)){
            alreadyHas.add((i+1)+":"+(j));
            getAdjoinIsland(A,i+1,j,alreadyHas);
        }
    }

    public static void main(String[] args) {
        int[][] A = new int[3][4];
        int[][] B = new int[][]{{1,1},{2,1},{2,2},{2,3}};
        System.out.println(islandAndOcean(A,B));
    }
}
