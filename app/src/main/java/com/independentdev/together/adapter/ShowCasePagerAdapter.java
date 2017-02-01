package com.independentdev.together.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.independentdev.together.R;
import com.independentdev.together.model.ShowCase;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sanjayjith.madhavan on 2/1/2017.
 */

public class ShowCasePagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<ShowCase> showCaseList;
    @BindView(R.id.showCaseSlideIMV)
    ImageView showCaseSlideIMV;
    @BindView(R.id.showCaseTitle)
    TextView showCaseTitle;

    public ShowCasePagerAdapter(Context mContext, List<ShowCase> showCaseList) {
        this.mContext = mContext;
        this.showCaseList = showCaseList;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(position, container, false);
        container.addView(layout);

        ShowCase showCase = showCaseList.get(position);

        Glide.with(mContext).load(showCase.getPosterImgPath())
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(showCaseSlideIMV);
        showCaseTitle.setText(showCase.getPosterTitle());


        return layout;
    }

    @Override
    public int getCount() {
        return showCaseList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }


    static class ViewHolder {
        @BindView(R.id.showCaseSlideIMV)
        ImageView showCaseSlideIMV;
        @BindView(R.id.showCaseTitle)
        TextView showCaseTitle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
