package com.util;

import java.util.Random;
import java.util.UUID;

/**
 * Title: <br>
 * <p>
 * Description: <br>
 * <p>
 * Created by zengxianbing on 2016/5/27.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class RandomUtil {
    private static final Random random = new Random();

    private static final long hi = 1L << 50;

    private static char[] intChars = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    public static int randomRangeInt(int min, int max) {
        return random.nextInt(max) % (max - min + 1) + min;
    }

    public static String randomStr() {
        return Long.toHexString(hi | (random.nextLong() & (hi - 1)));
    }

    public static UUID randomUUID() {
        return UUID.randomUUID();
    }

    public static int randomInt(int max) {
        return random.nextInt(max);
    }

    public static int randomInt_1000() {
        return random.nextInt(1000);
    }

    public static String intStr(int bitNum) {
        String result = "";
        int lastPos = 0;
        long randFactor = random.nextLong();
        for (int i = 0; i < bitNum; i++) {
            long million = System.currentTimeMillis() + lastPos + randFactor;
            int pos = (int) (million % intChars.length);
            if (pos < 0) {
                pos = pos * -1;
            }
            lastPos = pos;
            result = result + intChars[pos];
            randFactor = random.nextLong();
        }
        return result;
    }
}
