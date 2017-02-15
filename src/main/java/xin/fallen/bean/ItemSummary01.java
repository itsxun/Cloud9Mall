package xin.fallen.bean;

public class ItemSummary01 {
    private String itemId;

    private Float goodRateShow;

    private Float generalRateShow;

    private Float poorRateShow;

    private Integer commentCount;

    private Integer goodCount;

    private Integer generalCount;

    private Integer poorCount;

    private String commentTableName;

    private String hotTag;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public Float getGoodRateShow() {
        return goodRateShow;
    }

    public void setGoodRateShow(Float goodRateShow) {
        this.goodRateShow = goodRateShow;
    }

    public Float getGeneralRateShow() {
        return generalRateShow;
    }

    public void setGeneralRateShow(Float generalRateShow) {
        this.generalRateShow = generalRateShow;
    }

    public Float getPoorRateShow() {
        return poorRateShow;
    }

    public void setPoorRateShow(Float poorRateShow) {
        this.poorRateShow = poorRateShow;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public Integer getGeneralCount() {
        return generalCount;
    }

    public void setGeneralCount(Integer generalCount) {
        this.generalCount = generalCount;
    }

    public Integer getPoorCount() {
        return poorCount;
    }

    public void setPoorCount(Integer poorCount) {
        this.poorCount = poorCount;
    }

    public String getCommentTableName() {
        return commentTableName;
    }

    public void setCommentTableName(String commentTableName) {
        this.commentTableName = commentTableName == null ? null : commentTableName.trim();
    }

    public String getHotTag() {
        return hotTag;
    }

    public void setHotTag(String hotTag) {
        this.hotTag = hotTag == null ? null : hotTag.trim();
    }
}