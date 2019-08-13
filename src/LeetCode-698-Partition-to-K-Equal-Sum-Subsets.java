class Solution {
    // My own solution (Wrong Answer)
//     public boolean canPartitionKSubsets(int[] nums, int k) {
//         int sum = 0;
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for (int num : nums) {
//             sum += num;
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }
//         if (sum % k != 0) return false;
//         int sub = sum / k;
        
//         for (int num : nums) {
//             if (num == sub || num == 0) {
//                 continue;
//             }
            
//             if (!map.containsKey(sub - num)) return false;
            
//             map.put(sub - num, map.get(sub - num) - 1);
//             if (map.get(sub - num) == 0) {
//                 map.remove(sub - num);
//             }
            
//         }
//         return true;
//     }
    
    // 1. DFS (using a visited boolean array to record the nums we visited)
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        int targetSum = sum / k;
        
        boolean[] visited = new boolean[nums.length];
        return recursive(nums, k, visited, targetSum, targetSum, 0);
    }
    
    private boolean recursive(int[] nums, int k, boolean[] visited, int currSum, int targetSum, int currIdx) {
        if (k == 1) return true;    // we already partitioned numbers into all subsets, k == 1 means the value left have sum == targetSum
        if (currSum == 0) {
            return recursive(nums, k - 1, visited, targetSum, targetSum, 0);
        }
        // if (currSum < 0) return false;
        
        for (int i = currIdx; i < nums.length; i++) {
            if (visited[i]) continue;
            if (currSum - nums[i] < 0) continue;
            visited[i] = true;
            if (recursive(nums, k, visited, currSum - nums[i], targetSum, currIdx + 1)) return true;
            visited[i] = false;
        }
        return false;
    }
    
    
    
        /*
      Partition to K Equal Sum Subsets - LeetCode: https://leetcode.com/problems/partition-to-k-equal-sum-subsets

      An adaption of the answer from user "climberig" on Leetcode.
      Link: https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/108730/JavaC%2B%2BStraightforward-dfs-solution

      Revision by Benyam Ephrem (Jan. 9th 2019)

      This code passes all Leetcode test cases as of Jan. 9th 2019
      Runtime: 10 ms, faster than 92.57% of Java online submissions for Partition to K Equal Sum Subsets.

      The video to explain this code is here: https://www.youtube.com/watch?v=qpgqhp_9d1s
    */

//      public boolean canPartitionKSubsets(int[] arr, int k) {

//       /*
//         Get the sum of all items in the array. We will use this to
//         divide by k to get the sum that each bucket needs to hit
//       */
//       int sumOfAllArrayItems = 0;
//       for (int num : arr) {
//           sumOfAllArrayItems += num;
//       }

//       /*
//         1.) k can not be negative or 0 because we can not fill 0
//         or negative buckets

//         2.) k can not be greater than the length of the array,
//         we can't partition more buckets than there are elements
//         in the array

//         3.) sumOfAllArrayItems % k must be 0. If it is not then
//         we would have to have to fill buckets to a floating point
//         sum which would be impossible with only integers
//       */
//       if (k <= 0 || k > arr.length || sumOfAllArrayItems % k != 0) {
//         return false;
//       }

//       return canPartition(0, arr, new boolean[arr.length], k, 0, sumOfAllArrayItems / k);
//     }

//     boolean canPartition(int iterationStart, int[] arr, boolean[] used, int k,
//                           int inProgressBucketSum, int targetBucketSum) {

//       /*
//         If we have filled all k - 1 buckets up to this point and we are now on
//         our last bucket, we can stop and be finished.

//         Example:

//         arr = [4, 3, 2, 3, 5, 2, 1]
//         k = 4

//         targetBucketSum = 5

//         If we get to the point in our recursion that k = 1 that means we have filled
//         k - 1 buckets (4 - 1 = 3). 3 buckets have been filled, each a value of 5 meaning
//         we have "eaten" 15 "points" of value from an array that sums to 20.

//         This means we have 5 "points" to extract from the array and that for sure will fill
//         the last bucket. So at the point there is 1 bucket left, we know we can complete the
//         partitioning (we don't have to though, we just want to know whether we can or not).
//       */
//       if (k == 1) {
//         return true;
//       }

//       /*
//         Bucket full. continue the recursion with k - 1 as the new k value, BUT the
//         targetBucketSum stays the same. We just have 1 less bucket to fill.
//       */
//       if (inProgressBucketSum == targetBucketSum) {
//         return canPartition(0, arr, used, k - 1, 0, targetBucketSum);
//       }

//       /*
//         Try all values from 'iterationStart' to the end of the array ONLY if:

//         1.) They have not been used up to this point in the recursion's path
//         2.) They do not overflow the current bucket we are filling
//       */
//       for (int i = iterationStart; i < arr.length; i++) {
//         if (!used[i] && inProgressBucketSum + arr[i] <= targetBucketSum) {
//           used[i] = true;
//           /*
//             See if we can partition from this point with the item added
//             to the current bucket progress
//           */
//           if (canPartition(i + 1, arr, used, k, inProgressBucketSum + arr[i], targetBucketSum)) {
//             return true;
//           }
//           used[i] = false;
//         }
//       }

//       /*
//         Partitioning from this point is impossible. Whether we are at the
//         top level of the recursion or deeper into it.
//       */
//       return false;
//     }
}
