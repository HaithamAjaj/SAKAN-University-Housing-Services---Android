package com.example.softwareproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import com.example.softwareproject.Model.Homes;

public class DetailsHomeActivity extends AppCompatActivity {
  TextView homeNameTV,phoneNumberTV,homeAddressTV,
          numberOfRoomsTV,homeRentTV,homeDescriptionTV,genderTV;
  GridView photoListHomeGV;
    Homes homes ;
  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_details_home);


   // homes = (Homes) getIntent().getExtras().get(Homes.OBJECT_KEY);
    homes = (Homes) getIntent().getExtras().get(homes.OBJECT_KEY);

    //phoneNumberTV = findViewById(R.id.phoneNumber_tv);
    homeAddressTV = findViewById(R.id.homeAddress_tv);
    numberOfRoomsTV = findViewById(R.id.numberOfRooms_tv);
    homeRentTV = findViewById(R.id.homeRent_tv);
    homeDescriptionTV = findViewById(R.id.homeDescription_tv);
    genderTV = findViewById(R.id.gender_tv);
//    photoListHomeGV = findViewById(R.id.photoListHome_gv);


    homeAddressTV.setText(homes.getAddress());
    numberOfRoomsTV.setText(homes.getRooms());
    homeRentTV.setText(homes.getRent());
    homeDescriptionTV.setText(homes.getDescription());
    genderTV.setText(homes.getGender());


  }
  /*
  private class DataRetrieveTask extends AsyncTask<Void, Void, AllUsersMessage>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected AllUsersMessage doInBackground(Void... voids) {

            try{
                String result = "";

                HttpURLConnection urlConnection;
                BufferedReader reader = null;

                URL url = null;

                url = new URL("https://reqres.in/api/users");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setDoInput(true);
                urlConnection.setRequestMethod("GET");

                urlConnection.connect();

                InputStream stream = urlConnection.getInputStream();
                InputStreamReader streamReader = new InputStreamReader(stream);
                BufferedReader bufferedReader = new BufferedReader(streamReader);
                String str;
                while (true) {
                    str = bufferedReader.readLine();
                    if (str == null)
                        break;
                    result += str;
                }

                Gson jsonParser = new Gson();

                AllUsersMessage message = jsonParser.fromJson(result, AllUsersMessage.class);

                // helper.insertUsers( message.getData() );

                return message;

            } catch (Exception e)
            {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(AllUsersMessage message) {
            super.onPostExecute(message);

            if(message != null)
            {

                usersList.clear();
                usersList.addAll(message.getData());
                adapter.notifyDataSetChanged();


            }


        }
    }
   */
}
