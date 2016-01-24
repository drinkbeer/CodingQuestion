/*
Find all numbers in a given array that occur odd number of times.


*/
class FindOddOccurance{
    public static int find(int[] arr){
        java.util.Arrays.sort(arr);

        int count = 0;
        for(int i = 0; i < arr.length; i++){
            int num = 0;
            while(i + num < arr.length && arr[i + num] == arr[i]){
                num++;
            }
            if(num % 2 == 1) count++;
            i = i + num - 1;
        }
        return count;
    }

    public static void main(String[] args){
        int[] arr = {5, 1, 3, 2, 3, 1, 3, 4, 5};
        System.out.println(find(arr));
    }
}
