
public class ClimbStairs {
    // recursive solution(exceed leetcode limited time)
    public int climbStairs(int n) {
        if(n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // save time
    public int climbStairs2(int n) {
        
        if(n <= 2) return n;
        
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for(int i = 2; i < n; i++){
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }

    // space and time both saved
    public int climbStairs3(int n) {
        // if(n <= 2) return n;
        // return climbStairs(n - 1) + climbStairs(n - 2);
        
        int[] arr = {0, 1, 2};
        if(n <= 2) return arr[n];
        
        int j = 2;
        while(true){
            j++;
            arr[j % 3] = arr[(j + 1) % 3] + arr[(j + 2) % 3];
            if(j == n) return arr[j % 3];
        }
    }

}