package com.util;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Title: <br>
 * <p>
 * Description: <br>
 * <p>
 * Created by zengxianbing on 2016/5/27.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class CookieUtils {
    /**
     *
     * 创建Cookie对象
     *
     * */
    public static Cookie newCookie(String name, String value, int maxAge,
                                   String domain){
        try {
            value = value!=null? URLEncoder.encode(value, "UTF-8"):value;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setDomain(domain);

        return cookie;

    }
    /**
     *
     * 添加Cookie对象到HttpServletResponse，<br/>
     * 可添加HttpOnly的Cookie和非HttpOnly的Cookie。
     *
     * */
    public static void addCookie(HttpServletResponse response, String name,
                                 String value, int maxAge, String domain){
        try {
            value = value!=null?URLEncoder.encode(value, "UTF-8"):value;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setDomain(domain);
        cookie.setPath("/");
        response.addCookie(cookie);

    }

    public static void addCookie(HttpServletResponse response, String name,
                                 String value, int maxAge, String domain,boolean encode){
        try {
            value = value!=null && encode?URLEncoder.encode(value, "UTF-8"):value;
            value = value.replace("\r", "").replace("\n", "");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setDomain(domain);
        cookie.setPath("/");
        response.addCookie(cookie);

    }
    /**
     * 根据Cookie名称获得Cookie
     * */
    private static Cookie getCookieFromReq(HttpServletRequest req, String name) {
        Cookie cookies[] = req.getCookies();
        if (cookies != null) {
            for (int nCookie = 0; nCookie < cookies.length; nCookie++) {
                if (cookies[nCookie].getName().equalsIgnoreCase(name)) {
                    return cookies[nCookie];
                }
            }
        }
        return null;
    }
    private static String getCookieValue(Cookie cookie) {
        if(cookie == null){
            return null;
        }
        String cookieValue = checkDoubleQuote(cookie.getValue());
        try {
            return StringUtils.isNotBlank(cookieValue)?
                    URLDecoder.decode(cookieValue, "utf-8"):cookieValue;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getCookieValue(Cookie cookie,boolean decode) {
        if(cookie == null){
            return null;
        }
        String cookieValue = checkDoubleQuote(cookie.getValue());
        try {
            return StringUtils.isNotBlank(cookieValue) && decode?
                    URLDecoder.decode(cookieValue, "utf-8"):cookieValue;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String checkDoubleQuote(String cookie) {
        String doubleQuote = "\"";
        if ((cookie != null) && cookie.startsWith(doubleQuote)
                && cookie.endsWith(doubleQuote)) {
            int last = cookie.length() - 1;
            cookie = cookie.substring(1, last);
        }
        return cookie;
    }

    public static String getCookieValue(HttpServletRequest req, String name){
        return getCookieValue(getCookieFromReq(req, name));
    }

    public static String getCookieValue(HttpServletRequest req, String name,boolean decode){
        return getCookieValue(getCookieFromReq(req, name),decode);
    }

    /**
     * 清除cookie
     *
     * @param cookieName
     * @param request
     * @param response
     */
    public static void clearCookie(String cookieName,String domain,HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    cookie.setMaxAge(0);
                    cookie.setValue(null);
                    cookie.setPath("/");
                    cookie.setDomain(domain);
                    response.addCookie(cookie);
                    break;//tu add 减少循环
                }
            }
        }
    }

}
