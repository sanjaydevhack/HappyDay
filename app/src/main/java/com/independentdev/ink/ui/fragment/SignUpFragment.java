package com.independentdev.ink.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.independentdev.ink.R;

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
    }

    public void doSignup(Context context) {
        Toast.makeText(context, "SignUp", Toast.LENGTH_SHORT).show();
    }
}
