package com.hk.loginsamplemvvm.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hk.loginsamplemvvm.models.LoginModel;
import com.hk.loginsamplemvvm.repos.LoginRepo;

import java.util.List;

public class LoginViewModel extends ViewModel {
    LoginRepo apiRepo;
    MutableLiveData<List<LoginModel>> getPosts;

    public LoginViewModel () {
        apiRepo = new LoginRepo();
    }

    public LiveData<List<LoginModel>> getPostData () {
        if (getPosts == null) {
            getPosts = apiRepo.loginData();
        }

        return getPosts;
    }
}
