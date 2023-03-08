package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> description = new ArrayList<>();
    ArrayList<String> category = new ArrayList<>();
    ArrayList<Integer> budget = new ArrayList<>();
    ArrayList<String> days_open = new ArrayList<>();
    ArrayList<Integer> time_spent = new ArrayList<>();
    ArrayList<String> map = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            // fetch JSONArray named users
            JSONArray dateArray = obj.getJSONArray("dates");
            System.out.println(dateArray);
            // implement for loop for getting
            // date list data
            for (int i = 0; i < dateArray.length(); i++) {
                // create a JSONObject for fetching single date data
                JSONObject dateDetail = dateArray.getJSONObject(i);
                // fetch email and name and store it in arraylist
                name.add(dateDetail.getString("name"));
                description.add(dateDetail.getString("description"));
                category.add(dateDetail.getString("category"));
                budget.add(dateDetail.getInt("budget"));
                days_open.add(dateDetail.getString("days_open"));
                time_spent.add(dateDetail.getInt("time_spent"));
                map.add(dateDetail.getString("map"));
                // create a object for getting contact data from JSONObject

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("C:\\Users\\Facundo\\AndroidStudioProjects\\HelloWorld2\\app\\src\\main\\java\\com\\example\\helloworld\\dates.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void onBtnClick (View view){
        TextView nameTextView = findViewById(R.id.name);
        TextView descriptionTextView = findViewById(R.id.description);
        TextView categoryTextView = findViewById(R.id.category);
        TextView budgetTextView = findViewById(R.id.budget);
        nameTextView.setText(name.get(0));
        descriptionTextView.setText(description.get(0));
        categoryTextView.setText(category.get(0));
        budgetTextView.setText(budget.get(0));
    }
}