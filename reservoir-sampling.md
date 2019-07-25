
https://leetcode.com/problems/linked-list-random-node/discuss/85659/Brief-explanation-for-Reservoir-Sampling  
https://www.geeksforgeeks.org/reservoir-sampling/   


```
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * https://www.cnblogs.com/snowInPluto/p/5996269.html
 *
 * Time Complexity: O(N)
 */
public class ReservoirSamplingTest {

    private int[] pool;
    private int N = 10000;
    private static final Random random = new Random();

    public ReservoirSamplingTest() {
        this.pool = new int[N];
        for (int i = 0; i < N; i++) {
            pool[i] = i;
        }
    }

    private int[] sampling(int K) {
        int[] result = new int[K];
        for (int i = 0; i < K; i++) {
            result[i] = pool[i];
        }

        for (int i = K; i < N; i++) {
            int r = random.nextInt(i);  // randomly pick one element in range [0, i)

            if (r < K) {
                result[r] = pool[i];
            }
        }

        return result;
    }

    @Test
    public void test() {
        String res = "";
        for (int i : sampling(20)) {
            res += i + " ";
        }
        System.out.println(res);
    }
}

```

#### 382. Linked List Random Node
https://leetcode.com/problems/linked-list-random-node/

```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// 1. Using a HashMap to store <idx, node> pair.
/*
If the size of the link is not huge, we could store the <Idx, Node> pair in map. But if the size of the list is huge, this way will occupy a lot of memory, so it doesn't work.
*/
// class Solution {

//     Map<Integer, ListNode> map = new HashMap<>();
//     private static final java.util.Random rand = new java.util.Random();
    
//     /** @param head The linked list's head.
//         Note that the head is guaranteed to be not null, so it contains at least one node. */
//     public Solution(ListNode head) {
//         int i = 0;
//         while (head != null) {
//             map.put(i, head);
//             head = head.next;
//             i++;
//         }
//     }
    
//     /** Returns a random node's value. */
//     public int getRandom() {
//         int r = rand.nextInt(map.keySet().size());
//         return map.get(r).val;
//     }
// }


// 2. Follow-up when the length of LinkedList is extremely large, and length is unknown.
/*
Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
*/
class Solution {

    private static final java.util.Random rand = new java.util.Random();
    ListNode head;
    
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        
        int i = 0;
        ListNode curr = head;
        ListNode candidate = head;
        while (curr != null) {
            // randomly pick a number between [0, i + 1)
            if (rand.nextInt(i + 1) == i) {
                candidate = curr;
            }
            curr = curr.next;
            i++;
        }
        return candidate.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
```


