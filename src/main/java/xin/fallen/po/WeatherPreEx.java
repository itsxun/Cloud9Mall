package xin.fallen.po;

/**
 * Author: Fallen
 * Date: 2017/3/6
 * Time: 12:55
 * Usage:
 */
public class WeatherPreEx {
    /**
     * 日期
     * 白天天气
     * 夜间天气
     * 降水概率
     * 最高温
     * 最低温
     * 能见度
     * 风向
     * 风力
     */
    private String date;
    private String weaStaD;
    private String weaStaN;
    private String rainP;
    private String tempMax;
    private String tempMin;
    private String vis;
    private String wdir;
    private String sc;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeaStaD() {
        return weaStaD;
    }

    public void setWeaStaD(String weaStaD) {
        this.weaStaD = weaStaD;
    }

    public String getWeaStaN() {
        return weaStaN;
    }

    public void setWeaStaN(String weaStaN) {
        this.weaStaN = weaStaN;
    }

    public String getRainP() {
        return rainP;
    }

    public void setRainP(String rainP) {
        this.rainP = rainP;
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
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
