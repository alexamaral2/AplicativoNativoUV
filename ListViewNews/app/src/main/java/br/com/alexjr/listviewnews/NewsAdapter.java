package br.com.alexjr.listviewnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, List<News> newsList) {
        super(context, 0, newsList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News news = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.news_list, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.newsImage);
        TextView titleView = convertView.findViewById(R.id.newsTitle);
        TextView descriptionView = convertView.findViewById(R.id.newsDescription);

        imageView.setImageResource(news.getImageResId());
        titleView.setText(news.getTitle());
        descriptionView.setText(news.getDescription());

        return convertView;
    }
}
