

Usually Knacpack problem could be solved by:
1. DFS
2. DFS with Memorization Optimization
3. DP (2D Array)
4. DP (1D Array)
5. DP (convert to subset sum problem, and use 2D or 1D array)


# 1. Zero-One Knapsack Problem
https://www.acwing.com/problem/content/description/2/  
https://leetcode-cn.com/problems/coin-change/solution/bei-bao-wen-ti-zhi-01bei-bao-wen-ti-ke-pu-wen-ji-c/  
https://www.acwing.com/solution/content/1644/  

Transformation: 
```
dp[i][j] = max(dp[i - 1][j] , dp[i - 1][j - v] + w)
```

```Java
import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/coin-change/solution/bei-bao-wen-ti-zhi-01bei-bao-wen-ti-ke-pu-wen-ji-c/
 */
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  // N items
        int V = scanner.nextInt();  // Pack capacity
        int[] v = new int[N + 1];   // ith item capacity
        int[] w = new int[N + 1];   // ith item value
        
        for (int i = 1; i <= N; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        scanner.close();
        // System.out.println(zeroOnePackExecutor1st(N, V, v, w));
        System.out.println(zeroOnePackExecutor2nd(N, V, v, w));
    }
    
    /*
    定义一个二阶矩阵dp[N+1][V+1],
    这里之所以要N+1和V+1，是因为第0行表示只能选择第0个物品的时候，即没有物品的时候
    第0列表示背包的体积为0的时候，即不能装任何东西的时候

    dp[i][j]表示在 只能选择前i个物品，背包容量为j的情况下，背包中物品的最大价值
    对于dp[i][j]有两种情况：
    1. 不选择当前的第i件物品/第i件物品比背包容量要大，则dp[i][j] = dp[i-1][j]
    2. 选择当前的第i件物品（潜在要求第i件物品体积小于等于背包总容量），则能装入的物品最大价值为：
        当前物品的价值 加上 背包剩余容量在只能选前i-1件物品的情况下的最大价值
        dp[i][j] = dp[i-1][j-v[i]] + w[i]
    dp[i][j]在两种情况中选择比较大的情况作为当前的最优解；
    即：
    if(j >= v[i]):
        dp[i][j] = max(dp[i-1][j], dp[i-1][j-v[i]] + w[i])
    else:
        dp[i][j] = dp[i-1][j]
    */
    private static int zeroOnePackExecutor1st(int N, int V, int[] v, int[] w) {
        // state
        int[][] dp = new int[N + 1][V + 1];
        
        // init
        dp[0][0] = 0;
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i]);
                }
            }
        }
        
        return dp[N][V];
    }
    
    // 将dp优化为一维数组
    /*
    注意，这里第二层循环的时候，还是小到大循环的话，那么

    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-v[i]] + w[i])
    实际上变成了
    dp[i][j] = Math.max(dp[i][j], dp[i][j-v[i]] + w[i]);

    因为i-1的值已经在前面被更新过了，覆盖了
    为了避免这个问题，所以要逆序更新，即先更新第i个，然后更新第i-1个，从而保证第i-1个不被覆盖

    如果不逆序的话，输出结果为10，dp数组实际为：
    0 0 0 0 0 0 
    0 2 4 6 8 10
    0 2 4 6 8 10
    0 2 4 6 8 10
    0 2 4 6 8 10
    */
    private static int zeroOnePackExecutor2nd(int N, int V, int[] v, int[] w) {
        int[] dp = new int[V + 1];
        dp[0] = 0;
        
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        
        return dp[V];
    }
    
}
```

# 2. Complete Knapsack Problem
https://www.acwing.com/problem/content/3/  
https://www.acwing.com/solution/content/36299/  
https://www.acwing.com/solution/content/5345/  

Transformation:
```
dp[i][j] = max(dp[i - 1][j] ,   dp[i - 1][j - v] + w ,  dp[i - 1][j - 2 * v] + 2 * w , ..... ,  dp[i - 1][j - s * v] + s * w) //假设j - s * v > 0)
dp[i][j-v] = max(               dp[i - 1][j - v] ,      dp[i - 1][j - 2 * v] + w , ..... ,      dp[i - 1][j - s * v] + s * w) //假设j - s * v > 0)
dp[i][j-v] + w = max(           dp[i - 1][j - v] + w,   dp[i - 1][j - 2 * v] + 2 * w , ..... ,  dp[i - 1][j - s * v] + s * w) //假设j - s * v > 0)
```
So we got:
```
dp[i][j] = max(dp[i - 1][j] ,   dp[i][j-v] + w)
```

Optimize space (use 1-d array):
```
dp[j] = max(dp[j] , dp[j - v] + w , dp[j - 2 * v] + 2 * w , ..... , dp[j - s * v] + s * w) //假设j - s * v > 0)
dp[j-v] = max(      dp[j - v] ,     dp[j - 2 * v] + w , ..... ,     dp[j - s * v] + s * w) //假设j - s * v > 0)
dp[j-v]+ w = max(   dp[j - v] + w,  dp[j - 2 * v] + 2 * w , ..... , dp[j - s * v] + s * w) //假设j - s * v > 0)
```
So we got:
```
dp[j] = max(dp[j] , dp[j-v]+ w)
```

```Java
import java.util.Scanner;

class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  // N items
        int V = scanner.nextInt();  // Pack capacity
        int[] v = new int[N + 1];   // ith item capacity
        int[] w = new int[N + 1];   // ith item value
        
        for (int i = 1; i <= N; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        scanner.close();
        // System.out.println(completePackExecutor1(N, V, v, w));
        // System.out.println(completePackExecutor2(N, V, v, w));
        System.out.println(completePackExecutor3(N, V, v, w));
    }
    
    private static int completePackExecutor1(int N, int V, int[] v, int[] w) {
        // state
        int[][] dp = new int[N + 1][V + 1];
        
        // init
        dp[0][0] = 0;
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                for (int k = 0; k * v[i] <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * v[i]] + k * w[i]);
                }
            }
        }
        
        return dp[N][V];
    }
    
    // Optimize time
    private static int completePackExecutor2(int N, int V, int[] v, int[] w) {
        // state
        int[][] dp = new int[N + 1][V + 1];
        
        // init
        dp[0][0] = 0;
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= v[i]) dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - v[i]] + w[i]);
            }
        }
        
        return dp[N][V];
    }
    
    // Optimize time
    private static int completePackExecutor3(int N, int V, int[] v, int[] w) {
        // state
        int[] dp = new int[V + 1];
        
        // init
        dp[0] = 0;
        
        for (int i = 1; i <= N; i++) {
            for (int j = v[i]; j <= V; j++) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        
        return dp[V];
    }
}

```

# Multiple Pack
https://www.acwing.com/problem/content/4/  
https://www.acwing.com/solution/content/36327/  

```
import java.util.Scanner;

class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  // N items
        int V = scanner.nextInt();  // Pack capacity
        int[] v = new int[N + 1];
        int[] w = new int[N + 1];
        int[] s = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
            s[i] = scanner.nextInt();
        }
        scanner.close();
        
        // System.out.println(multiplePack1(N, V, v, w, s));
        System.out.println(multiplePack2(N, V, v, w, s));

    }
    
    private static int multiplePack1(int N, int V, int[] v, int[] w, int[] s) {
        // state
        int[][] dp = new int[N + 1][V + 1];
        
        // init
        dp[0][0] = 0;
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                for (int k = 0; k <= s[i] && k * v[i] <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * v[i]] + k * w[i]);
                }
            }
        }
        
        return dp[N][V];
    }
    
    // Optimize space
    private static int multiplePack2(int N, int V, int[] v, int[] w, int[] s) {
        // state
        int[] dp = new int[V + 1];
        
        // init
        dp[0] = 0;
        
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= 0; j--) {
                for (int k = 0; k <= s[i] && k * v[i] <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
                }
            }
        }
        
        return dp[V];
    }
    
}
```

# Problems

#### 494. Target Sum
https://leetcode.com/problems/target-sum/

```
/*
1.DFS

2.DP (Pull)

3.DP (Push)

4.DP (convert to subset problem & Pull)

5.DP (convert to subset problem & Push)

*/
class Solution {
    // 1.DFS
    /*
    Time O(2^N)
    */
//     public int findTargetSumWays(int[] nums, int S) {
//         if (nums == null || nums.length == 0) return 0;
//         int[] res = new int[1];
//         DFS(nums, 0, S, res);
//         return res[0];
//     }

//     private void DFS(int[] nums, int idx, int S, int[] res) {
//         if (idx == nums.length) {
//             if (S == 0) res[0]++;
//             return;
//         }
        
//         DFS(nums, idx + 1, S + nums[idx], res);
//         DFS(nums, idx + 1, S - nums[idx], res);
//     }
    
    // 2. DP (Knacpsack problem) (pull from previous level)
    /*
    this is a classic knapsack problem
    in knapsack, we decide whether we choose this element or not
    in this question, we decide whether we add this element or minus it

    Subproblem: 
    So start with a two dimensional array dp[i][j] which means the number of ways for first i-th element to reach a sum j

    Recurrence Relation:
    we can easily observe that dp[i][j] = dp[i-1][j+nums[i]] + dp[i-1][j-nums[i],

    Another part which is quite confusing is return value, here we return dp[sum+S], why is that?
    because dp's range starts from -sum --> 0 --> +sum
    so we need to add sum first, then the total starts from 0, then we add S

    Actually most of Sum problems can be treated as knapsack problem, hope it helps
    */
//     public int findTargetSumWays(int[] nums, int S) {
//         if (nums == null || nums.length == 0) return 0;
    
//         int n = nums.length;
//         int sum = 0;
//         for (int num : nums) sum += num;
        
//         if (S < -sum || S > sum) return 0;
        
//         /*
//         DP (pull)
        
//         sub problem:
//         int[][] state = new int[n + 1][2 * sum + 1];
//             -  state[i][j] means number of ways to sum to j using nums[0-i]
//         but the j could range from [-sum, sum], so total possible sum is 2*sum+1
        
//         sum value:      -sum    -  0    -  sum
//         index value:    0       -   sum -   2*sum
        
//         init:
//         state[0][sum] = 1;    // i==0 means it's empty set, so the sum value is 0, and we don't choose anything
        
//         output:
//         state[n][sum+S]
        
//         recurrence relation:
//         state[i][j] += state[i - 1][j + nums[i - 1]] if (j+nums[i - 1]) <= 2*sum
//         state[i][j] += state[i - 1][j - nums[i - 1]] if (j-nums[i - 1]) >= to 0
        
        
//         Time: O(N*sum) - N is number of elements, sum is the sum of elements
//         Space: O(N*sum)
        
//         */
//         int[][] state = new int[n + 1][2 * sum + 1];
        
//         // Init the state[0][sum] to be 1. sum means total value is 0, so if we select nothing, this is the only approach to get total value to be 1
//         state[0][sum] = 1;
        
//         for (int i = 1; i <= n; i++) {
//             for (int j = 0; j < 2 * sum + 1; j++) {
//                 if (j + nums[i - 1] <= 2 * sum) state[i][j] += state[i - 1][j + nums[i - 1]];
//                 if (j - nums[i - 1] >= 0) state[i][j] += state[i - 1][j - nums[i - 1]];
//             }
//         }
        
//         return state[n][sum + S];
//     }
    
    
    // DP (push to next level)
//     public int findTargetSumWays(int[] nums, int S) {
//         if (nums == null || nums.length == 0) return 0;
    
//         int n = nums.length;
//         int sum = 0;
//         for (int num : nums) sum += num;
        
//         if (S < -sum || S > sum) return 0;
        
//         /*
//         DP (pull)
        
//         sub problem:
//         state[i][j] means number of ways to sum to j using nums[0-i]
        
//         sum value:      -sum    -  0    -  sum
//         index value:    0       -   sum -   2*sum
        
//         init:
//         state[0][sum] = 1;
        
//         output:
//         state[n][sum+S]
        
//         recurrence relation:
//         state[i][j] += state[i + 1][j + nums[i]] if (j+nums[i - 1]) <= 2*sum
//         state[i][j] += state[i + 1][j - nums[i]] if (j-nums[i - 1]) >= to 0
        
        
//         Time: O(N*sum) - N is number of elements, sum is the sum of elements
//         Space: O(N*sum)
        
//         */
//         int[][] state = new int[n + 1][2 * sum + 1];
        
//         // Init the state[0][sum] to be 1. sum means total value is 0, so if we select nothing, this is the only approach to get total value to be 1
//         state[0][sum] = 1;
        
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < 2 * sum + 1; j++) {
//                 if (j + nums[i] <= 2 * sum) state[i + 1][j] += state[i][j + nums[i]];
//                 if (j - nums[i] >= 0) state[i + 1][j] += state[i][j - nums[i]];
//             }
//         }
        
//         return state[n][sum + S];
//     }
    
    // 3.Optimized DP for space. Using one dimention array
    /*
    
    Time O(N*sum)
    Space O(sum)
    */
//     public int findTargetSumWays(int[] nums, int S) {
//         if (nums == null || nums.length == 0) return 0;
    
//         int n = nums.length;
//         int sum = 0;
//         for (int num : nums) sum += num;
        
//         if (S < -sum || S > sum) return 0;
    
//         int[] dp = new int[2 * sum + 1];
//         dp[sum] = 1;
        
//         for (int i = 1; i <= n; i++) {
//             int[] tempDp = new int[2 * sum + 1];
//             for (int j = 0; j <= 2 * sum; j++) {
//                 if (j + nums[i - 1] <= 2 * sum) {
//                     tempDp[j] += dp[j + nums[i - 1]];
//                 }
//                 if (j - nums[i - 1] >= 0) {
//                     tempDp[j] += dp[j - nums[i - 1]];
//                 }
//             }
//             dp = tempDp;
//         }
        
//         return dp[sum + S];
//     }
    
    // 4. DP (subset & pull & 2D array)
    /*
    Split the array to be two parts, 
    Let P denotes a subset of nums have a + in front of it
    Let N denotes a subset of nums have a - in front of it
    
    P ∪ N = {a1, a2, ..., an}, P ∩ N = ∅
    
    sum(P) - sum(N) = target
    sum(P) - sum(N) + sum(P) + sum(N) = target + sum(P) + sum(N)
    2 * sum(p) = target + sum(P) + sum(N)    <-   Knapsack problem (find a subset has sum value equals to a special target)
    
    subproblem:
    dp[i][j]  -   the number of ways to nums[0 - i] elements or its subset to get sum to be j
    
    recurrence relation:
    dp[i][j] = dp[i-1][j] + dp[i-1][j - nums[i]] if j - nums[i] >= 0
    
    init:
    dp[0][sum] = 1
    
    ans:
    S = (S + sum) / 2       // update the new target
    dp[n][S]
    */
//     public int findTargetSumWays(int[] nums, int S) {
//         if (nums == null || nums.length == 0) return 0;
    
//         int n = nums.length;
//         int sum = 0;
//         for (int num : nums) sum += num;
        
//         if (S < -sum || S > sum) return 0;
//         if ((S + sum) % 2 != 0) return 0;           // means we cannot fnid a subset P, which has 2 * sum(P) = target + sum, here target + sum must be even
//         S = (S + sum) / 2;
        
//         int[][] dp = new int[n + 1][sum + 1];       // means using [0, i] elements or its subset to get a sum to be j
        
//         dp[0][0] = 1;
        
//         for (int i = 1; i <= n; i++) {
//             for (int j = 0; j <= sum; j++) {
//                 dp[i][j] = dp[i - 1][j];
//                 if (j - nums[i - 1] >= 0) {
//                     dp[i][j] += dp[i - 1][j - nums[i - 1]];
//                 }
//             }
            
//             // System.out.println(Arrays.deepToString(dp));
//         }
//         return dp[n][S];
//     }
    
    // DP: Subset & Optimized to use One-Dimension array & Pull  (One of the best solution)
//     public int findTargetSumWays(int[] nums, int S) {
//         if (nums == null || nums.length == 0) return 0;
    
//         int n = nums.length;
//         int sum = 0;
//         for (int num : nums) sum += num;
        
//         if (S < -sum || S > sum) return 0;
//         if ((S + sum) % 2 != 0) return 0;           // means we cannot fnid a subset P, which has 2 * sum(P) = target + sum, here target + sum must be even
//         S = (S + sum) / 2;
    
//         // subproblem: 
//         int[] dp = new int[sum + 1];
        
//         // init
//         dp[0] = 1;
        
//         // recurrence relation
//         for (int i = 1; i <= n; i++) {
//             for (int j = sum; j >= nums[i - 1]; j--) {
//                 if (j - nums[i - 1] >= 0) {
//                     dp[j] += dp[j - nums[i - 1]];
//                 }
//             }
//         }
        
//         // res
//         return dp[S];
//     }
    
    // DP (Pull && Subset problem && Optimized the Space)
     public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
    
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        
        if (S < -sum || S > sum) return 0;
        if ((S + sum) % 2 != 0) return 0;           // means we cannot fnid a subset P, which has 2 * sum(P) = target + sum, here target + sum must be even
        S = (S + sum) / 2;
    
        // subproblem: 
        int[] dp = new int[S + 1];      // Optimized here, only need S
        
        // init
        dp[0] = 1;
        
        // recurrence relation
        for (int i = 1; i <= n; i++) {
            for (int j = S; j >= nums[i - 1]; j--) {
                if (j - nums[i - 1] >= 0) {
                    dp[j] += dp[j - nums[i - 1]];
                }
            }
        }
        
        // res
        return dp[S];
    }
    
    // 5. DP (subset & push & 2D array)
    /*
    subproblem:
    dp[i][j]    -       the sum of nums [0, i] or its subset is equal to j
    
    recurrence relation:
    dp[i + 1][j] += dp[i][j]
    dp[i + 1][j + nums[i + 1]] += dp[i][j]        // didn't select nums[i]
    
    */
//     public int findTargetSumWays(int[] nums, int S) {
//         if (nums == null || nums.length == 0) return 0;
    
//         int n = nums.length;
//         int sum = 0;
//         for (int num : nums) sum += num;
        
//         if (S < -sum || S > sum) return 0;
//         if ((S + sum) % 2 != 0) return 0;
        
//         S = (S + sum) / 2;  // update new specific target
    
//         // subproblem: the sum of nums [0, i] or its subset is equal to j
//         int[][] dp = new int[n + 1][sum + 1];
        
//         // init
//         dp[0][0] = 1;
        
//         // recurrence relation
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j <= sum; j++) {
//                 dp[i + 1][j] += dp[i][j];
//                 if (j + nums[i] <= sum) {
//                     dp[i + 1][j + nums[i]] += dp[i][j];
//                 }
//             }
//         }
        
//         // ans
//         return dp[n][S];
//     }
}
```

#### 282. Expression Add Operators
https://leetcode.com/problems/expression-add-operators/

```

```

#### 1049. Last Stone Weight II
https://leetcode.com/problems/last-stone-weight-ii/

```

```

#### 416. Partition Equal Subset Sum
https://leetcode.com/problems/partition-equal-subset-sum/

```
    // 1. Recursive DFS without Memorization Optimization (TLE)
    /*
    https://leetcode.com/problems/partition-equal-subset-sum/discuss/90588/Concise-C%2B%2B-Solution-summary-with-DFS-DP-BIT
    
    DFS could be optimized by using memorized solution, and pass the OJ. See the above link.
    */
//     public boolean canPartition(int[] nums) {
//         int[] res = new int[2];
//         return recursive(nums, 0, res);
//     }
    
//     private boolean recursive(int[] nums, int i, int[] res) {
//         if (i == nums.length - 1) {
//             if (res[0] + nums[i] == res[1] || res[0] == res[1] + nums[i]) {
//                 return true;
//             } else {
//                 return false;
//             }
//         }
        
//         if (recursive(nums, i + 1, new int[] {res[0] + nums[i], res[1]}) || recursive(nums, i + 1, new int[] {res[0], res[1] + nums[i]})) {
//             return true;
//         }
//         return false;
//     }
    
    // 2. DP (Pull)
    /*
    Knacpack problem. We convert this problem to either add "+" or "-" in each element, and make the final sum to be 0.
    
    subproblem:
    dp[i][j]  - whether we could using the elements in [0, i] to get the sum j
    
    recurrence relation:
    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j + nums[i]]
    
    init:
    dp[0][sum] = true   // empty set, the sum value is 0, it's true
    sum:    -sum    0       sum
    idx:    0       sum     2*sum
    
    ans:
    return dp[n][sum]
    */
//     public boolean canPartition(int[] nums) {
//         int n = nums.length;
//         int sum = 0;
//         for (int num : nums) sum += num;
        
//         // subproblem
//         boolean[][] dp = new boolean[n + 1][2*sum + 1];
        
//         // init
//         dp[0][sum] = true;
//         // dp[0][sum + nums[0]] = true;
        
//         // recurrence relation
//         for (int i = 1; i <= n; i++) {
//             for (int j = 0; j <= 2 * sum; j++) {
//                 if (j - nums[i - 1] >= 0) {
//                     dp[i][j] |= dp[i - 1][j - nums[i - 1]];
//                 }
//                 if (j + nums[i - 1] <= 2 * sum) {
//                     dp[i][j] |= dp[i - 1][j + nums[i - 1]];
//                 }
//             }
//         }
        
//         return dp[n][sum];
//     }
    
    // 2. DP (Push)
    /*
    Knacpack problem. We convert this problem to either add "+" or "-" in each element, and make the final sum to be 0.
    
    subproblem:
    dp[i][j]  - whether we could using the elements in [0, i] to get the sum j
    
    recurrence relation:
    dp[i][j] = dp[i][j - nums[i]] || dp[i][j + nums[i]]
    
    init:
    dp[0][sum] = true
    sum:    -sum    0       sum
    idx:    0       sum     2*sum
    
    ans:
    return dp[n][sum]
    */
//     public boolean canPartition(int[] nums) {
//         int n = nums.length;
//         int sum = 0;
//         for (int num : nums) sum += num;
        
//         // subproblem
//         boolean[][] dp = new boolean[n + 1][2*sum + 1];
        
//         // init
//         dp[0][sum] = true;
//         // dp[0][sum + nums[0]] = true;
        
//         // recurrence relation
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j <= 2 * sum; j++) {
//                 if (dp[i][j]) {
//                     if (j - nums[i] >= 0) {
//                         dp[i + 1][j - nums[i]] = true;
//                     }
//                     if (j + nums[i] <= 2 * sum) {
//                         dp[i + 1][j + nums[i]] = true;
//                     }
//                 }
                
//             }
//         }
        
//         return dp[n][sum];
//     }
    
    // 3. DP (Pull && 1D array)
//     public boolean canPartition(int[] nums) {
//         int n = nums.length;
        
//         int sum = 0;
//         for (int num : nums) sum += num;
        
//         boolean[] dp = new boolean[2 * sum + 1];
        
//         // init
//         dp[sum] = true;
        
//         // recurrence relation
//         for (int i = 1; i <= n; i++) {
//             boolean[] tempDP = new boolean[2 * sum + 1];
//             for (int j = 0; j <= 2 * sum; j++) {
//                 if (j - nums[i - 1] >= 0) {
//                     tempDP[j] |= dp[j - nums[i - 1]];
//                 }
//                 if (j + nums[i - 1] <= 2 * sum) {
//                     tempDP[j] |= dp[j + nums[i - 1]];
//                 }
//             }
//             dp = tempDP;
//         }
        
//         return dp[sum];
//     }
    
    // 4. DP (Subset & Pull & 2D Array)
    /*
    Split the array to two parts:
    Let P denotes a subset of nums have a + in front of it
    Let N denotes a subset of nums have a - in front of it
    
    P ∪ N = {a1, a2, ..., an}, P ∩ N = ∅
    
    sum(P) + sum(N) = sum
    sum(P) - sum(N) = 0
    
    sum(P) = sum / 2;
    
    so the problem becomes find a subset with sum to be sum / 2;
    
    subproblem:
    dp[j]   -   if it's possible to get sum j using the elements before ith
    */
//     public boolean canPartition(int[] nums) {
//         int n = nums.length;
        
//         int sum = 0;
//         for (int num : nums) sum += num;
//         if (sum % 2 != 0) return false;
//         sum = sum / 2;
        
//         boolean[] dp = new boolean[sum + 1];
        
//         // init
//         dp[0] = true;   // in empty set, the sum to be 0 is true
        
//         for (int i = 1; i <= n; i++) {
//             boolean[] tempDP = new boolean[sum + 1];
            
//             for (int j = 0; j <= sum; j++) {
//                 tempDP[j] |= dp[j]; // not plus nums[i - 1]
//                 if (j - nums[i - 1] >= 0) {
//                     // plus nums[i - 1]
//                     tempDP[j] |= dp[j - nums[i - 1]];
//                 }
//             }
//             dp = tempDP;
//         }
        
//         return dp[sum];
//     }
    
    // DP (Subset & Pull & 2D Array) - further optimized by not using a copy array
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        
        boolean[] dp = new boolean[sum + 1];
        
        // init
        dp[0] = true;   // in empty set, the sum to be 0 is true
        
        for (int i = 1; i <= n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i - 1] >= 0) {
                    // plus nums[i - 1] from the previous j - nums[i - 1]
                    dp[j] |= dp[j - nums[i - 1]];
                }
            }
        }
        
        return dp[sum];
    }
```
