package com.independentdev.writer.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.independentdev.writer.R;
import com.independentdev.writer.model.ShowCaseData;

import java.util.List;

/**
 * Created by sanjayjith.madhavan on 2/1/2017.
 */

public class ShowCasePagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<ShowCaseData> showCaseDataList;

    public ShowCasePagerAdapter(Context mContext, List<ShowCaseData> showCaseDataList) {
        this.mContext = mContext;
        this.showCaseDataList = showCaseDataList;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.show_case_fragment, container, false);
        container.addView(layout);

        ImageView showCaseSlideIMV = (ImageView) layout.findViewById(R.id.showCaseSlideIMV);
        TextView showCaseTitle = (TextView) layout.findViewById(R.id.showCaseTitle);

        ShowCaseData showCaseData = showCaseDataList.get(position);

        Glide.with(mContext).load(showCaseData.getPosterImgPath())
                .fitCenter()
                .error(R.drawable.ic_menu_camera)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(showCaseSlideIMV);
        showCaseTitle.setText(showCaseData.getPosterTitle());


        return layout;
    }

    @Override
    public int getCount() {
        return showCaseDataList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);
    }
}
