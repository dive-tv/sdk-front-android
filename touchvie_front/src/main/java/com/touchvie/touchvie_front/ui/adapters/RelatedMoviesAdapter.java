package com.touchvie.touchvie_front.ui.adapters;

/**
 * Adapter to present a search movie list to do synchronization.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.Movies;
import com.touchvie.touchvie_client.interfaces.OauthObjectInterface;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.listeners.CardDetailListener;
import com.touchvie.touchvie_front.ui.utils.CropSquareTransformation;


public class RelatedMoviesAdapter extends BaseAdapter {

    private final Movies[] movies;
    private final Picasso mPicasso;
    private final CardDetailListener mListener;
    private Context context;
    private LayoutInflater mInflater;
    private OauthObjectInterface auth;
    /**
     * Constructor.
     * @param context
     * @param movies
     * @param mListener
     */
    public RelatedMoviesAdapter(Context context, Movies[] movies, OauthObjectInterface auth, CardDetailListener mListener) {
        this.context = context;
        this.movies = movies;
        this.mInflater = LayoutInflater.from(context);
        this.mPicasso = Picasso.with(context);
        this.mListener = mListener;
        this.auth = auth;
    }

    /**
     * The number of items in the list. It is determined by the number of speeches in our array.
     *
     * @returns {int} length. The number of items in the providers list.
     */
    @Override
    public int getCount() {
        return movies.length;
    }

    /**
     * Since the data comes from an array, just returning the index is sufficient
     * to get at the data. If we were using a more complex data structure, we
     * would return whatever object represents one row in the list.
     *
     * @param {int} position. The object's position in the array.
     * @returns {Object} position. The object's position in the array
     */
    @Override
    public Object getItem(int position) {
        return movies[position];
    }

    /**
     * Since the data comes from an array, just returning the index is sufficient
     * to get at the data. If we were using a more complex data structure, we
     * would return whatever object represents one row in the list.
     *
     * @param {int} position. The object's position in the array.
     * @returns {Object} position. The object's position in the array
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Makes a view to hold each row.
     *
     * @param {int}       position. The item's position in the array.
     * @param {View}      convertView. The provider's list view.
     * @param {ViewGroup} parent. The view group that holds the provider's view.
     * @returns {View} convertView. The view to hold each row.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RelatedMoviesViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.module_related_movies_row, null);
            holder = new RelatedMoviesViewHolder();
            holder.row = (LinearLayout) convertView.findViewById(R.id.module_related_movies_row_container);
            holder.photo = (ImageView) convertView.findViewById(R.id.module_related_movies_row_photo);
            holder.title = (TextView) convertView.findViewById(R.id.module_related_movies_row_title);
            holder.subtitle = (TextView) convertView.findViewById(R.id.module_related_movies_row_subtitle);
            convertView.setTag(holder);
        } else {
            holder = (RelatedMoviesViewHolder) convertView.getTag();
        }
        final Movies relatedMovie = movies[position];
        //Photo
        if (relatedMovie.getImage() != null && relatedMovie.getImage().length() > 0) {
            mPicasso
                    .load(relatedMovie.getImage())
//                    .transform(new CropSquareTransformation((int)context.getResources().getDimension(R.dimen.module_related_movies_row_photo_width), (int)context.getResources().getDimension(R.dimen.module_related_movies_row_photo_height),relatedMovie.getAnchor_x(),relatedMovie.getAnchor_y()))
                    .into(holder.photo);
            holder.photo.setVisibility(View.VISIBLE);
        } else {
            holder.photo.setVisibility(View.GONE);
        }

        //text
        if (relatedMovie.getTitle() != null && relatedMovie.getTitle().length() > 0) {
            holder.title.setText(relatedMovie.getTitle());
        } else {
            holder.title.setText("");
        }

        //Subtitle
        if (relatedMovie.getSubtitle() != null && relatedMovie.getSubtitle().length() > 0) {
            holder.subtitle.setText(relatedMovie.getSubtitle());
        } else {
            holder.subtitle.setText("");
        }

        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mListener.goToNewCard(relatedMovie.getMovie_id())
                mListener.goToNewCard("2", auth);
            }
        });

        return convertView;
    }


    private class RelatedMoviesViewHolder {
        LinearLayout row;
        ImageView photo;
        TextView title;
        TextView subtitle;
    }
}
