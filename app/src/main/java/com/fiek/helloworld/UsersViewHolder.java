package com.fiek.helloworld;

import android.view.View;
import android.widget.TextView;

public class UsersViewHolder {
    TextView tvNameSurname, tvEmail;

    public UsersViewHolder(View v)
    {
        tvNameSurname = v.findViewById(R.id.tvNameSurname);
        tvEmail = v.findViewById(R.id.tvEmail);
    }

    public TextView getTvNameSurname() {
        return tvNameSurname;
    }

    public TextView getTvEmail() {
        return tvEmail;
    }
}
