

### Binary Search

Template

Boundary: `[lo, hi]`  

```
public int search(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;

        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) lo = mid + 1;
        else hi = mid - 1;
    }
    return lo;
}
```

Boundary: `[lo, hi]`
```
public int searchInsert(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;
    while (lo + 1 < hi) {
        int mid = lo + (hi - lo) / 2;

        if (nums[mid] == target) hi = mid;
        else if (nums[mid] < target) lo = mid + 1;
        else hi = mid - 1;
    }
    
    if (nums[lo] >= target) return lo;
    if (nums[hi] >= target) return hi;
    return hi + 1;
}
```


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
