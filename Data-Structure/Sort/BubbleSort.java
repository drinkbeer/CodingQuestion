/*
Bubble Sort
Time O(N^2)
*/

class BubbleSort {

    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length == 0) return;

        int N = arr.length;
        for(int i = N - 1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    // keep swapping in pairs until there is no need to swap
    public static void bubbleSort2(int[] arr){
        if(arr == null || arr.length == 0) return;

        int N = arr.length;
        boolean swap = true;
        while(swap){
            swap = false;

            for(int i = 1; i < N; i++){
                if(arr[i] < arr[i - 1]){
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] =  temp;
                    swap = true;
                }
            }
        }
    }

    // Optimize of bubbleSort2.
    public static void bubbleSort3(int[] arr){
        if(arr == null || arr.length == 0) return;

        int N = arr.length;
        boolean swap = true;
        while(swap){
            swap = false;

            for(int i = 1; i < N; i++){
                if(arr[i] < arr[i - 1]){
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] =  temp;
                    swap = true;
                }
            }
            N--;    //optimize: each for loop, there is one in its final position
        }
    }

    // Another Optimize of bubbleSort2.
    public static void bubbleSort4(int[] arr){
        if(arr == null || arr.length == 0) return;

        int N = arr.length;
        boolean swap = true;
        while(N != 0){
            swap = false;
            int lastSwap = 0;

            for(int i = 1; i < N; i++){
                if(arr[i] < arr[i - 1]){
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] =  temp;
                    lastSwap = i;
                }
            }
            N = lastSwap;    //optimize: each for loop, lastSwap is last position of swap, subarray after is non-decending
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{5,2,4,6,1,3};
        bubbleSort4(arr);
        for(int curr : arr){
            System.out.print(curr + " ");
        }
    }
}