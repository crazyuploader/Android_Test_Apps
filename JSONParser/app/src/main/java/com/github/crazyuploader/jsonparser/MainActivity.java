package com.github.crazyuploader.jsonparser;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView postHolder;
    Retrofit retrofit;
    final String baseURL = "https://jsonplaceholder.typicode.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postHolder = findViewById(R.id.postHolder);

        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostAPI globalStatisticsAPI = retrofit.create(PostAPI.class);

        Call<List<Post>> call = globalStatisticsAPI.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    postHolder.setText("Response: " + response.code());
                }
                else {
                    List<Post> posts = response.body();
                    for (Post post : posts) {
                        String content = "";
                        content += "ID: " + post.getUserID() + "\n";
                        content += "Post ID: " + post.getPostID() + "\n";
                        content += "Title: " + post.getTitle() + "\n";
                        content += "Body: " + post.getText() + "\n\n";
                        postHolder.append(content);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                postHolder.setText(t.getMessage());
            }
        });
    }
}
