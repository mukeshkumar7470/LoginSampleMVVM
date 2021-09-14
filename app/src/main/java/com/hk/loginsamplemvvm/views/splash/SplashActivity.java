package com.hk.loginsamplemvvm.views.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.hk.loginsamplemvvm.views.login.LoginActivity;
import com.hk.loginsamplemvvm.R;
import com.hk.loginsamplemvvm.databinding.ActivityMainBinding;

public class SplashActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpViewBindings();
        startHandlerDelay();
        getSupportActionBar().hide();
    }

    //Setting up the View model and Data binding for the view
    private void setUpViewBindings() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.executePendingBindings();
    }

    //Method to add delay in order to show static loader of loading here...
    private void startHandlerDelay() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        }, 3000);
    }
}