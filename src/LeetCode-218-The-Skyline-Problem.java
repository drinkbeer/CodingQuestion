class Solution {
    /*
    https://www.youtube.com/watch?v=GSBLe8cKu0s
    https://leetcode.com/problems/the-skyline-problem/discuss/61197/(Guaranteed)-Really-Detailed-and-Good-(Perfect)-Explanation-of-The-Skyline-Problem
    https://www.educative.io/page/11000001/70001
    
    Time O(NlogN)
    Space O(N)
    */
    private class BuildingPoint implements Comparable<BuildingPoint> {
        int x;              // x axis
        int h;              // height, which is y axis
        boolean isStart;    // if it's start point
        
        public BuildingPoint(int x, int h, boolean s) {
            this.x = x;
            this.h = h;
            this.isStart = s;
        }
        
        @Override
        public int compareTo(BuildingPoint o) {
            if (this.x != o.x) {
                return this.x - o.x;
            } else {
                //
                if (this.isStart && o.isStart) {
                    // higher height point first (decreasing order)
                    return o.h - this.h;
                } else if (!this.isStart && !o.isStart) {
                    // lower height point first (ascending order)
                    return this.h - o.h;
                } else {
                    // one is start, and another one is end, we always let end point first, then start point
                    return this.isStart ? -1 : 1;
                }
                
                // The following one line could represent the above comparision: 
                // return (this.isStart ? -this.h : this.h) - (o.isStart ? -o.h : o.h);
            }
        }
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0) return new ArrayList<>();
        
        
        List<BuildingPoint> list = new ArrayList<>();
        for (int[] b : buildings) {
            BuildingPoint bpl = new BuildingPoint(b[0], b[2], true);
            list.add(bpl);
            
            BuildingPoint bpr = new BuildingPoint(b[1], b[2], false);
            list.add(bpr);
        }
        Collections.sort(list);
        // printBPList(list);
        
        List<List<Integer>> res = new ArrayList<>();
        // <height, frequency> map
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        int prevMaxHeight = 0;
        for (BuildingPoint bp : list) {
            if (bp.isStart) {
                map.put(bp.h, map.getOrDefault(bp.h, 0) + 1);
            } else {
                map.put(bp.h, map.get(bp.h) - 1);
                if (map.get(bp.h) == 0) map.remove(bp.h);
            }
            
            // printTM(map);
            
            int currMaxHeight = map.lastKey();
            if (prevMaxHeight != currMaxHeight) {
                res.add(Arrays.asList(bp.x, currMaxHeight));
                prevMaxHeight = currMaxHeight;
            }
        }
        return res;
    }
    
    private void printBPList(List<BuildingPoint> list) {
        for (BuildingPoint bp : list) {
            System.out.println("x: " + bp.x + "  h: " + bp.h + "  isStart: " + bp.isStart);
        }
    }
    
    private void printTM(TreeMap<Integer, Integer> map) {
        System.out.println(map);
    }
}
