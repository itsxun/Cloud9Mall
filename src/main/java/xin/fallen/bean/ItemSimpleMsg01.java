package xin.fallen.bean;

public class ItemSimpleMsg01 {
    private Integer recordid;

    private String itemId;

    private String coarseGrained;

    private String fineGrained;

    private String homePage;

    private String title;

    private String thumbnail;

    private String price;

    private String comment;

    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getCoarseGrained() {
        return coarseGrained;
    }

    public void setCoarseGrained(String coarseGrained) {
        this.coarseGrained = coarseGrained == null ? null : coarseGrained.trim();
    }

    public String getFineGrained() {
        return fineGrained;
    }

    public void setFineGrained(String fineGrained) {
        this.fineGrained = fineGrained == null ? null : fineGrained.trim();
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage == null ? null : homePage.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail == null ? null : thumbnail.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}