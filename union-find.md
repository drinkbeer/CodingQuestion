https://leetcode.com/tag/union-find/  
https://blog.csdn.net/Guo15331092/article/details/78702686  
https://zxi.mytechroad.com/blog/data-structure/sp1-union-find-set/  

### Union-Find Class

```
private class UnionFind {

    private int[] id, size;
    private int count;

    public UnionFind(int len) {
        id = new int[len];
        size = new int[len];
        for (int i = 0; i < len; i++) {
            id[i] = i;
            size[i] = 1;
        }
        count = len;
    }

    public int size() {
        return count;
    }

    private int root(int i) {
        while(i != id[i]) {
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
```

#### 128. Longest Consecutive Sequence

https://leetcode.com/problems/longest-consecutive-sequence/


#### 261. Graph Valid Tree
https://leetcode.com/problems/graph-valid-tree/

```
// 3. Union-Find (Define a UnionFind Class)
public boolean validTree(int n, int[][] edges) {
    UnionFind uf = new UnionFind(n);
    for (int[] edge : edges) {
        if (uf.find(edge[0], edge[1])) return false;
        uf.union(edge[0], edge[1]);
    }
    return uf.size() == 1;
}

private class UnionFind {

    private int[] id, size;
    private int count;

    public UnionFind(int len) {
        id = new int[len];
        size = new int[len];
        for (int i = 0; i < len; i++) {
            id[i] = i;
            size[i] = 1;
        }
        count = len;
    }

    public int size() {
        return count;
    }

    private int root(int i) {
        while(i != id[i]) {
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
```

#### 547. Friend Circles
https://leetcode.com/problems/friend-circles/

```
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
```

