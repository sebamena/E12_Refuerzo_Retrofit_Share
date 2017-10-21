package com.adacherSoft.unsplashy.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.adacherSoft.unsplashy.R;
import com.adacherSoft.unsplashy.adapter.UnsplashyAdapter;
import com.adacherSoft.unsplashy.background.GetDataSplash;
import com.adacherSoft.unsplashy.models.Unsplash;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    private UnsplashyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        adapter = new UnsplashyAdapter();
        new Async().execute();
    }

    private class Async extends GetDataSplash {

        @Override
        protected void onPostExecute(List<Unsplash> unsplashes) {
            adapter.update(unsplashes);
        }


    }

}
