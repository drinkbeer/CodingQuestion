
https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)

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
        if(visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) continue;
        list.add(nums[i]);
        visited[i] = true;
        DFS(nums, visited, result, list);
        list.remove(list.size() - 1);
        visited[i] = false;
    }
}
```

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

Subsets II (contains duplicates) : https://leetcode.com/problems/subsets-ii/
```
public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
} 
```

Palindrome Partitioning : https://leetcode.com/problems/palindrome-partitioning/
```
public List<List<String>> partition(String s) {
   List<List<String>> list = new ArrayList<>();
   backtrack(list, new ArrayList<>(), s, 0);
   return list;
}

public void backtrack(List<List<String>> list, List<String> tempList, String s, int start){
   if(start == s.length())
      list.add(new ArrayList<>(tempList));
   else{
      for(int i = start; i < s.length(); i++){
         if(isPalindrome(s, start, i)){
            tempList.add(s.substring(start, i + 1));
            backtrack(list, tempList, s, i + 1);
            tempList.remove(tempList.size() - 1);
         }
      }
   }
}

public boolean isPalindrome(String s, int low, int high){
   while(low < high)
      if(s.charAt(low++) != s.charAt(high--)) return false;
   return true;
} 
```



BFS：
1.用来判断可行解的存在性问题(存在一个解，任务完成)
2.可行解的解空间的最小性问题(我们会像Binary Tree 的BFS的过程，也是得到了一个path，BFS可以用来处理path的最小长度，Leetcode - 127 Word Ladder就是一个很好的例子)

DFS：
用来在全部的解空间中寻找所有的可行解(或许需要满足一定性质的可行解)

即DFS侧重于解的完备性，BFS侧重解的存在性与长度最短(当然对于遍历数据结构这样不求解的过程其实没什么差异)
