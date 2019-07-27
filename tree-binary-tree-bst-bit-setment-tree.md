
#### 315. Count of Smaller Numbers After Self
https://leetcode.com/problems/count-of-smaller-numbers-after-self/

```

```

#### 493. Reverse Pairs
https://leetcode.com/problems/reverse-pairs/

Build Binary Search Tree:
```
    // 2. Build BST from left to right of array + search elements > 2L * element value  (TLE)
    private class Node {
        int val;        // value of current Node
        int count;      // count of nodes' value >= val
        Node left, right;
        
        public Node(int val) {
            this.val = val;
            this.count = 1;
        }
    }
    
    private class BinarySearchTree {
        Node root;
        public BinarySearchTree () {
            this.root = null;       // init the BST to be empty tree
        }
        
        // search the number of elements that is > val
        public int searchLargerCount(long val) {
            return searchLargerCount(val, root);
        }
        
        private int searchLargerCount(long val, Node curr) {
            if (curr == null) {
                return 0;   // search in an empty (sub) tree, we just return 
            } else if (curr.val > val) {
                // count curr count (num of nodes >= curr.val) and search in left tree
                return curr.count + searchLargerCount(val, curr.left);
            } else {
                return searchLargerCount(val, curr.right);
            }
        }
        
        private void insert(int val) {
            if (root == null) {
                root = new Node(val);
                return;
            }
            insert(val, root);
        }
        
        private Node insert(int val, Node curr) {
            if (curr == null) {
                return new Node(val);
            } else if (val == curr.val) {
                curr.count++;
            } else if (val < curr.val) {
                curr.left = insert(val, curr.left);
            } else {
                // insert in right sub-tree
                curr.count++;
                curr.right = insert(val, curr.right);
            }
            return curr;
        }
    }
    
    public int reversePairs(int[] nums) {
        BinarySearchTree bst = new BinarySearchTree();
        
        int res = 0;
        for (int v : nums) {
            // System.out.println("v: " + v + "  res: " + res + "  bst.searchLargerCount(2L * v): " + bst.searchLargerCount(2L * v));
            res += bst.searchLargerCount(2L * v);   // search in the existing tree that the val > 2L * v. as we are inserting from left to right, so we are search in range [0, curr_idx)
            bst.insert(v);
        }
        return res;
    }
```

Build Binary Index Tree:
```
    // 3. Binary Index Tree
    /*
    https://leetcode.com/problems/reverse-pairs/discuss/97268/General-principles-behind-problems-similar-to-%22Reverse-Pairs%22
    http://pavelsimo.blogspot.com/2012/09/counting-inversions-in-array-using-BIT.html
    https://www.cnblogs.com/grandyang/p/6657956.html
    
    
    nums: [2, 4, 3, 5, 1]    copy: [1, 2, 3, 4, 5]  BitArr: [0, 0, 0, 0, 0, 0]  nums[i]: 1  idx1: 0  idx2: 0  Query Result in BIT: 0
    nums: [2, 4, 3, 5, 1]    copy: [1, 2, 3, 4, 5]  BitArr: [0, 1, 1, 0, 1, 0]  nums[i]: 5  idx1: 2  idx2: 4  Query Result in BIT: 1
    nums: [2, 4, 3, 5, 1]    copy: [1, 2, 3, 4, 5]  BitArr: [0, 1, 1, 0, 1, 1]  nums[i]: 3  idx1: 1  idx2: 2  Query Result in BIT: 1
    nums: [2, 4, 3, 5, 1]    copy: [1, 2, 3, 4, 5]  BitArr: [0, 1, 1, 1, 2, 1]  nums[i]: 4  idx1: 1  idx2: 3  Query Result in BIT: 1
    nums: [2, 4, 3, 5, 1]    copy: [1, 2, 3, 4, 5]  BitArr: [0, 1, 1, 1, 3, 1]  nums[i]: 2  idx1: 0  idx2: 1  Query Result in BIT: 0
    */
    private class BinaryIndexTree {
        private int[] arr;
        public BinaryIndexTree(int n) {
            arr = new int[n + 1];
        }
        
        public void update(int i) {
            i = i + 1;
            while (i < arr.length) {
                arr[i]++;
                i += getLowBit(i);
            }
        }
        
        public int query(int i) {
            // i = i + 1;
            int res = 0;
            while (i > 0) {
                res += arr[i];
                i -= getLowBit(i);
            }
            return res;
        }
        
        private int getLowBit(int x) {
            return x & (-x);
        }
        
        public int[] getBitArr() {
            return arr;
        }
    }
    
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[] copy = nums.clone();
        Arrays.sort(copy);
        
        BinaryIndexTree bit = new BinaryIndexTree(n);
        
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            int idx1 = search(copy, 1.0 * num / 2);
            
            res += bit.query(idx1);
            int idx2 = search(copy, num);
            // System.out.println(1.0 * num / 2);
            // System.out.println("nums: " + Arrays.toString(nums) + "    copy: " + Arrays.toString(copy) + "  BitArr: " + Arrays.toString(bit.getBitArr()) + "  nums[i]: " + nums[i] + "  idx1: " + idx1 + "  idx2: " + idx2 + "  Query Result in BIT: " + bit.query(idx1));
            
            bit.update(idx2);
        }
        return res;
    }
    
    // find the first position in the arr that has arr[i] >= val
    // private int search(int[] arr, double val) {
    //     int lo = 0, hi = arr.length - 1;
    //     while (lo + 1 < hi) {
    //         int mid = lo + (hi - lo) / 2;
    //         if (arr[mid] < val) {
    //             lo = mid;
    //         } else {
    //             hi = mid;
    //         }
    //     }
    //     if (arr[lo] >= val) return lo;
    //     return hi;
    // }
    
    // find the first index that has nums[i] >= val. i could exceed the boundary, for example: [-7, -4], when we search -3.5, then return 2
    private int search(int[] arr, double val) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < val) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        return lo;
    }
```

Using Merge Sort (Divide & Conquer): 
```
    // Another approach to do Merge Sort without sorting
    /*
    https://www.youtube.com/watch?v=Uf-27aFXhHY
    Time O(NlogN)
    
    Runtime: 37 ms, faster than 97.97% of Java online submissions for Reverse Pairs.
    Memory Usage: 52 MB, less than 75.66% of Java online submissions for Reverse Pairs.
    */
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return sort(nums, temp, 0, nums.length - 1);
    }
    
    private int sort(int[] nums, int[] temp, int lo, int hi) {
        if (lo >= hi) return 0;
        int mid = lo + (hi - lo) / 2;
        int count = 0;
        count += sort(nums, temp, lo, mid);
        count += sort(nums, temp, mid + 1, hi);
        count += merge(nums, temp, lo, mid, hi);
        return count;
    }
    
    private int merge(int[] nums, int[] temp, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }
        
        int i = lo, j = mid + 1, count = 0;
        while (i <= mid && j <= hi) {
            if ((long) nums[i] > 2 * (long) nums[j]) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }
        
        i = lo;
        j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (j > hi || (i <= mid && temp[i] < temp[j])) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
            }
        }
        
        return count;
    }
```

## Binary Search Tree

```

```

## Binary Index Tree (Fenwick Tree)
https://www.youtube.com/watch?v=CWDQJGaN1gY  
https://www.youtube.com/watch?v=WbafSgetDDk  

Binary Index Tree is proposed to solve the prefix problem. The idea is to store partial sum in each node, and get total sum by traversing the tree from leaf to root. The tree has a height of log(N).

Query: `O(logN)`  
Update: `O(logN)`

```
/**
 * https://www.youtube.com/watch?v=CWDQJGaN1gY
 * https://www.youtube.com/watch?v=WbafSgetDDk
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/FenwickTree.java
 */
public class BinaryIndexTree {

    private int[] sum;

    public BinaryIndexTree(int n) {
        sum = new int[n + 1];
    }

    public void update(int i, int delta) {
        while (i < sum.length) {
            sum[i] += delta;
            i += getLowBit(i);
        }
    }

    public int query(int i) {
        int res = 0;
        while (i > 0) {
            res += sum[i];
            i -= getLowBit(i);
        }
        return res;
    }

    /**
     * lowbit(x) = x & (-x)
     * <p>
     * x = 5:  0110
     * -x = ~x + 1 = 1001 + 0001 = 1010
     * lowbit(x) = x & (-x) = 0110 & 1010 = 0010 = 2
     */
    private int getLowBit(int x) {
        return x & (-x);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        BinaryIndexTree bit = new BinaryIndexTree(nums.length);
        for (int i = 0; i < nums.length; i++) {
            bit.update(i + 1, nums[i]);
        }

        System.out.println(bit.query(0));
        System.out.println(bit.query(1));
        System.out.println(bit.query(2));
        System.out.println(bit.query(3));
        System.out.println(bit.query(4));
        System.out.println(bit.query(5));
        System.out.println(bit.query(6));
        System.out.println(bit.query(7));
    }
}
```

## Segment Tree

https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/   
https://www.geeksforgeeks.org/segment-tree-set-1-range-minimum-query/  
https://www.youtube.com/watch?v=ZBHKZF5w4YU  
https://www.youtube.com/watch?v=rYBtViWXYeI  

Segment Tree is used for range query (range sum, range max, range min, etc).

Update: `O(logN)`   
Query: `O(logN + K)`   

```
/**
 * https://www.youtube.com/watch?v=rYBtViWXYeI
 * https://www.youtube.com/watch?v=ZBHKZF5w4YU
 *
 * Update: O(logN)
 * Query: O(logN + K)
 */
public class SegmentTree {
    private class Node {
        int start;
        int end;
        int sum;    // could be max/min
        Node left, right;

        public Node(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }

    private Node root;
    public SegmentTree(int[] nums) {
        this.root = buildSegmentTree(nums, 0, nums.length - 1);
    }

    private Node buildSegmentTree(int[] nums, int i, int j) {
        if (i == j) {
            return new Node(i, j, nums[i]);
        }

        int mid = i + (j - i) / 2;
        Node left = buildSegmentTree(nums, i, mid);
        Node right = buildSegmentTree(nums, mid + 1, j);

        Node curr = new Node(i, j, left.sum + right.sum);
        curr.left = left;
        curr.right = right;

        return curr;
    }

    public void update(int idx, int val) {
        update(root, idx, val);
    }

    private void update(Node curr, int idx, int val) {
        if (curr.start == curr.end && curr.start == idx) {
            curr.sum = val;
            return;
        }

        int mid = curr.start + (curr.end - curr.start) / 2;
        if (idx <= mid) {
            update(curr.left, idx, val);
        } else {
            update(curr.right, idx, val);
        }

        curr.sum = curr.left.sum + curr.right.sum;
    }

    public int query(int i, int j) {
        return query(root, i, j);
    }

    private int query(Node curr, int i, int j) {
        if (curr.start == i && curr.end == j) {
            return curr.sum;
        }

        int mid = curr.start + (curr.end - curr.start) / 2;
        if (j <= mid) {
            return query(curr.left, i, j);
        } else if (i > mid) {
            return query(curr.right, i, j);
        } else {
            return query(root.left, i, mid) + query(root.right, mid + 1, j);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(nums);

        System.out.println(st.query(0, 1));
        System.out.println(st.query(0, 4));
        System.out.println(st.query(2, 5));

        // {1, 3, -1, 7, 9, 11}
        st.update(2, -1);
        System.out.println(st.query(0, 1));
        System.out.println(st.query(0, 4));
        System.out.println(st.query(2, 5));
    }

}

```

