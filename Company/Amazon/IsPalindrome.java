
class IsPalindrome{
    public static boolean isPalindrome(String str){
        if(str == null || str.length() <= 1) return true;
        int lo = 0, hi = str.length() - 1;

        while(lo < hi){
            if(str.charAt(lo) != str.charAt(hi)) return false;
            lo++;
            hi--;
        }
        return true;
    }

    public static void main(String[] args){
        String str = "abcddcba";
        String str2 = "abcdefg";

        System.out.println(isPalindrome(str));
        System.out.println(isPalindrome(str2));
    }
}