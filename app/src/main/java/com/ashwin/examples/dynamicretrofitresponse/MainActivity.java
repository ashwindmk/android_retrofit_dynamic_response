package com.ashwin.examples.dynamicretrofitresponse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        fetchDynamicResponse();

        //fetchNestedDynamicResponse();
    }

    private void fetchDynamicResponse() {
        RetrofitService service = RetrofitClient.getRetrofit().create(RetrofitService.class);
        Call<ResponseBody> call = service.getDynamicProfile();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    JSONObject json = new JSONObject(response.body().string());
                    Log.d("debug-log", "response: " + json);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("debug-log", "response: " + t.toString(), t);
            }
        });
    }

    private void fetchNestedDynamicResponse() {
        RetrofitService service = RetrofitClient.getRetrofit().create(RetrofitService.class);
        Call<Profile> call = service.getProfile();
        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (response.isSuccessful()) {
                    Log.d("debug-log", "response body: " + response.body().toString());
                    Profile profile = response.body();
                    JSONObject address = profile.getAddress();
                    Log.d("debug-log", "address: " + String.valueOf(address));
                } else {
                    Log.e("debug-log", "response not successful");
                }
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                Log.e("debug-log", "response failure: " + t.toString());
            }
        });
    }
}
