

### Binary Search

https://leetcode.com/problems/find-k-th-smallest-pair-distance/submissions/

```
public int smallestDistancePair(int[] nums, int k) {
    Arrays.sort(nums);

    int low = 0;
    int high = nums[nums.length - 1] - nums[0];

    while (low < high) {
        int mid = low + (high - low) / 2;

        if (!enough(nums, mid, k)) {
            low = mid + 1;
        } else {
            high = mid;
        }
    }

    return low;
}
```
