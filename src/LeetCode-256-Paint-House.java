/*


*/
public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        
        int[][] state = new int[costs.length][3];
        // init state
        state[0][0] = costs[0][0];
        state[0][1] = costs[0][1];
        state[0][2] = costs[0][2];
        
        for(int i = 1; i < costs.length; i++){
            state[i][0] = Math.min(state[i - 1][1], state[i - 1][2]) + costs[i][0];
            state[i][1] = Math.min(state[i - 1][0], state[i - 1][2]) + costs[i][1];
            state[i][2] = Math.min(state[i - 1][0], state[i - 1][1]) + costs[i][2];
        }
        
        int result = Math.min(state[costs.length - 1][0], state[costs.length - 1][1]);
        return Math.min(result, state[costs.length - 1][2]);
    }
    
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        
        int n = costs.length;
        int[][] state = new int[n][3];
        for (int i = 0; i < 3; i++) state[0][i] = costs[0][i];
        
        for (int i = 1; i < n; i++) {
            state[i][0] = Math.min(state[i - 1][1], state[i - 1][2]) + costs[i][0];
            state[i][1] = Math.min(state[i - 1][0], state[i - 1][2]) + costs[i][1];
            state[i][2] = Math.min(state[i - 1][0], state[i - 1][1]) + costs[i][2];
        }
        System.out.println(Arrays.deepToString(state));
        
        return Math.min(state[n - 1][0], Math.min(state[n - 1][1], state[n - 1][2]));
    }
}
