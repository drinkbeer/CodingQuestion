/*
https://github.com/drinkbeer/CodingQuestion/blob/master/heap.md
Similar to : https://leetcode.com/problems/top-k-frequent-words/
*/
class Solution {
    // 1. Using Min Heap
    /*
    Time O(NlogK)
    Space O(K)
    */
    // Heap sort
//     public int[] topKFrequent(int[] nums, int k) {
//         Map<Integer, Integer> map = new HashMap<>();
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(map.get(a), map.get(b)));
        
//         // Calculate frequency
//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }
        
//         for (int key : map.keySet()) {
//             pq.offer(key);
//             if (pq.size() > k) {
//                 pq.poll();
//             }
//         }
        
//         int size = pq.size();
//         int[] result = new int[size];
//         for (int i = 0; i < size; i++) {
//             result[i] = pq.poll();
//         }
//         return result;
//     }
    
    // 2. Using Bucket sort
//     public List<Integer> topKFrequent(int[] nums, int k) {
//         List<Integer> res = new ArrayList<>();
        
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for (int n : nums) {
//             map.put(n, map.getOrDefault(n, 0) + 1);
//         }
        
//         // <freq, list of num>
//         List<Integer>[] bucket = new List[nums.length + 1];
//         for (int key : map.keySet()) {
//             if (bucket[map.get(key)] == null) {
//                 bucket[map.get(key)] = new ArrayList<>();
//             }
            
//             bucket[map.get(key)].add(key);
//         }
        
//         for (int j = bucket.length - 1; j >= 0; j--) {
//             if (bucket[j] == null) continue;
            
//             for (int key : bucket[j]) {
//                 if (res.size() < k) {
//                     res.add(key);
//                 } else {
//                     break;
//                 }
//             }
//         }
        
//         return res;
//     }

    // QuickSelect, doesn't work
//     public int[] topKFrequent(int[] nums, int k) {
//         Map<Integer, Integer> map = new HashMap<>();
        
//         // Calculate frequency
//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }
        
//         int[] temp = new int[map.size()];
//         int[] arr = new int[map.size()];
//         int i = 0;
//         for (int key : map.keySet()) {
//             arr[i++] = key;
//         }
        
//         List<Integer> res = new ArrayList<>();
//         quickSelect(nums, k - 1, temp, map, res, 0, arr.length - 1);
//         int[] result = new int[res.size()];
//         for (int j = 0; j < res.size(); j++) {
//             result[j] = res.get(j);
//         }
//         return result;
//     }
    
//     private void quickSelect(int[] nums, int k, int[] temp, Map<Integer, Integer> map, List<Integer> res, int lo, int hi) {
//         if (lo >= hi) return;
        
//         int val = partition(nums, temp, map, lo, hi);
        
//         if (val == k) {
//             res.add(nums[k]);
//             return;
//         } else if (val < k) {
//             quickSelect(nums, k, temp, map, res, val + 1, hi);
//         } else {
//             quickSelect(nums, k, temp, map, res, lo, val - 1);
//         }
//     }
    
//     private int partition(int[] nums, int[] temp, Map<Integer, Integer> map, int lo, int hi) {
//         for (int k = lo; k <= hi; k++) {
//             temp[k] = nums[k];
//         }
        
//         int mid = lo + (hi - lo) / 2;
//         swap(nums, mid, hi);
//         int pivot = map.get(temp[hi]);
//         int p = lo;
//         for (int k = lo; k < hi; k++) {
//             if (map.get(temp[k]) < pivot) {
//                 swap(nums, p++, k);
//             }
//         }
        
//         swap(nums, p, hi);
//         return p;
        
//     }
    
//     private void swap(int[] arr, int i, int j) {
//         int temp = arr[i];
//         arr[i] = arr[j];
//         arr[j] = temp;
//     }
    
    // QuickSelect
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            if (!map.containsKey(currNum)) {
                map.put(currNum, 0);
            }
            map.put(currNum, map.get(currNum)+1);
        }
        
        //remove duplicated nums
        int[] filteredNum = new int[map.size()];
        int writeIdx = 0;
        for (int num : map.keySet()) {
            filteredNum[writeIdx] = num;
            writeIdx++;
        }
        int headIdx = 0;
        int tailIdx = filteredNum.length - 1;
        while (headIdx < tailIdx) {
            int sortedIdx = partition(filteredNum, headIdx, tailIdx, map);
            if (sortedIdx == k-1) {
                break;
            } else if (sortedIdx > k-1) {
                tailIdx = sortedIdx - 1;
            } else {
                headIdx = sortedIdx + 1;
            }
        }
        int[] result = new int[k];
        for (int j = 0; j < result.length; j++) {
            result[j] = filteredNum[j];
        }
        return result;
    }
    
    private int partition(int[] nums, int headIdx, int tailIdx, Map<Integer, Integer> map) {
        int pivotIdx = headIdx;
        int pivotPointCount = map.get(nums[pivotIdx]);
        swap(nums, pivotIdx, tailIdx);
        int j = headIdx;
        for (int i = headIdx; i < tailIdx; i++) {
            int currNumCount = map.get(nums[i]);
            if (currNumCount > pivotPointCount) {
                swap(nums, i, j);
                j++;
            }
        }
        swap(nums, j, tailIdx);
        return j;
    }
    
    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}