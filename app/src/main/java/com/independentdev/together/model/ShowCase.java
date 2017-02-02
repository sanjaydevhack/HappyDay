package com.independentdev.together.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sanjayjith.madhavan on 2/2/2017.
 */

public class ShowCase {

    @SerializedName("data")
    private List<ShowCaseData> showCaseDataList;

    public ShowCase(List<ShowCaseData> showCaseDataList) {
        this.showCaseDataList = showCaseDataList;
    }

    public List<ShowCaseData> getShowCaseDataList() {
        return showCaseDataList;
    }

    public void setShowCaseDataList(List<ShowCaseData> showCaseDataList) {
        this.showCaseDataList = showCaseDataList;
    }
}
