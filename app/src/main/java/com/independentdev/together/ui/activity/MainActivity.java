package com.independentdev.together.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.independentdev.together.R;
import com.independentdev.together.service.api.HelloService;
import com.independentdev.together.service.di.DaggerApplication;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Inject
    HelloService helloService;

    EditText userNameText;
    Button greetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerApplication.component().inject(this);

        userNameText = (EditText) findViewById(R.id.userNameText);
        greetButton = (Button) findViewById(R.id.greet);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        greetButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.greet:
                String greetMessage = helloService.greet(userNameText.getText().toString());

                Snackbar mySnackbar = Snackbar.make(this.findViewById(R.id.activity_main_container),
                        greetMessage,
                        Snackbar.LENGTH_LONG);

                mySnackbar.show();
                break;
        }
    }
}
