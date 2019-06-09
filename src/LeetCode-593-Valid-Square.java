/**
Clarify that distance squares are not exceeding the Integer range [-2^32, 2^32]
If it is possible to out range, then use long, [-2^64, 2^64]
*/
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.add(calc(p1, p2));
        set.add(calc(p1, p2));
        set.add(calc(p1, p3));
        set.add(calc(p1, p4));
        set.add(calc(p2, p3));
        set.add(calc(p2, p4));
        set.add(calc(p3, p4));
        
        return set.size() == 2 && !set.contains(0);
    }
    
    private int calc(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
