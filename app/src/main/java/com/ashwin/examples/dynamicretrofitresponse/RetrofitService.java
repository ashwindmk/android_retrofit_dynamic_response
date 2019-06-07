package com.ashwin.examples.dynamicretrofitresponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("profile.json")
    Call<ResponseBody> getDynamicProfile();

    @GET("profile.json")
    Call<Profile> getProfile();
}
