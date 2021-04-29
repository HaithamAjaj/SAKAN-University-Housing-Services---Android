package com.example.softwareproject.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.softwareproject.R;

import java.util.ArrayList;

public class HomeAdapter extends BaseAdapter {
  public HomeAdapter(ArrayList<Homes> homeArrayList, Context context) {
    this.homeArrayList = homeArrayList;
    this.context = context;
  }

  ArrayList<Homes> homeArrayList;
  Context context;
  @Override
  public int getCount() {
    return homeArrayList.size();
  }

  @Override
  public Object getItem(int position) {
    return homeArrayList.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    final Homes homeDetails = homeArrayList.get(position);
    View view = LayoutInflater.from(context).inflate(R.layout.home_list_item, null);
    TextView timeTV,descriptionTV,LocHomeTV,GenderTV;

    timeTV = view.findViewById(R.id.time_tv);
    descriptionTV = view.findViewById(R.id.description_tv);
    LocHomeTV = view.findViewById(R.id.Loc_tv);
    GenderTV = view.findViewById(R.id.gender_tv);
    timeTV.setText(homeDetails.reg_date);
    descriptionTV.setText(homeDetails.Description);
    LocHomeTV.setText(homeDetails.Address);
    GenderTV.setText(homeDetails.Gender);
    return view;
  }
}
