package com.independentdev.together.util;

import com.independentdev.together.model.ShowCase;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sanjayjith.madhavan on 2/1/2017.
 */

public interface ApiInterface {

    @GET("showCase.json")
    Call<ShowCase> getShowCaseData();
}
