import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
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
        String res = HttpUtil.get("http://files.heweather.com/china-city-list.json");
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = parser.parse(res).getAsJsonArray();
        Gson gson = new Gson();
        for (JsonElement bean : jsonArray) {
           HefengCityCode h=gson.fromJson(bean,HefengCityCode.class);

        }
    }
}
