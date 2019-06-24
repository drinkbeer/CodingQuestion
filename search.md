

### Binary Search

Template

In a sorted, non-duplicate array, search target:  
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

In a sorted, duplicated array, search the first element >= target:  
Boundary: `[lo, hi]`

```
public int searchInsert(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;
    while (lo + 1 < hi) {
        int mid = lo + (hi - lo) / 2;

        if (nums[mid] == target) hi = mid;
        else if (nums[mid] < target) lo = mid;
        else hi = mid;
    }
    
    if (nums[lo] >= target) return lo;
    if (nums[hi] >= target) return hi;
    return hi + 1;
}
```

In a sorted, duplicated array, search the last element >= target:  
Boundary: `[lo, hi]`

```
public int searchInsert(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;
    while (lo + 1 < hi) {
        int mid = lo + (hi - lo) / 2;

        if (nums[mid] == target) lo = mid;
        else if (nums[mid] < target) lo = mid;
        else hi = mid;
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

Binary Search题目类型有三类：
1. 有明确Target
2. 没有明确Target
3. 没有明确Target（可越界类型）

### 第一类题：有明确Target的题型

#### 374. Guess Number Higher or Lower

```
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1, hi = n;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (guess(mid) == 0) return mid;
            else if (guess(mid) == -1) hi = mid - 1;
            else lo = mid + 1;
        }
        
        return lo;
    }
}
```

