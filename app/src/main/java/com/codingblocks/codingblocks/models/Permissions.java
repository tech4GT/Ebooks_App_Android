
package com.codingblocks.codingblocks.models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Permissions {

    @SerializedName("admin")
    private Boolean mAdmin;
    @SerializedName("edit")
    private Boolean mEdit;
    @SerializedName("important")
    private Boolean mImportant;

    public Boolean getAdmin() {
        return mAdmin;
    }

    public void setAdmin(Boolean admin) {
        mAdmin = admin;
    }

    public Boolean getEdit() {
        return mEdit;
    }

    public void setEdit(Boolean edit) {
        mEdit = edit;
    }

    public Boolean getImportant() {
        return mImportant;
    }

    public void setImportant(Boolean important) {
        mImportant = important;
    }

}
