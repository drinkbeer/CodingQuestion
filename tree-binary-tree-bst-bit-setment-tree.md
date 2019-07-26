
#### 315. Count of Smaller Numbers After Self
https://leetcode.com/problems/count-of-smaller-numbers-after-self/

```

```

#### 493. Reverse Pairs
https://leetcode.com/problems/reverse-pairs/

```

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

