package com.fiek.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PostsActivity extends AppCompatActivity {

    OkHttpClient client = new OkHttpClient();
    ListView lvPosts;
    ProgressBar progressBarPosts;
    PostsAdapter postsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        progressBarPosts = findViewById(R.id.progressBarPosts);
        lvPosts = findViewById(R.id.lvPosts);

        postsAdapter = new PostsAdapter(PostsActivity.this);
        lvPosts.setAdapter(postsAdapter);

        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .build();

        /*try (Response response = client.newCall(request).execute()) {
            Log.i("ResponseString",response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Looper.prepare();
                Toast.makeText(PostsActivity.this, "Failed to load Posts", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful())
                {
                    Gson gson = new Gson();
                    Type listType = new TypeToken<List<PostClass>>(){}.getType();
                    List<PostClass> responseObjects = (List<PostClass>)gson.fromJson(response.body().string(),
                            listType);

                    for(int i=0;i<responseObjects.size();i++)
                    {

                        postsAdapter.datasource.add(responseObjects.get(i));
                        progressBarPosts.setProgress(i+1);
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            postsAdapter.notifyDataSetChanged();
                        }
                    });
                    //PostClass obj = gson.fromJson(response.body().string(), PostClass.class);
                    Log.i("ResponseString", responseObjects.get(0).getTitle());
                }
            }
        });
    }
}