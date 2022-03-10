class Solution {
    // Descending Monotonic Stack
    /*
    Runtime: 146 ms, faster than 10.56% of Java online submissions for Buildings With an Ocean View.
    Memory Usage: 84.8 MB, less than 59.12% of Java online submissions for Buildings With an Ocean View.
    */
//     public int[] findBuildings(int[] heights) {
//         Stack<Integer> stack = new Stack<>();
        
//         for (int i = 0; i < heights.length; i++) {
//             int h = heights[i];
//             while (!stack.isEmpty() && heights[stack.peek()] <= h) {
//                 stack.pop();
//             }
            
//             stack.push(i);
//         }
        
//         int[] res = new int[stack.size()];
//         int i = stack.size() - 1;
//         while (i >= 0) res[i--] = stack.pop();
//         return res;
//     }
    
    // 2. Directly mark the building with right view as '-1'
    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Buildings With an Ocean View.
    Memory Usage: 53 MB, less than 96.84% of Java online submissions for Buildings With an Ocean View.
    */
    public int[] findBuildings(int[] heights) {
        if(heights.length == 0) return new int[]{};
        
        int maxHt = 0, count = 0;
        for(int i = heights.length - 1; i >= 0; i--){
            if(heights[i] > maxHt){
                maxHt = heights[i];
                count += 1;
                
                heights[i] = -1;
            }
        }
        
        int[] result = new int[count];
        int k = 0;
        for(int i = 0; i < heights.length; i++){
            if(heights[i] == -1) result[k++] = i;
        }
        return result;
    }
}
