package com.independentdev.ink.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.independentdev.ink.R;
import com.independentdev.ink.adapter.LoginPagerAdapter;
import com.independentdev.ink.helper.CommonMethods;
import com.independentdev.ink.helper.MyAppCompactActivity;
import com.independentdev.ink.ui.fragment.SignInFragment;
import com.independentdev.ink.ui.fragment.SignUpFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends MyAppCompactActivity implements View.OnClickListener {

    private static final String TAG = LoginActivity.class.getSimpleName();

    @BindView(R.id.loginContainer)
    ViewPager loginPager;
    @BindView(R.id.loginCoverIMV)
    ImageView loginCoverPic;
    @BindView(R.id.loginGo)
    FloatingActionButton loginGoFAB;

    LoginPagerAdapter loginPagerAdapter;

    SignInFragment signInFragment;
    SignUpFragment signUpFragment;

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

        signInFragment = new SignInFragment();
        signUpFragment = new SignUpFragment();

        loginPagerAdapter = new LoginPagerAdapter(getSupportFragmentManager(), signInFragment, signUpFragment);
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

                int position = loginPager.getCurrentItem();
                if (position == 0)
                    loginPagerAdapter.signInFragment.validateLogInCred(getApplicationContext());
                else
                    loginPagerAdapter.signUpFragment.validateSignUp(getApplicationContext());

                break;
        }
    }

    @Override
    public void doPositiveClick() {

    }

    @Override
    public void doNegativeClick() {

    }

}
