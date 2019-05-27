/*
https://discuss.leetcode.com/topic/4189/share-my-concise-c-solution-less-than-20-lines/2


*/
public class Solution {
//     public List<String> fullJustify(String[] words, int maxWidth) {
//         List<String> result = new LinkedList<String>();
        
//         // each loop is Text Justification of one line
//         for(int i = 0, w; i < words.length; i = w){
//             // Step1: Justify standard texts
//             // len: one line's length, w: index of words in one line
//             int len = -1;
//             // len + words[w].length() + 1 <= maxWidth, not <, as length can get to maxWidth
//             for(w = i; w < words.length && len + words[w].length() + 1 <= maxWidth; w++){
//                 len += words[w].length() + 1;
//             }
//             // until here, we get standard texts in one line: word + ' ' + word + ' ' ... ' ' + word, each word with one space in gap
            
//             // Step2: distirbute extra spaces
//             // now, we start distribute extra spaces in this line. First let's calculate the # of extrace to distribute.
//             // w != i + 1: only one word in one line, w != words.length: last line
//             // space = 1 not space = 0, because in last line if there are more than one words, we need then have 1 space gap
//             // ["What","must","be","shall","be."] -> ["What must be","shall be.   "], not ["What must be","shallbe.    "]
//             int space = 1, extra = 0;
//             if(w != i + 1 && w != words.length){
//                 // maxWidth - len: # of extra spaces to distribute, w - i: # of words in this line, w - i + 1: # of spaces in this line, +1: add the one space gap in standard texts
//                 space = (maxWidth - len) / (w - i - 1) + 1;
//                 extra = (maxWidth - len) % (w - i - 1);
//             }
            
//             // Step3: Text Justification
//             StringBuilder sb = new StringBuilder();
//             sb.append(words[i]);
//             for(int j = i + 1; j < w; j++){
//                 for(int s = space; s > 0; s--) sb.append(' ');
//                 if(extra-- > 0) sb.append(' ');
//                 sb.append(words[j]);
//             }
            
//             // finally, don't forget the spaces for the last line (for last line, there is one space in word gap, and all left are spaces append to the end )
//             int strLen = maxWidth - sb.length();
//             while(strLen-- > 0) sb.append(' ');
            
//             result.add(sb.toString());
//         }
//         return result;
//     }
    
    
    /*
    https://blog.csdn.net/tingting256/article/details/49804527
    https://shmilyaw-hotmail-com.iteye.com/blog/2302045
    */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        
        int len = words.length;
        if (len <= 0) return result;
        
        int i = 0;
        while (i < len) {
            int size = words[i].length();
            int j = i + 1;
            while (j < len && size + 1 + words[j].length() <= maxWidth) {
                size += 1 + words[j].length();
                j++;
            }
            
            String line = words[i];
            if (j == len) {
                // Case 1. We reached the last line.
                for (int k = i + 1; k < j; k++) {
                    line += " " + words[k];
                }
                
                while(line.length() < maxWidth) {
                    line += " ";
                }
                result.add(line);
            } else {
                // means this is not last line
                if (j - i == 1) {
                    // Case 2. A line with only one word
                    while (line.length() < maxWidth) {
                        line += " ";
                    }
                    result.add(line);
                } else {
                    // Case 3. Normal case.
                    int numSlot = j - i - 1;
                    int actualLen = size - numSlot; // the len of pure words in this line (without space)
                    int spaceLen = maxWidth - actualLen;
                    int x = spaceLen / numSlot;
                    int y = spaceLen % numSlot;
                    int count = 0;
                    for (int k = i + 1; k < j; k++) {
                        int spaceInLine = 0;
                        while (spaceInLine++ < x) line += " ";
                        if (count++ < y) line += " ";
                        line += words[k];
                    }
                    result.add(line);
                }
            }
            
            i = j;
        }
        
        return result;
    }
}
