package com.example.mrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewAct extends AppCompatActivity {
    SQLHelper DB=new  SQLHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
// bei Start the Activity
        showData();



    }




    public void showData(){
        // hier fange ich mit dem Code wegen List View
        ListView list  =(ListView) findViewById( R.id.listview); // Verknüpf
        ArrayList<ObjectItems> Objectes=new ArrayList<ObjectItems>();
        ArrayList<String> listofNames = DB.getAllNamewithID();
        ArrayList<String> listofMeans = DB.getAllMeans();
        for(int i=0;i<listofMeans.size()-1;i++){
            ObjectItems OBG = new ObjectItems(listofNames.get(i),listofMeans.get(i));
            Objectes.add(OBG);
        }

           MyListAdapter MLD = new MyListAdapter(Objectes);
            list.setAdapter(MLD);


       // ArrayList<String> listStrings = DB.getAllInput();
        // ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,Objectes); //list.setAdapter(arrayAdapter);
        //list.setAdapter(arrayAdapter);

        //other Way   //  ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listStrings); //list.setAdapter(arrayAdapter);








    }
    class MyListAdapter extends BaseAdapter{
        ArrayList<ObjectItems> listitme = new ArrayList<ObjectItems>();


        public MyListAdapter (ArrayList<ObjectItems> listen){
            this.listitme=listen;






        }

        @Override
        public int getCount() {
            return listitme.size();
        }

        @Override
        public Object getItem(int position) {
            return listitme.get(position).Mean;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View view1 = layoutInflater.inflate(R.layout.row_list_layout_private,null);

            TextView name = (TextView)view1.findViewById(R.id.itemnumber);
            TextView mean = (TextView)view1.findViewById(R.id.itemmean);
            ImageView imgEdit=(ImageView)view1.findViewById(R.id.editimagitem);
            ImageView imgDele=(ImageView)view1.findViewById(R.id.deletItemimga);

            name.setText(listitme.get(position).Name);

            mean.setText(listitme.get(position).Mean);

            imgEdit.setImageResource(listitme.get(position).EditImag);

            imgDele.setImageResource(listitme.get(position).DeleteImag);


            return view1;
        }
    }





    }

