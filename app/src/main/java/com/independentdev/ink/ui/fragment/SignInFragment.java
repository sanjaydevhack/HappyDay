package com.independentdev.ink.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.independentdev.ink.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sanjayjith.madhavan on 2/16/2017.
 */

public class SignInFragment extends Fragment {

    private static final String TAG = SignUpFragment.class.getSimpleName();

    @BindView(R.id.userNameET)
    EditText userNameET;
    @BindView(R.id.userPasswordET)
    EditText userPasswordET;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_sign_in, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    public void validateLogInCred(Context context) {
        String userNameStr = userNameET.getText().toString();
        String userPasswordStr = userPasswordET.getText().toString();

        if (!userNameStr.isEmpty()) {
            userNameET.setError(null);
            if (!(userNameStr.length() < 6)) {
                userNameET.setError(null);
                if (!userPasswordStr.isEmpty()) {
                    userPasswordET.setError(null);
                    if (!(userPasswordStr.length() < 6)) {
                        userPasswordET.setError(null);

                        doLogin(getContext());

                    } else {
                        userPasswordET.setError("Password is too short...!");
                    }
                } else {
                    userPasswordET.setError("Password cannot be empty...!");
                }
            } else {
                userNameET.setError("Username is too short...!");
            }
        } else {
            userNameET.setError("Username cannot be empty...!");
        }
    }


    public void doLogin(Context context) {

    }

}
