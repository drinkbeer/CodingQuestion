class Solution {
    // Wrong Answer
    /*
    I am trying to resolve this problem similar to: https://github.com/drinkbeer/CodingQuestion/blob/master/src/LeetCode-239-Sliding-Window-Maximum.java
    But it doesn't work:
    
    For example:
    [2,6,3]
    My output: [1,1,0]
    Correct output: [0,1,0]
    */
//     public List<Integer> countSmaller(int[] nums) {
//         int n = nums.length;
//         List<Integer> res = new ArrayList<>();
//         Deque<Integer> dq = new ArrayDeque<>();
        
//         for (int i = n - 1; i >= 0; i--) {
//             System.out.println("i: " + i + "  nums[i]: " + nums[i] + "  dq: " + dq.toString());
//             if (!dq.isEmpty()) {
//                 System.out.println(" nums[dq.peekLast()]: " +  nums[dq.peekLast()]);
//             }
//             while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                
//                 dq.pollLast();
//             }
            
//             dq.offerLast(i);
            
            
            
//             res.add(0, n - i - dq.size());
//         }
        
//         return res;
//     }
    
    // 1. Merge Sort
    /*
    https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76584/Mergesort-solution
    */
//     private class Pair {
//         int val;
//         int idx;
        
//         public Pair (int val, int idx) {
//             this.val = val;
//             this.idx = idx;
//         }
//     }
    
//     public List<Integer> countSmaller(int[] nums) {
//         int n = nums.length;
//         Pair[] tmp = new Pair[n];
//         int[] res = new int[n];
        
//         Pair[] pairs = new Pair[n];
//         for (int i = 0; i < n; i++) {
//             pairs[i] = new Pair(nums[i], i);
//         }
        
//         mergeSort(pairs, 0, n - 1, tmp, res);
//         // System.out.println(Arrays.toString(res));
//         // System.out.println(Arrays.stream(pairs).map(p -> p.val).collect(Collectors.toList()).toString());
//         return Arrays.stream(res).boxed().collect(Collectors.toList());
//     }
    
//     private void mergeSort(Pair[] pairs, int lo, int hi, Pair[] tmp, int[] res) {
//         if (lo >= hi) return;
//         int mid = lo + (hi - lo) / 2;
//         mergeSort(pairs, lo, mid, tmp, res);
//         mergeSort(pairs, mid + 1, hi, tmp, res);
//         merge(pairs, lo, mid, hi, tmp, res);
//     }
    
//     private void merge(Pair[] pairs, int lo, int mid, int hi, Pair[] tmp, int[] res) {
//         if (lo >= hi) return;
//         for (int k = lo; k <= hi; k++) {
//             tmp[k] = pairs[k];
//         }
        
//         int i = lo, j = mid + 1;
//         for (int k = lo; k <= hi; k++) {
//             if (j > hi || (i <= mid && tmp[i].val <= tmp[j].val)) {
//                 pairs[k] = tmp[i];
//                 // System.out.println("i: " + i + "  j: " + j + "  tmp[i].idx: " + tmp[i].idx + "  tmp[i].val: " + tmp[i].val + "  lo: " + lo + "  hi: " + hi);
//                 // mid + 1 is the init index of the right array. j - (mid + 1) is the length of the subarray of right array that each element smaller than current i.
//                 res[tmp[i].idx] += j - (mid + 1);
//                 i++;
//             } else {
//                 pairs[k] = tmp[j];
//                 j++;
//             }
//         }
//     }
    
    // 2. BST
    /*
    https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76587/Easiest-Java-solution
    https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76580/9ms-short-Java-BST-solution-get-answer-when-building-BST
    
    Time O(N^2) if input is like n, n-1, ..., 2, 1
    */
    private class Node {
        int val;
        int leftSum = 0;    // number of nodes in left child tree
        int count = 0;      // number of nodes equal to val
        Node left, right;
        
        public Node (int val) {
            this.val = val;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        int n = nums.length;
        
        List<Integer> res = new ArrayList<>();
        Node root = new Node(nums[n - 1]);
        root.count++;
        res.add(0, 0);
        for (int i = n - 2; i >= 0; i--) {
            res.add(0, insert(root, nums[i]));
        }
        return res;
    }
    
    private int insert(Node node, int num) {
        int leftSum = 0;
        while (node.val != num) {
            if (num < node.val) {
                // insert to the left child tree of node
                if (node.left == null) node.left = new Node(num);
                node.leftSum++;     // insert the new node to left child tree, so the count of left child tree nodes +1
                node = node.left;
            } else {
                if (node.right == null) node.right = new Node(num);
                leftSum += node.leftSum + node.count;
                node = node.right;
            }
        }
        node.count++;
        return leftSum + node.leftSum;
    }
    
    // 3. Other approaches
    /*
    Segment Tree:
    
    Binary Index Tree:
    
    https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76657/3-ways-(Segment-Tree-Binary-Indexed-Tree-Binary-Search-Tree)-clean-python-code
    */
}
