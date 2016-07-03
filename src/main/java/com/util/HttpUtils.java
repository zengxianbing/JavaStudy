package com.util;

import com.jd.common.util.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Title: <br>
 * <p>
 * Description: <br>
 * <p>
 * Created by zengxianbing on 2016/5/27.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class HttpUtils {
    private final static Log log = LogFactory.getLog(HttpUtils.class);

    public static String httpGetData(String url, String param,String charSet){
        return httpGetData(url,param,charSet,null);
    }
    public static String httpGetData(String url, String param,String charSet, String [] header) {
        String result = "";
        BufferedReader in = null;
        URLConnection conn = null;
        URL realUrl = null;
        try {
            String urlName = url + "?" + param;
            log.error("=====Get URL:" + urlName );
            realUrl = new URL(urlName);
            // 打开和URL之间的连接
            conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setConnectTimeout(0);
            conn.setReadTimeout(0);
            if(header != null){
                for(int i=0;i<header.length;i++){
                    String[] content = header[i].split(":");
                    conn.setRequestProperty(content[0], content[1]);
                }
            }
            // 建立实际的连接
            conn.connect();
            if(StringUtils.isNotBlank(charSet)){
                in = new BufferedReader(new InputStreamReader(conn.getInputStream(),charSet));
            }else{
                in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }

            String line = "";
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            log.error("访问url地址："+url+"发送GET请求出现异常",e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                realUrl=null;
                conn=null;
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
            }
        }
        log.error("=====Http Result:" + result);
        return result;
    }

    public static String httpPostData(String urlPath, String data,String charSet) {
        return httpPostData(urlPath, data, charSet, null);
    }

    public static String httpPostData(String urlPath, String data,String charSet, String[] header) {
        String result = "";
        URL url = null;
        HttpURLConnection httpurlconnection = null;
        try {
            log.error("=====Post URL:" + urlPath +", data:" + data);
            url = new URL(urlPath);
            httpurlconnection = (HttpURLConnection) url.openConnection();
            httpurlconnection.setDoInput(true);
            httpurlconnection.setDoOutput(true);
            httpurlconnection.setConnectTimeout(0);//设置连接主机超时（单位：毫秒）
            httpurlconnection.setReadTimeout(0);//设置从主机读取数据超时（单位：毫秒）

            if(header != null){
                for(int i=0;i<header.length;i++){
                    String[] content = header[i].split(":");
                    httpurlconnection.setRequestProperty(content[0], content[1]);
                }
            }

            httpurlconnection.setRequestMethod("POST");
            httpurlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            if(StringUtils.isNotBlank(data)){
                if(StringUtils.isBlank(charSet)){
                    httpurlconnection.getOutputStream().write(data.getBytes());
                } else {
                    httpurlconnection.getOutputStream().write(data.getBytes(charSet));
                }
            }
            httpurlconnection.getOutputStream().flush();
            httpurlconnection.getOutputStream().close();
            int code = httpurlconnection.getResponseCode();

            if (code == 200) {
                BufferedReader in = null;
                if(StringUtils.isNotBlank(charSet)){
                    in = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream(),charSet));
                }else{
                    in = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
                }
                String line = "";
                while ((line = in.readLine()) != null) {
                    result += line;
                }
            }else{
                log.error("请求地址："+urlPath +"返回状态异常，异常号为："+code);
            }
        } catch (Exception e) {
            log.error("访问url地址："+urlPath+"发生异常",e);
        } finally {
            url = null;
            if (httpurlconnection != null) {
                httpurlconnection.disconnect();
            }
        }
        log.error("=====Http Result:" + result);
        return result;
    }

}
