package xin.fallen.bean;

public class ItemDetailedMsg01 {
    private String itemId;

    private String shopName;

    private String thumbnails;

    private String brand;

    private String itemColor;

    private String itemVersion;

    private String itemInfo;

    private String itemParam;

    private String shopAveScore;

    private String itemScore;

    private String serviceScore;

    private String logisticsScore;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(String thumbnails) {
        this.thumbnails = thumbnails == null ? null : thumbnails.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getItemColor() {
        return itemColor;
    }

    public void setItemColor(String itemColor) {
        this.itemColor = itemColor == null ? null : itemColor.trim();
    }

    public String getItemVersion() {
        return itemVersion;
    }

    public void setItemVersion(String itemVersion) {
        this.itemVersion = itemVersion == null ? null : itemVersion.trim();
    }

    public String getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(String itemInfo) {
        this.itemInfo = itemInfo == null ? null : itemInfo.trim();
    }

    public String getItemParam() {
        return itemParam;
    }

    public void setItemParam(String itemParam) {
        this.itemParam = itemParam == null ? null : itemParam.trim();
    }

    public String getShopAveScore() {
        return shopAveScore;
    }

    public void setShopAveScore(String shopAveScore) {
        this.shopAveScore = shopAveScore == null ? null : shopAveScore.trim();
    }

    public String getItemScore() {
        return itemScore;
    }

    public void setItemScore(String itemScore) {
        this.itemScore = itemScore == null ? null : itemScore.trim();
    }

    public String getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(String serviceScore) {
        this.serviceScore = serviceScore == null ? null : serviceScore.trim();
    }

    public String getLogisticsScore() {
        return logisticsScore;
    }

    public void setLogisticsScore(String logisticsScore) {
        this.logisticsScore = logisticsScore == null ? null : logisticsScore.trim();
    }
}