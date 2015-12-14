/*
LeetCode: https://leetcode.com/problems/gray-code/
LintCode: http://www.lintcode.com/problem/gray-code/
JiuZhang: http://www.jiuzhang.com/solutions/gray-code/
GeeksForGeeks: http://www.geeksforgeeks.org/given-a-number-n-generate-bit-patterns-from-0-to-2n-1-so-that-successive-patterns-differ-by-one-bit/

Analysis:
n-bit Gray Codes can be generated from list of (n-1)-bit Gray codes using following steps.
1) Let the list of (n-1)-bit Gray codes be L1. Create another list L2 which is reverse of L1.
2) Modify the list L1 by prefixing a ‘0’ in all codes of L1.
3) Modify the list L2 by prefixing a ‘1’ in all codes of L2.
4) Concatenate L1 and L2. The concatenated list is required list of n-bit Gray codes.

For example, following are steps for generating the 3-bit Gray code list from the list of 2-bit Gray code list.
L1 = {00, 01, 11, 10} (List of 2-bit Gray Codes)
L2 = {10, 11, 01, 00} (Reverse of L1)
Prefix all entries of L1 with ‘0’, L1 becomes {000, 001, 011, 010}
Prefix all entries of L2 with ‘1’, L2 becomes {110, 111, 101, 100}
Concatenate L1 and L2, we get {000, 001, 011, 010, 110, 111, 101, 100}

To generate n-bit Gray codes, we start from list of 1 bit Gray codes. The list of 1 bit Gray code is {0, 1}. We repeat above steps to generate 2 bit Gray codes from 1 bit Gray codes, then 3-bit Gray codes from 2-bit Gray codes till the number of bits becomes equal to n.

*/
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if(n <= 1) {
            for(int i = 0; i <= n; i++) result.add(i);
            return result;
        }
        
        result = grayCode(n - 1);
        
        List<Integer> reverse = reverse(result);
        
        int x = 1 << (n - 1);
        for(int i = 0; i < reverse.size(); i++){
            reverse.set(i, reverse.get(i) + x);     // here must be reverse.set(), not reverse.add()
        }
        result.addAll(reverse);
        
        return result;
    }
    
    private List<Integer> reverse(List<Integer> result){
        List<Integer> reverse = new ArrayList<Integer>();
        
        for(int i = result.size() - 1; i >= 0; i--){
            reverse.add(result.get(i));
        }
        
        return reverse;
    }
}