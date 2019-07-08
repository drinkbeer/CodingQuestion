/*
https://leetcode.com/problems/max-points-on-a-line/discuss/47113/A-java-solution-with-notes

        遍历每个点，看它和后面的每个点构成的直线上有多少个点
        对每个点建立map，斜率是key (或者说斜率的HashCode是Key)
        斜率要用分数的形式，不要用double的形式存
        计算分数时先求分子分母的最大公约数gcd，再都除以gcd
        重合的点特殊处理

Test Cases:

[[0,0]]                 -   1
[[0,0],[1,1],[1,-1]]    -   2
[[0,0],[1,1],[0,0]]     -   3

*/
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int overlap = 0, max = 0;
            
            for (int j = i + 1; j < n; j++) {
                int x = points[j][0] - points[i][0], y = points[j][1] - points[i][1];
                
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                
                int gcd = findGCD(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }
                
                String key = x + "@" + y;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            res = Math.max(res, max + overlap + 1);
        }
        
        return res;
    }
    
    // Calculate the greatest common divisor
    private int findGCD(int a, int b) {
        if (b == 0) return a;
        return findGCD(b, a % b);
    }
}
