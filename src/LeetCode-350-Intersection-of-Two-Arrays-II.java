class Solution {
    /*
    https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/82241/AC-solution-using-Java-HashMap
    Time: O(N + M)  -   N is size of nums1, M is size of nums2
    Space: O(N)
    
    
    Follow up 1: What if the given array is already sorted? How would you optimize your algorithm?
    See the code below using two pointers.
    
    Follow up 2: What if nums1's size is small compared to nums2's size? Which algorithm is better?


    Follow up 3: What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
    


    
    */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int n : nums2) {
            if (map.containsKey(n) && map.get(n) > 0) {
                res.add(n);
                map.put(n, map.get(n) - 1);
            }
        }
        
        int[] r = new int[res.size()];
        int i = 0;
        for (int n : res) {
            r[i++] = n;
        }
        
        return r;
    }
    
    
    // Follow-up 1: What if the given array is already sorted? How would you optimize your algorithm?
    /*
    https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/282372/Java-solution-with-all-3-follow-up-questions
    
    Classic Two Pointer iteration, i points to nums1 and j points to nums2. Because a sorted array is ascending order, so if nums1[i] > nums2[j], we need to increment j, and vice versa. Only when nums1[i] == nums2[j], we add it to the result, and increment both i and j.
    
    Worst case, for example would be nums1 = {100}, and nums2 = {1,2,...,100}. We will always iterate the longest array.
    
    In some cases, if the arrays are sorted, two pointers are better than hashmap:
    1.Don't need extra memory.
    2.Avoid some edge cases. Nums1 = {1,2,3,...,100}, nums2={1,2}. It will ends faster when reaching nums2's end than the HashMap solution, which will iterate through both arrays.
    
    Avg Time Complexity is : O(max{M, N})
    Worst Time Complexity is : O(M + N)
    Space O(1) if result list is not counted as extra space.
    
    I manually sorted the two arrays to pass the OJ.
    */
//     public int[] intersect(int[] nums1, int[] nums2) {
//         Arrays.sort(nums1);
//         Arrays.sort(nums2);
//         int i = 0, j = 0;
//         List<Integer> list = new ArrayList<>();
//         while (i < nums1.length && j < nums2.length) {
//             if (nums1[i] < nums2[j]) {
//                 i++;
//             } else if (nums1[i] > nums2[j]) {
//                 j++;
//             } else {
//                 list.add(nums1[i]);
//                 i++;
//                 j++;
//             }
//         }
        
//         int[] ret = new int[list.size()];
//         for (int k = 0; k < list.size(); k++) {
//             ret[k] = list.get(k);
//         }
//         return ret;
//     }
    
    // Follow up 2: What if nums1's size is small compared to nums2's size? Which algorithm is better?
    /*
    If nums1 size is smaller than nums2 size, we use nums1 to get the frequency hashmap, and vice verse. So Space will be O(min{M, N}), time is still O(M + N).
    
    If the two arrays are both sorted, then using two pointers is much better than using HashMap, as it will avoid some edge cases, Nums1 = {1,2,3,...,100}, nums2={1,2}. It will ends faster when reaching nums2's end than the HashMap solution, which will iterate through both arrays.
    Some edge cases:
    nums1 = {1,100}, nums2 = {1,2,...,100}  -   Both algorithm has the same time, but Two Pointers has better space. It's worst case of two pointers algo.
    nums1 = {1,2}, nums2 = {1,2,...,100}    -   Two pointers are much better than HashMapp in both time and space.
    
    Binary Search Algo:
    We could iterate through nums1, and do binary search in nums2. (What if nums1 has duplicates?)
    So time complexity is O(MlogN). 
    Duplicate nums in nums1 case: nums1={1,2,2,3}, nums2={1,2}
    */
    
    // Follow up 3: What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
    /*
    https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/82243/Solution-to-3rd-follow-up-question
    (External Sort: https://github.com/drinkbeer/CodingQuestion/blob/master/sort.md) 
    if nums1 and nums2 are so huge that no one can load into memory, create HashMap for nums1, read chunks of nums1 until exhausted, record the number(key) and its frequency(value). Then read chunks of nums2, deal with hashmap of nums1 to find the intersection.
    
    There are roughly 3 ideas to process the problem:    
    1.Store the two strings in distributed system(whether self designed or not), then using MapReduce technique to solve the problem;
    2.Processing the Strings by chunk, which fits the memory, then deal with each chunk of data at a time;
    3.Processing the Strings by streaming, then check.
    
    Just wanted to add that when using map-reduce for two huge arrays, we cannot equally split them up. I think we should sort them through external sorting first and then using binary search to decide where to split.

    */
}
