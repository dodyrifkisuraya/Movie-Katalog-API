package com.dorizu.ms3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_TITLE        = "extra_title";
    public static String EXTRA_OVERVIEW     = "extra_overview";
    public static String EXTRA_RELEASE_DATE = "extra_release_date";
    public static String EXTRA_POSTER_JPG   = "extra_poster_jpg";
    public static String EXTRA_RATE_COUNT   = "extra_rate_count";
    public static String EXTRA_RATE         = "extra_rate";
    public static String EXTRA_LANG         = "extra_lang";

    private TextView tvJudul,tvRating, tvRilis, tvOverview, tvOrilang;
    private ImageView imgThumnail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.back);
        setSupportActionBar(toolbar);


        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });


        tvJudul = findViewById(R.id.tv_judul);
        tvRating = findViewById(R.id.tv_rating);
        tvRilis = findViewById(R.id.tv_rilis);
        tvOverview = findViewById(R.id.tv_overview);
        tvOrilang = findViewById(R.id.tv_lang);
        imgThumnail = findViewById(R.id.img_thumnail);
        tvOrilang = findViewById(R.id.tv_lang);

        String title = getIntent().getStringExtra(EXTRA_TITLE);
        String overview = getIntent().getStringExtra(EXTRA_OVERVIEW);
        String rating = getIntent().getStringExtra(EXTRA_RATE);
        String rating_count = getIntent().getStringExtra(EXTRA_RATE_COUNT);
        String poster_jpg = getIntent().getStringExtra(EXTRA_POSTER_JPG);
        String release_date = getIntent().getStringExtra(EXTRA_RELEASE_DATE);
        String ori_language = getIntent().getStringExtra(EXTRA_LANG);
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = date_format.parse(release_date);

            SimpleDateFormat new_date_format = new SimpleDateFormat("EEEE, MMM dd, yyyy");
            String date_of_release = new_date_format.format(date);
            tvRilis.setText(date_of_release);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        tvJudul.setText(title);
        tvRating.setText("( "+rating+"/10 ) "+rating_count+" Ratingers");
        tvOverview.setText(overview);
        tvOrilang.setText(ori_language);
        Picasso.with(getApplicationContext()).load("http://image.tmdb.org/t/p/w342/"+poster_jpg).into(imgThumnail);

    }
}
