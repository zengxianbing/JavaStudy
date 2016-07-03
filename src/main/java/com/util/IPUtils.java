package com.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Title: <br>
 * <p>
 * Description: <br>
 * <p>
 * Created by zengxianbing on 2016/5/27.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class IPUtils {
    private static final String ipReg = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";

    public boolean inBlock(String ip, IPBlock ipBlock) {
        return true;

    }

    private static String serverIP = null;

    public static String serverIP() {

        if (serverIP == null) {
            try {
                Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
                InetAddress ip = null;
                while (allNetInterfaces.hasMoreElements()) {
                    NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                    if (netInterface.isLoopback()) {
                        continue;
                    }

                    Enumeration addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = (InetAddress) addresses.nextElement();
                        if (ip != null && ip instanceof Inet4Address) {
                            serverIP = ip.getHostAddress().toString();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return serverIP;
    }

    /**
     * ip 点分十进制
     *
     * @param ip
     * @return
     */
    public static int[] divideToSegment(String ip) {

        if (!ip.matches(ipReg)) {
            return null;
        }

        String[] segments = ip.split("\\.");
        int int_segments[] = new int[segments.length];
        for (int i = 0; i < segments.length; i++) {
            int_segments[i] = Integer.parseInt(segments[i]);
        }

        return int_segments;
    }

    public static void main(String[] args) {
        System.out.println(255 & 127);
    }
}
