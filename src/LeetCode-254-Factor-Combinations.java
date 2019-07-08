class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 1) return res;
        recursive(n, 2, res, new ArrayList<>());
        return res;
    }
    
    public void recursive(int n, int start, List<List<Integer>> res, List<Integer> list) {
        if (n == 1) {
            if (list.size() == 1) return;
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            if (n % i != 0) continue;
            list.add(i);
            recursive(n / i, i, res, list);
            list.remove(list.size() - 1);
        }
    }
}
