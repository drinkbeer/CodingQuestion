/*
1.Swap in char array
Time O(logN)
Space O(1)

2.Append
Time O(N)
Space O(N)
*/
class ReverseString{
    public static String reverse(String str){
        if(str == null || str.length() <= 1) return str;

        char[] chars = str.toCharArray();

        int lo = 0, hi = chars.length - 1;

        while(lo < hi){
            char temp = chars[lo];
            chars[lo] = chars[hi];
            chars[hi] = temp;
            lo++;
            hi--;
        }
        return String.valueOf(chars);
    }
    
    public static String reverse2(String str){
        if(str == null || str.length() <= 1) return str;
        
        StringBuilder sb = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String str1 = "";
        String str2 = "a";
        String str3 = "ab";
        String str4 = "asdfghjkl";

        System.out.println(reverse(str1) + " " + reverse(str2) + " " + reverse(str3) + " " + reverse(str4));
        System.out.println(reverse2(str1) + " " + reverse2(str2) + " " + reverse2(str3) + " " + reverse2(str4));
    }
}