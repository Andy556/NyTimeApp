
package com.nytimes.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ArticleList {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("adx_keywords")
    @Expose
    private String adxKeywords;
    @SerializedName("column")
    @Expose
    private Object column;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("byline")
    @Expose
    private String byline;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("abstract")
    @Expose
    private String _abstract;
    @SerializedName("published_date")
    @Expose
    private String publishedDate;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("asset_id")
    @Expose
    private String assetId;
    @SerializedName("views")
    @Expose
    private Integer views;


    /**
     * No args constructor for use in serialization
     */
    public ArticleList() {
    }

    /**
     * @param adxKeywords
     * @param type
     * @param url
     * @param section
     * @param id
     * @param title
     * @param byline
     * @param source
     * @param assetId
     * @param views
     * @param column
     * @param _abstract
     * @param publishedDate
     */
    public ArticleList(String url, String adxKeywords, Object column, String section, String byline, String type, String title, String _abstract, String publishedDate, String source, String id, String assetId, Integer views) {
        super();
        this.url = url;
        this.adxKeywords = adxKeywords;
        this.column = column;
        this.section = section;
        this.byline = byline;
        this.type = type;
        this.title = title;
        this._abstract = _abstract;
        this.publishedDate = publishedDate;
        this.source = source;
        this.id = id;
        this.assetId = assetId;
        this.views = views;

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdxKeywords() {
        return adxKeywords;
    }

    public void setAdxKeywords(String adxKeywords) {
        this.adxKeywords = adxKeywords;
    }

    public Object getColumn() {
        return column;
    }

    public void setColumn(Object column) {
        this.column = column;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstract() {
        return _abstract;
    }

    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this).append("url", url).append("adxKeywords", adxKeywords).append("column", column).append("section", section).append("byline", byline).append("type", type).append("title", title).append("_abstract", _abstract).append("publishedDate", publishedDate).append("source", source).append("id", id).append("assetId", assetId).append("views", views).toString();
    }

}
