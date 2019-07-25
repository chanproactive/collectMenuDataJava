
package com.collectMenuDataJava.collectMenuDataJava.tools.googleRequestModel;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CloudRequestModel {

    @SerializedName("requests")
    @Expose
    private ArrayList<RequestModel> requests = new ArrayList<>();

    public ArrayList<RequestModel> getRequests() {
        return requests;
    }

    public void setRequests(ArrayList<RequestModel> requests) {
        this.requests = requests;
    }

}
