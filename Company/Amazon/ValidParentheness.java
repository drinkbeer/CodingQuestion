import java.util.*;
class ValidParentheness{

    private static boolean valid(String str){
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                stack.push(map.get(ch));
            }else{
                char c = stack.pop();
                if(ch != c) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        String str = "([{}])";
        System.out.println(valid(str));
        String str2 = "([{]})";
        System.out.println(valid(str2));
    }
}