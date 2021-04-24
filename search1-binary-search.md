

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
    return -1;
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
    return -1;
}
```

In a sorted, duplicated array, search the last element <= target:  
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
    
    if (nums[hi] <= target) return hi;
    if (nums[lo] <= target) return lo;
    return -1;
}
```

Example: 
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

Codes are in [BinarySearch.java](./Data-Structure/Search/BinarySearch.java).

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


#### 367. Valid Perfect Square
https://leetcode.com/problems/valid-perfect-square/

```
class Solution {
    public boolean isPerfectSquare(int num) {
        int lo = 1, hi = num;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (mid < num / mid) lo = mid + 1;
            else if (mid > num / mid) hi = mid - 1;
            else return num % mid == 0;
        }
        
        return false;
    }
}
```

#### 33. Search in Rotated Sorted Array
https://leetcode.com/problems/search-in-rotated-sorted-array/

```
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (nums[mid] == target) return mid;
            
            // Be careful that mid could be equal to 0 (the lower boundary) when there are only two elements.
            if (nums[mid] >= nums[0]) {
                // means mid is in the left side of pivot
                if (nums[lo] <= target && target < nums[mid]) {
                    // means target is between lo and mid
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                // means mid is in the right side of pivot
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        
        return - 1;
    }
```

### 第二类题：没有明确Target的题型

#### 34. Find First and Last Position of Element in Sorted Array
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Template 2 is much easier than template one, as it's easier to process the boundary.

```
public int[] searchRange(int[] nums, int target) {
    int[] res = new int[] {-1, -1};
    if (nums == null || nums.length == 0) return res;
    if (nums.length == 1) {
        if (nums[0] == target) return new int[] {0, 0};
        return res;
    }

    // search the lower boundary
    int lo = 0, hi = nums.length - 1;
    while (lo + 1 < hi) {
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == target) hi = mid;
        else if (nums[mid] > target) hi = mid;
        else lo = mid;
    }
    if (nums[lo] == target) res[0] = lo;
    else if (nums[hi] == target) res[0] = hi;

    // search the higher boundary
    lo = 0;
    hi = nums.length - 1;
    while (lo + 1 < hi) {
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == target) lo = mid;
        else if (nums[mid] < target) lo = mid;
        else hi = mid;
    }
    if (nums[hi] == target) res[1] = hi;
    else if (nums[lo] == target) res[1] = lo;

    return res;
}
```

#### 35. Search Insert Position
https://leetcode.com/problems/search-insert-position/
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

public int searchInsert(int[] nums, int target) {
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

### 第三类题：没有明确Target的题型，可越界类型

这类题型，用“lo <= hi”的模板可能会越界。

#### 162. Find Peak Element
https://leetcode.com/problems/find-peak-element/

```
public int findPeakElement(int[] nums) {
    int lo = 0, hi = nums.length - 1;

    while (lo + 1 < hi) {
        int mid = lo + (hi - lo) / 2;

        if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
            return mid;
        } else if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
            lo = mid;
        } else {
            hi = mid;
        }
    }

    return nums[lo] > nums[hi] ? lo : hi;
}
```

#### 153. Find Minimum in Rotated Sorted Array
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
```
public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) return -1;
    if (nums.length == 1) return nums[0];

    int lo = 0, hi = nums.length - 1;
    while (lo + 1 < hi) {
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] > nums[hi]) {
            lo = mid;
        } else {
            hi = mid;
        }
    }

    return Math.min(nums[lo], nums[hi]);
}
```


### Reference
[[二分/排序/搜索] Binary Search的总结帖](https://www.1point3acres.com/bbs/thread-432793-1-1.html)  
[[二分/排序/搜索] Binary Search for Beginners，最不易出错的 Binary Search写法和总结](https://www.1point3acres.com/bbs/thread-747061-1-1.html)  
[LeetCode Binary Search Summary 二分搜索法小结](https://www.cnblogs.com/grandyang/p/6854825.html)  
[Binary Search 101](https://leetcode.com/problems/binary-search/discuss/423162/Binary-Search-101-The-Ultimate-Binary-Search-Handbook)  
