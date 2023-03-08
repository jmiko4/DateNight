package com.example.helloworld;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Card {
    private String name;
    private String description;
    private String category;
    private int budget;
    private List<String> days_open = new ArrayList<String>();
    private int time_spent;
    private String map_link;

        public Card(){
            name = "Name";
            description = "Description";
            category = "Category";
            budget = 0;
            days_open.add("Days Open");
            time_spent = 60;
            map_link = "https://goo.gl/maps/mjb2vrW7p14aV5Je9";
        }







}
