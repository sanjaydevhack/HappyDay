package com.independentdev.ink.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.independentdev.ink.ui.fragment.SignInFragment;
import com.independentdev.ink.ui.fragment.SignUpFragment;

/**
 * Created by sanjayjith.madhavan on 2/16/2017.
 */

public class LoginPagerAdapter extends FragmentPagerAdapter {

    public LoginPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SignInFragment();
            case 1:
                return new SignUpFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Sign in";
            case 1:
                return "Sign up";
        }
        return null;
    }
}
