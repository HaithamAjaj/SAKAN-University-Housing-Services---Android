package com.example.softwareproject.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.softwareproject.AddHomesActivity;
import com.example.softwareproject.HomesListActivity;
import com.example.softwareproject.Model.AddHomes;
import com.example.softwareproject.Model.AddUsers_Data;
import com.example.softwareproject.Model.Homes;
import com.example.softwareproject.Model.Users;
import com.example.softwareproject.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {

  EditText userNameET , emailET , phoneNumberET , passwordET , confirmPasswordET ;

  ArrayList<Users> userDetails;
  Users userToBeAdded;
  RadioGroup genderRG;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_up);

    userNameET = findViewById(R.id.userName_et);
    emailET = findViewById(R.id.email_et);
    phoneNumberET = findViewById(R.id.phoneNumber_et);
    passwordET = findViewById(R.id.password_et);
    confirmPasswordET = findViewById(R.id.confirmPassword_et);
    genderRG = findViewById(R.id.gender_rg);

  }


  public void registration(View view) {

    userToBeAdded = new Users ();

    userToBeAdded.setFull_Name(userNameET.getText().toString());

    userToBeAdded.setPhone_num(phoneNumberET.getText().toString());
    userToBeAdded.setEmail(emailET.getText().toString());
    userToBeAdded.setPass_word(passwordET.getText().toString());
    switch (genderRG.getCheckedRadioButtonId()){

      case R.id.genderMale_rb :
        userToBeAdded.setGender("M");
        break;
      case R.id.genderFemale_rb :
        userToBeAdded.setGender("F");
        break;

      default:
        userToBeAdded.setGender("D");
        break;


    }
    AddUsersTask task = new AddUsersTask();
    task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
  }

 private class AddUsersTask extends AsyncTask<Void, Void, AddUsers_Data>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //pBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected AddUsers_Data doInBackground(Void... voids) {

            try{
                String result = "";

                HttpURLConnection urlConnection;
                BufferedReader reader = null;

                URL url = null;

                url = new URL("http://192.168.0.102//A/sakan/insertAppUser.php");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);
                urlConnection.setRequestMethod("POST");

                urlConnection.setRequestProperty("Content-Type",
                        "application/x-www-form-urlencoded");

                String postParameters =
                        "Full_Name="+ userToBeAdded.getFull_Name()
                        +"&Gender="+ userToBeAdded.getGender()
                                +"&phone_num="+ userToBeAdded.getPhone_num()
                                +"&email="+ userToBeAdded.getEmail()
                                +"&pass_word="+ userToBeAdded.getPass_word();

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


                Gson jsonParser = new Gson();

              AddUsers_Data message = jsonParser.fromJson(
                        result,
                      AddUsers_Data.class
                );



                return message;


            } catch (Exception e)
            {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(AddUsers_Data message) {
            super.onPostExecute(message);
          //  pBar.setVisibility(View.GONE);

          System.out.println("++++++++++++++++++++++++++  message:   " + message);
            if(message != null)
            {
                Toast.makeText(SignUpActivity.this,message.getResult_status(), Toast.LENGTH_SHORT).show();
                if(message.getResult_code() == 1 )
                {

                    userToBeAdded.setFull_Name((message.getFull_Name()));
                  userToBeAdded.setGender(message.getGender());
                  userToBeAdded.setPhone_num(message.getPhone_num());
                  userToBeAdded.setEmail(message.getEmail());
                  userToBeAdded.setPass_word(message.getPass_word());



                  userDetails.add(userToBeAdded);


        Intent intent = new Intent(SignUpActivity.this, HomesListActivity.class);

        startActivity(intent);
                }

            }else
            {
                Toast.makeText(SignUpActivity.this,"Error!", Toast.LENGTH_SHORT).show();

                // print error
            }


        }
    }

}
