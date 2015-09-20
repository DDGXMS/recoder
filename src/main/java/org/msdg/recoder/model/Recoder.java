package org.msdg.recoder.model;

import java.util.Date;

/**
 * Created by Administrator on 2015/9/20.
 */
public class Recoder {

    private int id;
    private String title;
    private String content;
    private int recoderType;
    private String tags;
    private int creator;
    private Date createTime;
    private Date lastModifyTime;
    private int flagDelete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRecoderType() {
        return recoderType;
    }

    public void setRecoderType(int recoderType) {
        this.recoderType = recoderType;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public int getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(int flagDelete) {
        this.flagDelete = flagDelete;
    }
}
