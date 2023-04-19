package com.fiek.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends BaseAdapter {
    List<UserModel> usersDataSet = new ArrayList<>();
    Context c;

    public UsersAdapter(Context _context)
    {
        c = _context;
//        UserModel user1 = new UserModel(1,"Filan", "Fisteku", "filan.fisteku");
//        UserModel user2 = new UserModel(2,"Albatros", "Gashi", "albatros.gashi");
//        usersDataSet.add(user1);
//        usersDataSet.add(user2);
    }

    @Override
    public int getCount() {
        return usersDataSet.size();
    }

    @Override
    public Object getItem(int i) {
        return usersDataSet.get(i);
    }

    @Override
    public long getItemId(int i) {
        return usersDataSet.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        UsersViewHolder viewHolder;

        if(view==null)
        {
            view = LayoutInflater.from(c)
                    .inflate(R.layout.row_layout,viewGroup,false);
            viewHolder = new UsersViewHolder(view);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (UsersViewHolder) view.getTag();
        }

        viewHolder.getTvNameSurname().setText(usersDataSet.get(i).getName()+" "+usersDataSet.get(i).getSurname());
        viewHolder.getTvEmail().setText(usersDataSet.get(i).getUsername());

        return view;
    }
}
