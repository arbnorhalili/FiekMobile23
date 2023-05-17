package com.fiek.helloworld;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PostsViewHolder {

    TextView tvTitle, tvBody;
    RelativeLayout relPosts;

    public PostsViewHolder(View v)
    {
        tvTitle = v.findViewById(R.id.tvTitle);
        tvBody = v.findViewById(R.id.tvBody);
        relPosts = v.findViewById(R.id.layPost);
    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public TextView getTvBody() {
        return tvBody;
    }

    public RelativeLayout getRelPosts() {
        return relPosts;
    }
}
