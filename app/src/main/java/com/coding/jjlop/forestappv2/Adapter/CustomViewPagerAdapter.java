package com.coding.jjlop.forestappv2.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coding.jjlop.forestappv2.Model.Model;
import com.coding.jjlop.forestappv2.R;
import com.hold1.pagertabsindicator.TabViewProvider;

import java.util.List;

/**
 * Created by jjlop on 05/03/2018.
 */

public class CustomViewPagerAdapter extends PagerAdapter implements TabViewProvider.ImageProvider{

    List<Model> models;
    Context context;

    public CustomViewPagerAdapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page "+(position+1);
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewGroup)container).removeView((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.layout_item,container,false);

        TextView textView= itemView.findViewById(R.id.txtTextView);
        textView.setText(models.get(position).getTitle());

        container.addView(itemView);
        return itemView;
    }

    @Override
    public Uri getImageUri(int i) {
        //Link from Internet
        return null;
    }

    @Override
    public int getImageResourceId(int i) {
        //Local Resoureces
        return models.get(i).getId();
    }
}
