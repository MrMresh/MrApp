package com.example.mrapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SQLHelper SQL = new SQLHelper(this);

    Methoden meth = new Methoden();


    private TextView Resource ;
    private  EditText TextWord;
    private  EditText TextMean;
    private Switch aSwitch;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextWord=(EditText) findViewById(R.id.word);
        TextMean = (EditText) findViewById(R.id.mean);
        Resource = (TextView) findViewById(R.id.Resource);
        Toolbar tool = findViewById(R.id.toolbar);
        setSupportActionBar(tool);
        Resource.setText(AnzahlWörter(SQL));


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

       switch (item.getItemId()){


           case R.id.aboutitem:
               Toast.makeText(this,"about is activated" ,Toast.LENGTH_LONG).show();
               Intent Info = new Intent(this,Info.class);
               startActivity(Info);}


               switch (item.getItemId()){
            case     R.id.startitem:
            Intent textact = new Intent(this,SettingActivity.class);
             startActivity(textact);
                Toast.makeText(this,"Test Activity " ,Toast.LENGTH_LONG).show();}



                switch (item.getItemId()){
            case R.id.settingsitem:
                Toast.makeText(this,"Selceted is not ready " ,Toast.LENGTH_LONG).show();

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option,menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void BuView(View view) {


        Intent viewact = new Intent(this,ViewAct.class);
        startActivity(viewact);

    }

    public void BuAdd(View view) {
        String Name = TextWord.getText().toString();
        String Meam = TextMean.getText().toString();

        if(meth.ExcestText(Name)&&meth.ExcestText(Meam)){

            Boolean Added = SQL.inserData(Name,Meam);
        if (Added == true ){   Toast.makeText(this,"Save Sucsess!" ,Toast.LENGTH_LONG).show();
        TextMean.setText("");
        TextWord.setText("");}
        else {Toast.makeText(this,"Save falled! Pleas try again" ,Toast.LENGTH_LONG).show();}}
        else {

            Toast.makeText(this,"Both of Inputs cant be Empty" ,Toast.LENGTH_LONG).show();
        }

        // Für Anzahl der Wörter
        Resource.setText(AnzahlWörter(SQL));

        }

    public void BuUpd(View view) {
    }



































































    public static String AnzahlWörter(SQLHelper SQL ){
        ArrayList<String> listStrings = SQL.getAllInput();

        int anzahl= (int) listStrings.size();
        return String.valueOf(anzahl);
    }


}

