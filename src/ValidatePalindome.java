
public class ValidatePalindome {
    public static boolean isPalindome(String str){
        int lo = 0;
        int hi = str.length() - 1;

        while(lo < hi){
            if(str.charAt(lo) != str.charAt(hi)) return false;
            lo++;
            hi--;
        }
        return true;
    }

    public static void main(String[] args){
        String str = "abcdefgfedcba";
        System.out.println("Is Palindome: " + isPalindome(str));

        String str2 = "abcdegfedcba";
        System.out.println("Is Palindome: " + isPalindome(str2));

        String str3 = "a";
        System.out.println("Is Palindome: " + isPalindome(str3));
    }
}