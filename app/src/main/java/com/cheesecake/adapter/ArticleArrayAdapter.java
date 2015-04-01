package com.cheesecake.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheesecake.pojo.ArticlePojo;
import com.cheesecake.util.ImageUtil;

import cheesecake.com.com.cheesecake.activity.R;


/**
 * Created by Ricardo Freire on 3/29/15.
 */
public class ArticleArrayAdapter extends ArrayAdapter<ArticlePojo> {

    private final Context context;
    private final ArticlePojo[] values;

    public ArticleArrayAdapter(Context context, ArticlePojo[] values) {
        super(context, R.layout.activity_main_list, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_row, parent, false);

        TextView title = (TextView) rowView.findViewById(R.id.title);
        TextView authors = (TextView) rowView.findViewById(R.id.authors);
        TextView date = (TextView) rowView.findViewById(R.id.date);
        ImageView image = (ImageView) rowView.findViewById(R.id.list_image);

        ArticlePojo article = values[position];
        title.setText(article.getTitle());
        authors.setText(article.getAuthors());
        date.setText(article.getDate());
        image.setImageResource(ImageUtil.getImageResouce(context, article.getWebsite()));

        return rowView;
    }

}
