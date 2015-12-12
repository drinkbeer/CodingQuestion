import java.util.List;
import java.util.ArrayList;

public class SubstringsOfAString {

    private static List<String> getAllSubstrings(String str){
        List<String> result = new ArrayList<String>();

        int len = str.length();
        for(int i = 0; i < len; i++){
            for(int j = 1; j <= len - i; j++){
                String sub = str.substring(i, i + j);
                result.add(sub);
            }
        }

        return result;
    }

    public static void main(String[] args){
        String str = "fun";
        List<String> result = getAllSubstrings(str);
        int count = 0;

        for(String s : result){
            System.out.println(s);
            System.out.println("Is Palindome: " + ValidatePalindome.isPalindome(s));
            if(ValidatePalindome.isPalindome(s)) count++;
        }

        System.out.println("Number of palindome: " + count);
    }
}