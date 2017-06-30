
package com.codingblocks.codingblocks.models.BookData;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Next {

    @SerializedName("exists")
    private Boolean mExists;
    @SerializedName("external")
    private Boolean mExternal;
    @SerializedName("introduction")
    private Boolean mIntroduction;
    @SerializedName("level")
    private String mLevel;
    @SerializedName("path")
    private String mPath;
    @SerializedName("title")
    private String mTitle;

    public Boolean getExists() {
        return mExists;
    }

    public void setExists(Boolean exists) {
        mExists = exists;
    }

    public Boolean getExternal() {
        return mExternal;
    }

    public void setExternal(Boolean external) {
        mExternal = external;
    }

    public Boolean getIntroduction() {
        return mIntroduction;
    }

    public void setIntroduction(Boolean introduction) {
        mIntroduction = introduction;
    }

    public String getLevel() {
        return mLevel;
    }

    public void setLevel(String level) {
        mLevel = level;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        mPath = path;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
