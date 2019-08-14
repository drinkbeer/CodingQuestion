// 1. UnionFind
/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Friend Circles.
Memory Usage: 45.2 MB, less than 40.00% of Java online submissions for Friend Circles.
*/
class Solution {
    
    private class UnionFind {
        int[] id, size;
        int count;
        public UnionFind(int len) {
            this.id = new int[len];
            this.size = new int[len];
            for (int i = 0; i < len; i++) {
                id[i] = i;
                size[i] = i;
            }
            this.count = len;
        }
        
        public int size() {
            return count;
        }
        
        private int root(int i) {
            while (i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
        
        public boolean find(int p, int q) {
            return root(p) == root(q);
        }
        
        public void union(int p, int q) {
            int pi = root(p), qi = root(q);
            if (pi == qi) return;
            if (size[pi] < size[qi]) {
                id[pi] = qi;
                size[qi] += size[pi];
            } else {
                id[qi] = pi;
                size[pi] += size[qi];
            }
            count--;
        }
    }
    
    public int findCircleNum(int[][] M) {
        UnionFind uf = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        
        return uf.size();
    }
}
