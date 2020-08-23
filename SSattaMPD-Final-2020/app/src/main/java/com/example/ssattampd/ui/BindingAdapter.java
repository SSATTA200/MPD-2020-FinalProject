package com.example.ssattampd.ui;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.ssattampd.data.models.Channel;

public class BindingAdapter {

    @androidx.databinding.BindingAdapter({"channel"})
    public static void loadImage(ImageView imageView, Channel channel) {

        if (channel != null) {

            Log.d("com.test", "channel image> " + channel.getImage().getUrl());
            Glide.with(imageView)
                    .load(channel.getImage().getUrl())
                    .apply(
                            new RequestOptions().transform(
                                    new RoundedCorners(5)
                            )
                    )
                    .into(imageView);
        }
    }
}
