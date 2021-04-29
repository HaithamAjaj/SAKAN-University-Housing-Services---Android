package com.example.softwareproject.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.softwareproject.AddHomesActivity;
import com.example.softwareproject.HomesListActivity;
import com.example.softwareproject.Model.AddUsers_Data;
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

public class LoginActivity extends AppCompatActivity {
    Button visitor;

  ImageView logoAppIV ;
  EditText userNameOrEmailET , userPasswordET ;
  Button visitorBTN , loginBTN , createNewAccountBTN;

  ArrayList<Users> userDetails;
  Users userToBeAdded;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    logoAppIV = findViewById(R.id.logoApp_iv);

    userNameOrEmailET = findViewById(R.id.userNameOrEmail_et);
    userPasswordET = findViewById(R.id.userPassword_et);

    visitorBTN = findViewById(R.id.visitor_btn);
    loginBTN = findViewById(R.id.login_btn);
    createNewAccountBTN = findViewById(R.id.createNewAccount_btn);






    visitor = findViewById(R.id.visitor_btn);
visitor.setOnClickListener(new View.OnClickListener() {
  @Override
  public void onClick(View v) {
//    Intent intent = new Intent(LoginActivity.this, HomesListActivity.class);
//    startActivity(intent);
    Intent intent = new Intent(LoginActivity.this, AddHomesActivity.class);
    startActivity(intent);
  }
});

  }


  public void Login(View view){

    userToBeAdded = new Users ();

    userToBeAdded.setFull_Name(userNameOrEmailET.getText().toString());

    userToBeAdded.setPhone_num(userPasswordET.getText().toString());
    Intent intent = new Intent(LoginActivity.this, HomesListActivity.class);

    startActivity(intent);

   // AddUsersTask task = new AddUsersTask();
   // task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

  }
  public void GoToSignUp(View view){

    Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
    startActivity(intent);


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

                url = new URL("http://192.168.0.102//A/sakan/selectAppUser.php");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);
                urlConnection.setRequestMethod("POST");

                urlConnection.setRequestProperty("Content-Type",
                        "application/x-www-form-urlencoded");

                String postParameters =
                        "Full_Name="+ userToBeAdded.getFull_Name()

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
                Toast.makeText(LoginActivity.this,message.getResult_status(), Toast.LENGTH_SHORT).show();
                if(message.getResult_code() == 1 )
                {

                    userToBeAdded.setFull_Name((message.getFull_Name()));
                  userToBeAdded.setEmail(message.getEmail());
                  userToBeAdded.setPass_word(message.getPass_word());



                  userDetails.add(userToBeAdded);


        Intent intent = new Intent(LoginActivity.this, HomesListActivity.class);

        startActivity(intent);
                }

            }else
            {
                Toast.makeText(LoginActivity.this,"Error!", Toast.LENGTH_SHORT).show();

                // print error
            }


        }
    }


}
