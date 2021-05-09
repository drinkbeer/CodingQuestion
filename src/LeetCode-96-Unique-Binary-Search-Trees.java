/*
LeetCode: https://leetcode.com/problems/unique-binary-search-trees/
LintCode: http://www.jiuzhang.com/solutions/unique-binary-search-trees/
JiuZhang: http://www.lintcode.com/problem/unique-binary-search-trees/
ProgramCreek: http://www.programcreek.com/2014/05/leetcode-unique-binary-search-trees-java/

Analysis:
First note that dp[k] represents the number of BST trees built from 1....k;

Then assume we have the number of the first 4 trees: dp[1] = 1 ,dp[2] =2 ,dp[3] = 5, dp[4] =14 , how do we get dp[5] based on these four numbers is the core problem here.

The essential process is: to build a tree, we need to pick a root node, then we need to know how many possible left sub trees and right sub trees can be held under that node, finally multiply them.

To build a tree contains {1,2,3,4,5}. First we pick 1 as root, for the left sub tree, there are none; for the right sub tree, we need count how many possible trees are there constructed from {2,3,4,5}, apparently it's the same number as {1,2,3,4}. So the total number of trees under "1" picked as root is dp[0] * dp[4] = 14. (assume dp[0] =1). Similarly, root 2 has dp[1]*dp[3] = 5 trees. root 3 has dp[2]*dp[2] = 4, root 4 has dp[3]*dp[1]= 5 and root 5 has dp[0]*dp[4] = 14. Finally sum the up and it's done.

count[i] be the # of unique binary tree nodes when index == i

count[0]=1  enpty tree

count[1]=1  one tree

count[2]=count[0]*count[1]  1 is root
        +count[1]*count[0]  2 is root
        
count[3]=count[0]*count[2]  1 is root
        +count[1]*count[1]  2 is root
        +count[2]*count[0]  3 is root
        
count[4]=count[0]*count[3]  1 is root
        +count[1]*count[2]  2 is root
        +count[2]*count[1]  3 is root
        +count[3]*count[0]  4 is root

So, DP state function, count[n] = SUM(count[0...k]*count[k+1...n-1]), 0 <= k < n-1
*/

public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i] = dp[i] + dp[j] * dp[i - 1 - j];
            }
        }

        return dp[n];
    }
}