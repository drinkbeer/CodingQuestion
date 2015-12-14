/*
LeetCode: https://leetcode.com/problems/4sum/
LintCode: http://www.lintcode.com/problem/4sum/
JiuZhang: http://www.jiuzhang.com/solutions/4sum/
ProgramCreek: http://www.programcreek.com/2013/02/leetcode-4sum-java/

Analysis: (Two Pointer solution. The same solution with 3Sum)
1.Sort array
2.P1 scan from 0 to Len-3
2.P2 scan from p1+1 to Len-2
3.P3, P4 scan from P2+1, Len-1, respectively.

方法二：
这道题还有另一个方法，就是先可以用一个hash表记录数组当中任意两个数的和sum = a[x]+a[y]，并且记录是哪两个数的和, 这样用o(n^2)的时间复杂度就可以记录任意两个数的和，然后在用两个指针i,j(i<j)遍历数组, 然后在hash表中寻找v-a[i]-a[j]是否存在，并且保证a[i],a[j],a[x],a[y] 不能取相同的数，然后通过i,j两层for循环就可以找到4sum
*/
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null && nums.length < 4) return result;
        
        java.util.Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 3; i++){
            if(i != 0 && nums[i - 1] == nums[i]) continue;       //skip the duplicates
            
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j != i + 1 && nums[j - 1] == nums[j]) continue;       //skip the duplicates
                
                int lo = j + 1;
                int hi = nums.length - 1;
                
                while(lo < hi){
                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    if(sum < target){
                        lo++;
                    }else if(sum > target){
                        hi--;
                    }else{
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[lo]);
                        temp.add(nums[hi]);
                        result.add(temp);
                        
                        lo++;
                        hi--;
                        
                        //skip duplicates
                        while(lo < hi && nums[lo - 1] == nums[lo]){
                            lo++;
                        }
                        
                        while(lo < hi && nums[hi] == nums[hi + 1]){
                            hi--;
                        }
                        
                    }
                    
                }
                
            }
        }
        
        return result;
    }
}