package com.independentdev.ink.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.independentdev.ink.R;
import com.independentdev.ink.adapter.LoginPagerAdapter;
import com.independentdev.ink.helper.CommonMethods;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = LoginActivity.class.getSimpleName();

    @BindView(R.id.loginContainer)
    ViewPager loginPager;
    @BindView(R.id.loginCoverIMV)
    ImageView loginCoverPic;
    @BindView(R.id.loginGo)
    FloatingActionButton loginGoFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        Glide.with(getApplicationContext())
                .load(R.raw.login_cover_pic)
                .asGif()
                .into(loginCoverPic);

        LoginPagerAdapter loginPagerAdapter = new LoginPagerAdapter(getSupportFragmentManager());
        loginPager.setAdapter(loginPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.loginTabs);
        tabLayout.setupWithViewPager(loginPager);

        if (CommonMethods.isAboveLolipop())
            loginGoFAB.setElevation(12);

        loginGoFAB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.loginGo:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }
}
