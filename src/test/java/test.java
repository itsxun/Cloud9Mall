import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import xin.fallen.po.EmailVerify;
import xin.fallen.po.HefengCityCode;
import xin.fallen.util.HttpUtil;
import xin.fallen.util.JedisUtil;
import xin.fallen.util.RandomUtil;
import xin.fallen.util.SerializeUtil;

import java.util.Date;
import java.util.RandomAccess;

/**
 * Author: Fallen
 * Date: 2017/3/3
 * Time: 15:23
 * Usage:
 */
public class test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"classpath:spring/applicationContext-dao.xml",
                "classpath:spring/applicationContext-service.xml",
                "classpath:spring/applicationContext-transaction.xml",
                "classpath:spring/springMVC.xml",
                "classpath:mybatis/SqlMapperConfig.xml"});
//        JedisPool pool = (JedisPool) ac.getBean("jedisPool");
//        Jedis jedis = pool.getResource();
//        EmailVerify ev = new EmailVerify();
//        ev.setCaptcha("123456");
//        ev.setTimeStamp(new Date());
//        JedisUtil.addToMap("test", "fallen", ev);
//        System.out.println("存储完毕");

//        byte[] b = jedis.hget("test".getBytes(), "fallen".getBytes());
//        EmailVerify evv = (EmailVerify) SerializeUtil.unserialize(b);
//        System.out.println(evv);
//        String res = HttpUtil.get("http://files.heweather.com/china-city-list.json");
//        JsonParser parser = new JsonParser();
//        JsonArray jsonArray = parser.parse(res).getAsJsonArray();
//        Gson gson = new Gson();
//        for (JsonElement bean : jsonArray) {
//           HefengCityCode h=gson.fromJson(bean,HefengCityCode.class);
//
//        }
//        String s = RandomUtil.getRandomDigit(5);
//        System.out.println(s);
//        System.out.println(new Date().getTime());

        EmailVerify ev = new EmailVerify();

        String s = ev.getClass().getName();
        try {
            Class clazz = Class.forName(s);
            Object obj = clazz.newInstance();
            if(obj instanceof EmailVerify){
                System.out.println(123);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
