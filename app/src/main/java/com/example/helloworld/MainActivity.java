package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.util.ArrayList;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.FileReader;

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
            File csvfile = new File(Environment.getExternalStorageDirectory() + "/dates.csv");
            CSVReader reader = new CSVReader(new FileReader(csvfile.getAbsolutePath()));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                System.out.println(nextLine[0] + nextLine[1] + "etc...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "The specified file was not found", Toast.LENGTH_SHORT).show();
        }

//


//    public void onBtnClick (View view){
//        TextView nameTextView = findViewById(R.id.name);
//        TextView descriptionTextView = findViewById(R.id.description);
//        TextView categoryTextView = findViewById(R.id.category);
//        TextView budgetTextView = findViewById(R.id.budget);
//        nameTextView.setText(name.get(0));
//        descriptionTextView.setText(description.get(0));
//        categoryTextView.setText(category.get(0));
//        budgetTextView.setText(budget.get(0));
//    }
    }
}