// 1. Using Base64 encoding algorithm to encode the longUrl to tinyUrl.
/*
https://leetcode.com/problems/encode-and-decode-tinyurl/discuss/100268/Two-solutions-and-thoughts
*/
public class Codec {
    
    HashMap<String, String> map = new HashMap<>();  // store <shortUrl, longUrl> pair
    String BASE_HOST = "http://tinyurl.com/";
    String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Random rand = new Random();
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = "";
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int r = rand.nextInt(charSet.length());
                sb.append(charSet.charAt(r));
            }
            key = sb.toString();
        } while (map.containsKey(key));
        
        map.put(BASE_HOST + key, longUrl);
        return BASE_HOST + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (!map.containsKey(shortUrl)) return "";
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
