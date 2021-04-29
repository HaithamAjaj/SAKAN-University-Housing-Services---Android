package com.example.softwareproject.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.softwareproject.HomesListActivity;
import com.example.softwareproject.R;

public class ProfileActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile);
  }

  public void goToSettings(View view) {
    Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
    startActivity(intent);
  }

  public void goToInformation(View view) {
    Intent intent = new Intent(ProfileActivity.this, InformationActivity.class);
    startActivity(intent);
  }


}
