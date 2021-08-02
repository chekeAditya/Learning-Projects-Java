package com.example.apicallingusingdynamicfragment;

import com.example.apicallingusingdynamicfragment.Model.ResponseModelItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("{userName}/{userId}/{raw}/{id}/{brokerName}")
    Call<List<ResponseModelItem>> data(@Path("userName") String userName,
                                       @Path("userId") String userId,
                                       @Path("raw") String raw,
                                       @Path("id") String id,
                                       @Path("brokerName") String brokerName
    );

}
/*
https://gist.githubusercontent.com/shivarajp/2cbe00030c04472c9d8ad4b0ec112dbe/raw/c651391e428182f08d60d59e79073f3fcf79b858/nobroker
 */
