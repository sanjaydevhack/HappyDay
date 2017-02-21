package com.independentdev.ink.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.independentdev.ink.R;
import com.independentdev.ink.helper.CommonMethods;
import com.independentdev.ink.ui.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sanjayjith.madhavan on 2/16/2017.
 */

public class SignUpFragment extends Fragment {

    private static final String TAG = SignUpFragment.class.getSimpleName();

    @BindView(R.id.fullNameET)
    EditText fullNameET;
    @BindView(R.id.mobileNoET)
    EditText mobileNoET;
    @BindView(R.id.emailIdET)
    EditText emailIdET;
    @BindView(R.id.signUpPasswordET)
    EditText signUpPasswordET;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    public void validateSignUp(Context context) {
        String fullNameStr = fullNameET.getText().toString();
        String mobileNoStr = mobileNoET.getText().toString();
        String emailIdStr = emailIdET.getText().toString();
        String signUpPasswordStr = signUpPasswordET.getText().toString();

        if (!fullNameStr.isEmpty()) {
            fullNameET.setError(null);
            if (fullNameStr.length() >= 6) {
                fullNameET.setError(null);
                if (!mobileNoStr.isEmpty()) {
                    mobileNoET.setError(null);
                    if (mobileNoStr.length() >= 10) {
                        mobileNoET.setError(null);
                        if (!emailIdStr.isEmpty()) {
                            emailIdET.setError(null);
                            if (CommonMethods.isEmailValid(emailIdStr)) {
                                emailIdET.setError(null);
                                if (!signUpPasswordStr.isEmpty()) {
                                    signUpPasswordET.setError(null);
                                    if (CommonMethods.isValidPassword(signUpPasswordStr)) {
                                        signUpPasswordET.setError(null);

                                        doSignup(getContext());

                                    } else {
                                        signUpPasswordET.setError("Password should contain atleast one uppercase, number & symbol...!");
                                    }
                                } else {
                                    signUpPasswordET.setError("Password cannot be empty...!");
                                }
                            } else {
                                emailIdET.setError("Enter valid email id");
                            }
                        } else {
                            emailIdET.setError("Email id cannot be empty...!");
                        }
                    } else {
                        mobileNoET.setError("Enter valid mobile number...!");
                    }
                } else {
                    mobileNoET.setError("Mobile number cannot be empty...!");
                }
            } else {
                fullNameET.setError("Username is too short...!");
            }
        } else {
            fullNameET.setError("Username cannot be empty...!");
        }
    }

    public void doSignup(Context context) {
        Toast.makeText(context, "SignUp", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(context, MainActivity.class));
    }
}
