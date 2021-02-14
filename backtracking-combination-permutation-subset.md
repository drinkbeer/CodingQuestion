
https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)

# Combination

Some key points of Combination problem:
1. Is there any duplicates in the array? (1) No, then don't need sort and dedup; (2) Yes, then need sort and dedup.
2. Is the array sorted? No
3. Are there negative elements? If yes, in each backtracking, the target could be negative. The problem become more complicate. It can be a follow-up question.
4. Can we reuse the same number? Yes. Combination can re-use the same number, so in each backtrack, the start number is `i`.

The answer to the above questions determines how we (1) dedup; (2) do we need sort the array first.

Combination Sum : https://leetcode.com/problems/combination-sum/

```
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (candidates == null || candidates.length == 0) return res;

    backtrack(candidates, target, 0, res, new ArrayList<>());
    return res;
}

private void backtrack(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> list) {
    if (target < 0) return;
    if (target == 0) {
        res.add(new ArrayList<>(list));
        return;
    }

    for (int i = start; i < candidates.length; i++) {
        list.add(candidates[i]);
        backtrack(candidates, target - candidates[i], i, res, list);  // not i + 1 because we can reuse same elements
        list.remove(list.size() - 1);
    }
}
```

Combination Sum II (can't reuse same element) : https://leetcode.com/problems/combination-sum-ii/

```
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (candidates == null || candidates.length == 0) return result;

    Arrays.sort(candidates);
    backtrack(candidates, target, 0, result, new ArrayList<>());
    return result;
}

public void backtrack(int[] nums, int target, int start, List<List<Integer>> result, List<Integer> list) {
    if (target < 0) return;
    if (target == 0) {
        result.add(new ArrayList<>(list));
        return;
    }

    for (int i = start; i < nums.length; i++) {
        if (nums[i] > target) return;
        if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicate

        list.add(nums[i]);
        backtrack(nums, target - nums[i], i + 1, result, list);
        list.remove(list.size() - 1);
    }
}
```

# Permutation

Some key questions to ask?
1. Is there any duplicates in the array? (1) No. Then no need sort, and dedup; (2) Yes. Then need sort, and dedup.
2. Is the array sorted? No.
3. Can we reuse the same number? Not Applicable, you cannot reuse the same number in a Permutation.
4. Is there negative element? Positive or negative element will not affect the result.

Permutations : https://leetcode.com/problems/permutations/
```
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if(nums == null || nums.length == 0) return res;
    backtrack(nums, res, new ArrayList<>());
    return res;
}

private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list) {
    if (list.size() == nums.length) {
        res.add(new ArrayList<>(list));
        return;
    }

    for (int i = 0; i < nums.length; i++) {
        if (list.contains(nums[i])) continue;
        list.add(nums[i]);
        backtrack(nums, res, list);
        list.remove(list.size() - 1);
    }
}
```

```
public List<List<Integer>> permute(int[] nums) {
    if(nums == null || nums.length == 0) return null;

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    result.add(new ArrayList<Integer>());

    // Gradually insert the numbers to the result row by row
    for (int i = 0; i < nums.length; i++) {
        // start insertion of the first row
        List<List<Integer>> tempResult = new ArrayList<List<Integer>>();

        for (int insertPos = 0; insertPos <= i; insertPos++) {
            // the insertPos could be at the beginning of the existing list, it could also be the end of the existing list,
            // so the insertPos could be "i"

            for (List<Integer> sub : result) {
                List<Integer> row = new ArrayList<>(sub);
                row.add(insertPos, nums[i]);
                tempResult.add(row);
            }

        }

        result = tempResult;
    }

    return result;
}
```

Permutations II (contains duplicates) : https://leetcode.com/problems/permutations-ii/
```
/*
if(!result.contains(list)){
we could use contains to check duplicate, but it's too slow.
*/
public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(nums == null) return result;

    List<Integer> list = new ArrayList<Integer>();
    boolean[] visited = new boolean[nums.length];
    java.util.Arrays.sort(nums);

    DFS(nums, visited, result, list);
    return result;
}

private void DFS(int[] nums, boolean[] visited, List<List<Integer>> result, List<Integer> list){
    // end condition
    if(list.size() == nums.length){
        result.add(new ArrayList<Integer>(list));
        return;
    }

    for(int i = 0; i < nums.length; i++){
        // [1,1,2], when we visit the second 1, we have to ensure the first 1 has already been visited. which means in the final result, the add order is: first 1, second 1
        if(visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) continue;    // skip duplicate
        list.add(nums[i]);
        visited[i] = true;
        DFS(nums, visited, result, list);
        list.remove(list.size() - 1);
        visited[i] = false;
    }
}
```

```
public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (nums == null || nums.length == 0) return result;

    result.add(new ArrayList<>());

    // Start inserting the numbers in nums row by row
    for (int i = 0; i < nums.length; i++) {
        List<List<Integer>> tempResult = new ArrayList<List<Integer>>();

        for (int insertPos = 0; insertPos <= i; insertPos++) {

            for (List<Integer> sub : result) {
                List<Integer> row = new ArrayList<>(sub);
                row.add(insertPos, nums[i]);
                if (tempResult.contains(row)) continue; // skip duplicate
                tempResult.add(row);
            }

        }

        result = tempResult;
    }

    return result;
}
```

# Subset

1. Is there any duplicates in the array? (1) No, then don't need sort and dedup; (2) Yes, then need sort and dedup.
2. Is the array sorted? No
3. Are there negative elements? Not applicable. Negative or positive will not affect the result.
4. Can we reuse the same number? No. Subset cannot re-use the same number, so in each backtrack, the start number is `i+1`.


Subsets : https://leetcode.com/problems/subsets/
```
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length == 0) return result;

    recursive(nums, 0, result, new ArrayList<>());
    return result;
}

private void recursive(int[] nums, int start, List<List<Integer>> result, List<Integer> list) {
    result.add(new ArrayList<>(list));

    for (int i = start; i < nums.length; i++) {
        list.add(nums[i]);
        recursive(nums, i + 1, result, list);
        list.remove(list.size() - 1);
    }
}
```

```
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (nums == null || nums.length == 0) return result;

    result.add(new ArrayList<>());

    for (int i : nums) {
        List<List<Integer>> temp = new ArrayList<List<Integer>>();
        for (List<Integer> sub : result) {
            List<Integer> list = new ArrayList<>(sub);  // have to create a copy of the sub list, otherwise the next line will pollute the existing result.
            list.add(i);
            temp.add(list);
        }
        result.addAll(temp);  // we have to add the temp after we finished the above for-loop, as it's loop the result.
    }
    return result;
}
```

Subsets II (contains duplicates) : https://leetcode.com/problems/subsets-ii/
```
public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (nums == null) return result;

    Arrays.sort(nums);
    subsetsWithDup(nums, 0, result, new ArrayList<>());
    return result;
}

private void subsetsWithDup(int[] nums, int start, List<List<Integer>> result, List<Integer> list) {
    result.add(new ArrayList<>(list));

    for (int i = start; i < nums.length; i++) {
        if (i > start && nums[i - 1] == nums[i]) continue;      // skip duplicate
        list.add(nums[i]);
        subsetsWithDup(nums, i + 1, result, list);
        list.remove(list.size() - 1);
    }
}
```

```
// Iterative
public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (nums == null || nums.length == 0) return result;

    Arrays.sort(nums);  // have to sort here is we want to skip duplicates
    result.add(new ArrayList<>());

    for (int i : nums) {
        List<List<Integer>> temp = new ArrayList<List<Integer>>();

        for (List<Integer> sub : result) {
            List<Integer> list = new ArrayList<>(sub);  // have to create a new list to avoid polluating the existing results
            list.add(i);
            if (result.contains(list)) continue;  // have to skip the duplicates
            temp.add(list);
        }

        result.addAll(temp);
    }

    return result;
}
```

# Palindrome

Palindrome Partitioning : https://leetcode.com/problems/palindrome-partitioning/
```
    // 1.Pure DFS
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        
        if(s == null || s.length() == 0) return result;
        
        DFS(s, 0, result, list);
        return result;
    }
    
    private void DFS(String s, int start, List<List<String>> result, List<String> list){
        // stop condition
        if(start == s.length()){
            result.add(new ArrayList<String>(list));
            return;
        }
        
        for(int end = start; end < s.length(); end++){
            if(isPalindrome(s, start, end)){
                list.add(s.substring(start, end + 1));
                DFS(s, end + 1, result, list);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) return false;
            lo++;
            hi--;
        }
        return true;
    }
```

```
    // 2. DFS + DP (Memorized DFS)
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        if(s == null || s.length() == 0) return result;
        
        helper(s, 0, dp, result, list);
        return result;
    }
    
    private void helper(String s, int start, boolean[][] dp, List<List<String>> result, List<String> list) {
        if (start == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        for (int end = start; end < s.length(); end++) {
            // "abca", start = 0, end = 3, so "a"=="a" -> ok
            if (s.charAt(start) != s.charAt(end)) continue;
            // "abca", start + 1 = 1, end - 1= 2, so "b"!="c" -> continue
            if (start + 1 < end - 1 && !dp[start + 1][end - 1]) continue;
            
            dp[start][end] = true;
            list.add(s.substring(start, end + 1));
            helper(s, end + 1, dp, result, list);
            list.remove(list.size() - 1);
        }
    }
```

```
    // 3. Pure DP
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        
        int len = s.length();
        List<List<String>>[] result = new List[len + 1];    // dp results from 0 length to actual length
        result[0] = new ArrayList<>();
        result[0].add(new ArrayList<>());
        
        boolean[][] dp = new boolean[len][len];
        
        for (int r = 0; r < len; r++) {
            result[r + 1] = new ArrayList<>();
            
            for (int l = 0; l <= r; l++) {
                // First approach
//                 if (s.charAt(l) != s.charAt(r)) continue;
//                 if(l + 1 < r - 1 && !dp[l + 1][r - 1]) continue;
                
//                 dp[l][r] = true;
//                 String sSub = s.substring(l, r + 1);
//                 for(List<String> sub : result[l]) {
//                     List<String> temp = new ArrayList<>(sub);
//                     temp.add(sSub);
//                     result[r + 1].add(temp);
//                 }
                
                // Second approach
                if (s.charAt(l) != s.charAt(r)) continue;
                if(l + 1 < r - 1 && !dp[l + 1][r - 1]) continue;
                
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    String sSub = s.substring(l, r + 1);
                    for(List<String> sub : result[l]) {
                        List<String> temp = new ArrayList<>(sub);
                        temp.add(sSub);
                        result[r + 1].add(temp);
                    }
                }
            }
        }
        
        return result[len];
    }
```



BFS：
1.用来判断可行解的存在性问题(存在一个解，任务完成)
2.可行解的解空间的最小性问题(我们会像Binary Tree 的BFS的过程，也是得到了一个path，BFS可以用来处理path的最小长度，Leetcode - 127 Word Ladder就是一个很好的例子)

DFS：
用来在全部的解空间中寻找所有的可行解(或许需要满足一定性质的可行解)

即DFS侧重于解的完备性，BFS侧重解的存在性与长度最短(当然对于遍历数据结构这样不求解的过程其实没什么差异)
