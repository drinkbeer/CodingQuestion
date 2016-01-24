class StrStr{
    private static boolean isSubstring(String s1, String s2){
        if(s1 == null && s2 == null) return true;
        if(s1 != null && s2 == null) return true;
        if(s1 == null && s2 != null) return false;

        int l1 = s1.length();
        int l2 = s2.length();

        if(l1 < l2) return false;

        for(int i = 0; i <= l1 - l2; i++){
            if(s1.charAt(i) == s2.charAt(0)){
                int j = 0;
                for(; j < l2; j++){
                    if(s1.charAt(i + j) != s2.charAt(j)) break;
                }
                if(j == l2) return true;
            }
        }
        return false;
    }
    
    public static int strStr(String haystack, String needle) {
        if(haystack == null || needle == null ) return 0;
        if(needle.length() == 0) return 0;
        
        for(int i = 0; i <=  haystack.length() - needle.length(); i++){
            int m = i;
            int j = 0;
            for(; j < needle.length(); j++){
                if(haystack.charAt(m) != needle.charAt(j)) break;
                m++;
            }
            if(j == needle.length()) return i;
        }
        return -1;
    }

    public static void main(String[] args){
        String s1 = "substring";
        String s2 = "str";
        System.out.println(isSubstring(s1, s2));
        System.out.println(strStr(s1, s2));
    }
}