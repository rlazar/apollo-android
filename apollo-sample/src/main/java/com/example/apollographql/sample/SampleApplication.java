package com.example.apollographql.sample;

import android.app.Application;

import com.apollographql.android.ApolloCall;
import com.apollographql.android.impl.ApolloClient;

import java.util.concurrent.Executor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class SampleApplication extends Application {

  private static final String BASE_URL = "https://githunt-api.herokuapp.com/graphql";
  private ApolloClient apolloClient;
  private Executor executor = new MainThreadExecutor();

  @Override public void onCreate() {
    super.onCreate();
    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient okHttpClient = new OkHttpClient.Builder()
        .addNetworkInterceptor(loggingInterceptor)
        .build();

    apolloClient = ApolloClient.<ApolloCall>builder()
            .serverUrl(BASE_URL)
            .okHttpClient(okHttpClient)
            .build();
  }

  public ApolloClient apolloClient() {
    return apolloClient;
  }

  public Executor executor() {
    return executor;
  }
}
