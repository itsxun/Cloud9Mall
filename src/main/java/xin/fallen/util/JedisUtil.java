package xin.fallen.util;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: fallen
 * Date: 17-2-12
 * Time: 下午2:12
 * Usage:
 */
public class JedisUtil {

    public static JedisPool pool;

    public Jedis getJedis() {
        return pool.getResource();
    }

    public static boolean setValue(String key, String value) {
        Jedis jedis = pool.getResource();
        String res = jedis.set(key, value);
        jedis.close();
        return res == null;
    }

    public static boolean setValue(String key, String value, int len) {
        Jedis jedis = pool.getResource();
        String res = jedis.setex(key, len, value);
        jedis.close();
        return res == null;
    }

    public static String getValue(String key) {
        Jedis jedis = pool.getResource();
        String res = jedis.get(key);
        jedis.close();
        return res;
    }

    public static boolean TTLRefresh(String key, int len) {
        Jedis jedis = pool.getResource();
        Long res = jedis.expire(key, len);
        jedis.close();
        return res == null;
    }

    public static Set<String> FuzzySeach(String pattern) {
        Set<String> keys = null;
        Jedis jedis = pool.getResource();
        keys = jedis.keys(pattern);
        jedis.close();
        return keys;
    }

    public static boolean addToSet(String key, String setName) {
        Jedis jedis = pool.getResource();
        Long res = jedis.sadd(key, setName);
        jedis.close();
        return res > 0;
    }

    public static boolean removeFromSet(String key, String setName) {
        Jedis jedis = pool.getResource();
        Long res = jedis.srem(key, setName);
        jedis.close();
        return res > 0;
    }

    public static boolean isInSet(String key, String setName) {
        Jedis jedis = pool.getResource();
        boolean flag = jedis.sismember(key, setName);
        jedis.close();
        return flag;
    }

    public static Set<String> getSet(String setName) {
        Jedis jedis = pool.getResource();
        Set<String> set = jedis.smembers(setName);
        jedis.close();
        return set;
    }

    public static boolean addToMap(String mapName, String key, String value) {
        Jedis jedis = pool.getResource();
        Long res = jedis.hset(mapName, key, value);
        jedis.close();
        return res > 0;
    }

    public static String getFromMap(String key, String mapName) {
        Jedis jedis = pool.getResource();
        String value = jedis.hget(mapName, key);
        jedis.close();
        return value;
    }

    public static boolean delFromMap(String mapName, String key) {
        Jedis jedis = pool.getResource();
        Long res = jedis.hdel(mapName, key);
        jedis.close();
        return res > 0;
    }
}