// 1. Using a Queue
// class Vector2D {

//     Queue<Integer> queue = new LinkedList<>();
    
//     public Vector2D(int[][] v) {
//         for (int i = 0; i < v.length; i++) {
//             for (int n : v[i]) {
//                 queue.offer(n);
//             }
//         }
//     }
    
//     public int next() {
//         return queue.poll();
//     }
    
//     public boolean hasNext() {
//         return !queue.isEmpty();
//     }
// }


// 2.Using Two Pointers
class Vector2D {

    int[][] v;
    int totalRows;
    int currCol;
    int currRow;
    
    public Vector2D(int[][] v) {
        this.v = v;
        totalRows = v.length;
        currCol = 0;
        currRow = 0;
    }
    
    public int next() {
        if (hasNext()) {
            return v[currRow][currCol++];
        }
        return -1;
    }
    
    public boolean hasNext() {
        while(currRow < totalRows) {
            if (currCol < v[currRow].length) {
                return true;
            }
            currRow++;
            currCol = 0;
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
