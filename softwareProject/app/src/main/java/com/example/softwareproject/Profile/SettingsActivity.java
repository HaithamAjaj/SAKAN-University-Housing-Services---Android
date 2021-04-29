package com.example.softwareproject.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.softwareproject.HomesListActivity;
import com.example.softwareproject.R;

public class SettingsActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_settings);
  }

  public void goToNameSetting(View view) {
    Intent intent = new Intent(SettingsActivity.this, NameSettingActivity.class);
    startActivity(intent);
  }

  public void goToPhoneNumberSetting(View view) {
    Intent intent = new Intent(SettingsActivity.this, PhoneNumberSettingActivity.class);
    startActivity(intent);
  }


  public void goToPasswordSetting(View view) {
    Intent intent = new Intent(SettingsActivity.this, PasswordSettingActivity.class);
    startActivity(intent);
  }


  public void goToEmailSetting(View view) {
        Intent intent = new Intent(SettingsActivity.this, EmailSettingActivity.class);
        startActivity(intent);

  }
}
