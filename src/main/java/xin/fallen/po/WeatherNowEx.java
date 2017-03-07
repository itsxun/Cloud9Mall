package xin.fallen.po;

/**
 * Author: Fallen
 * Date: 2017/3/5
 * Time: 15:30
 * Usage:
 */
public class WeatherNowEx {
    private String temp;//温度

    private String weaSta;//状态

    private String vis;//能见度

    private String wdir;//风向

    private String sc;//风力

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWeaSta() {
        return weaSta;
    }

    public void setWeaSta(String weaSta) {
        this.weaSta = weaSta;
    }

    public String getVis() {
        return vis;
    }

    public void setVis(String vis) {
        this.vis = vis;
    }

    public String getWdir() {
        return wdir;
    }

    public void setWdir(String wdir) {
        this.wdir = wdir;
    }

    public String getSc() {
        return sc;
    }

    public void setSc(String sc) {
        this.sc = sc;
    }
}
