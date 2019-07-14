class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String str : strings) {
            String code = encode(str);
            map.computeIfAbsent(code, k -> new ArrayList<>()).add(str);
        }
        
        for (String str : map.keySet()) {
            res.add(new ArrayList<>(map.get(str)));
        }
        
        return res;
    }
    
    private String encode(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            sb.append((ch + 26 - chars[0]) % 26).append("#");
        }
        return sb.toString();
    }
}
