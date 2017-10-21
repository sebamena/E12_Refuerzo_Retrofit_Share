package com.adacherSoft.unsplashy.background;

import android.os.AsyncTask;
import android.util.Log;

import com.adacherSoft.unsplashy.models.Unsplash;
import com.adacherSoft.unsplashy.network.GetSplash;
import com.adacherSoft.unsplashy.network.UnsplashInterceptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * xc
 * Created by adacher on 10-07-17.
 */

public class GetDataSplash extends AsyncTask<Void, Void, List<Unsplash>> {

    @Override
    protected List<Unsplash> doInBackground(Void... params) {

        GetSplash request = new UnsplashInterceptor().get();
        Call<List<Unsplash>> call = request.getRandom(10);

        List<Unsplash> list = new ArrayList<>();

        try {
            Response<List<Unsplash>> response = call.execute();

            Log.d("CODE", String.valueOf(response.code()));

            if (response.code() == 200 && response.isSuccessful()){

                if (response.body().size()>0){

                    list = response.body();

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return list;

    }


}



