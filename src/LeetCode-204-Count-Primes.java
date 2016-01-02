/*
LeetCode: https://leetcode.com/problems/count-primes/
LintCode: 
JiuZhang:
Program Creek: http://www.programcreek.com/2014/04/leetcode-count-primes-java/
Other: 

Analysis: 
1.General Solution
Time Limit Exceeded when input is 1500000
Time O(N^2)

2.Sieve of Eratosthenes
Time: O(nloglogn)  -- i*i<n loop is O(loglogn), j<n loop is O(n)
Space: O(n)
*/
public class Solution {
    // 1.General Solution
    // public int countPrimes(int n) {
    //     int count = 0;
    //     for(int i = 1; i < n; i++){
    //         if(isPrime(i)) count++;
    //     }
    //     return count;
    // }
    
    // private boolean isPrime(int num){
    //     if(num <= 1) return false;
    //     // Loop ending condition is i*i<num, not i<sqrt(num), as sqrt(num) is expensive
    //     for(int i = 2; i * i < num; i++){
    //         if(num % i == 0) return false;
    //     }
    //     return true;
    // }
    
    // 2.Sieve of Eratosthenes
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        
        for(int i = 2; i < n; i++) isPrime[i] = true;
        
        //Oprimize1: Terminating loop condition is i*i<n, not i<sqrt(n), as sqrt() is expensive
        for(int i = 2; i * i < n; i++){
            if(!isPrime[i]) continue;
            //Optimize2: Start of loop is j=i*i, not j = i, because i*k(k is [2,i-1]) has already marked off
            for(int j = i * i; j < n; j += i){
                isPrime[j] = false;
            }
        }
        
        int count = 0;
        for(int i = 2; i < n; i++){
            if(isPrime[i]) count++;
        }
        return count;
    }
}