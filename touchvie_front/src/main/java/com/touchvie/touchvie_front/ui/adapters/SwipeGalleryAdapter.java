package com.touchvie.touchvie_front.ui.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.Image;
import com.touchvie.touchvie_client.data.ImageSize;
import com.touchvie.touchvie_client.manager.ClientManager;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.fragments.SwipeGallery;
import com.touchvie.touchvie_front.ui.other.CustomTypefaceSpan;
import com.touchvie.touchvie_front.ui.utils.Utils;
import com.touchvie.touchvie_front.ui.views.TouchImageView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 11/10/2016.
 */

public class SwipeGalleryAdapter extends PagerAdapter {

    private SwipeGallery.OnSwipeGalleryListener listener;
    private ArrayList<Image> images;
    Picasso mPicasso;

    private LayoutInflater inflater;
    private Context context;

    private Typeface mLatoRegular;

    /**
     * Instantiates a new Full screen image adapter.
     */


    public SwipeGalleryAdapter(Context context, ArrayList<Image> images, SwipeGallery.OnSwipeGalleryListener listener) {

        this.images = images;
        this.mPicasso = Picasso.with(context);
        this.listener = listener;
        this.context=context;
        mLatoRegular= Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR);
    }

    @Override
    public int getCount() {
        return this.images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        TouchImageView imgDisplay;
        TextView sourceView;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View viewLayout = inflater.inflate(R.layout.layout_fullscreen_image, container, false);

        imgDisplay = (TouchImageView) viewLayout.findViewById(R.id.tiv_display);
        sourceView = (TextView) viewLayout.findViewById(R.id.txtv_source_display);

        final Image image= images.get(position);

        if(image.getFull() !=null &&  image.getFull().length()>0 && URLUtil.isValidUrl(image.getFull()) ){
            mPicasso
                    .load(ClientManager.getInstance().getImageUrl(image.getFull(), ImageSize.medium, DisplayMetrics.DENSITY_XHIGH))
                    .into(imgDisplay);
        }


        if(image.getSource() !=null && image.getSource().getName() !=null){

            sourceView.setVisibility(View.VISIBLE);

            if(image.getSource().getUrl() !=null && URLUtil.isValidUrl(image.getSource().getUrl())){
                try {
                    final String source=image.getSource().getUrl();

                    final URL url = new URL(source);

                    Spannable spannable = new SpannableString(context.getResources().getString(R.string.source));

                    spannable.setSpan(new CustomTypefaceSpan(mLatoRegular), 0, spannable.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                    spannable.setSpan(new CustomTypefaceSpan(mLatoRegular), spannable.toString().indexOf(url.getHost()),
                            spannable.toString().indexOf(url.getHost()) + url.getHost().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                    spannable.setSpan(new ClickableTarget(url.toString()), spannable.toString().indexOf(url.getHost()),
                            spannable.toString().indexOf(url.getHost()) + url.getHost().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    sourceView.setText(spannable);
                    sourceView.setMovementMethod(LinkMovementMethod.getInstance());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }else{
                final String source=image.getSource().getName();
                Spannable spannable = new SpannableString(context.getResources().getString(R.string.source));

                spannable.setSpan(new CustomTypefaceSpan(mLatoRegular), 0, spannable.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                spannable.setSpan(new CustomTypefaceSpan(mLatoRegular), spannable.toString().indexOf(source),
                        spannable.toString().indexOf(source) + source.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                sourceView.setText(spannable);
            }
        }
       container.addView(viewLayout);

        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);

    }

    class ClickableTarget extends ClickableSpan {// extend ClickableSpan
        String url;

        public ClickableTarget(String url) {
            super();
            url = url;
        }

        public void onClick(View tv) {
            listener.loadWeb(url);
        }

        public void updateDrawState(TextPaint ds) {// override updateDrawState
            ds.setUnderlineText(false); // set to false to remove underline
        }
    }
}