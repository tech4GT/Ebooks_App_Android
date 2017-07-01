
package com.codingblocks.codingblocks.models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class List {

    @SerializedName("author")
    private Author mAuthor;
    @SerializedName("counts")
    private Counts mCounts;
    @SerializedName("cover")
    private Cover mCover;
    @SerializedName("dates")
    private Dates mDates;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("id")
    private String mId;
    @SerializedName("language")
    private String mLanguage;
    @SerializedName("license")
    private String mLicense;
    @SerializedName("locked")
    private Boolean mLocked;
    @SerializedName("name")
    private String mName;
    @SerializedName("permissions")
    private Permissions mPermissions;
    @SerializedName("public")
    private Boolean mPublic;
    @SerializedName("publish")
    private Publish mPublish;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("template")
    private String mTemplate;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("topics")
    private java.util.List<Object> mTopics;
    @SerializedName("urls")
    private Urls mUrls;

    public Author getAuthor() {
        return mAuthor;
    }

    public void setAuthor(Author author) {
        mAuthor = author;
    }

    public Counts getCounts() {
        return mCounts;
    }

    public void setCounts(Counts counts) {
        mCounts = counts;
    }

    public Cover getCover() {
        return mCover;
    }

    public void setCover(Cover cover) {
        mCover = cover;
    }

    public Dates getDates() {
        return mDates;
    }

    public void setDates(Dates dates) {
        mDates = dates;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

    public String getLicense() {
        return mLicense;
    }

    public void setLicense(String license) {
        mLicense = license;
    }

    public Boolean getLocked() {
        return mLocked;
    }

    public void setLocked(Boolean locked) {
        mLocked = locked;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Permissions getPermissions() {
        return mPermissions;
    }

    public void setPermissions(Permissions permissions) {
        mPermissions = permissions;
    }

    public Boolean getPublic() {
        return mPublic;
    }

    public void setPublic(Boolean public) {
        mPublic = public;
    }

    public Publish getPublish() {
        return mPublish;
    }

    public void setPublish(Publish publish) {
        mPublish = publish;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getTemplate() {
        return mTemplate;
    }

    public void setTemplate(String template) {
        mTemplate = template;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public java.util.List<Object> getTopics() {
        return mTopics;
    }

    public void setTopics(java.util.List<Object> topics) {
        mTopics = topics;
    }

    public Urls getUrls() {
        return mUrls;
    }

    public void setUrls(Urls urls) {
        mUrls = urls;
    }

}
