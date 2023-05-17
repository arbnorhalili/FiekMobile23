package com.fiek.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends BaseAdapter {
    Context context;
    List<PostClass> datasource = new ArrayList<>();

    public PostsAdapter(Context _context)
    {
        context = _context;
    }

    @Override
    public int getCount() {
        return datasource.size();
    }

    @Override
    public Object getItem(int i) {
        return datasource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return datasource.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PostsViewHolder viewHolder;

        if(view==null)
        {
            view = LayoutInflater.from(context)
                    .inflate(R.layout.post_row,viewGroup,false);
            viewHolder = new PostsViewHolder(view);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (PostsViewHolder) view.getTag();
        }

        viewHolder.getTvTitle().setText(datasource.get(i).getTitle());
        viewHolder.getTvBody().setText(datasource.get(i).getBody());

        if(i%2==0)
        {
            viewHolder.getRelPosts().setBackgroundColor(context.getColor(android.R.color.white));
        }
        else
        {
            viewHolder.getRelPosts().setBackgroundColor(context.getColor(android.R.color.darker_gray));
        }

        viewHolder.getTvBody().setAnimation(AnimationUtils.loadAnimation(context,R.anim.slide_in_animation));


        return view;
    }
}
