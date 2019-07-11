/*
1. Java Deque

hit
Time O(1)
getHit
Time O(1)


2. Array
hit/getHit  - O(1)

*/
// class HitCounter {
//     Deque<Integer> dq;
//     /** Initialize your data structure here. */
//     public HitCounter() {
//         dq = new ArrayDeque<>();
//     }
    
//     /** Record a hit.
//         @param timestamp - The current timestamp (in seconds granularity). */
//     public void hit(int timestamp) {
//         while(!dq.isEmpty() && timestamp - dq.peekFirst() + 1 > 300) {
//             dq.pollFirst();     // poll value from the head
//         }
//         dq.offerLast(timestamp);
//     }
    
//     /** Return the number of hits in the past 5 minutes.
//         @param timestamp - The current timestamp (in seconds granularity). */
//     public int getHits(int timestamp) {
//         while(!dq.isEmpty() && timestamp - dq.peekFirst() + 1 > 300) {
//             dq.pollFirst();     // poll value from the head
//         }
//         return dq.size();
//     }
// }

/*
https://leetcode.com/problems/design-hit-counter/discuss/83483/Super-easy-design-O(1)-hit()-O(s)-getHits()-no-fancy-data-structure-is-needed!
https://www.geeksforgeeks.org/design-a-hit-counter/

Time, space: O(1)
*/
class HitCounter {
    int[] times;
    int[] hits;
    
    /** Initialize your data structure here. */
    public HitCounter() {
        times = new int[300];
        hits = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int idx = timestamp % 300;
        if (times[idx] != timestamp) {
            times[idx] = timestamp;
            hits[idx] = 1;
        } else {
            hits[idx]++;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int count = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                count += hits[i];
            }
        }
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
