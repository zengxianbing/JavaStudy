package com.zxb.guava3;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cengxianbing on 2015/11/25.
 */
public class BimapTest {
    @Test
    public void logMapTest() {
        String str2 = new String("Hello World!");
        Map<Integer, String> logfileMap = Maps.newHashMap();
        logfileMap.put(2, "b.log");
        logfileMap.put(3, "c.log");
        logfileMap.put(3, "c.log");
        System.out.println("logfileMap:" + logfileMap);
        String str1 = new String("Hello World!");
        HashMap<String, String> hashMap = new HashMap<>();

    }

    /**
     * 逆转Map的key和value
     *
     * @param <S>
     * @param <T>
     * @param map
     * @return
     */
    public static <S, T> Map<T, S> getInverseMap(Map<S, T> map) {
        Map<T, S> inverseMap = new HashMap<T, S>();
        for (Map.Entry<S, T> entry : map.entrySet()) {
            inverseMap.put(entry.getValue(), entry.getKey());
        }
        return inverseMap;
    }


    @Test
    public void logMapTest2() {
        Map<Integer, String> logfileMap = Maps.newHashMap();
        logfileMap.put(1, "a.log");
        logfileMap.put(2, "b.log");

        logfileMap.put(3, "c.log");
        System.out.println("logfileMap:" + logfileMap);
        logfileMap.put(3, "c.log");

        Map<String, Integer> logfileInverseMap = Maps.newHashMap();

        logfileInverseMap = getInverseMap(logfileMap);

        System.out.println("logfileInverseMap:" + logfileInverseMap);


    }


    @Test
    public void BimapTest() {
        BiMap<Integer, String> logfileMap = HashBiMap.create();
        logfileMap.put(1, "a.log");
        logfileMap.put(2, "b.log");
        logfileMap.put(3, "c.log");
        System.out.println("logfileMap:" + logfileMap);
        BiMap<String, Integer> filelogMap = logfileMap.inverse();
        System.out.println("filelogMap:" + filelogMap);
    }

    @Test
    public void BimapTest1() {
        BiMap<Integer, String> logfileMap = HashBiMap.create();
        logfileMap.put(1, "a.log");
        logfileMap.put(2, "b.log");
        logfileMap.put(3, "c.log");
        logfileMap.put(4, "d.log");
        logfileMap.put(5, "d.log");
    }
    @Test
    public void BimapTest2(){
        BiMap<Integer,String> logfileMap = HashBiMap.create();
        logfileMap.put(1,"a.log");
        logfileMap.put(2,"b.log");
        logfileMap.put(3,"c.log");

        logfileMap.put(4,"d.log");
        logfileMap.forcePut(5,"d.log");
        System.out.println("logfileMap:"+logfileMap);
    }
    @Test
    public void BimapTest3(){
        BiMap<Integer,String> logfileMap = HashBiMap.create();
        logfileMap.put(1,"a.log");
        logfileMap.put(2,"b.log");
        logfileMap.put(3,"c.log");
        System.out.println("logfileMap:"+logfileMap);
        BiMap<String,Integer> filelogMap = logfileMap.inverse();
        System.out.println("filelogMap:"+filelogMap);

        logfileMap.put(4,"d.log");

        System.out.println("logfileMap:"+logfileMap);
        System.out.println("filelogMap:"+filelogMap);
    }
}
