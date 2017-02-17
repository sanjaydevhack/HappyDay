package com.independentdev.ink.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import com.independentdev.ink.R;
import com.independentdev.ink.helper.MyAppCompactActivity;

/**
 * Created by sanjayjith.madhavan on 1/31/2017.
 */

public class AlertDialogFragment extends DialogFragment {

    public static AlertDialogFragment newInstance(String mTitle, String mMessage, String positiveTxt, String negativeTxt) {
        AlertDialogFragment frag = new AlertDialogFragment();
        Bundle args = new Bundle();
        args.putString("mTitle", mTitle);
        args.putString("mMessage", mMessage);
        args.putString("positiveTxt", positiveTxt);
        args.putString("negativeTxt", negativeTxt);

        frag.setArguments(args);
        return frag;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String mTitle = getArguments().getString("mTitle");
        String mMessage = getArguments().getString("mMessage");
        String positiveTxt = getArguments().getString("positiveTxt");
        String negativeTxt = getArguments().getString("negativeTxt");

        return new AlertDialog.Builder(getActivity(), R.style.MyDialogTheme).setTitle(mTitle).setMessage(mMessage)
                .setPositiveButton(positiveTxt, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((MyAppCompactActivity) getActivity()).doPositiveClick();
                    }
                }).setNegativeButton(negativeTxt, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((MyAppCompactActivity) getActivity()).doNegativeClick();
                    }
                }).create();
    }
}
