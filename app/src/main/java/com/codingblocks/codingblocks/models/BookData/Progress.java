
package com.codingblocks.codingblocks.models.BookData;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Progress {

    @SerializedName("chapters")
    private List<Chapter> mChapters;
    @SerializedName("current")
    private Current mCurrent;
    @SerializedName("percent")
    private Double mPercent;
    @SerializedName("prevPercent")
    private Double mPrevPercent;

    public List<Chapter> getChapters() {
        return mChapters;
    }

    public void setChapters(List<Chapter> chapters) {
        mChapters = chapters;
    }

    public Current getCurrent() {
        return mCurrent;
    }

    public void setCurrent(Current current) {
        mCurrent = current;
    }

    public Double getPercent() {
        return mPercent;
    }

    public void setPercent(Double percent) {
        mPercent = percent;
    }

    public Double getPrevPercent() {
        return mPrevPercent;
    }

    public void setPrevPercent(Double prevPercent) {
        mPrevPercent = prevPercent;
    }

}
