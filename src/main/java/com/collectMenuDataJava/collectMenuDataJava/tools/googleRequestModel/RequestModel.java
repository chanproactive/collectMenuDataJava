
package com.collectMenuDataJava.collectMenuDataJava.tools.googleRequestModel;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestModel {

    @SerializedName("features")
    @Expose
    private ArrayList<FeatureModel> features = new ArrayList<>();

    @SerializedName("image")
    @Expose
    private ImageModel image;

    @SerializedName("imageContext")
    @Expose
    private  ImageContext imageContext;

    public List<FeatureModel> getFeatures() {
        return features;
    }

    public void setFeatures(ArrayList<FeatureModel> features) {
        this.features = features;
    }

    public ImageModel getImage() {
        return image;
    }

    public void setImage(ImageModel image) {
        this.image = image;
    }

    public ImageContext getImageContext() {
        return imageContext;
    }

    public  void setImageContext(ImageContext imageContext) {
        this.imageContext = imageContext;
    }
}
