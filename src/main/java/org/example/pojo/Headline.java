package org.example.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName news_headline
 */
@TableName(value ="news_headline")
@Data
public class Headline implements Serializable {
    /**
     * 头条id
     */
    @TableId(type = IdType.AUTO)
    private Integer hid;

    /**
     * 头条标题
     */
    private String title;

    /**
     * 头条新闻内容
     */
    private String article;

    /**
     * 头条类型id
     */
    private Integer type;

    /**
     * 头条发布用户id
     */
    private Integer publisher;

    /**
     * 头条浏览量
     */
    private Integer pageViews;

    /**
     * 头条发布时间
     */
    private Date createTime;

    /**
     * 头条最后的修改时间
     */
    private Date updateTime;

    /**
     * 乐观锁
     */
    @Version
    private Integer version;

    /**
     * 头条是否被删除 1 删除  0 未删除
     */
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Headline other = (Headline) that;
        return (this.getHid() == null ? other.getHid() == null : this.getHid().equals(other.getHid()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getArticle() == null ? other.getArticle() == null : this.getArticle().equals(other.getArticle()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getPublisher() == null ? other.getPublisher() == null : this.getPublisher().equals(other.getPublisher()))
            && (this.getPageViews() == null ? other.getPageViews() == null : this.getPageViews().equals(other.getPageViews()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHid() == null) ? 0 : getHid().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getArticle() == null) ? 0 : getArticle().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getPublisher() == null) ? 0 : getPublisher().hashCode());
        result = prime * result + ((getPageViews() == null) ? 0 : getPageViews().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", hid=").append(hid);
        sb.append(", title=").append(title);
        sb.append(", article=").append(article);
        sb.append(", type=").append(type);
        sb.append(", publisher=").append(publisher);
        sb.append(", pageViews=").append(pageViews);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", version=").append(version);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}