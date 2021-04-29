package com.example.softwareproject.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.softwareproject.AddHomesActivity;
import com.example.softwareproject.HomesListActivity;
import com.example.softwareproject.R;

public class FirstActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_first);
  }

  public void view_house_btn(View view) {

    Intent intent = new Intent(FirstActivity.this, HomesListActivity.class);
    startActivity(intent);



  }
  public void add_house_btn(View view) {
    Intent intent = new Intent(FirstActivity.this, AddHomesActivity.class);
    startActivity(intent);

  }
}
