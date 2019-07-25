
## Binary Search Tree

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

