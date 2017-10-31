package com.adacherSoft.unsplashy.network;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLSocketFactory;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adacher on 10-07-17.
 */

public class UnsplashInterceptor {

    public static final String BASE_URL = "https://api.unsplash.com/photos/";

    public  GetSplash get() {

//        ConnectionSpec spec = new
//                ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
//                .tlsVersions(TlsVersion.TLS_1_2)
//                .build();

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                //.connectionSpecs(Collections.singletonList(spec))
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS);

        try {
            URL url = new URL(BASE_URL);
            SSLSocketFactory NoSSLv3Factory = new NoSSLv3SocketFactory(url);
            httpClient.sslSocketFactory(NoSSLv3Factory);
        } catch (IOException e) {
            e.printStackTrace();
        }

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request request = originalRequest.newBuilder()
                    /*Common headers*/
                        //.header("Accept-Version", "v1")
                        .header("Authorization", "Client-ID 4357c10176620b91d684c0e05c3d5947195d93fa43faba91285b47dce48edfff")
                        .build();

                Response response = chain.proceed(request);

            /*If the request fail then you get 3 retrys*/
                int retryCount = 0;
                while (!response.isSuccessful() && retryCount < 3) {
                    retryCount++;
                    response = chain.proceed(request);
                }

                return response;
            }
        });

        OkHttpClient client = httpClient.build();

        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        GetSplash request = interceptor.create(GetSplash.class);

        return request;



    }
}
