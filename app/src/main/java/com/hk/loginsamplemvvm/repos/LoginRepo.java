package com.hk.loginsamplemvvm.repos;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.hk.loginsamplemvvm.models.LoginModel;
import com.hk.loginsamplemvvm.networking.ApiInterface;
import com.hk.loginsamplemvvm.networking.RetrofitRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepo {
    public MutableLiveData<List<LoginModel>> loginData() {
        final MutableLiveData<List<LoginModel>> postModel = new MutableLiveData<>();

        ApiInterface apiService =
                RetrofitRequest.getRetrofitInstance().create(ApiInterface.class);

        apiService.login().enqueue(new Callback<List<LoginModel>>() {
            @Override
            public void onResponse(Call<List<LoginModel>> call, Response<List<LoginModel>> response) {
                Log.e("response_check", "response="+response );

                if (response.isSuccessful() && response.body()!=null ) {
                    Log.e("responseSuccess", "response"+response.body().size() );
                    postModel.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<LoginModel>> call, Throwable t) {
                Log.e("responseFailed", "getProdList onFailure" + call.toString());
            }
        });

        return postModel;
    }
}
