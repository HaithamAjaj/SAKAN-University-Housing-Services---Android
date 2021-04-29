package com.example.softwareproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.softwareproject.Model.HomeAdapter;
import com.example.softwareproject.Model.Homes;
import com.example.softwareproject.Model.Homes_Data;
import com.example.softwareproject.Profile.ProfileActivity;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static com.example.softwareproject.Model.Homes.OBJECT_KEY;

public class HomesListActivity extends AppCompatActivity {


  ImageButton sortHomeIB ;
  AlertDialog dialog ;
  ArrayList<Homes> detailsList ;
  ListView listHomesLV ;
Homes  homes ;
  HomeAdapter adapter ;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_homes_list)  ;
    sortHomeIB = findViewById(R.id.sort_home_ib)  ;
    listHomesLV = findViewById(R.id.listHomes_lv) ;
    Intent intent = getIntent();
   // homeDetails = intent.getStringExtra("data") ;


    detailsList = new ArrayList<>() ;


    adapter = new HomeAdapter(detailsList, HomesListActivity.this) ;
    listHomesLV.setAdapter(adapter) ;


// get data to database
    DataRetrieveTask task = new DataRetrieveTask();
    task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    sortHomeIB.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        View view = LayoutInflater.from(HomesListActivity.this).inflate(R.layout.dialog_sort_home, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(HomesListActivity.this);
        builder.setTitle("Add New Note");
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();


      }
    });

    listHomesLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      Homes data = new Homes();
        Intent intent = new Intent(HomesListActivity.this,DetailsHomeActivity.class);
        intent.putExtra(OBJECT_KEY,detailsList);
        startActivity(intent);

      }
    });

  }



  public void goToProfile(View view) {
    Intent intent = new Intent(HomesListActivity.this, ProfileActivity.class);
    startActivity(intent);
  }

  private class DataRetrieveTask extends AsyncTask<Void, Void,Homes_Data>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Homes_Data doInBackground(Void... voids) {

            try{
                String result = "";

                HttpURLConnection urlConnection;
                BufferedReader reader = null;

                URL url = null;

                url = new URL("http://172.20.10.11//A/sakan/selectHomes.php");
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
              Log.e("test res",result);
                Gson jsonParser = new Gson();

                Homes_Data message = jsonParser.fromJson(result, Homes_Data.class);

              Log.e("test res2", String.valueOf(message));
                return message;

            } catch (Exception e)
            {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Homes_Data message) {
            super.onPostExecute(message);
          System.out.println("++++++++++++++++++++++++++ message  " + message);
            if(message != null)
            {

                detailsList.clear();
                detailsList.addAll(message.getResult_msg());
                adapter.notifyDataSetChanged();


            }


        }
    }

}
