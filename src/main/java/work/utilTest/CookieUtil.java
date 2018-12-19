package work.utilTest;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;

public class CookieUtil {
    public static Map<String,Cookie> getCookie(Cookie[] cookies) { //用map接收集合类型的cookie
        Map<String,Cookie> maps = new HashMap<>();
        if (cookies != null) {
            for (Cookie coo : cookies
                    ) {
                maps.put(coo.getName(),coo);
            }
        }
        return maps;
    }
}
