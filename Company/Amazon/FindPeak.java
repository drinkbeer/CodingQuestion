class FindPeak{
    private static int find(int[] arr){
        if(arr == null && arr.length <= 1) return 0;

        int lo = 0, hi = arr.length - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            if(arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) lo = mid + 1;
            if(arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) hi = mid - 1;
        }

        return -1;
    }



    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 4, 2};
        System.out.println(find(arr));
    }
}