
package com.collectMenuDataJava.collectMenuDataJava.tools.googleRequestModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeatureModel {

    @SerializedName("type")
    @Expose
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
