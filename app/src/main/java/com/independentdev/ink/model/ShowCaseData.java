package com.independentdev.ink.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sanjayjith.madhavan on 2/2/2017.
 */

public class ShowCaseData {

    @SerializedName("posterImgPath")
    private String posterImgPath;
    @SerializedName("posterTitle")
    private String posterTitle;

    public ShowCaseData(String posterImgPath, String posterTitle) {
        this.posterImgPath = posterImgPath;
        this.posterTitle = posterTitle;
    }

    public String getPosterImgPath() {
        return posterImgPath;
    }

    public void setPosterImgPath(String posterImgPath) {
        this.posterImgPath = posterImgPath;
    }

    public String getPosterTitle() {
        return posterTitle;
    }

    public void setPosterTitle(String posterTitle) {
        this.posterTitle = posterTitle;
    }
}
