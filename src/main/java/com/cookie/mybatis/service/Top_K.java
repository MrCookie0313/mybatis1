package com.cookie.mybatis.service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sunbing
 @date 2020-1-7
 @Version 1.0
 */
public class Top_K {
    public static void main(String[] args) {
        int[] arr = Top_K.reduceArr(100);
        System.out.println("========测试arr========");
        System.out.println(Arrays.toString(arr));
        System.out.println("========堆排序topK========");
        List<Integer> list = Top_K.findTopK(arr, 10);
//        排序是为了方便观察
        Collections.sort(list);
        System.out.println(list.toString());
        System.out.println("========快排思想topK========");
        List<Integer> list1 = Top_K.findTopK1(arr, 10);
//        排序是为了方便观察
        Collections.sort(list1);
        System.out.println(list1.toString());
    }

    /**
     * @param input：需要排序的数组
     * @param k：需要的top K
     * @return :返回top K的list集合
     */
    public static List<Integer> findTopK1(int[] input, int k) {
        List<Integer> list = new ArrayList<>();
//        这里其实不用重写compare方法，因为默认的就是从小到大排序
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (o1, o2) -> o1 - o2);
        if (input == null || input.length < 1) {
            return list;
        }
        for (int num : input) {
//            在不够k之前，直接添加
            if (maxHeap.size() < k) {
                maxHeap.offer(num);
            }
//            小顶堆的堆顶元素<num，那么就将其替换，优先队列会自动进行调整小顶堆的顺序
            else if (maxHeap.peek() < num) {
                maxHeap.poll();
                maxHeap.offer(num);
            }
        }
        list.addAll(maxHeap.stream().collect(Collectors.toList()));
        return list;
    }
    /**
     * @param arr
     * @param k
     * @return :返回topK的list
     */
    public static List<Integer> findTopK(int[] arr ,int k ) {
        List<Integer> list = new ArrayList<>();
        if (arr == null || arr.length < 1) {
            return list;
        }
        if (k > arr.length) {
            for (int num : arr) {
                list.add(num);
            }
        } else {
//            代用findK方法让数组部分排序，直接获取arr.length - k到arr.length的所有元素
            Top_K.findK(arr, 0, arr.length - 1, k);
            for (int i = arr.length - k; i <arr.length; i++) {
                list.add(arr[i]);
            }
        }
        return list;
    }
    /**
     * 找到第k大元素，并且此时第k大元素所在下标到arr.length都是大于第k大元素的元素
     * @param array
     * @param left
     * @param right
     * @param k：所要找的最大值k
     * @return :返回找到的第k大元素
     */
    public static int findK(int[] array, int left, int right, int k) {
        int[] p = partition(array, left, right);
        int index = array.length - k ;
        if (p[1] == index) {
            return array[index];
        } else if (p[1] > index) {
            return findK(array, left, p[1] - 1, k);
        } else if (p[1] < index) {
            return findK(array, p[1] + 1, right, k);
        }
        return 0;
    }
    /**
     * 将数组以arr[r]分割为三部分，小于arr[r],等于arr[r]，大于arr[r]
     * @param arr:需要partition的数组
     * @param l：partition数组的左边界
     * @param r：partition数组的右边界
     * @return ：返回分割元素所在的左右下标
     */
    public static int[] partition(int[] arr, int l, int r) {
        int less = l-1;
        int more = r;
        while ( l < more ) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, l, --more);
            } else {
                l++;
            }
        }
        swap(arr,more,r);
        return new int[] { less + 1, more };
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    /**
     *
     * @param num:要生成的数组长度
     * @return ：返回随机生成的数组
     */
    public static int[] reduceArr(int num) {
        int[] res = new int[num];
        for (int i = 0; i < num; i++) {
            res[i] = (int) (Math.random() * num);
        }
        return res;
    }
}
