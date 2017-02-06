package com.independentdev.ink.viewbinder;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import com.independentdev.ink.R;

import butterknife.BindView;

/**
 * Created by sanjayjith.madhavan on 2/3/2017.
 */

public class MainActivityBind {

    @BindView(R.id.showCaseViewPager)
    ViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    public MainActivityBind() {
    }
}
