
package com.codingblocks.codingblocks.models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Author {

    @SerializedName("counts")
    private Counts mCounts;
    @SerializedName("dates")
    private Dates mDates;
    @SerializedName("github")
    private Github mGithub;
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("permissions")
    private Permissions mPermissions;
    @SerializedName("type")
    private String mType;
    @SerializedName("urls")
    private Urls mUrls;
    @SerializedName("username")
    private String mUsername;
    @SerializedName("website")
    private String mWebsite;

    public Counts getCounts() {
        return mCounts;
    }

    public void setCounts(Counts counts) {
        mCounts = counts;
    }

    public Dates getDates() {
        return mDates;
    }

    public void setDates(Dates dates) {
        mDates = dates;
    }

    public Github getGithub() {
        return mGithub;
    }

    public void setGithub(Github github) {
        mGithub = github;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
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

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public Urls getUrls() {
        return mUrls;
    }

    public void setUrls(Urls urls) {
        mUrls = urls;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public void setWebsite(String website) {
        mWebsite = website;
    }

}
