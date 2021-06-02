package com.technocrat.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GridView grid;
    private TextView tv;
    private ImageView iv;

    int images[] = {R.drawable.dhokla, R.drawable.masala_dosa,R.drawable.idli_sambar, R.drawable.samosa, R.drawable.sambar_vada,
            R.drawable.manchurian_rice,R.drawable.crispy_curry,R.drawable.pani_puri,R.drawable.aloo_chaat,R.drawable.momo, R.drawable.noodles,
            R.drawable.pizza,R.drawable.burgur,R.drawable.crispy_fried_chicken};

    String name[] = {"Delicious Dhokla","Delicious Masala Dosa","Delicious Idli Sambar","Delicious Samosa","Delicious Sambar Vada",
            "Delicious Manchurian Rice","Delicious Crispy Curry","Delicious PaniPuri","Delicious Aloo Chaat","Delicious Moms","Delicious Noodles",
            "Delicious Pizza","Delicious Burgur","Delicious Crispy Fried Chicken"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initialise();
    }

    private void initialise() {
        grid = findViewById(R.id.recycler_food);
        grid.setAdapter(new MyFoodAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Selected item is " + name[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class MyFoodAdapter extends BaseAdapter {    // inner class
        public MyFoodAdapter(Context c) {
        }


        @Override
        public int getCount() {
            return name.length;  // count length name, images i.e...name 5 , images 5
        }

        @Override
        public Object getItem(int position) {
            return position; // which position i click
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.custom, parent, false);
            iv = v.findViewById(R.id.iv_food);
            iv.setBackgroundResource(images[position]);

            tv = v.findViewById(R.id.tv_food);
            tv.setText(name[position]);
            return v;
        }
    }
}