https://www.geeksforgeeks.org/cartesian-tree/   
https://leetcode.com/problems/maximum-binary-tree/   


#### Construct a Cartesian Tree (Min or Max Heap)

```
public class CartesianTree {
	
	public static class Node {
		public int value;
		public Node left;
		public Node right;
	}
	
	public static Node build(int[] data) {
		if (data == null || data.length == 0) return null;
		return build(data, 0, data.length - 1);
	}
	
	private static Node build(int[] data, int start, int end) {
		if (end < start) return null;
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		
		for (int i = start; i <= end; i++) {
			if (data[i] < min) {
				min = data[i];
				minIndex = i;
			}
		}
		
		Node node = new Node();
		node.value = min;
		
		node.left = build(data, start, minIndex - 1);
		node.right = build(data, minIndex + 1, end);
		
		return node;
	} 
}
```

```
public TreeNode constructMaximumBinaryTree(int[] nums) {
    if (nums == null || nums.length == 0) return null;
    return build(nums, 0, nums.length - 1);
}

private TreeNode build(int[] nums, int s, int e) {
    if (s > e) return null;
    int max = -1, maxVal = Integer.MIN_VALUE;

    for (int i = s; i <= e; i++) {
        if (nums[i] > maxVal) {
            maxVal = nums[i];
            max = i;
        }
    }

    TreeNode node = new TreeNode(nums[max]);
    node.left = build(nums, s, max - 1);
    node.right = build(nums, max + 1, e);
    return node;
}
```
