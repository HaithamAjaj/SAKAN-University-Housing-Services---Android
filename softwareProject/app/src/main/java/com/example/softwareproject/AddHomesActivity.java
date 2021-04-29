package com.example.softwareproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.softwareproject.Model.AddHomes;
import com.example.softwareproject.Model.HomeDetails;
import com.example.softwareproject.Model.Homes;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class AddHomesActivity extends AppCompatActivity {
  EditText ownerHomeNameET,ownerPhoneNumberET,ownerHomeSiteET
          ,numberOfRoomsET,housePriceET,homeDescriptionET;
  RadioGroup genderRG;
  GridView photoListHomeGV;
  ArrayList<Homes> homeDetails;
  Homes homeToBeAdded;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_homes);


    ownerHomeSiteET = findViewById(R.id.ownerHomeSite_et);
//    ownerPhoneNumberET = findViewById(R.id.ownerPhoneNumber_et);
    numberOfRoomsET = findViewById(R.id.numberOfRooms_et);
    housePriceET = findViewById(R.id.housePrice_et);
    homeDescriptionET = findViewById(R.id.homeDescription_et);
    genderRG = findViewById(R.id.gender_rg);
    photoListHomeGV = findViewById(R.id.photoListHome_gv);


  }
  public void add_house_btn(View view) {

    AlertDialog.Builder addBuilder = new AlertDialog.Builder(AddHomesActivity.this);
    addBuilder.setTitle("Confirm Add");
    addBuilder.setMessage("Are You Sure You Want to Add Note ?");
    addBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {

         homeToBeAdded = new Homes ();

        homeToBeAdded.setAddress(ownerHomeSiteET.getText().toString());
       // details.setOwnerPhoneNumber(ownerPhoneNumberET.getText().toString());
        homeToBeAdded.setRooms(numberOfRoomsET.getText().toString());
        homeToBeAdded.setRent(housePriceET.getText().toString());
        homeToBeAdded.setDescription(homeDescriptionET.getText().toString());

        switch (genderRG.getCheckedRadioButtonId()){

          case R.id.genderMale_rb :
            homeToBeAdded.setGender("M");
            break;
          case R.id.genderFemale_rb :
            homeToBeAdded.setGender("F");
            break;

          default:
            homeToBeAdded.setGender("D");
            break;


        }
        AddHomeTask task = new AddHomeTask();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);




      }


    });
    addBuilder.setNegativeButton("No", null);
    addBuilder.create().show();
  }


  private class AddHomeTask extends AsyncTask<Void, Void, AddHomes>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //pBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected AddHomes doInBackground(Void... voids) {

            try{
                String result = "";

                HttpURLConnection urlConnection;
                BufferedReader reader = null;

                URL url = null;

                url = new URL("http://172.20.10.11//A/sakan/insertHomes.php");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);
                urlConnection.setRequestMethod("POST");

                urlConnection.setRequestProperty("Content-Type",
                        "application/x-www-form-urlencoded");

                String postParameters =
                        "Address="+ homeToBeAdded.getAddress()
                        +"&Rooms="+ homeToBeAdded.getRooms()
                                +"&Gender="+ homeToBeAdded.getGender()
                                +"&Rent="+ homeToBeAdded.getRent()
                                +"&Description="+ homeToBeAdded.getDescription()
                                +"&Owner_ID="+ 1;

                urlConnection.setFixedLengthStreamingMode(
                        postParameters.getBytes().length);
                PrintWriter out = new PrintWriter(urlConnection.getOutputStream());
                out.print(postParameters);
                out.close();

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

              Log.e("test res",result);
                Gson jsonParser = new Gson();

              AddHomes message = jsonParser.fromJson(
                        result,
                      AddHomes.class
                );



                return message;


            } catch (Exception e)
            {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(AddHomes message) {
            super.onPostExecute(message);
          //  pBar.setVisibility(View.GONE);


            if(message != null)
            {
            //  System.out.println("++++++++++++++++++++++++++  message:   " + message.getCode());
                Toast.makeText(AddHomesActivity.this,message.getResult_status(), Toast.LENGTH_SHORT).show();
                if(message.getCode() == 1 )
                {

                    homeToBeAdded.setAddress((message.getAddress()));
                    homeToBeAdded.setRooms(message.getRooms());
                  homeToBeAdded.setGender(message.getGender());
                  homeToBeAdded.setRent(message.getRent());
                  homeToBeAdded.setDescription(message.getDescription());
                  homeToBeAdded.setOwner_ID("1");


                  homeDetails.add(homeToBeAdded);


        Intent intent = new Intent(AddHomesActivity.this,HomesListActivity.class);

        startActivity(intent);
                }

            }else
            {
                Toast.makeText(AddHomesActivity.this,"Error!", Toast.LENGTH_SHORT).show();

                // print error
            }


        }
    }



}
