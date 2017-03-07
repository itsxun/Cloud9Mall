import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.JedisPool;
import xin.fallen.po.HefengCityCode;
import xin.fallen.util.HttpUtil;

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
        JedisPool pool = (JedisPool) ac.getBean("jedisPool");
        String res = HttpUtil.get("http://files.heweather.com/china-city-list.json");
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = parser.parse(res).getAsJsonArray();
        Gson gson = new Gson();
        for (JsonElement bean : jsonArray) {
           HefengCityCode h=gson.fromJson(bean,HefengCityCode.class);

        }
    }
}
