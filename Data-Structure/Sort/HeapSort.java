package Sort;

/*
HeapSort
Time: O()

Ref: http://mushiqianmeng.blog.51cto.com/3970029/738164
    http://www.cnblogs.com/skywang12345/p/3602162.html
    http://www.cnblogs.com/jetpie/p/3971382.html
*/
class HeapSort{

    private static void heapSort(int[] arr){
        int len = arr.length;
        buildMaxHeap(arr, len);
        for(int i = len - 1; i > 0; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            maxHeapify(arr, 1, i);
        }
    }

    private static void buildMaxHeap(int[] arr, int heapSize){
        for(int i = heapSize / 2; i > 0; i--){
            maxHeapify(arr, i, heapSize);
        }
    }

    private static void maxHeapify(int[] arr, int index, int heapSize){
        int l = index * 2;
        int r = l + 1;
        int largest;

        if(l <= heapSize && arr[l - 1] > arr[index - 1]){
            largest = l;
        }else{
            largest = index;
        }

        if(r <= heapSize && arr[r - 1] > arr[largest - 1]){
            largest = r;
        }

        if(largest != index){
            int temp = arr[index - 1];
            arr[index - 1] = arr[largest - 1];
            arr[largest - 1] = temp;
            maxHeapify(arr, largest, heapSize);
        }
    }

    public static void main(String[] args) { 
        int[] arr = new int[] {16, 14, 10, 8, 7, 9, 3, 2, 4, 1}; 

        heapSort(arr); 
        for (int i : arr) { 
            System.out.print(i + " "); 
        } 
    } 

}