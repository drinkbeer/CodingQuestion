import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Airwatch1 {

    static void printList(List<List<Integer>> sets){
        for (int i = 0; i < sets.size(); i++) {
            List<Integer> list =  sets.get(i);
            System.out.println("list: " + list);
        }
    }

    static int getMax(List<Integer> list){
        if(list.isEmpty()) return 0;
        int max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            Integer num =  list.get(i);
            if(num > max){
                max = num;
            }
        }
        return max;
    }

    static void removeNum(List<List<Integer>> sets){
        List<List<Integer>> newsets = new ArrayList<List<Integer>>();
        for (int i = 0; i < sets.size(); i++) {
            List<Integer> list =  sets.get(i);
            if(list.size() == 1){
                newsets.add(list);
            }
        }
        sets.removeAll(newsets);
    }

    static List<List<Integer>> addNumtoList(List<List<Integer>> sets, int n, int granularity){
        if(sets.isEmpty() && n == 1){
            List<Integer> list = new ArrayList<Integer>();
            list.add(n);
            sets.add(list);
            return sets;
        }

        List<List<Integer>> newsets = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(n);
        newsets.add(list);
        for (int i = 0; i < sets.size(); i++) {
            list =  new ArrayList<Integer>(sets.get(i));
            int max = getMax(list);
            if(n == max + granularity) {
                list.add(n);
                newsets.add(list);
            }
        }
        sets.addAll(newsets);
        return sets;
    }

    static List<List<Integer>> subSet(int n, int granularity){

        if(n == 1){
            List<List<Integer>> subsets = new ArrayList<List<Integer>>();
            addNumtoList(subsets, n, granularity);
//            printList(subsets);
            return subsets;
        }

        List<List<Integer>> subsets = subSet(n -1, granularity);
        addNumtoList(subsets, n, granularity);
//        printList(subsets);
        return subsets;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        int N = 4;
        int gradularity = 1;
        List<List<Integer>> sets = subSet(N, gradularity);
        removeNum(sets);
        printList(sets);
        System.out.println(sets.size());

        System.out.println("========");
        N = 2;
        gradularity = 1;
        List<List<Integer>> sets2 = subSet(N, gradularity);
        removeNum(sets2);
        printList(sets2);
        System.out.println(sets2.size());
        System.out.println("========");

        N = 3;
        gradularity = 2;
        List<List<Integer>> sets3 = subSet(N, gradularity);
        removeNum(sets3);
        printList(sets3);
        System.out.println(sets3.size());

        System.out.println("========");
//        List<List<Integer>> sets = new ArrayList<List<Integer>>();
//        List<Integer> l1 = new ArrayList<Integer>();
//        l1.add(1);
//        List<Integer> l2 = new ArrayList<Integer>();
//        l2.add(2);
//        List<Integer> l3 = new ArrayList<Integer>();
//        l2.add(1);
//        l2.add(2);
//
//        sets.add(l1);
////        printList(sets);
//        sets = addNumtoList(sets, 2);
//        sets = addNumtoList(sets, 3);
//        sets = addNumtoList(sets, 4);
//
//        printList(sets);

//        List<List<Integer>> subsets = subSet(N);
//        for (int i = 0; i < subsets.size(); i++) {
//            List<Integer> list = subsets.get(i);
//            System.out.println(list);
//        }
    }
}