package com.androidbuts.jsonparsing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidbuts.jsonparsing.R;
import com.androidbuts.jsonparsing.model.Favorite;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyFavoriteAdapter extends ArrayAdapter<Favorite> {

    List<Favorite> FavoriteList;
    Context context;
    private LayoutInflater mInflater;

    // Constructors
    public MyFavoriteAdapter(Context context, List<Favorite> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        FavoriteList = objects;
    }

    @Override
    public Favorite getItem(int position) {
        return FavoriteList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.layout_row_view, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Favorite item = getItem(position);

        vh.textViewTitle.setText(item.getTitle());
        vh.textViewDesc.setText(item.getDesc());
        Picasso.with(context).load(item.getImageUrl()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.imageView);

        return vh.rootView;
    }

    /**
     * ViewHolder class for layout.<br />
     * <br />
     * Auto-created on 2016-01-05 00:50:26 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private static class ViewHolder {
        public final RelativeLayout rootView;
        public final ImageView imageView;
        public final TextView textViewTitle;
        public final TextView textViewDesc;

        private ViewHolder(RelativeLayout rootView, ImageView imageView, TextView textViewName, TextView textViewEmail) {
            this.rootView = rootView;
            this.imageView = imageView;
            this.textViewTitle = textViewName;
            this.textViewDesc = textViewEmail;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageUrl);
            TextView textViewName = (TextView) rootView.findViewById(R.id.textViewTitle);
            TextView textViewEmail = (TextView) rootView.findViewById(R.id.textViewDesc);
            return new ViewHolder(rootView, imageView, textViewName, textViewEmail);
        }
    }
}
