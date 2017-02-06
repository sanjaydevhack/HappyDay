package com.independentdev.writer.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.independentdev.writer.R;
import com.independentdev.writer.adapter.ShowCasePagerAdapter;
import com.independentdev.writer.model.ShowCase;
import com.independentdev.writer.model.ShowCaseData;
import com.independentdev.writer.util.AlertDialogFragment;
import com.independentdev.writer.util.ApiClient;
import com.independentdev.writer.util.ApiInterface;
import com.independentdev.writer.util.MyAppCompactActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends MyAppCompactActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.showCaseViewPager)
    ViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.testImg)
    ImageView testImg;
    @BindView(R.id.content_main)
    LinearLayout contentMainLay;

    private List<ShowCaseData> showCaseDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        makeShowCaseReq();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment = AlertDialogFragment.newInstance("Title",
                        "Message", "Yes", "No");
                dialogFragment.show(getSupportFragmentManager(), "dialogFragment");
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void makeShowCaseReq() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ShowCase> call = apiService.getShowCaseData();
        call.enqueue(new Callback<ShowCase>() {
            @Override
            public void onResponse(Call<ShowCase> call, Response<ShowCase> response) {
                int statusCode = response.code();
                showCaseDataList = response.body().getShowCaseDataList();
                if (showCaseDataList != null) {
                    ShowCasePagerAdapter showCasePagerAdapter = new ShowCasePagerAdapter(getApplicationContext(), showCaseDataList);
                    viewPager.setAdapter(showCasePagerAdapter);
                    viewPager.setCurrentItem(1);
                    //viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

                    // Disable clip to padding
                    viewPager.setClipToPadding(false);
                    // set padding manually, the more you set the padding the more you see of prev & next page
                    viewPager.setPadding(100, 0, 100, 0);
                    // sets a margin b/w individual pages to ensure that there is a gap b/w them
                    viewPager.setPageMargin(20);
                }
            }

            @Override
            public void onFailure(Call<ShowCase> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_camera:
                break;
            case R.id.nav_gallery:
                break;
            case R.id.nav_slideshow:
                break;
            case R.id.nav_manage:
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_send:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void doPositiveClick() {
        Snackbar.make(contentMainLay, "Clicked Yes", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void doNegativeClick() {
        Snackbar.make(contentMainLay, "Clicked No", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
