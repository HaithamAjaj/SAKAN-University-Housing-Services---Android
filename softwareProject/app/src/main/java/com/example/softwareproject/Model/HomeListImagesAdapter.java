package com.example.softwareproject.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.softwareproject.R;

import java.util.ArrayList;

public class HomeListImagesAdapter extends BaseAdapter {

  ArrayList<HomeDetails> imageList;
  Context context;
  @Override
  public int getCount() {
    return imageList.size();
  }

  @Override
  public Object getItem(int position) {
    return imageList.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    final HomeDetails homeImage = imageList.get(position);
    View view = LayoutInflater.from(context).inflate(R.layout.photo_grid_home, null);
    ImageView  photoHomeIV= view.findViewById(R.id.photoHome_iv);
    return view;
  }
}
