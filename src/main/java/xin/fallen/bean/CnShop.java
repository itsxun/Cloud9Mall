package xin.fallen.bean;

import java.util.Date;

public class CnShop {
    private String shopId;

    private String shopName;

    private String sellsType;

    private String legalName;

    private String legalId;

    private String address;

    private String avatar;

    private String rank;

    private String shopAveScore;

    private String serviceScore;

    private String logisticsScore;

    private Boolean isActive;

    private Date dateJoined;

    private Integer userId;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getSellsType() {
        return sellsType;
    }

    public void setSellsType(String sellsType) {
        this.sellsType = sellsType == null ? null : sellsType.trim();
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName == null ? null : legalName.trim();
    }

    public String getLegalId() {
        return legalId;
    }

    public void setLegalId(String legalId) {
        this.legalId = legalId == null ? null : legalId.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank == null ? null : rank.trim();
    }

    public String getShopAveScore() {
        return shopAveScore;
    }

    public void setShopAveScore(String shopAveScore) {
        this.shopAveScore = shopAveScore == null ? null : shopAveScore.trim();
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}