package xin.fallen.bean;

public class ItemComment01 {
    private String commentId;

    private String referenceId;

    private String scoreLevel;

    private String content;

    private String createTime;

    private Integer score;

    private String userImage;

    private Integer usefulVoteCount;

    private String userProvice;

    private String nickname;

    private String productColor;

    private String productSize;

    private String userLevelName;

    private String userClientShow;

    private String hdImages;

    private String thumbnails;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId == null ? null : commentId.trim();
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId == null ? null : referenceId.trim();
    }

    public String getScoreLevel() {
        return scoreLevel;
    }

    public void setScoreLevel(String scoreLevel) {
        this.scoreLevel = scoreLevel == null ? null : scoreLevel.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage == null ? null : userImage.trim();
    }

    public Integer getUsefulVoteCount() {
        return usefulVoteCount;
    }

    public void setUsefulVoteCount(Integer usefulVoteCount) {
        this.usefulVoteCount = usefulVoteCount;
    }

    public String getUserProvice() {
        return userProvice;
    }

    public void setUserProvice(String userProvice) {
        this.userProvice = userProvice == null ? null : userProvice.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor == null ? null : productColor.trim();
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize == null ? null : productSize.trim();
    }

    public String getUserLevelName() {
        return userLevelName;
    }

    public void setUserLevelName(String userLevelName) {
        this.userLevelName = userLevelName == null ? null : userLevelName.trim();
    }

    public String getUserClientShow() {
        return userClientShow;
    }

    public void setUserClientShow(String userClientShow) {
        this.userClientShow = userClientShow == null ? null : userClientShow.trim();
    }

    public String getHdImages() {
        return hdImages;
    }

    public void setHdImages(String hdImages) {
        this.hdImages = hdImages == null ? null : hdImages.trim();
    }

    public String getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(String thumbnails) {
        this.thumbnails = thumbnails == null ? null : thumbnails.trim();
    }
}