/*
LeetCode: https://leetcode.com/problems/merge-sorted-array/
LintCode: http://www.lintcode.com/problem/merge-sorted-array/
JiuZhang: http://www.jiuzhang.com/solutions/merge-sorted-array/
ProgramCreek: http://www.programcreek.com/2012/12/leetcode-merge-sorted-array-java/

Analysis: 

*/
public class Solution {
    // 1.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int curr = m + n - 1;
        
        --m;
        --n;
        while(m >= 0 && n >= 0){
            if(nums1[m] > nums2[n]){
                nums1[curr--] = nums1[m--];
            }else{
                nums1[curr--] = nums2[n--];
            }
        }
        
        if(m < 0 && n >= 0){
            while(n >= 0){
                nums1[curr--] = nums2[n--];
            }
        }
        
        if(m >= 0 && n < 0){
            while(m >= 0){
                nums1[curr--] = nums1[m--];
            }
        }
    }
    
    // 2.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, len = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0) nums1[len--] = nums2[j--];
            else if (j < 0) nums1[len--] = nums1[i--];
            else {
                if (nums1[i] < nums2[j]) {
                    nums1[len--] = nums2[j--];
                } else {
                    nums1[len--] = nums1[i--];
                }
            }
        }
    }
}
