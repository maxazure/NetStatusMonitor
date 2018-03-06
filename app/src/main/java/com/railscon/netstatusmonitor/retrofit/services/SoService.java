package com.railscon.netstatusmonitor.retrofit.services;

import com.railscon.netstatusmonitor.retrofit.model.Lesson;
import com.railscon.netstatusmonitor.retrofit.model.Version;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SoService {
    @GET("get-version")
    Call<Version> getVersion();

    @GET("get-lessons")
    Call<Lesson[]> getLessons();

}
