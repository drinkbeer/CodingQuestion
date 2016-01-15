/*
LeetCode:  https://leetcode.com/problems/unique-word-abbreviation/
LintCode:  not find
JiuZhang:  not find
ProgramCreek:  not find
Other: https://leetcode.com/discuss/71652/java-solution-with-hashmap-string-string-beats-submissions
    http://www.chenguanghe.com/unique-word-abbreviation/
    https://leetcode.com/discuss/74731/why-hello-isunique-hello-should-return-true

Analysis:  

why ["hello"],isUnique("hello") should return [true]?
"A word's abbreviation is unique if no other word from the dictionary has the same abbreviation."
So, we need to record <abbr, word set> pair, two situations is unique:
    1.No word's abbr in map's key
    2.Contains word's key, but the word is the only element in the set.

*/
public class ValidWordAbbr {
    HashMap<String, HashSet<String>> map;
    
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, HashSet<String>>();
        
        for(String str : dictionary){
            String abbr = getAbbr(str);
            if(!map.containsKey(abbr)){
                map.put(abbr, new HashSet<String>());
            }
            map.get(abbr).add(str);
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        return !map.containsKey(abbr) || (map.get(abbr).size() == 1 && map.get(abbr).contains(word));
    }
    
    private String getAbbr(String str){
        if(str.length() > 2){
            return str.charAt(0) + Integer.toString(str.length() - 2) + str.charAt(str.length() - 1);
        }
        return str;
    }
}

// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");