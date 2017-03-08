package xin.fallen.util;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Random;

/**
 * Author: Fallen
 * Date: 2017/3/8
 * Time: 11:59
 * Usage:
 */
public class RandomUtil {
    public static final char[] Letters = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static String getRandomDigit(int len) {
        Random ram = new Random();
        StringBuffer sb = new StringBuffer(len);
        while (sb.length() < len) {
            int i = ram.nextInt(10);
            sb.append(i);
        }
        return sb.toString();
    }

    public static String getRandomDigit() {
        return getRandomDigit(6);
    }

    public static String getRandomLetter(int len) {
        Random ram = new Random();
        StringBuilder sb = new StringBuilder(len);
        while (sb.length() < len) {
            int i = ram.nextInt(47);
            sb.append(Letters[i]);
        }
        return sb.toString();
    }

    public static String getRandomLetter() {
        return getRandomLetter(6);
    }

    public static String getRandomString(int len) {
        Random ram = new Random();
        StringBuilder sb = new StringBuilder(len);
        while (sb.length() < len) {
            int i = ram.nextInt(57);
            sb.append(Letters[i]);
        }
        return sb.toString();
    }

    public static String getRandomString() {
        return getRandomString(6);
    }
}
