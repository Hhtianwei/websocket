package com.training.demo0515.sort;

import org.junit.Test;

import java.util.Arrays;

public class Sort {

    static int[] numbers = {9,8,7,6,5,1,2};

    @Test
    public void test1() {
        //bubbleSort01(numbers);

        //quick(numbers);

        //selectSort(numbers);

        insertSort(numbers);
        print();
    }

    public static void print() {
        System.out.println(Arrays.toString(numbers));
        System.out.println();
    }

    /**
     * 冒泡法排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *
     * @param numbers 需要排序的整型数组
     */
    public static void bubbleSort01(int[] numbers) {
        int size = numbers.length-1; // 数组大小

        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size - j; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                }
            }
            print();
        }
    }

    /**
     * 选择排序算法
     * 在未排序序列中找到最小元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
     * 以此类推，直到所有元素均排序完毕。
     * @param numbers
     */
    public static void selectSort(int[] numbers)
    {
        int size = numbers.length; //数组长度

        for(int i = 0 ; i < size ; i++)
        {
            int k = i;   //待确定的位置
            //选择出应该在第i个位置的数
            for(int j = size -1 ; j > i ; j--)
            {
                if(numbers[j] < numbers[k])
                {
                    k = j;
                }
            }
            //交换两个数
            int temp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = temp;
        }
    }

    /**
     * 插入排序
     *
     * 从第一个元素开始，该元素可以认为已经被排序
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 将新元素插入到该位置中
     * 重复步骤2
     * @param numbers  待排序数组
     */
    public static void insertSort(int[] numbers)
    {
        int size = numbers.length;
        int temp = 0 ;
        int j =  0;

        for(int i = 0 ; i < size ; i++)
        {
            temp = numbers[i];
            //假如temp比前面的值小，则将前面的值后移
            for(j = i ; j > 0 && temp < numbers[j-1] ; j --)
            {
                numbers[j] = numbers[j-1];
            }
            numbers[j] = temp;
        }
    }

}
