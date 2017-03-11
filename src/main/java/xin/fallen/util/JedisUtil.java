package xin.fallen.util;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.Set;

/**
 * Author: fallen
 * Date: 17-2-12
 * Time: 下午2:12
 * Usage:
 */
public class JedisUtil {

    public static ArrayList<JedisPool> pools;

    public static Jedis getJedis() {
        return pools.get(0).getResource();
    }

    public static Jedis getJedis(int id) {
        return pools.get(id).getResource();
    }

    public static boolean setValue(String key, String value) {
        Jedis jedis = getJedis();
        String res = jedis.set(key, value);
        jedis.close();
        return res == null;
    }

    public static boolean setValue(String key, String value, int DBID) {
        Jedis jedis = getJedis(DBID - 1);
        String res = jedis.set(key, value);
        jedis.close();
        return res == null;
    }

    public static boolean setTTLValue(String key, String value, int len) {
        Jedis jedis = getJedis();
        String res = jedis.setex(key, len, value);
        jedis.close();
        return res == null;
    }

    public static boolean setTTLValue(String key, String value, int DBID, int len) {
        Jedis jedis = getJedis(DBID - 1);
        String res = jedis.setex(key, len, value);
        jedis.close();
        return res == null;
    }

    public static String getValue(String key) {
        Jedis jedis = getJedis();
        String res = jedis.get(key);
        jedis.close();
        return res;
    }

    public static boolean TTLRefresh(String key, int len) {
        Jedis jedis = getJedis();
        Long res = jedis.expire(key, len);
        jedis.close();
        return res == null;
    }

    public static Set<String> FuzzySeach(String pattern) {
        Set<String> keys = null;
        Jedis jedis = getJedis();
        keys = jedis.keys(pattern);
        jedis.close();
        return keys;
    }

    public static boolean addToSet(String key, String setName) {
        Jedis jedis = getJedis();
        Long res = jedis.sadd(key, setName);
        jedis.close();
        return res > 0;
    }

    public static boolean removeFromSet(String key, String setName) {
        Jedis jedis = getJedis();
        Long res = jedis.srem(key, setName);
        jedis.close();
        return res > 0;
    }

    public static boolean isInSet(String key, String setName) {
        Jedis jedis = getJedis();
        boolean flag = jedis.sismember(key, setName);
        jedis.close();
        return flag;
    }

    public static Set<String> getSet(String setName) {
        Jedis jedis = getJedis();
        Set<String> set = jedis.smembers(setName);
        jedis.close();
        return set;
    }

    public static boolean addObjToMap(String mapName, String key, Object value) {
        Jedis jedis = getJedis();
        byte[] b = SerializeUtil.serialize(value);
        Long res = jedis.hset(mapName.getBytes(), key.getBytes(), b);
        jedis.close();
        return res > 0;
    }

    public static boolean addStrToMap(String mapName, String key, String value) {
        Jedis jedis = getJedis();
        Long res = jedis.hset(mapName, key, value);
        jedis.close();
        return res > 0;
    }

    public static String getStrFromMap(String mapName, String key) {
        Jedis jedis = getJedis();
        String value = jedis.hget(mapName, key);
        jedis.close();
        return value;
    }

    public static byte[] getObjFromMap(String mapName, String key, Class clazz) {
        Jedis jedis = getJedis();
        byte[] b = jedis.hget(mapName.getBytes(), key.getBytes());
        jedis.close();
        return b;
    }

    public static boolean delFromMap(String mapName, String key) {
        Jedis jedis = getJedis();
        Long res = jedis.hdel(mapName, key);
        jedis.close();
        return res > 0;
    }
}