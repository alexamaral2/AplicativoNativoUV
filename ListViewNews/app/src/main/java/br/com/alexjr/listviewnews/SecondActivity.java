package br.com.alexjr.listviewnews;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        int imageResId = getIntent().getIntExtra("imageResId", -1);
        String fullText = getIntent().getStringExtra("fullText");
        String author = getIntent().getStringExtra("author");

        TextView titleTextView = findViewById(R.id.news_title);
        TextView descriptionTextView = findViewById(R.id.news_description);
        TextView authorTextView = findViewById(R.id.news_author);
        ImageView imageView = findViewById(R.id.news_image);
        TextView fullTextView = findViewById(R.id.full_text);

        titleTextView.setText(title);
        descriptionTextView.setText(description);
        if (author != null) {
            authorTextView.setText(author);
        }

        if (imageResId != -1) {
            imageView.setImageResource(imageResId);
        }

        if (fullText != null) {
            fullTextView.setText(fullText);
        }
    }
}
