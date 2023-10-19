package br.senai.sc.supertrunfofrutas.security.util;

import br.senai.sc.supertrunfofrutas.security.CookieNotFound;
import br.senai.sc.supertrunfofrutas.security.model.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.util.WebUtils;

public class CookieUtil {

    public static Cookie generateCookie(User user) {
        String token = JWTUtil.generateToken(user);
        Cookie cookie = new Cookie("JWT", token);
        cookie.setPath("/");
        cookie.setMaxAge(1800);
        return cookie;
    }

    public static String getToken(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, "JWT");
        if(cookie != null){
            return cookie.getValue();
        }
        throw new CookieNotFound();
    }
}
