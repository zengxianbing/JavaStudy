package com.util;

/**
 * Title: <br>
 * <p>
 * Description: <br>
 * <p>
 * Created by zengxianbing on 2016/5/27.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class IPBlock {
    private String subnetMask;        //子网掩码
    private String netId;     //网络号

    private int[] subnetMaskSegment;
    private int[] netIdSegment;


    public IPBlock(String netId, String subnetMask) {

        this.netId = netId;
        this.subnetMask = subnetMask;

        initSubnetMaskSegment(subnetMask);
        intiNetIdSegment(netId);
    }


    private void initSubnetMaskSegment(String ip) {
        this.subnetMaskSegment = IPUtils.divideToSegment(ip);
    }

    private void intiNetIdSegment(String ip) {
        this.netIdSegment = IPUtils.divideToSegment(ip);
    }

    public String getSubnetMask() {
        return subnetMask;
    }

    public void setSubnetMask(String subnetMask) {
        this.subnetMask = subnetMask;
    }

    public String getNetId() {
        return netId;
    }


    public int[] getSubnetMaskSegment() {
        return subnetMaskSegment;
    }


    public int[] getNetIdSegment() {
        return netIdSegment;
    }

    public boolean inMyBlock(String ip) {

        int segments[] = IPUtils.divideToSegment(ip);
        if (segments == null || segments.length < 4) {
            return false;
        }

        for (int i = 0; i < subnetMaskSegment.length; i++) {
            if ((segments[i] & subnetMaskSegment[i]) != netIdSegment[i]) {
                return false;
            }
        }

        return true;
    }

    public boolean inMyBlock(int[] segments) {

        if (segments == null || segments.length < 4) {
            return false;
        }

        for (int i = 0; i < subnetMaskSegment.length; i++) {
            if ((segments[i] & subnetMaskSegment[i]) != netIdSegment[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(123&255);
    }
}
