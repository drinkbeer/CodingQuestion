/*
coding题      Ex: input: {1, 2, 3, 4 ,5}
                  interval = 2
1.    找出interval数量         output: 3      有三个interval {1， 2} {3， 4} {5}
2.    打印interval               {1， 2}                
                                {3， 4}
                                {5}

Analysis:
Corner case:
    null    3   ->  0
    []      3   ->  0
    [1]     3   -> 1
    [1,2,3] 3   -> 1
    [1,2,3,4]   3   ->  2
*/
import java.util.*;

class GetIntervals{
    public static int get(int[] arr, int interval){
        if(arr == null || arr.length == 0) return 0;
        if(arr.length <= interval) return 1;

        int count = arr.length / interval;
        return arr.length % interval == 0 ? count : count + 1;
    }
    
    public static List<List<Integer>> get2(int[] arr, int interval){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(arr == null || arr.length == 0) return result;
        
        for(int i = 0; i < arr.length; i++){
            List<Integer> subarr = new ArrayList<Integer>();
            int m = 0;
            while(m < 3 && i + m < arr.length){
                subarr.add(arr[i + m]);
                m++;
            }
            i = i + m - 1;
            result.add(subarr);
        }
                
        return result;
    }

    public static void main(String[] args){
        int[] arr1 = {1, 2, 3, 4};
        System.out.println(get(arr1, 3));
        List<List<Integer>> lists = get2(arr1, 3);
        printList(lists);
    }
    
    private static void printList(List<List<Integer>> lists){
        for(int i = 0; i < lists.size(); i++){
            List<Integer> l = lists.get(i);
            for(Integer k : l){
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}