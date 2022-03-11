/*
Analysis: 

1 2 3 4
5 6 7

--> 1 5 2 6 3 7 4


Test cases:
[],[] 
*/
public class ZigzagIterator {
    // 1.
//     List<Integer> l1;
//     List<Integer> l2;
//     List<Integer> list;
    
//     public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
//         l1 = v1;
//         l2 = v2;
//         list = v1.isEmpty() ? v2 : v1;
//     }

//     public int next() {
//         int res = list.get(0);
//         list.remove(0);
        
//         if(list == l1 && !l2.isEmpty()){
//             list = l2;
//         }else if(list == l2 && !l1.isEmpty()){
//             list = l1;
//         }
        
//         return res;
//     }

//     public boolean hasNext() {
//         return !list.isEmpty();
//     }
    
    // 2.
//     List<Integer> v1;
//     List<Integer> v2;
//     int cnt1 = 0;
//     int cnt2 = 0;
//     boolean isV1 = true; // true will go to v1, false go to v2

//     public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
//         this.v1 = v1;
//         this.v2 = v2;
//     }

//     public int next() {
//         if (!hasNext()) return -1;
        
//         if (isV1) {
//             if (cnt1 < v1.size()) {
//                 isV1 = false;
//                 return v1.get(cnt1++);
//             } else {
//                 return v2.get(cnt2++);
//             }
//         } else {
//             if (cnt2 < v2.size()) {
//                 isV1 = true;
//                 return v2.get(cnt2++);
//             } else {
//                 return v1.get(cnt1++);
//             }
//         }
//     }

//     public boolean hasNext() {
//         return cnt1 < v1.size() || cnt2 < v2.size();
//     }
    
    // 3. Queue. Also appliable for k-vector
    Queue<Iterator> queue;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if (!v1.isEmpty()) queue.offer(v1.iterator());
        if (!v2.isEmpty()) queue.offer(v2.iterator());
    }

    public int next() {
        Iterator<Integer> iter = queue.poll();
        int res = iter.next();
        if (iter.hasNext()) queue.offer(iter);
        
        return res;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
