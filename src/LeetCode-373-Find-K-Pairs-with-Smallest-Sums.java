class Solution {
    // 1. Using List<>[] array to hold the pairs sums. It will MLE (Memory Limit Exceeded), as the sum may be in huge range
    /*
    [-498632390,-498363355,497383746,498143041]
    
    Time O(N^2)
    Space O(maxSum - minSum)
    */
//     public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//         int s1 = Integer.MAX_VALUE, m1 = Integer.MIN_VALUE;
//         for (int i : nums1) {
//             s1 = Math.min(s1, i);
//             m1 = Math.max(m1, i);
//         }
        
//         int s2 = Integer.MAX_VALUE, m2 = Integer.MIN_VALUE;
//         for (int j : nums2) {
//             s2 = Math.min(s2, j);
//             m2 = Math.max(m2, j);
//         }
        
//         int offset = 0;
//         if (s1 + s2 < 0) offset = 0 - (s1 + s2);
        
//         List<int[]>[] sum = new List[m1 + m2 + 1 + offset];
        
//         for (int i : nums1) {
//             for (int j : nums2) {
//                 int idx = i + j + offset;
//                 if (sum[idx] == null) {
//                     sum[idx] = new ArrayList<>();
//                 }
//                 sum[idx].add(new int[] {i, j});
//             }
//         }
        
//         List<List<Integer>> res = new ArrayList<>();
//         for (int i = 0; i < sum.length; i++) {
//             if (sum[i] != null) {
//                 for (int[] p : sum[i]) {
//                     if (res.size() < k) {
//                         res.add(Arrays.asList(p[0], p[1]));
//                     } else {
//                         break;
//                     }
//                 }
//             }
//         }
//         return res;
//     }
    
    // 2. Using Min Heap (K-way Merge)
    /*
    https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/84551/simple-Java-O(KlogK)-solution-with-explanation
    
    
    
    It is hard for me to understand at the beginning, but I finally came up with an idea to view this question, hope it can help you!

    It is actually the same as how we merge k sorted list, in this question, the following are the k sorted list(each number in nums1[] full-mesh with the numbers in nums2[].

    (1,2) -> (1,9) -> (1,10) -> (1,15)
    (7,2) -> (7,9) -> (7,10) -> (7,15)
    (11,2) -> (11,9) -> (11,10) -> (11,15)
    (16,2) -> (16,9) -> (16,10) -> (16,15)

    Remember how we do in "merge k sorted list"? We simply add the head of the list into the heap and when a node is poll(), we just add the node.next.
    */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.get(0) + a.get(1), b.get(0) + b.get(1)));
        
        List<List<Integer>> res = new ArrayList<>();
        int l1 = nums1.length, l2 = nums2.length;
        if (l1 == 0 || l2 == 0) return res;
        // offer initial k pairs {nums1, nums2, index_of_nums2}
        for (int i = 0; i < Math.min(l1, k); i++) pq.offer(Arrays.asList(nums1[i], nums2[0], 0));
        
        // get 1st k elem into result, each time, offer potential better pairs into queue
        // if there r not enough pair, just return all pairs
        for (int i = 0; i < Math.min(l1 * l2, k); i++) {
            // get the best pair and put into res
            List<Integer> curr = pq.poll();
            res.add(Arrays.asList(curr.get(0), curr.get(1)));
            
            // next better pair could with be A: {after(num1), num2} or B: {num1. after(num2)}
            // for A, we've already added top possible k into queue, so A is either in the queue already, or not qualified
            // for B, it might be a better choice, so we offer it into queue
            if (curr.get(2) < l2 - 1) {
                // if curr.get(2) is not the last one in nums2
                int idx = curr.get(2) + 1;
                pq.offer(Arrays.asList(curr.get(0), nums2[idx], idx));
            }
        }
        
        return res;
    }
    
    
    
    // public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int K) {
    //     int n1 = nums1.length, n2 = nums2.length;
    //     if(K <= 0) {
    //         return new ArrayList<>();
    //     }
    //     if(K >= n1 * n2) {
    //         List<Integer>[] pairs = new List[n1 * n2];
    //         for(int i = 0, k = 0; i < n1; i++) {
    //             int num1 = nums1[i];
    //             for(int j = 0; j < n2; j++) {
    //                 int num2 = nums2[j];
    //                 pairs[k++] = Arrays.asList(new Integer[]{num1, num2});
    //             }
    //         }
    //         return Arrays.asList(pairs);
    //     }
    //     boolean isSwap;
    //     if(n1 > n2) {
    //         isSwap = true;
    //         int[] nums3 = nums1;
    //         nums1 = nums2;
    //         nums2 = nums3;
    //         int n3 = n1;
    //         n1 = n2;
    //         n2 = n3;
    //     } else {
    //         isSwap = false;
    //     }
    //     int start = nums1[0] + nums2[0], end = nums1[n1 - 1] + nums2[n2 - 1], mid, nEqual;
    //     for(;;) {
    //         mid = start + end >> 1;
    //         int count1 = 0, count2 = 0;
    //         Loop:
    //         for(int i = 0, j = n2 - 1, num2 = nums2[j]; i < n1; i++) {
    //             int num1 = nums1[i];
    //             for(; num1 + num2 > mid; num2 = nums2[--j]) {
    //                 if(j == 0) {
    //                     break Loop;
    //                 }
    //             }
    //             int k = j, num3 = num2;
    //             for(; num1 + num3 == mid; num3 = nums2[k]) {
    //                 if(--k < 0) {
    //                     break;
    //                 }
    //             }
    //             count1 += k + 1;
    //             count2 += j + 1;
    //         }
    //         if(K < count1) {
    //             end = mid - 1;
    //         } else if(K > count2) {
    //             start = mid + 1;
    //         } else {
    //             nEqual = K - count1;
    //             break;
    //         }
    //     }
    //     List<Integer>[] pairs = new List[K];
    //     Loop:
    //     for(int i = 0, j = n2 - 1, num2 = nums2[j], l = 0; i < n1; i++) {
    //         int num1 = nums1[i];
    //         for(; num1 + num2 > mid; num2 = nums2[--j]) {
    //             if(j == 0) {
    //                 break Loop;
    //             }
    //         }
    //         for(int k = 0; k <= j; k++) {
    //             int num3 = nums2[k];
    //             if(num1 + num3 == mid) {
    //                 if(nEqual > 0) {
    //                     nEqual--;
    //                 } else {
    //                     break;
    //                 }
    //             }
    //             Integer[] pair = isSwap ? new Integer[]{num3, num1} : new Integer[]{num1, num3};
    //             pairs[l++] = Arrays.asList(pair);
    //         }
    //     }
    //     return Arrays.asList(pairs);
    // }
}
