package com.util;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Title: <br>
 * <p>
 * Description: <br>
 * <p>
 * Created by zengxianbing on 2016/4/18.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class NetworkUtil {
    /**
     * 获取ip地址
     * @param request
     * @return
     */
    public static String  getRemoteIp(HttpServletRequest request) {

        if (request == null) {
            return null;
        }

        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        if (StringUtils.isNotEmpty(ip) && ip.contains(",")) {
            ip = ip.substring(0, ip.indexOf(","));
        }

        if (ip != null) {
            return ip.split(":")[0];
        }

        return null;
    }
}
