/*
Let's think about simple cases in one dimension first:

house location: [1,6] -> best point can be anywhere between 1~6
house location: [1,2,6] -> best point is 2, because 1 and 6 don't care where it is as long as the point is between them
house location: [1,2,3,6] -> best point is 2.5(actually 2 or 3)
For a sequence [a1, a2 ... an], dist(a1,bestPoint)+dist(an,bestPoint) is constant and equal to dist(a1,an)

*/
class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<Integer> I = new ArrayList<>();
        List<Integer> J = new ArrayList<>();
        
        // add value to I and J and ensure the order is ascending
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) I.add(i);
            }
        }
        
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) J.add(j);
            }
        }
        
        int res = 0;
        int lo = 0, hi = I.size() - 1;
        while (lo < hi) {
            res += I.get(hi) - I.get(lo);
            hi--;
            lo++;
        }
        
        lo = 0;
        hi = J.size() - 1;
        while(lo < hi) {
            res += J.get(hi) - J.get(lo);
            hi--;
            lo++;
        }
        return res;
    }
}
