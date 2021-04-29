package com.example.softwareproject.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.softwareproject.R;

public class InformationActivity extends AppCompatActivity {
  TextView informationTextTV;
  ImageView appLogoIV ;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_information);
    informationTextTV =  findViewById(R.id.informationText_tv);
    appLogoIV = findViewById(R.id.appLogo_iv);

    informationTextTV.setText("In practice, information is usually" +
            "        carried by weak stimuli that must be detected by" +
            "        specialized sensory systems and amplified by energy" +
            "        inputs before they can be functional to the organism or" +
            "        system. For example, light is mainly (but not only, e.g." +
            "        plants can grow in the direction of the lightsource) a causal" +
            "        input to plants but for animals it only provides information." +
            "        The colored light reflected from a flower is too weak for" +
            "         photosynthesis but the visual system of the bee detects it" +
            "          and the bee's nervous system uses the information to guide" +
            "           the bee to the flower, where the bee often finds nectar or pollen," +
            "         which are causal inputs, serving a nutritional function.");
  }
}
