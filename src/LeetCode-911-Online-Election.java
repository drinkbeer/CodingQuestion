/*
https://www.cnblogs.com/lightwindy/p/9758238.html

Persons     [0,1,1,0,0,1,0]
Times       [0,5,10,15,20,25,30]

q(3)    [0] 0
q(12)   [0,1,1] 1
q(25)   [0,1,1,0,0,1]   1


*/
/*
https://www.cnblogs.com/lightwindy/p/9758238.html

G家：

Give a vote list = [(a, 100), (b, 150), (a, 200)] # (name, timestamp) and time T. Find the highest number of votes (or anyone with the highest number of votes) at T

ex: T = 100 -> a, T = 150 -> a or b, T = 200 -> a

Followup1: give one more input K, find Top K votes at T

Followup2: the same vote list, K, but given the Top K votes list, find the time T.

For the first question, just travers the vote list and if vote.T <= T increment
the vote for person vote.Name. While doing that maximize the vote number. 
(O(n*l) time, O(c*l) space, c is the number of candidates, l is average length of name)

follow-up 1: instead of maximizing one, keep the hashtable with votes[person] = no. votes
now, put that into a vector and find the k-th element (using e.g. quicksort's partion 
method which is linear)
(O(n*l) time, O(c*l) space)

follow-up 2: I assume given are the top K candidates at a certain time T I have to find.
I have to keep all candidates sorted at each step and compare the top k of them with
the given list. The first part (keeping candidates sorted at each step) can be done 
using a balanced binary-tree, so I have O(n*lg(n)+n*l) for creating and maintaining that tree. 
(I will have to transpose the name into an integer, and have a nameId instead of the 
string in the tree)
Then I would have k compare's per iteration, which is then O(k*n*lg(n)+n*l). the factor k 
I can get rid of if I implement the tree in a way, so I monitor when elements enter and 
leave the top k. If one of the desired candidates enters top k, I reduce the amount of 
candidates I need in top k, if one leaves, I increment back. If that counter (which 
starts with k) is 0 I'm done, I found the first time where the desired condition happend.

*/
// class TopVotedCandidate {
//     HashMap<Integer, Integer> map;
//     int[] top;
//     int[] times;
//     public TopVotedCandidate(int[] persons, int[] times) {
//         this.map = new HashMap<>();
//         this.top = new int[persons.length];
//         this.times = times;
        
//         int topCountNow = 0;
//         for (int i = 0; i < persons.length; i++) {
//             map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
//             if (map.get(persons[i]) >= topCountNow) {
//                 topCountNow = map.get(persons[i]);
//                 top[i] = persons[i];
//             } else {
//                 if (i == 0) {
//                     top[i] = persons[i];
//                 } else {
//                     top[i] = top[i - 1];
//                 }
//             }
//         }
//     }
    
//     // find the last value in top[] which has top[i] <= t
//     public int q(int t) {
//         int lo = 0, hi = top.length - 1;
//         while (lo + 1 < hi) {
//             int mid = lo + (hi - lo) / 2;
//             if (times[mid] == t) {
//                 return top[mid];
//             } else if (times[mid] < t) {
//                 lo = mid;
//             } else {
//                 hi = mid;
//             }
//         }
        
//         if (times[hi] <= t) return top[hi];
//         return top[lo];
//     }
// }


// 2. TreeMap
/*
https://blog.csdn.net/kingymxe/article/details/82823406

TreeMap maintains <Time, TopPerson> entry.

*/
class TopVotedCandidate {
 
    public TreeMap<Integer, Integer> tm = new TreeMap<>();
    public TopVotedCandidate(int[] persons, int[] times) {
        int[] count = new int[persons.length];
        int max = -1;
        for (int i = 0; i < times.length; ++i) {
            ++count[persons[i]];
            if (max <= count[persons[i]]) {
            	max=count[persons[i]];
                tm.put(times[i], persons[i]);
            }
        }
    }
    public int q(int t) {
        return tm.floorEntry(t).getValue();
    }

}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
