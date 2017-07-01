
package com.codingblocks.codingblocks.models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Counts {

    @SerializedName("changeRequests")
    private Long mChangeRequests;
    @SerializedName("discussions")
    private Long mDiscussions;
    @SerializedName("stars")
    private Long mStars;
    @SerializedName("subscriptions")
    private Long mSubscriptions;
    @SerializedName("updates")
    private Long mUpdates;

    public Long getChangeRequests() {
        return mChangeRequests;
    }

    public void setChangeRequests(Long changeRequests) {
        mChangeRequests = changeRequests;
    }

    public Long getDiscussions() {
        return mDiscussions;
    }

    public void setDiscussions(Long discussions) {
        mDiscussions = discussions;
    }

    public Long getStars() {
        return mStars;
    }

    public void setStars(Long stars) {
        mStars = stars;
    }

    public Long getSubscriptions() {
        return mSubscriptions;
    }

    public void setSubscriptions(Long subscriptions) {
        mSubscriptions = subscriptions;
    }

    public Long getUpdates() {
        return mUpdates;
    }

    public void setUpdates(Long updates) {
        mUpdates = updates;
    }

}
