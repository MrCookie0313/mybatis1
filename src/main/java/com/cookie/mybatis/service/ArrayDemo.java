package com.cookie.mybatis.service;

import javax.management.Query;
import java.util.*;

/**
 * @author Sunbing
 * @date 2020/1/6 15:52
 * @Version 1.0
 */
public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,5,6,7,4,7,9,8,10,12,13,11,14,15,10,18,16,3,5};
//        int query = query(arr);
//        System.out.println("query = " + query);
        Arrays.sort(arr);
        int result = arr[9];
        System.out.println("result = " + result);

    }

    /**
     * 求出数组中第10大的数
     * @param arr
     * @return
     */
    public static int query(int[] arr){

        Set set = new HashSet();
        LinkedHashSet<Object> temp = new LinkedHashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int num= arr[i];
            set.add(num);
        }
        List list = new ArrayList(set);
        Collections.sort(list);
        int o = (int) list.get(9);
        return o;
    }


}
