package com.apps.emdad.adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.apps.emdad.R;
import com.apps.emdad.models.PhotosModel;
import com.apps.emdad.models.SliderModel;
import com.apps.emdad.tags.Tags;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends PagerAdapter {
    private List<SliderModel.Data> list;
    private Context context;
    private LayoutInflater inflater;


    public SliderAdapter(List<SliderModel.Data> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = inflater.inflate(R.layout.slider_row,container,false);
        ImageView imageView = view.findViewById(R.id.image);
        Picasso.get().load(Uri.parse(Tags.IMAGE_URL+list.get(position).getImage())).fit().into(imageView);
      //  Log.e("ccccccccccc",Tags.IMAGE_URL+list.get(position).getImage());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
