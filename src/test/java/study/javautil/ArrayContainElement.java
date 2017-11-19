package study.javautil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by wsylp on 2017/9/20.
 */
public class ArrayContainElement {

    public static void main(String[] args) {
//        String[] arr = new String[] {  "CD",  "BC", "EF", "DE", "AB"};

        String[] arr = new String[1000];
        Random s = new Random();
        for(int i=0; i< 1000; i++){
            arr[i] = String.valueOf(s.nextInt());
        }

//        String[] arr = new String[10000];
//
//        Random s = new Random();
//        for(int i=0; i< 10000; i++){
//            arr[i] = String.valueOf(s.nextInt());
//        }

        //use list
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useList(arr, "A");
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("useList:  " + duration / 1000000);

        //use set
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useSet(arr, "A");
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("useSet:  " + duration / 1000000);

        //use loop
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useLoop(arr, "A");
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("useLoop:  " + duration / 1000000);

        //use Arrays.binarySearch()
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useArraysBinarySearch(arr, "A");
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("useArrayBinary:  " + duration / 1000000);
    }

    private static boolean useArraysBinarySearch(String[] myArr, String targetValue) {
        int a = Arrays.binarySearch(myArr, targetValue);
        if (a > 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean useLoop(String[] myArr, String targetValue) {
        for (String a : myArr) {
            if (a.equals(targetValue)) {
                return true;
            }

        }
        return false;
    }

    private static boolean useSet(String[] myArr, String targetValue) {
        Set<String> set = new HashSet<String>(Arrays.asList(myArr));
        return set.contains(targetValue);
    }

    private static boolean useList(String[] myArr, String targetValue) {
        return Arrays.asList(myArr).contains(targetValue);
    }

    private static boolean useAyyayUtil(String[] myArr, String targetValue) {
        return ArrayUtils.contains(myArr,targetValue);
    }

}
