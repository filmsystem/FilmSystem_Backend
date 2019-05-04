package shu.ces.filmsystem.Model;

import java.sql.Timestamp;

public class BookinfRecord {
    private int id;
    private int userId;
    private int showId;
    private Timestamp createTime;
    private Timestamp payTime;
    private String collectingString;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }


    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    public String getCollectingString() {
        return collectingString;
    }

    public void setCollectingString(String collectingString) {
        this.collectingString = collectingString;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
