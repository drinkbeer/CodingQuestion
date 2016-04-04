/*
a new method setCharat(index, char) is added, a substring must keep the changes of parrent string that are made before its creation, but both the parrent string and the substring will not affect each other after the creation of the substring, requires O(1) space complexity

*/
import java.util.*;

class TrieNode{
    char ch;
    boolean isLeaf;

    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

    public TrieNode(){}

    public TrieNode(char ch){
        ch = ch;
    }
}

class MutableString{
    private TrieNode root;
    String str;

    public MutableString(String str){
        root = new TrieNode();  //root is empty TrieNode
        str = str;
        buildTrie(str);
    }

    private void buildTrie(String str){

        TrieNode curr = root;
        HashMap<Character, TrieNode> children = curr.children;

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(children.containsKey(ch)){
                curr = children.get(ch);
                children = curr.children;
            }else{
                TrieNode newNode = new TrieNode(ch);
                children.put(ch, newNode);
                curr = newNode;
                children = curr.children;
            }

            if(i == str.length() - 1){
                curr.isLeaf = true;
            }
        }
    }

    char charAt(int i){
        TrieNode curr = root;
        HashMap<Character, TrieNode> children = curr.children;

        if(i >= str.length()) return ' ';

        char ch = ' ';
        while(i > 0){
            i--;

            Iterator iter = children.keySet().iterator();
            
            if(!iter.hasNext()){
                return ' ';
            }
            ch = ((Character)iter.next()).charValue();

            curr = children.get(ch);
            children = curr.children;
        }

        return ch;
    }

    String substring(int beginIndex, int endIndex){
        return str.substring(beginIndex, endIndex);
    }

    boolean setcharAt(int i, char c){
        TrieNode curr = root;
        HashMap<Character, TrieNode> children = curr.children;

        if(i >= str.length()) return false;

        char ch = ' ';
        while(i > 0){
            i--;

            Iterator iter = children.keySet().iterator();
            
            if(!iter.hasNext()){
                return false;
            }
            ch = ((Character)iter.next()).charValue();

            curr = children.get(ch);
            children = curr.children;
        }
        if(ch == ' ') return false;

        children.remove(ch);
        TrieNode newNode = new TrieNode(c);
        children.put(c, newNode);

        return true;

    }

}