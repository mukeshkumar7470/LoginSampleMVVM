package com.hk.loginsamplemvvm.views.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.hk.loginsamplemvvm.R;
import com.hk.loginsamplemvvm.models.LoginModel;
import com.hk.loginsamplemvvm.viewModels.LoginViewModel;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    LoginViewModel postViewModel = new LoginViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(isNetworkConnectionAvailable()) {
            postViewModel.getPostData().observe(this, new Observer<List<LoginModel>>() {
                @Override
                public void onChanged(List<LoginModel> postModels) {
                    for (int i=0; i<postModels.size(); i++) {
                        Log.d("PostData", "onChangedTitle: "+postModels.get(i).getEmail());
                    }
                }
            });

        }else{
            Toast.makeText(this, "No Network Available", Toast.LENGTH_LONG).show();
        }
    }

    boolean isNetworkConnectionAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) return false;
        NetworkInfo.State network = info.getState();
        return (network == NetworkInfo.State.CONNECTED || network == NetworkInfo.State.CONNECTING);
    }
}