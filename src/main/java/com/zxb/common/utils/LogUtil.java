package com.zxb.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2015/12/30.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class LogUtil {
    public static final String PASSPORT_EXCEPTIONLOG = "PASSPORT_EXCEPTIONLOG";
    public static final String PASSPORT_ORDINARYLOG = "PASSPORT_ORDINARYLOG";
    public static final String REG_EXCEPTIONLOG = "REG_EXCEPTIONLOG";
    public static final String REG_ORDINARYLOG = "REG_ORDINARYLOG";
    public static final String PSOA_LOGIN_EXCEPTIONLOG = "PASSPORTSOA_EXCEPTIONLOG";
    public static final String PSOA_LOGIN_ORDINARYLOG = "PASSPORTSOA_ORDINARYLOG";
    public static final String PSOA_REG_EXCEPTIONLOG = "PASSPORTSOA_EXCEPTIONLOG";
    public static final String PSOA_REG_ORDINARYLOG = "PASSPORTSOA_ORDINARYLOG";

    public static final String PAIPAI_EXCEPTIONLOG="PAIPAI_EXCEPTIONLOG";
    public static final String PAIPAI_ORDINARYLOG="PAIPAI_ORDINARYLOG";
    public static final String JZT_EXCEPTIONLOG="JZT_EXCEPTIONLOG";
    public static final String JZT_ORDINARYLOG="JZT_ORDINARYLOG";
    public static final String XYZX_EXCEPTIONLOG="XYZX_EXCEPTIONLOG";
    public static final String XYZX_ORDINARYLOG="XYZX_ORDINARYLOG";
    public static final String USER_EXECUTOR_LOG="USER_EXECUTOR_LOG";


    public static final String DAO_ORDINARYLOG="DAO_ORDINARYLOG";
    public static final String DAO_ERRORLOG="DAO_ERRORLOG";
    public static final String REDIS_LOG="REDIS_LOG";
    public static final String REDIS_ERROR_LOG="REDIS_ERROR_LOG";
    public static final String DB_LOG="DB_LOG";
    public static final String MQ_LOG="MQ_LOG";

    public static final String EXPORT_SERVICE_LOG="EXPORT_SERVICE_LOG";
    public static final String INNER_SERVICE_LOG="INNER_SERVICE_LOG";
    public static final String RPC_SERVICE_LOG="RPC_SERVICE_LOG";

    public static final String BACK_SOURCE_LOG="BACK_SOURCE_LOG";

    public static final String ALIAS_NAME_LOGIN = "ALIAS_NAME_LOGIN";

    /**
     * log日志debug打印
     * @param name
     * @param msg
     */
    public static void debug(String name, String msg){
        Logger logger = LoggerFactory.getLogger(name);
        if (null != logger) {
            logger.debug(msg);
        }
    }

    /**
     * log日志info打印
     * @param name
     * @param msg
     */
    public static void info(String name,String msg){
        Logger logger = LoggerFactory.getLogger(name);
        if (null != logger) {
            logger.info(msg);
        }
    }

    /**
     * log日志error打印
     * @param name
     * @param msg
     */
    public static void error(String name, String msg) {
        Logger logger = LoggerFactory.getLogger(name);
        if(null != logger) {
            logger.error(msg);
        }
    }

    /**
     * log异常信息打印
     * @param name
     * @param msg
     * @param Exception
     */
    public static void error(String name, String msg, Throwable Exception) {
        Logger logger = LoggerFactory.getLogger(name);
        if (null != logger) {
            logger.error(msg, Exception);
        }
    }

}
