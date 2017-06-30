
package com.codingblocks.codingblocks.models.BookData;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Chapter {

    @SerializedName("done")
    private Boolean mDone;
    @SerializedName("index")
    private Long mIndex;
    @SerializedName("introduction")
    private Boolean mIntroduction;
    @SerializedName("level")
    private String mLevel;
    @SerializedName("next")
    private Next mNext;
    @SerializedName("path")
    private String mPath;
    @SerializedName("percent")
    private Long mPercent;
    @SerializedName("title")
    private String mTitle;

    public Boolean getDone() {
        return mDone;
    }

    public void setDone(Boolean done) {
        mDone = done;
    }

    public Long getIndex() {
        return mIndex;
    }

    public void setIndex(Long index) {
        mIndex = index;
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

    public Next getNext() {
        return mNext;
    }

    public void setNext(Next next) {
        mNext = next;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        mPath = path;
    }

    public Long getPercent() {
        return mPercent;
    }

    public void setPercent(Long percent) {
        mPercent = percent;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
