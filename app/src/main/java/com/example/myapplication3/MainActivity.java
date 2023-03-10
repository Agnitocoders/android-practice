package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    String fruitList[] = { "apple", "mango", " orange", "banana" , "strawbarry"};
    int fruitImages [] = { R.drawable.apple, R.drawable.banana, R.drawable.mango, R.drawable.orange, R.drawable.strawbarry };
    public static String api = "https://jsonplaceholder.typicode.com/";
    List<userModel>  allUsersList;

        ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView ) findViewById(R.id.customeListView);
        CustomeBaseAdapter customBaseAdapter = new CustomeBaseAdapter(getApplicationContext(), fruitList, fruitImages);
        listView.setAdapter(customBaseAdapter);

        RetrofitInstance.getInstance().apiInterface.getUsers().enqueue(new Callback<List<userModel>>() {
            @Override
            public void onResponse(Call<List<userModel>> call, Response<List<userModel>> response) {
                Log.e("api", "onFailure: "+ response.body().toString());
                allUsersList = response.body();

                for(int i=0; i<allUsersList.size();i++){
                    Log.e("api", "onResponse: "+allUsersList.get(i).getTitle());
                }
            }

            @Override
            public void onFailure(Call<List<userModel>> call, Throwable t) {
                Log.e("api", "onFailure: "+t.getLocalizedMessage());
            }
        });

    }
}