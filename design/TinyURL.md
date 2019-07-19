
### Requirement
* encode long URL to short URL
* decode short URL back to long URL

### QPS + Storage
1.询问面试官日活跃度
 * 约100M
2.推算产生一条Tiny URL的QPS
* 假设每个用户平均每天发0.1条带URL的微博
* Average Write QPS = 100M * 0.1 / 86400 ~ 100
* Peak Write QPS = 100 * 2
3.推算点击一条Tiny URL的QPS
* 假设每个用户平均点个Tiny URL
I Averate Read QPS = 100M * 1 / 86400 ~ 1k
I Peak Read QPS = 2k
4.推算每天产生的新的URL所占存储
* 100M * 0.1 ~ 10M
* 每一条URL长度平均100算，一共1G
* 1T硬盘可以用三年

### Service

1. Store <id, longUrl> pair in SQL DB
```
id        longUrl                       shortUrl
—      ————                      ---------
1        www.google.com        sdfds8d
2       www.amazon.com       aeflj2d4
...
```

2.Convert Sqeuencial ID to a shortUrl (encode)
3.Decode

```
public class UrlService {

    /**
     * Convert a longUrl to 6 digit short Url.
     *
     */
    private String encode(String longUrl) {

        int id = 123;     //get the id from the SQL Database's sequencial id
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String shortUrl = "";
        while (id > 62) {
            shortUrl = chars.charAt(id % 62) + shortUrl;
            id /= 62;
        }
        return shortUrl;
    }

    private int decode(String shortUrl) {

        int id = 0;

        for (int i = 0; i < shortUrl.length(); i++) {
            char c = shortUrl.charAt(i);
            if ('a' <= c && c <= 'z') {
                id = id * 62 + c - 'a';
            } else if ('A' <= c && c <= 'Z') {
                id = id * 62 + c - 'A' + 26;
            } else {
                id = id * 62 + c - '0' + 56;
            }

        }
        return id;
    }
}
```
