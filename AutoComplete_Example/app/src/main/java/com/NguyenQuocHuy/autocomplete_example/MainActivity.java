package com.NguyenQuocHuy.autocomplete_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoTV;
    ArrayList<String> COUNTRIES = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get();
        COUNTRIES.add("VietNam");
        COUNTRIES.add("United States");
        COUNTRIES.add("Canada");
        COUNTRIES.add("United Kingdom");
        COUNTRIES.add("France");
        COUNTRIES.add("Germany");
        COUNTRIES.add("Spain");
        COUNTRIES.add("Italy");
        COUNTRIES.add("Australia");
        COUNTRIES.add("Japan");
        COUNTRIES.add("South Korea");
        COUNTRIES.add("India");
        COUNTRIES.add("Brazil");
        COUNTRIES.add("Argentina");
        COUNTRIES.add("Mexico");
        COUNTRIES.add("Russia");
        COUNTRIES.add("Turkey");
        COUNTRIES.add("Egypt");
        COUNTRIES.add("South Africa");
        COUNTRIES.add("Nigeria");
        COUNTRIES.add("Kenya");
        COUNTRIES.add("Ghana");
        COUNTRIES.add("Uganda");
        COUNTRIES.add("Ethiopia");
        COUNTRIES.add("Morocco");
        COUNTRIES.add("Saudi Arabia");
        COUNTRIES.add("United Arab Emirates");
        COUNTRIES.add("Qatar");
        COUNTRIES.add("Oman");
        COUNTRIES.add("Thailand");
        COUNTRIES.add("Singapore");
        COUNTRIES.add("Malaysia");
        COUNTRIES.add("Indonesia");
        COUNTRIES.add("Philippines");
        COUNTRIES.add("Pakistan");
        COUNTRIES.add("Bangladesh");
        COUNTRIES.add("Nepal");
        COUNTRIES.add("Sri Lanka");
        COUNTRIES.add("New Zealand");
        COUNTRIES.add("Fiji");
        COUNTRIES.add("Samoa");
        COUNTRIES.add("Tonga");
        COUNTRIES.add("Solomon Islands");
        COUNTRIES.add("Papua New Guinea");
        COUNTRIES.add("Federated States of Micronesia");
        COUNTRIES.add("Palau");
        COUNTRIES.add("Marshall Islands");
        COUNTRIES.add("Iraq");
        COUNTRIES.add("Syria");
        COUNTRIES.add("Lebanon");
        COUNTRIES.add("Jordan");
        COUNTRIES.add("Greece");
        COUNTRIES.add("Portugal");
        COUNTRIES.add("Netherlands");
        COUNTRIES.add("Belgium");
        COUNTRIES.add("Austria");
        COUNTRIES.add("Switzerland");
        COUNTRIES.add("Sweden");
        COUNTRIES.add("Norway");
        COUNTRIES.add("Denmark");
        COUNTRIES.add("Finland");
        COUNTRIES.add("Iceland");
        COUNTRIES.add("Greenland");
        COUNTRIES.add("Estonia");
        COUNTRIES.add("Latvia");
        COUNTRIES.add("Lithuania");
        COUNTRIES.add("Poland");
        COUNTRIES.add("Czech Republic");
        COUNTRIES.add("Slovakia");
        COUNTRIES.add("Hungary");
        COUNTRIES.add("Romania");
        COUNTRIES.add("Bulgaria");
        COUNTRIES.add("Serbia");
        COUNTRIES.add("Croatia");
        COUNTRIES.add("Slovenia");
        COUNTRIES.add("Macedonia");
        COUNTRIES.add("Montenegro");
        COUNTRIES.add("Bosnia and Herzegovina");
        COUNTRIES.add("Albania");
        COUNTRIES.add("Kosovo");
        COUNTRIES.add("Moldova");
        COUNTRIES.add("Ukraine");
        COUNTRIES.add("Belarus");
        COUNTRIES.add("Kazakhstan");
        COUNTRIES.add("Kyrgyzstan");
        COUNTRIES.add("Tajikistan");
        COUNTRIES.add("Turkmenistan");
        COUNTRIES.add("Uzbekistan");
        COUNTRIES.add("Armenia");
        COUNTRIES.add("Azerbaijan");
        COUNTRIES.add("Georgia");
        COUNTRIES.add("Iran");
        COUNTRIES.add("Afghanistan");
        ArrayAdapter<String> adapterCoutries = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,COUNTRIES);
        autoTV.setAdapter(adapterCoutries);
    }
    public void get(){
        autoTV = findViewById(R.id.autoComplete);
    }
}