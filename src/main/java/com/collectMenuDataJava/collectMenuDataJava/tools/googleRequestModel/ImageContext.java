
package com.collectMenuDataJava.collectMenuDataJava.tools.googleRequestModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageContext {

    @SerializedName("languageHints")
    @Expose
    private List<String> languageHints;

    public List<String> getLanguageHints() {
        return languageHints;
    }

    public void setLanguageHints(List<String> languageHints) {
        this.languageHints = languageHints;
    }

}
