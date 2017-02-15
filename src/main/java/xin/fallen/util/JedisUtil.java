package xin.fallen.util;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Author: fallen
 * Date: 17-2-12
 * Time: 下午2:12
 * Usage:
 */
public class JedisUtil {

    private static JedisPool pool;

    @Resource
    private JedisPool jedisPool;

    @PostConstruct
    public void initPool() {
        pool = jedisPool;
    }

    public Jedis getJedis() {
        return pool.getResource();
    }

    public static void setValue(String key, String value) {
        Jedis jedis = pool.getResource();
        jedis.set(key, value);
        jedis.close();
    }

    public static void setValue(String key, String value, int len) {
        Jedis jedis = pool.getResource();
        jedis.setex(key, len, value);
        jedis.close();
    }

    public static String getValue(String key) {
        Jedis jedis = pool.getResource();
        String res = jedis.get(key);
        jedis.close();
        return res;
    }

    public static void reborn(String key, int len) {
        Jedis jedis = pool.getResource();
        jedis.expire(key, len);
        jedis.close();
    }
}
